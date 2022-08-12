import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class SIMD {
   public static void main(String[] args) throws Exception{

      File file1 = new File("C:\\Users\\Administrator\\Desktop\\v1.mp4");
      byte[] fileContent1 = Files.readAllBytes(file1.toPath());

      File file2 = new File("C:\\Users\\Administrator\\Desktop\\v2.mp4");
      byte[] fileContent2 = Files.readAllBytes(file2.toPath());

      long stime = System.currentTimeMillis();
      boolean result1 = Arrays.equals(fileContent1, fileContent2); // SIMD
      long etime = System.currentTimeMillis();

      System.out.println("way1 compare equal: " + result1 + " time :" + (etime - stime));

     
      stime = System.currentTimeMillis();
      boolean result2 = MyArrays.equals(fileContent1, fileContent2);
      etime = System.currentTimeMillis();
      System.out.println("way2 compare, equal: " + result2  + " time :" + (etime - stime));

   }
} 