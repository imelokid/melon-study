package cn.melon.top100;


/**
 * 两个数求和
 *
 * @author imelonkid
 * @date 2021/09/07 18:06
 **/
public class TwoNumSum {

    public static void main(String[] args) {
        TwoNumSum twoNumSum = new TwoNumSum();
        ListNode n1 = ListNode.generateList(new int[]{2, 4, 3});
        ListNode n2 = ListNode.generateList(new int[]{5, 6, 4});

        ListNode node = twoNumSum.solution(n1, n2);
        System.out.println(node.print());
    }

    public ListNode solution(ListNode l1, ListNode l2) {

        // 定义游标
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode finalNum = null;
        ListNode p3 = null;

        // 进位flag
        boolean flag = false;

        // 大循环执行相加
        while (p1 != null || p2 != null || flag) {
            // 求和 如果执行了进位
            int sum = caculateSum(p1, p2, flag);

            // 标记位复位
            if (flag) {
                flag = false;
            }

            // 需要进位
            if (sum >= 10) {
                flag = true;
                sum -= 10;
            }

            // 生成节点
            if (finalNum == null) {
                finalNum = new ListNode(sum);
                p3 = finalNum;

                // 游标后移
                p1 = p1 == null ? null : p1.next;
                p2 = p2 == null ? null : p2.next;
                continue;
            }

            p3.next = new ListNode(sum);

            // 游标后移
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            p3 = p3.next;

        }

        return finalNum;
    }


    private int caculateSum(ListNode n1, ListNode n2, boolean flag) {
        int val1 = n1 == null ? 0 : n1.val;
        int val2 = n2 == null ? 0 : n2.val;

        return flag ? (val1 + val2 + 1) : (val1 + val2);
    }


}
