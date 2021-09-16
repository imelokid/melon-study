package cn.melon.study.linklist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础测试类
 *
 * @author imelonkid
 * @date 2021/08/10 16:27
 **/
public abstract class BaseTester {


    /** LOGGER */
    protected Logger logger = LoggerFactory.getLogger(BaseTester.class);

    protected <T extends AbstractListNode> T generateList(Class<T> type, int size) {

        T head = null;
        T curr = null;

        for (int i = 0; i < size; i++) {
            if (head == null) {
                head = generateNode(type, i);
                curr = head;
                continue;
            }

            T node = generateNode(type, i);
            curr.next = node;
            curr = node;
        }

        return head;
    }

    protected <T extends AbstractListNode> T generateNode(Class<T> type, Object val) {
        T t = null;
        try {
            t = type.newInstance();
            t.setVal(val);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    protected <T extends AbstractListNode> T copyList(Class<T> type, T head) {

        T newHead = null;
        T newCurrNode = null;

        while (head != null) {
            if (newHead == null) {
                newHead = generateNode(type, head.getVal());
                newCurrNode = newHead;
                head = (T) head.next;
                continue;
            }

            newCurrNode.next = generateNode(type, head.getVal());
            newCurrNode = (T) newCurrNode.next;
            head = (T) head.next;
        }

        return newHead;
    }

    protected <T extends AbstractListNode> String printList(String info, T head) {

        StringBuilder sb = new StringBuilder(info + ":[");
        while (head != null) {
            sb.append(head.getVal());
            head = (T) head.next;
            sb.append(", ");
        }
        String str = sb.substring(0, sb.length() - ", ".length());
        return str + "]";
    }

}
