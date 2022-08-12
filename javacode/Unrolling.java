public class Unrolling {

    public static void main(String[] args)
    {
     
    // n is 8 lakhs
    int n = 800000;
     
    // t to note start time
    double t1 = (double)System.nanoTime();
     
    // to store the sum
    long sum = 0;
     
    // Normal loop
    for (int i = 1; i <= n; i++)
        sum += i;
     
    // to mark end time
    t1 = (double)System.nanoTime() - t1;
     
    System.out.println("sum is: "+
        Double.toString(sum));
    System.out.println("time taken by normal loops:" +
        Double.toString(t1 / Math.pow(10.0, 9.0)));
     
    // to mark start time
    // of unrolling
    double t2 = (double)System.nanoTime();
     
    // Unrolling technique
    // (assuming that n is
    // a multiple of 8).
    sum = 0;
    for (int i = 1; i <= n; i += 8)
    {
        sum += i ;
        sum += (i + 1);
        sum += (i + 2);
        sum += (i + 3);
        sum += (i + 4);
        sum += (i + 5);
        sum += (i + 6);
        sum += (i + 7);
    }
     
    // to mark the end of loop
    t2 = (double)System.nanoTime() - t2;
     
    System.out.println("sum is: " +
        Double.toString(sum));
    System.out.println("time taken by Unrolling loops:" +
        Double.toString(t2 / Math.pow(10.0, 9.0)));

        System.out.println("Unrolling loops is " + (t1 / t2) + " times faster than normal loops");
    }

    // CSAPP chapter6
    // sum is: 3.200004E11
    // time taken by normal loops:0.002537
    // sum is: 3.200004E11
    // time taken by Unrolling loops:4.385E-4
    // Unrolling loops is 5.785632839224629 times faster than normal loops
}
