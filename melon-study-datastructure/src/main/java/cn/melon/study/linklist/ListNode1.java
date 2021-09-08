package cn.melon.study.linklist;

/**
 * 链表节点
 *
 * @author imelonkid
 * @date 2021/08/27 18:01
 **/
public class ListNode1 {

    /** 前序节点 */
    public ListNode1 pre;

    /** 后继节点 */
    public ListNode1 next;

    /** 当前节点值 */
    public int val;

    public ListNode1(int val) {
        this.val = val;
    }
}
