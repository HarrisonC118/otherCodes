/**
* �˶��Ὺ��N�죬һ����������Mö��
* ��һ�췢����1ö��ʣ�µ��߷�֮һö��
* �ڶ��췢����2ö��ʣ�µ��߷�֮һö��
* ��3�췢����3ö��ʣ�µ��߷�֮һö��
* �Ժ�ÿ�춼�մ˰���
* ���˵�N��պû��н���Nö�����˽���ȫ�����ꡣ
* �����N��M��
*/


// ���ؽ�������
void fjpwt_result(int* day, int* num) {
    int i = 0, count = 0;
    int gold[100];
    do {
        count = count + 6;
        gold[count] = count;
        for (i = count - 1; i >= 1; i--) {
            if (gold[i + 1] % 6 != 0) {
                break;
            } else {
                gold[i] = gold[i + 1] * 7 / 6 + i;
            }
        }
    } while (i >= 1);
    *day = count;
    *num = gold[1];
}