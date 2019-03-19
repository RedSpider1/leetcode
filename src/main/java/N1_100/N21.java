package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N21 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = l2;
                break;
            } else if (l2 == null) {
                node.next = l1;
                break;
            } else {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                node = node.next;
            }
        }
        return head.next;
    }
}
