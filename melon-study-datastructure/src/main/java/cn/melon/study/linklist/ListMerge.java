package cn.melon.study.linklist;

/**
 * 链表合并
 *
 * @author imelonkid
 * @date 2021/09/16 09:37
 **/
public class ListMerge {


    public ListNodeInt solution(ListNodeInt l1, ListNodeInt l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNodeInt finalNode = null;
        ListNodeInt cursor = null;

        while (l1 != null || l2 != null) {
            // l1已经完全入队，只需将l2剩余的部分全部入队即可
            if (l1 == null) {
                if (finalNode == null) {
                    finalNode = l2;
                    cursor = finalNode;
                } else {
                    cursor.next = l2;
                    cursor = (ListNodeInt) cursor.next;
                }
                l2 = (ListNodeInt) l2.next;
                continue;
            }

            // l2已经全部入队，只需将l1剩余的部分挨个入队即可
            if (l2 == null) {
                if (finalNode == null) {
                    finalNode = l1;
                    cursor = finalNode;
                } else {
                    cursor.next = l1;
                    cursor = (ListNodeInt) cursor.next;
                }
                l1 = (ListNodeInt) l1.next;
                continue;
            }

            // l1,l2都没有完全入队，需要对每个节点挨个比较进行入队
            if (l1.val < l2.val) {
                if (finalNode == null) {
                    finalNode = l1;
                    cursor = finalNode;
                } else {
                    cursor.next = l1;
                    cursor = (ListNodeInt) cursor.next;
                }
                l1 = (ListNodeInt) l1.next;
                continue;
            }

            if (finalNode == null) {
                finalNode = l2;
                cursor = finalNode;
            } else {
                cursor.next = l2;
                cursor = (ListNodeInt) cursor.next;
            }
            l2 = (ListNodeInt) l2.next;
        }

        return finalNode;
    }

}
