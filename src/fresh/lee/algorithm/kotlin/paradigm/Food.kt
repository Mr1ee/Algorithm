package fresh.lee.algorithm.kotlin.paradigm

open class Food(open val name: String = "food") {}

open class FastFood(override val name: String = "fast food") : Food(name) {}

class Burger(override val name: String = "burger") : FastFood(name) {}