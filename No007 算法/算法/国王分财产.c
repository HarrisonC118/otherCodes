/**
* 国王分财产。
* 某国王临终前给儿子们分财产。他把财产分为若干份，
* 然后给第一个儿子一份，再加上剩余财产的1/10；
* 给第二个儿子两份，再加上剩余财产的1/10；……；
* 给第i个儿子i份，再加上剩余财产的1/10。
* 每个人分到的财产是一样的
* 老国王共有几个儿子？财产共分成了多少份？
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
