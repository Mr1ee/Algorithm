package fresh.lee.algorithm.java;

import java.util.Arrays;

public final class Log {
    private Log() {
    }

    private static Log instance;

    public static Log getInstance() {
        if (instance == null) {
            synchronized (Log.class) {
                if (instance == null) {
                    instance = new Log();
                }
            }
        }
        return instance;
    }

    public void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void print(int arr) {
        System.out.print(arr);
    }

    public void println(int arr) {
        System.out.println(arr);
    }

}
