package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 2/12/15.
 */
public class RestoreIPAddress {


    private static List<String> restoreIpAddresses(String s, int loc) {
        List<String> valid_ips = new ArrayList<String>();
        if (s.length() > 3 * (4 - loc)) return valid_ips;

        if (loc == 4) {
            valid_ips.add("");
            return valid_ips;
        }
        if (loc < 4 && s.length() == 0) return valid_ips;

        String local = "";
        //System.out.println("Loc = " + loc + " string = " + s);
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            local = s.substring(0, i + 1);
            if (Integer.parseInt(local) > 255) continue;
            if (local.length() > 1 &&  local.startsWith("0")) continue;
            List<String> ip_chunk = restoreIpAddresses(s.substring(i + 1), loc + 1);
            if (ip_chunk == null || ip_chunk.isEmpty()) continue;
            for (String ip : ip_chunk) {
                if (ip.equals("")) valid_ips.add(local);
                else valid_ips.add(local + "." + ip);
                //System.out.println(local + " " + ip);
            }
        }
        return valid_ips;
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> valid_ips = restoreIpAddresses(s, 0);
        return valid_ips;
    }
    
    public static void main(String[] args) {
        
        String ip = "25525511135";
        ip = "010010";
        List<String> ips = restoreIpAddresses(ip);
        for (String valid_ip : ips) {
            System.out.println(valid_ip);
        }
    }
}
