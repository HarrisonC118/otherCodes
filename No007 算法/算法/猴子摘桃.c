/**
 * ���ӳ��ҡ�
 * ��һȺ����ժ����һ�����ӣ������涨
 * ÿ��ֻ׼��һ���һֻ�����ڶ����ʣ�µ�һ���һֻ���Դ����ƣ���
 * �ھ������ó��꣬
 * �ʺ�����ժ���˶������ӣ�
 */

 /**
  * @author: HatcherCheung
  * Date:  2021/9/13
  */
const int HZZT_TOTAL_DAY = 9;
/**
 * @param day ��ǰ�ǵڼ���
 * @return �ڼ���ʣ�µ���������
 */
int hzzt_result(int day) {
    if (day == HZZT_TOTAL_DAY) {
        return 0;
    }
    return (hzzt_result(day + 1) + 1) * 2;
}