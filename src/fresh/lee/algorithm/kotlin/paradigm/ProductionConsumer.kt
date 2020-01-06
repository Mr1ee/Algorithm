package fresh.lee.algorithm.kotlin.paradigm

/**
 * Invariant(不变)
 *
 * 如果既将泛型作为函数参数，又将泛型作为函数的输出，那就既不用 in 或 out。
 */
interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}