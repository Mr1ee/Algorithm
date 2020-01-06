package fresh.lee.algorithm.kotlin.paradigm

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

//    val consumer11 : Consumer<Food> = Everybody()
//    val consumer22 : Consumer<Food> = ModernPeople()  // Error
//    val consumer33 : Consumer<Food> = American()  // Error
    //因此，对于 in 泛型，我们可以将使用父类泛型的对象赋值给使用子类泛型的对象。


    //父类泛型对象可以赋值给子类泛型对象，用 in；
    //子类泛型对象可以赋值给父类泛型对象，用 out。

}