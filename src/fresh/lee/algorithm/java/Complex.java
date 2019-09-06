package fresh.lee.algorithm.java;

/**
 * @author lihuayong
 * @version 1.0
 * @description Complex 复数对象
 * @date 2019-09-06
 * <p>
 * Effective java 重写hashCode equals标准写法
 */
public class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * @param re 实数域
     * @param im 虚数域
     * @return 一个复数（Complex）对象
     */
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    /**
     * 极坐标形式的复数
     *
     * @param r     极坐标半径
     * @param theta 极坐标角度
     */
    public static Complex valueOfPolar(double r, double theta) {
        return new Complex(r * Math.cos(theta), r * Math.cos(theta));
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.re + im * c.im);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex(re * c.re + im * c.im / tmp, re * c.re - im * c.im / tmp);
    }

    /**
     * hashCode 计算方式
     * i.    如果域是boolean型，则计算 (f ? 1 : 0)
     * ii.   如果域是byte、char、short或者int型，则计算 int(f)
     * iii.  如果域是long型，则计算 (int)(f ^ (f >>> 32))
     * iv.   如果域是float型，则计算 Float.floatToIntBits(f)
     * v.    如果域是Double型，则计算 Double.doubleToIntBits(f)，然后按照步骤 iii，为得到的long型值计算散列值
     * vi.   如果该域是一个对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域。
     * 则同样为这个域递归地调用hashCode。如果需要更复杂的比较，则为这个域计算一个"范式"，
     * 然后针对这个范式调用hashCode。如果这个域的值为null，这返回0。
     * <p>
     * vii.  如果这个域是一个数组，则要把每一个元素当作单独的域来处理。也就是说，递归地应用上述规则，
     * 对每一个元素计算一个散列码，然后根据下面的方式把散列值组合起来。如果数组域的每个元素都很重要
     * 可以利用Arrays.hashCode的方法。
     * <p>
     * <p>
     * example:
     * <p>
     * int i;
     * long l;
     * float f;
     * double d;
     * int[] array;
     * <p>
     * int hashCode = 17 + i;
     * hashCode = 31 * hashCode + (int)(l ^ (l >>> 32));
     * hashCode = 31 * hashCode + Float.floatToIntBits(f);
     * hashCode = 31 * hashCode + (int)(Double.doubleToIntBits(d) ^ (Double.doubleToIntBits(d) >>> 32));
     * hashCode = 31 * hashCode + Arrays.hashCode(array);
     * <p>
     * 通常选用一个素数（17）作为开始，31做乘法。VM可以把 31 * i 优化成 (i << 5) - i
     */
    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    }

    /**
     * 重写equals 需要遵守以下协定:
     * 需要满足自反性，对称性，传递性，一致性。
     * <p>
     * 不要在equals里面做太多"智能"的事情
     */
    @Override
    public boolean equals(Object o) {
        // 1 引用地址判断
        if (o == this) {
            return true;
        }

        // instanceof 判断
        if (!(o instanceof Complex)) {
            return false;
        }

        // 其他判断
        Complex c = (Complex) o;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    /**
     * 尽量为每一个类重写toString方式
     */
    @Override
    public String toString() {
        return "(" + re + " ," + im + ")";
    }
}
