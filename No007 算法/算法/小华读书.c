/**
* С�����顣
* ��һ�����ȫ���һ��Ӷ�ҳ��
* �ڶ������ʣ�µ�һ��Ӷ�ҳ��
* �Ժ�������ˡ�����
* �����������������ҳ��
* ��ȫ���ж���Ǯҳ��
*/

const int XHDS_END_DAY = 6;
int xhds_result(int currentDay) {
	if (currentDay == XHDS_END_DAY) {
		return 3;
	}
	return (xhds_result(currentDay + 1) + 2) * 2;
}