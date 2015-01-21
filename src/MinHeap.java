import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by manshu on 1/7/15.
 */
public class MinHeap {
    private int capacity;
    private int size;
    int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[this.capacity];
    }

    public int getParent(int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0) return parent;
        return -1;
    }

    public int getLeft(int i) {
        int left = 2 * i + 1;
        if (left < getSize()) return left;
        return -1;
    }

    public int getRight(int i) {
        int right = 2 * i + 2;
        if (right < getSize()) return right;
        return -1;
    }

    public void percolateUp(int i) {
        int parent = getParent(i);
        if (parent == -1) return;
        if (heap[i] < heap[parent]) {
            int tmp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = tmp;
            percolateUp(parent);
        }
    }

    private void percolateDown(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        if (left == -1 && right == -1) return;

        if (right == -1 || heap[left] < heap[right]) {
            int tmp = heap[i];
            heap[i] = heap[left];
            heap[left] = tmp;
            percolateDown(left);
        } else if (left == -1 || heap[left] >= heap[right]) {
            int tmp = heap[i];
            heap[i] = heap[right];
            heap[right] = tmp;
            percolateDown(right);
        }
    }

    public void insert(int priority) {
        if (this.size == this.capacity)
            throw new OutOfMemoryError("Heap is full");
        heap[this.size++] = priority;
        percolateUp(this.size - 1);
    }

    public int deleteMin() {
        if (getSize() >= 1) {
            int min = heap[0];
            heap[0] = heap[this.size - 1];
            this.size--;
            percolateDown(0);
            return min;
        }
        throw new IllegalStateException("Heap size is 0");
    }

    public int getSize() {
        return this.size;
    }

    public int getMin() {
        if (getSize() >= 1)
            return heap[0];
        throw new InputMismatchException("Size of the heap is 0");
    }

    public static void main(String args[]) {
        MinHeap heap = new MinHeap(10);
        heap.insert(5);
        heap.insert(4);
        heap.insert(8);
        heap.insert(2);
        heap.insert(1);
        heap.insert(10);
        heap.insert(0);

        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());

        int arr[] = {20, 0, 50, 98, 16, 15, 66, 12, 49, 81, 12, 49, 89, 38, 84, 42, 30, 44, 56, 72, 22, 22, 20, 18, 1, 79, 69, 10, 79, 71, 93, 90, 89, 13, 88, 85, 84, 80, 17, 1, 10, 4, 25, 39, 9, 7, 46, 63, 26, 31, 56, 98, 3, 73, 77, 39, 29, 71, 71, 32, 82, 7, 96, 6, 99, 63, 73, 86, 76, 47, 43, 32, 14, 74, 77, 93, 72, 61, 12, 22, 47, 72, 13, 90, 77, 96, 17, 71, 64, 51, 18, 52, 48, 6, 81, 22, 51, 1, 35, 32};
        int K = 10;
        MinHeap topk = new MinHeap(K); //topK number
        for (int i = 0; i < arr.length; i++) {
            if (topk.getSize() < K)
                topk.insert(arr[i]);
            else {
                if (arr[i] > topk.getMin()) {
                    topk.deleteMin();
                    topk.insert(arr[i]);
                }
            }
        }

        for (int i = 0; i < K; i++)
            System.out.print(topk.deleteMin() + ", ");
        System.out.println();
        Arrays.sort(arr);
        for (int i = arr.length - K; i < arr.length; i++)
            System.out.print(arr[i] + ", ");

    }
}
