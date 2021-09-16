package cn.melon.study.linklist;

/**
 * 链表节点
 *
 * @author imelonkid
 * @date 2021/08/27 18:01
 **/
public class ListNodeInt extends AbstractListNode {
    /** 当前节点值 */
    public int val;

    public ListNodeInt() {
    }

    @Override
    public void setVal(Object val) {
        this.val = (int) val;
    }

    @Override
    public Object getVal() {
        return val;
    }
}
