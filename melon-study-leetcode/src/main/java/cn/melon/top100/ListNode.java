package cn.melon.top100;

/**
 * 链表节点
 *
 * @author imelonkid
 * @date 2021/08/27 18:01
 **/
public class ListNode {

    /** 前序节点 */
    public ListNode pre;

    /** 后继节点 */
    public ListNode next;

    /** 当前节点值 */
    public int val;

    ListNode() {
    }

    public static ListNode generateList(int[] vals) {
        ListNode head = null;
        ListNode p = null;
        for (int val : vals) {
            if (head == null) {
                head = new ListNode(val);
                p = head;
                continue;
            }
            p.next = new ListNode(val);
            p = p.next;
        }

        return head;
    }

    public ListNode(int val) {
        this.val = val;
    }


    public String print() {
        StringBuilder sb = new StringBuilder("[");
        ListNode p = this;
        while(p != null) {
            sb.append(p.val).append(", ");
            p = p.next;
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }
}
