/**
* 
* ĳ�ִ�Ⱦ����һ��ֻ��һ�����ߣ�
* ǰ5��ΪǱ���ڣ�������Ҳ���ᴫȾ�ˣ�
* ��6�쿪ʼ�������ӷ�����������Ҫ5��ʱ�䣬�ڼ�ÿ�촫Ⱦ3���ˣ�
* ���N�칲�ж��ٻ��ߡ�
*
*/
int crbwt_result(int day) {
	int sum = 0;
	if (day <= 5) {
		return 1;
	}
	else {
		sum = crbwt_result(day - 5) * 3 + crbwt_result(day - 1);
	}
	return sum;
}