package _01_递归.上下车问题;

/**
 * 某路公共汽车，总共有八站，
 * 从一号站发轩时车上已有n位乘客，
 * 到了第二站先下一半乘客，再上来了六位乘客；
 * 到了第三站也先下一半乘客，再上来了五位乘客，
 * 以后每到一站都先下车上已有的一半乘客，再上来了乘客比前一站少一个……，
 * 到了终点站车上还有乘客六人，
 * 问发车时车上的乘客有多少？
 */

/**
 * @author: HatcherCheung
 * Date:  2021/9/13
 */
public class Index {
    private static final Integer TOTAL_STATION_NUM = 8;
    public static void main(String[] args) {
        System.out.println(result(2,6));
    }

    /**
     * @param currentStationNum 当前是第几站
     * @param offPeopleNum 当前下了多少人
     * @return 到站前车上有多少人
     */
    public static double result(double currentStationNum, double offPeopleNum) {
        if (currentStationNum == TOTAL_STATION_NUM) {
            return 6;
        }
        return (result(currentStationNum + 1,TOTAL_STATION_NUM - currentStationNum - 1) - offPeopleNum) * 2 ;
    }
}
