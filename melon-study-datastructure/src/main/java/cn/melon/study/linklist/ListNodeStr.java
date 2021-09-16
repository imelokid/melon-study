package cn.melon.study.linklist;

/**
 * 链表节点
 *
 * @author imelonkid
 * @date 2021/08/27 18:01
 **/
public class ListNodeStr extends AbstractListNode {
    /** 当前节点值 */
    public String val;

    public ListNodeStr() {
    }

    @Override
    public void setVal(Object val) {
        this.val = val.toString();
    }

    @Override
    public Object getVal() {
        return val;
    }
}
