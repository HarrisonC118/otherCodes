package _01_递归.出售金鱼问题;

/**
 * 出售金鱼问题：
 * 第一次卖出全部金鱼的(一半加二分之一)条金鱼；
 * 第二次卖出乘余金鱼的三分之一加三分之一条金鱼；
 * 第三次卖出剩余金鱼的四分之一加四分之一条金鱼；
 * 第四次卖出剩余金鱼的五分之一加五分之一条金鱼；
 * 现在还剩下11条金鱼，在出售金鱼时不能把金鱼切开或者有任何破损的。
 * 问这鱼缸里原有多少条金鱼？
 */

/**
 * @author: HatcherCheung
 * Date:  2021/9/13
 */
public class Index {
    private static final int END_FISH_NUM = 11;
    public static void main(String[] args) {
        System.out.println(fish(1.0));
    }

    public static Double fish(Double currentNum) {
        Double fishNum = 0.0;
        Double saleNum = 5.0;
        if (currentNum.equals(saleNum)) {
            return Double.valueOf(END_FISH_NUM);
        }
        fishNum += fish(currentNum + 1) / (1/(currentNum + 1)+1/(currentNum + 1));
        return fishNum;
    }
}
