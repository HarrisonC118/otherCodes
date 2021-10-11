//void dgdxsc_result(int q) {
//    if (q > 0) {
//        // 如果是最后一次输出，则不输出逗号
//        // 输出最后一位
//        if (q / 10 != 0) {
//            printf("%d,", q % 10);
//        }
//        else {
//            printf("%d", q % 10);
//        }
//        // 每次除以10，原来的数都会去掉最后一位
//        dgdxsc_result(q / 10);
//    }
//}