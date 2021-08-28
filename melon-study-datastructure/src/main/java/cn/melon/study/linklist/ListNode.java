package cn.melon.study.linklist;

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
    public String val;

    public ListNode(String val) {
        this.val = val;
    }
}
