package N1_100;

import common.ListNode;

public class N2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先加起来，不处理进位
        ListNode result = addIgnoreCarry(l1, l2);
        carry(result);
        return result;
    }

    // 直接相加，忽略进位
    private ListNode addIgnoreCarry(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(l1.val + l2.val);
        ListNode result = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            head.next = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
        return result;
    }

    // 处理进位
    private void carry(ListNode listNode) {
        boolean needCarry = false; // 当前是否需要进位
        while (listNode != null) {
            int val = listNode.val;
            if (needCarry) {
                val += 1;
            }
            if (val >= 10) {
                listNode.val = val % 10;
                needCarry = true;
                if (listNode.next == null) {
                    listNode.next = new ListNode(1);
                    break;
                }
            } else {
                listNode.val = val;
                needCarry = false;
            }
            listNode = listNode.next;
        }
    }
}
