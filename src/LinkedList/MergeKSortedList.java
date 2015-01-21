package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by manshu on 1/8/15.
 */
public class MergeKSortedList {
    class QueueItem {
        int index;
        ListNode listNode;

        QueueItem(ListNode node, int i) {
            listNode = node;
            index = i;
        }

        @Override
        public String toString() {
            return "Index = " + index + ", Val = " + listNode.val;
        }
    }

    class QueueComparator implements Comparator<QueueItem> {
        public int compare(QueueItem o1, QueueItem o2) {
            Integer i1 = o1.listNode.val;
            Integer i2 = o2.listNode.val;
            return i1.compareTo(i2);
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int k = lists.size();
        if (k == 0) return null;
        if (k == 1) return lists.get(0);

        Comparator<QueueItem> queueComparator = new QueueComparator();
        PriorityQueue<QueueItem> priorityQueue = new PriorityQueue<QueueItem>(k, queueComparator);
        ListNode head = null, tail = null;
        for (int i = 0; i < k; i++) {
            if (lists.get(i) != null)
                priorityQueue.add(new QueueItem(lists.get(i), i));
        }
        QueueItem queueItem;
        while (!priorityQueue.isEmpty()) {
            //System.out.println(priorityQueue.poll());
            queueItem = priorityQueue.poll();
            if (head == null) {
                head = new ListNode(queueItem.listNode.val);
                tail = head;
            } else {
                tail.next = new ListNode(queueItem.listNode.val);
                tail = tail.next;
            }
            queueItem = new QueueItem(queueItem.listNode.next, queueItem.index);
            if (queueItem.listNode == null) continue;
            priorityQueue.add(queueItem);
        }
        return head;
    }

    public static void main(String args[]) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        List<ListNode> listNodes = new ArrayList<ListNode>();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(10);
        head1.next.next.next = new ListNode(15);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(11);
        head2.next.next.next = new ListNode(16);

        ListNode head3 = new ListNode(0);
        head3.next = new ListNode(4);
        head3.next.next = new ListNode(9);
        head3.next.next.next = new ListNode(14);


        listNodes.add(head1);
        listNodes.add(head2);
        listNodes.add(head3);

        System.out.println(mergeKSortedList.mergeKLists(listNodes));
    }
}
