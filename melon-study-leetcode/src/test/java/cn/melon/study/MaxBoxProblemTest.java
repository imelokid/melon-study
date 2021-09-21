package cn.melon.study;

import cn.melonkid.exception.MelonStatusCodeEnums;
import cn.melonkid.util.AssertUtil;
import org.junit.Test;

/**
 * MaxBoxProblem测试用例
 *
 * @author imelonkid
 * @date 2021/09/21 20:43
 **/
public class MaxBoxProblemTest {

    private MaxBoxProblem maxBoxProblem = new MaxBoxProblem();

    /**
     * arr=[3, 6, 5, 1, 8] m=6 需要6个箱子
     */
    @Test
    public void testSolution() {
        int[] arr = {3, 6, 5, 1, 8};
        int ret = maxBoxProblem.solution(arr);
        AssertUtil.assertTrue(ret == 6, MelonStatusCodeEnums.SYSTEM_ERROR);

        arr = new int[]{3, 6, 5, 1, 5, 1, 8};
        ret = maxBoxProblem.solution(arr);
        AssertUtil.assertTrue(ret == 9, MelonStatusCodeEnums.SYSTEM_ERROR);

        arr = new int[]{5};
        ret = maxBoxProblem.solution(arr);
        AssertUtil.assertTrue(ret == 0, MelonStatusCodeEnums.SYSTEM_ERROR);

        arr = new int[]{5, 1};
        ret = maxBoxProblem.solution(arr);
        AssertUtil.assertTrue(ret == 2, MelonStatusCodeEnums.SYSTEM_ERROR);

        arr = new int[]{5, 1};
        ret = maxBoxProblem.solution(arr);
        AssertUtil.assertTrue(ret == 2, MelonStatusCodeEnums.SYSTEM_ERROR);
    }
}
