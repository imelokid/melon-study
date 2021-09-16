package cn.melon.study.linklist;

/**
 * 链表节点
 *
 * @author imelonkid
 * @date 2021/08/27 18:01
 **/
public abstract class AbstractListNode {

    /** 前序节点 */
    public AbstractListNode pre;

    /** 后继节点 */
    public AbstractListNode next;

    public abstract void setVal(Object val);

    public abstract Object getVal();

}
