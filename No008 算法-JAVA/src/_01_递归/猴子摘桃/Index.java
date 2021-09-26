package _01_递归.猴子摘桃;

/**
 * 猴子吃桃。
 * 有一群猴子摘来了一批桃子，猴王规定
 * 每天只准吃一半加一只（即第二天吃剩下的一半加一只，以此类推），
 * 第九天正好吃完，
 * 问猴子们摘来了多少桃子？
 */

/**
 * @author: HatcherCheung
 * Date:  2021/9/13
 */
public class Index {
    private static final int TOTAL_DAY = 9;
    public static void main(String[] args) {
        System.out.println(result(0));
    }

    /**
     *
     * @param day 当前是第几天
     * @return 第几天剩下的桃子树梁
     */
    public static int result(int day) {
        if (day == TOTAL_DAY) {
            return 0;
        }
        return (result(day + 1) + 1) * 2;
    }
}
