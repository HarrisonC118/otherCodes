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
const int HZZT_TOTAL_DAY = 9;
/**
 * @param day 当前是第几天
 * @return 第几天剩下的桃子树梁
 */
int hzzt_result(int day) {
    if (day == HZZT_TOTAL_DAY) {
        return 0;
    }
    return (hzzt_result(day + 1) + 1) * 2;
}