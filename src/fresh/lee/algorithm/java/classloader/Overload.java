package fresh.lee.algorithm.java.classloader;

import java.io.Serializable;

/***
 * 下面的代码运行后会输出：
 * ```java
 * hello char
 * ```
 * 这很好理解， 'a'是一个char类型的数据， 自然会寻找参数类型为char的重载方法， 如果注释掉sayHello（ char arg） 方法， 那输出会变为：
 * ```java
 * hello int
 * ```
 * 这时发生了一次自动类型转换， 'a'除了可以代表一个字符串， 还可以代表数字97（ 字符'a'的Unicode数值为十进制数字97） ， 因此参数类型为int的重载也是合适的。 我们继续注释掉sayHello（ int arg） 方法， 那输出会变为：
 * ```java
 * hello long
 * ```
 * 这时发生了两次自动类型转换， 'a'转型为整数97之后， 进一步转型为长整数97L， 匹配了参数类型为long的重载。实际上自动转型还能继续发生多次， 按照char-＞ int-＞ long-＞ float-＞ double的顺序转型进行匹配。 但不会匹配到byte和short类型的重载， 因为char到byte或short的转型是不安全的。 我们继续注释掉sayHello（ long arg） 方法， 那输出会变为：
 * ```java
 * hello Character
 * ```
 * 这时发生了一次自动装箱， 'a'被包装为它的封装类型java.lang.Character， 所以匹配到了参数类型为Character的重载， 继续注释掉sayHello（ Character arg） 方法， 那输出会变为：
 * ```java
 * hello Serializable
 * ```
 * 这个输出可能会让人感觉摸不着头脑， 一个字符或数字与序列化有什么关系？ 出现helloSerializable， 是因为java.lang.Serializable是java.lang.Character类实现的一个接口， 当自动装箱之后发现还是找不到装箱类， 但是找到了装箱类实现了的接口类型， 所以紧接着又发生一次自动转型。 char可以转型成int， 但是Character是绝对不会转型为Integer的， 它只能安全地转型为它实现的接口或父类。继续注释掉sayHello（ Serializable arg） 方法， 输出会变为：
 * ```java
 * hello Object
 * ```
 * 这时是char装箱后转型为父类了， 如果有多个父类， 那将在继承关系中从下往上开始搜索， 越接近上层的优先级越低。 即使方法调用传入的参数值为null时， 这个规则仍然适用。我们把sayHello（ Object arg） 也注释掉， 输出将会变为：
 * ```java
 * hello char……
 * ```
 */
public class Overload {

    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char……");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
