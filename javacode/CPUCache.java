
public class CPUCache {

    // 数组大小：数组越大，性能差距越明显
    private static final int ARR_SIZE = 9999;

    public static void main(String[] args) {
        case1();
        case2();
    }

    private static void case1() {
        int[] arr = new int[64 * 1024 * 1024];

        double t = (double) System.nanoTime();
        for (int i = 0; i < arr.length; i++)
            arr[i] *= 3;
        t = (double) System.nanoTime() - t;
        System.out.println("time1: " + t);

        t = (double) System.nanoTime();
        for (int i = 0; i < arr.length; i += 16)
            arr[i] *= 3;
        t = (double) System.nanoTime() - t;
        System.out.println("time2: " + t);
    }


    private static void case2() {
        // 新数组
        int arr[][] = new int[ARR_SIZE][ARR_SIZE];
        long currTime = System.currentTimeMillis();
        colMajor(arr);
        System.out.println("Total time in colMajor : " + (System.currentTimeMillis() - currTime) + " ms");

        // 新数组，与arr完全相同
        int arr1[][] = new int[ARR_SIZE][ARR_SIZE];
        currTime = System.currentTimeMillis();
        rowMajor(arr1); // this is the only difference in above
        System.out.println("Total time in rowMajor : " + (System.currentTimeMillis() - currTime) + " ms");
    }

    private static void colMajor(int arr[][]) {
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                arr[i][j] = i + j;
            }
        }
    }

    private static void rowMajor(int arr[][]) {
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                arr[j][i] = i + j;
            }
        }
    }
}