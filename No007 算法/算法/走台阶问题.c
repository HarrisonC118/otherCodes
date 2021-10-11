int ztjwt_result(int left) {
    if (2 == left) {
        return 2;
    }
    else if (1 == left) {
        return 1;
    }
    else {
        return ztjwt_result(left - 2) + ztjwt_result(left - 1);
    }
}