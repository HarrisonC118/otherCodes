/**
* �����ֲƲ���
* ĳ��������ǰ�������ǷֲƲ������ѲƲ���Ϊ���ɷݣ�
* Ȼ�����һ������һ�ݣ��ټ���ʣ��Ʋ���1/10��
* ���ڶ����������ݣ��ټ���ʣ��Ʋ���1/10��������
* ����i������i�ݣ��ټ���ʣ��Ʋ���1/10��
* ÿ���˷ֵ��ĲƲ���һ����
* �Ϲ������м������ӣ��Ʋ����ֳ��˶��ٷݣ�
*/

void gwfcc_result(int* num1, int* num2) {
    int i = 0, count = 0;
    int property[100];
    do {
        count += 9;
        property[count] = count;
        for (i = count - 1; i >= 1; i--) {
            if (property[i + 1] % 9 != 0) break;
            else
                property[i] = property[i + 1] * 10 / 9 + i;
        }
    } while (i >= 1);
    *num1 = count;
    *num2 = property[1];
}
