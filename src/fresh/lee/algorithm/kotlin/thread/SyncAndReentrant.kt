package fresh.lee.algorithm.kotlin.thread

import kotlin.concurrent.thread
import java.util.concurrent.locks.ReentrantLock


class Person {
    companion object {
        var COUNT = 30
    }

    private val lock = ReentrantLock()

    // 同一时间只允许一个线程吃
    @Synchronized
    fun eat() {
        print("开始吃   ")
        COUNT--
        print("  吃东西-$COUNT")
        print("   吃完了\n")
    }

    fun eatWithSeq() {
        synchronized(Person::class.java) {
            print("开始吃   ")
            COUNT--
            print("  吃东西-$COUNT")
            print("   吃完了\n")
        }
    }

    fun eatReentrant() {
        lock.lock()
        // 为了保证锁释放，所以每次lock之后都用try-catch-finally
        try {
            print("开始吃   ")
            COUNT--
            print("  吃东西-$COUNT")
            print("   吃完了\n")
        } finally {
            lock.unlock()
        }
    }

}

fun main() {

    val thread0 = Thread {
        for (i in 0..2) {
            val p = Person()
            p.eat()
        }
    }

    val thread1 = Thread {
        for (i in 0..2) {
            val p = Person()
            p.eat()
        }
    }

    val thread2 = Thread {
        for (i in 0..2) {
            val p = Person()
            p.eat()
        }
    }

    thread0.start()
    thread1.start()
    thread2.start()

    Thread.sleep(300)
    //synchronized关键字修饰普通方法是对象锁，只能锁住一个对象，
    //synchronized关键字修饰静态方法是 类锁，可以锁住所有类的实例（对象）
    //乱序！！！ 因为synchronized关键字修饰普通方法不能锁多个对象！！！，
    //开始吃   开始吃     吃东西-9  吃东西-8开始吃      吃完了
    //开始吃      吃完了
    //开始吃     吃东西-6   吃完了
    //  吃东西-7   吃完了
    //开始吃   开始吃     吃东西-3   吃完了
    //  吃东西-5   吃完了
    //  吃东西-4   吃完了
    //开始吃   开始吃     吃东西-1   吃完了
    //  吃东西-2   吃完了


    // synchronized(Person::class.java)
    println()
    println("synchronized(Person::class.java)")
    thread(start = true) {
        for (i in 0..2) {
            val p = Person()
            p.eatWithSeq()
        }
    }

    thread(start = true) {
        for (i in 0..2) {
            val p = Person()
            p.eatWithSeq()
        }
    }

    thread(start = true) {
        for (i in 0..2) {
            val p = Person()
            p.eatWithSeq()
        }
    }
    // 顺序执行，因为synchronized锁住了Person整个类对象
    //开始吃     吃东西-0   吃完了
    //开始吃     吃东西--1   吃完了
    //开始吃     吃东西--2   吃完了
    //开始吃     吃东西--3   吃完了
    //开始吃     吃东西--4   吃完了
    //开始吃     吃东西--5   吃完了
    //开始吃     吃东西--6   吃完了
    //开始吃     吃东西--7   吃完了
    //开始吃     吃东西--8   吃完了

    println()
    println("reentrant lock")
    thread(start = true) {
        val p = Person()
        p.eatReentrant()
    }

    thread(start = true) {
        val p = Person()
        p.eatReentrant()
    }

    thread(start = true) {
        val p = Person()
        p.eatReentrant()
    }
    // ReentrantLock
    // 顺序执行
    //开始吃     吃东西-0   吃完了
    //开始吃     吃东西--1   吃完了
    //开始吃     吃东西--2   吃完了
    //开始吃     吃东西--3   吃完了
    //开始吃     吃东西--4   吃完了
    //开始吃     吃东西--5   吃完了
    //开始吃     吃东西--6   吃完了
    //开始吃     吃东西--7   吃完了
    //开始吃     吃东西--8   吃完了

}