package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N83 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        ListNode previousNode = head;
        ListNode nextNode = previousNode.next;
        while (nextNode != null) {
            if (nextNode.val != previousNode.val) {
                previousNode.next = nextNode;
                previousNode = nextNode;
            }
            nextNode = nextNode.next;
        }
        previousNode.next = nextNode;
        return result;
    }
}


