package fresh.lee.algorithm.kotlin.paradigm


/**
 * In(逆变)
 *
 * 如果你的类是将泛型对象作为函数的参数，那么可以用 in：
 *
 * 可以称其为 consumer class/interface，因为其主要是消费指定泛型对象。
 * 因此，可以这样来记：consume = input = in。
 *
 * 类似Java PECS（product Extends， consumer Supper ）
 * P out， C in
 */
interface Consumer<in T> {
    fun consume(item: T)
}