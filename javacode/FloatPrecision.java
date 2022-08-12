
public class FloatPrecision {
    public static void main(String[] args) {
        float a = 20000000.0f;
        float b = 1.0f;
        float c = a + b;
        System.out.println("c is " + c);
        float d = c - a;
        System.out.println("d is " + d);
    }
    // c is 2.0E7
    //d is 0.0
}
