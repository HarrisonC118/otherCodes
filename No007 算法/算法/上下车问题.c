/**
 * 某路公共汽车，总共有八站，
 * 从一号站发轩时车上已有n位乘客，
 * 到了第二站先下一半乘客，再上来了六位乘客；
 * 到了第三站也先下一半乘客，再上来了五位乘客，
 * 以后每到一站都先下车上已有的一半乘客，再上来了乘客比前一站少一个……，
 * 到了终点站车上还有乘客六人，
 * 问发车时车上的乘客有多少？
 */


const int SXCWT_TOTAL_STATION_NUM = 8;
/**
 * @param currentStationNum 当前是第几站
 * @param offPeopleNum 当前下了多少人
 * @return 到站前车上有多少人
 */
int sxcwt_result(double currentStationNum, double offPeopleNum) {
    if (currentStationNum == SXCWT_TOTAL_STATION_NUM) {
        return 6;
    }
    return (sxcwt_result(currentStationNum + 1, SXCWT_TOTAL_STATION_NUM - currentStationNum - 1) - offPeopleNum) * 2;
}