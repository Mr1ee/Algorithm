package fresh.lee.algorithm.kotlin.paradigm

/**
 * Out (协变)
 *
 * 如果你的类是将泛型作为内部方法的返回，那么可以用 out：
 * 可以称其为 production class/interface，因为其主要是产生（produce）指定泛型对象。
 * 因此，可以这样来记：produce = output = out。
 *
 * 因此，对于 out 泛型，我们能够将使用子类泛型的对象赋值给使用父类泛型的对象
 *
 * 类似Java PECS（product Extends， consumer Supper ）
 * P out， C in
 */
interface Production<out T> {
    fun produce(): T
}