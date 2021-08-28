package cn.melon.study.linklist;

/**
 * 单向链表反转
 *
 * @author imelonkid
 * @date 2021/08/27 18:00
 **/
public class ReverseSingleList {

    /**
     * 反转链表
     *
     * @param head 原始单向链表头结点
     *             原始链表：a -> b -> c -> null
     *             反转链表：c -> b -> a -> null
     *             <p>
     *             思路：这里有三个比较关键的指针，pre, curr, next
     *             pre：记录当前节点反转后的后继节点
     *             curr：游标指针
     *             next: 由于curr会在反转的过程中将next重新定向，所以链表会出现中断
     *             这时候为了下一次循环curr能找到正确的节点，需要在链表断裂之前将curr -> next 记录下来。
     */
    public ListNode reverse(ListNode head) {

        // 定义指针
        ListNode curr = head;
        ListNode pre = null;
        ListNode next;

        // 开始循环
        while (curr != null) {
            // 保存后继
            next = curr.next;
            // 重新设置curr的后继为pre 这时链表出现断裂
            curr.next = pre;
            // 记录前序
            pre = curr;
            // 将游标指向
            curr = next;
        }

        // 返回反转后链表的头结点
        return pre;
    }


    /**
     * 反转链表
     *
     * @param head 原始单向链表头结点
     *             如对链表[a, b, c, d]的第[1,2]区间进行反转
     *             原始链表：a -> b -> c -> d -> null
     *             反转链表：a -> c -> b -> d -> null
     *             <p>
     *             思路：这里有三个比较关键的指针，pre, curr, next
     *             pre：记录当前节点反转后的后继节点
     *             curr：游标指针
     *             next: 由于curr会在反转的过程中将next重新定向，所以链表会出现中断
     *             这时候为了下一次循环curr能找到正确的节点，需要在链表断裂之前将curr -> next 记录下来。
     */
    public ListNode reverseRegion(ListNode head, int startPos, int endPos) {

        // 定义指针
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode startReverseNode = null;
        ListNode startReversePreNode = null;

        int idx = 0;
        while(curr != null){
            // 记录next
            next = curr.next;

            // 反转区间执行反转
            if(idx >= startPos && idx <= endPos) {
                // 处理游标刚刚进入区间的情况
                if(idx == startPos) {
                    startReverseNode = curr;
                    startReversePreNode = pre;
                }
                curr.next = pre;
            }

            // 处理游标刚刚离开区间的情况
            if(idx == endPos + 1) {
                // 获取新的链表头部
                if(startReversePreNode == null) {
                    // 说明链表是从头部就开始反转的，新的头部不是head了, 新的头部应该是pre;
                    head = pre;
                }else {
                    // 将反转区间的前序节点连接到反转区间的头结点
                    startReversePreNode.next = pre;
                }

                // 将反转链表的尾节点连接到next
                startReverseNode.next = next;
            }

            // 更新游标
            pre = curr;
            curr = next;

            idx++;
        }

        return head;
    }
}
