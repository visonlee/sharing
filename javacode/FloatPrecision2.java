
public class FloatPrecision2 {
    public static void main(String[] args) {
        float sum = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = 1.0f;
            sum += x;
        }
        System.out.println("sum is " + sum);
    }
    // sum is 1.6777216E7
}
