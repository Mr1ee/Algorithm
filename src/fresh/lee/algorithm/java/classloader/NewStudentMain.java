package fresh.lee.algorithm.java.classloader;

import com.google.gson.internal.UnsafeAllocator;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewStudentMain implements Serializable {

    public static void main(String[] args) throws Exception {
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

        Student student2 = UnsafeAllocator.create().newInstance(Student.class);
        System.out.println(student2);
        student2.name = "落花滿天蔽月光，借一杯附薦鳳臺上";
        System.out.println(student2.name);

    }
}
