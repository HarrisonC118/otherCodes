/**
 * 出售金鱼问题：
 * 第一次卖出全部金鱼的一半加二分之一条金鱼；
 * 第二次卖出乘余金鱼的三分之一加三分之一条金鱼；
 * 第三次卖出剩余金鱼的四分之一加四分之一条金鱼；
 * 第四次卖出剩余金鱼的五分之一加五分之一条金鱼；
 * 现在还剩下11条金鱼，在出售金鱼时不能把金鱼切开或者有任何破损的。
 * 问这鱼缸里原有多少条金鱼？
 */


double csjy_result(double currentTime) {
	if (currentTime == 5.00) {
		return 11;
	}
	return ((currentTime + 1) * csjy_result(currentTime + 1) + 1) / currentTime;
}