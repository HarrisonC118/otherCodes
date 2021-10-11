/**
* ¿ìËÙÅÅÐò
*/
void kspx_result(int array[], int left, int right) {
	if (left >= right) {
		return;
	}
	int left_index = left;
	int right_index = right;
	int pivot = array[left_index];
	while (left_index < right_index) {
		while ((right_index > left_index) && array[right_index] >= pivot) {
			right_index--;
		}
		if (left_index < right_index) {
			array[left_index] = array[right_index];
		}
		while ((right_index > left_index) && array[left_index] <= pivot) {
			left_index++;
		}
		if (left_index < right_index) {
			array[right_index] = array[left_index];
		}
		if (left_index == right_index) {
			array[left_index] = pivot;
		}
	}
	kspx_result(array, left, right_index - 1);
	kspx_result(array, left_index + 1, right);
}