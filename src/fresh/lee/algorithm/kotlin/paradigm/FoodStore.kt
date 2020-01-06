package fresh.lee.algorithm.kotlin.paradigm

/**
 * In(逆变)
 *
 * 如果你的类是将泛型对象作为函数的参数，那么可以用 in：
 *
 * 可以称其为 consumer class/interface，因为其主要是消费指定泛型对象。
 * 因此，可以这样来记：consume = input = in。
 * 简单来说就是只能作为入参（或者只能set）
 *
 * 类似Java PECS（product Extends， consumer Supper ）
 * P out， C in
 */
interface Consumer<in T> {
    fun consume(item: T)
}

/**
 * Out (协变)
 *
 * 如果你的类是将泛型作为内部方法的返回，那么可以用 out：
 * 可以称其为 production class/interface，因为其主要是产生（produce）指定泛型对象。
 * 因此，可以这样来记：produce = output = out。
 *
 * 因此，对于 out 泛型，我们能够将使用子类泛型的对象赋值给使用父类泛型的对象
 * 简单来说就是只能作为出参（或者只能get）
 *
 * 类似Java PECS（product Extends， consumer Supper ）
 * P out， C in
 */
interface Production<out T> {
    fun produce(): T
}


class FoodStore : Production<Food> {
    override fun produce(): Food {
        println("Produce food")
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun produce(): FastFood {
        println("Produce food")
        return FastFood()
    }
}

class InOutBurger : Production<Burger> {
    override fun produce(): Burger {
        println("Produce burger")
        return Burger()
    }
}

class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println("Eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat fast food")
    }
}

class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        println("Eat burger")
    }
}

fun main() {
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<Food> = InOutBurger()
    (production1.produce())
    (production2.produce())
    (production3.produce())

//    val production11 : Production<Burger> = FoodStore()  // Error
//    val production22 : Production<Burger> = FastFoodStore()  // Error
//    val production33 : Production<Burger> = InOutBurger()
    //因此，对于 out 泛型，我们能够将使用子类泛型的对象赋值给使用父类泛型的对象


    val consumer1: Consumer<Burger> = Everybody()
    val consumer2: Consumer<Burger> = ModernPeople()
    val consumer3: Consumer<Burger> = American()
    (consumer1.consume(Burger()))
    (consumer2.consume(Burger()))
    (consumer3.consume(Burger()))

    val consumer11: Consumer<Food> = Everybody()
    val consumer22: Consumer<FastFood> = ModernPeople()

    val list: ArrayList<Consumer<in Burger>> = arrayListOf()
    list.add(consumer1)
    list.add(consumer2)
    list.add(consumer3)
    list.add(consumer11)
    list.add(consumer22)

    for (consumer in list) {
        consumer.consume(Burger())
    }

//    val consumer11 : Consumer<Food> = Everybody()
//    val consumer22 : Consumer<Food> = ModernPeople()  // Error
//    val consumer33 : Consumer<Food> = American()  // Error
    //因此，对于 in 泛型，我们可以将使用父类泛型的对象赋值给使用子类泛型的对象。


    //父类泛型对象可以赋值给子类泛型对象，用 in；
    //子类泛型对象可以赋值给父类泛型对象，用 out。

    val foodlist: ArrayList<FastFood> = arrayListOf(Burger())

    //只能set 能get，但是取得都是Any? 类型
    var foods: ArrayList<in FastFood> = arrayListOf()
//    foods.add(Food()) //error ??? 这个很奇怪啊，为什么add Food？
    foods.add(FastFood())
    foods.add(Burger())
//    foods.addAll(foodlist)  //error ??? 这个也很奇怪zzzz
//    foods = foodlist
    for (food in foods) {

    }

    // 只能get 不能set
    val foods2: ArrayList<out Food> = arrayListOf(Food(), FastFood(), Burger())
//    foods2[4] = Burger() error
    for (food in foods2) {
        println(food.name)
    }
}