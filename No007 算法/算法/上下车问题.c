/**
 * ĳ·�����������ܹ��а�վ��
 * ��һ��վ����ʱ��������nλ�˿ͣ�
 * ���˵ڶ�վ����һ��˿ͣ�����������λ�˿ͣ�
 * ���˵���վҲ����һ��˿ͣ�����������λ�˿ͣ�
 * �Ժ�ÿ��һվ�����³������е�һ��˿ͣ��������˳˿ͱ�ǰһվ��һ��������
 * �����յ�վ���ϻ��г˿����ˣ�
 * �ʷ���ʱ���ϵĳ˿��ж��٣�
 */


const int SXCWT_TOTAL_STATION_NUM = 8;
/**
 * @param currentStationNum ��ǰ�ǵڼ�վ
 * @param offPeopleNum ��ǰ���˶�����
 * @return ��վǰ�����ж�����
 */
int sxcwt_result(double currentStationNum, double offPeopleNum) {
    if (currentStationNum == SXCWT_TOTAL_STATION_NUM) {
        return 6;
    }
    return (sxcwt_result(currentStationNum + 1, SXCWT_TOTAL_STATION_NUM - currentStationNum - 1) - offPeopleNum) * 2;
}