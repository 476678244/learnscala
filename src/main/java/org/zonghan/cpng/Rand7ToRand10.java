package org.zonghan.cpng;


import java.util.*;

public class Rand7ToRand10 {

    /*
      已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
        不要使用系统的 Math.random() 方法。
            示例 1:
                输入: 1
                输出: [7]
            示例 2:
                输入: 2
                输出: [8,4]
            示例 3:
                输入: 3
                输出: [8,1,10]
        提示:
            rand7 已定义。
            传入参数: n 表示 rand10 的调用次数。
        进阶:
            rand7()调用次数的 期望值 是多少 ?
    * */
    public int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public int rand10() {
        return rand7();
    }

    public static void main(String[] args) {
        Rand7ToRand10 obj = new Rand7ToRand10();

        Map<Integer, Integer> numberCounts = new HashMap<Integer, Integer>();
        for (int i = 1; i < 11; i++) {
            numberCounts.put(i, 0);
        }

        int total = 10000000;
        int cursor = total;
        while (cursor > 0) {
            int r = obj.rand10();
            numberCounts.put(r, numberCounts.get(r) + 1);
            cursor--;
        }

        numberCounts.keySet().stream().forEach(key -> {
            System.out.println(key + ":" + numberCounts.get(key) * 100.0 / total + "%");
        });


    }
}
