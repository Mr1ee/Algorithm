package fresh.lee.algorithm.java.classloader;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewStudentMain implements Serializable {

    public static void main(String[] args) {
        Class<Student> cls =  Student.class;
//        try {
//            student = cls.newInstance();  //报异常！
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        Student student = null;
        Constructor<Student> constructor = null;
        try {
            constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            student = constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        student.name = "lihua";
        System.out.println(student.name);

        Student.Sub sb = new Student.Sub();
        sb.name = "zhangsan";
        System.out.println(sb.name);
    }
}
