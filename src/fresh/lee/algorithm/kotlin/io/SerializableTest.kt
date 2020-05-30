package fresh.lee.algorithm.kotlin.io

import java.io.*

fun main() {
    val lee = Person("lee", 28)
    val dir = "/Users/xxxx/Desktop/wanandroid/Algorithm/src/fresh/lee/algorithm/kotlin/io"
    val file = File(dir, "lee.obj")
    val oss = ObjectOutputStream(FileOutputStream(file))
    oss.writeObject(lee)
    oss.close()

    val file1 = File(dir, "lee.obj")
    val ois = ObjectInputStream(FileInputStream(file1))
    val lee1 = ois.readObject() as Person
    ois.close()
    println(lee1)

    val leeA = AnonymousPerson("lee", 28)
    val fileA = File(dir, "lee1.obj")
    val ossA = ObjectOutputStream(FileOutputStream(fileA))
    ossA.writeObject(leeA)
    ossA.close()

    val file2 = File(dir, "lee1.obj")
    val ois2 = ObjectInputStream(FileInputStream(file2))
    val lee2 = ois2.readObject() as AnonymousPerson
    ois2.close()
    println(lee2)
}

class Person(var name: String?, var age: Int) : Serializable {
    override fun toString(): String {
        return "Person{" +
                "name='" + name + '\''.toString() +
                ", age=" + age +
                '}'.toString()
    }
}

class AnonymousPerson(@Transient var name: String?, var age: Int) : Serializable {
    override fun toString(): String {
        return "AnonymousPerson{" +
                "name='" + name + '\''.toString() +
                ", age=" + age +
                '}'.toString()
    }
}