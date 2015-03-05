package General;

import java.nio.ByteBuffer;

/**
 * Created by manshu on 2/18/15.
 */
class BI {
    //data store
    private byte bi_data[];
    private int size;

    BI add(BI other) {
        int s1 = size;
        int s2 = other.getSize();
        byte bi_data_2[] = other.getBytes();
        byte new_bi_data[] = new byte[Math.max(s1, s2)];
        int carry = 0;
        int i = 0;
        while (i < Math.min(s1, s2)) {
            int x = carry + (int) bi_data[i] + (int) bi_data_2[i];
            if (x >= 256) {
                new_bi_data[i] = (byte) ((byte) x % 256);
                carry = x - 255;
            } else {
                new_bi_data[i] = (byte) ((int) bi_data[i] + (int) bi_data_2[i]);
                carry = 0;
            }
            i++;
        }

        for (; i < Math.max(s1, s2); i++) {
            int x = carry;
            if (s2 > s1) x += (int) bi_data_2[i];
            else x += (int) bi_data[i];
            if (x >= 256) {
                new_bi_data[i] = (byte) ((byte)x % 256);
                carry = x - 255;
            } else {
                new_bi_data[i] = (byte) x;
                carry = 0;
            }
        }

        while (carry != 0) {
            if (size == new_bi_data.length) {
                byte bi_temp[] = new byte[2 * size];
                for (int j = 0; i < size; j++) {
                    bi_temp[j] = new_bi_data[j];
                }
                new_bi_data = bi_temp;
            }
            new_bi_data[i++] = (byte) ((byte)carry % 256);
            carry %= 256;
        }

        return new BI(new_bi_data);
    }


    private byte[] convertInt2Bytes(int data) {
        return ByteBuffer.allocate(4).putInt(data).array();
    }

    private BI(byte[] biData) {
        bi_data = new byte[biData.length];
        for (int i = 0; i < biData.length; i++){
        bi_data[i] = biData[i];
        }
        size = biData.length;
    }

    public BI(int initial){
        //code
        bi_data = convertInt2Bytes(initial);
        size = 4;
    }

    public int getSize() {
        return size;
    }

    public byte[] getBytes() {
        return bi_data;
    }
    
    //code
    public static void main(String[] args) {
        BI a = new BI(5);
        BI b = new BI(6);
        BI sum = a.add(b);
        System.out.println(sum.getSize());
        for (int i = 0; i < sum.getSize(); i++) {
            System.out.println(sum.getBytes()[i]);
        }
//        
//        System.out.println(sum);
//        
//        BI x = new BI(1);
//        for (int i = 0; i < 10000; i++) x = x.add(x);
    }
}

//immutable
//unsigned
//stores arbitrary-length integers. 1000 bits ok, 10000 bits ok, etc...
//implement the data store (you decide how)
//implement a basic constructor (from a positive integer)

//implement addition.
//EXAMPLES:

//  BI a = new BI(5);
//  BI b = new BI(6)
//  BI sum = a.add(b);
// -> produces a new BI, does not modify a or b, value is 11

// BI x = new BI(1);
// for (int i = 0; i < 10000; i++) x = x.add(x)
// x is now 2 ^ 10000

