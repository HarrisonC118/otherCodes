/**
* ∫œ≤¢≈≈–Ú
*/
void merge(int target[], int left, int middle, int right) {
    int i, j, k;
    int* b = (int*)malloc(sizeof(int) * (right - left + 1));

    for (i = middle + 1, k = 0, j = left; j <= middle && i <= right; ++k) {
        if (target[j] <= target[i]) {
            b[k] = target[j++];
        } else {
            b[k] = target[i++];
        }
    }
    while (j <= middle) {
        b[k] = target[j];
        k++;
        j++;
    }while (i <= right) {
        b[k] = target[i];
        k++;
        i++;
    }
    for (i = left, k = 0; i <= right; i++, k++) {
        target[i] = b[k];
    }
}
void merge_sort(int target[], int left, int right) {
    if (left < right){
        int middle = (left + right) / 2;
        merge_sort(target, left, middle);
        merge_sort(target, middle + 1, right);
        merge(target, left, middle, right);
    }
}