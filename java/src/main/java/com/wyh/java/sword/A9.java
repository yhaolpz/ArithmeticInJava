package com.wyh.java.sword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author WangYingHao
 * @since 2019-06-30
 */
public class A9 {
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
