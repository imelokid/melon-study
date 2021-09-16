package cn.melon.study.linklist;

import org.junit.Test;

/**
 * ReverseSingleList测试类
 *
 * @author imelonkid
 * @date 2021/08/28 12:57
 **/
public class ReverseSingleListTest extends BaseTester {


    @Test
    public void testReverseRegion() {
        ListNodeStr head = generateList(ListNodeStr.class, 10);
        String soureLis = printList("sourceLis", head);
        System.out.println(soureLis);

        ReverseSingleList singleList = new ReverseSingleList();
        ListNodeStr head1 = copyList(ListNodeStr.class, head);
        System.out.println(printList("copyLis", head1));
        ListNodeStr reverseLis = singleList.reverse(head1);
        System.out.println(printList("reverseLis", reverseLis));

        // 从中间节点开始反转
        ListNodeStr head2 = copyList(ListNodeStr.class, head);
        ListNodeStr reverseRegionLis = singleList.reverseRegion(head2, 2, 5);
        System.out.println(printList("reverseRegionLis", reverseRegionLis));

        // 从首节点进行反转
        ListNodeStr head3 = copyList(ListNodeStr.class, head);
        ListNodeStr reverseRegionLis1 = singleList.reverseRegion(head3, 0, 2);
        System.out.println(printList("reverseRegionLis1", reverseRegionLis1));

        // 反转固定值区间
        ListNodeStr head4 = copyList(ListNodeStr.class, head);
        ListNodeStr reverseRegionLis2 = singleList.reverseRegion(head4, 0, 0);
        System.out.println(printList("reverseRegionLis2", reverseRegionLis2));

        // 反转固定值区间
        ListNodeStr head5 = copyList(ListNodeStr.class, head);
        ListNodeStr reverseRegionLis3 = singleList.reverseRegion(head5, 1, 1);
        System.out.println(printList("reverseRegionLis3", reverseRegionLis3));
    }


}
