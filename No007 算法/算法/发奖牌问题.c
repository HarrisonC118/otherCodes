/**
* 运动会开了N天，一共发出金牌M枚。
* 第一天发金牌1枚加剩下的七分之一枚，
* 第二天发金牌2枚加剩下的七分之一枚，
* 第3天发金牌3枚加剩下的七分之一枚，
* 以后每天都照此办理。
* 到了第N天刚好还有金牌N枚，到此金牌全部发完。
* 编程求N和M。
*/


// 返回金牌总数
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