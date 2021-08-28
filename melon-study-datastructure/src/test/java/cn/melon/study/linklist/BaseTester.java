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

    protected ListNode generateList(int size) {

        ListNode head = null;
        ListNode curr = null;

        for(int i = 0; i < size; i++) {
            if(head == null) {
                head = new ListNode(i + "");
                curr = head;
                continue;
            }

            ListNode node = new ListNode(i + "");
            curr.next = node;
            curr = node;
        }

        return head;
    }

    protected ListNode copyList(ListNode head) {

        ListNode newHead = null;
        ListNode newCurrNode = null;

        while(head != null) {
            if(newHead == null) {
                newHead = new ListNode(head.val);
                newCurrNode = newHead;
                head = head.next;
                continue;
            }

            newCurrNode.next = new ListNode(head.val);
            newCurrNode = newCurrNode.next;
            head = head.next;
        }

        return newHead;
    }

    protected String printList(String info, ListNode head) {

        StringBuilder sb = new StringBuilder(info + ":[");
        while(head != null) {
            sb.append(head.val);
            head = head.next;
            sb.append(", ");
        }
        String str = sb.substring(0, sb.length() - ", ".length());
        return str + "]";
    }

}
