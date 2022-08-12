import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ZeroCopy {

    public static void main(String[] args) throws Exception {
   
        String src = "C:\\Users\\Administrator\\Desktop\\sharing\\1.mp4";
        String dst1 = "C:\\Users\\Administrator\\Desktop\\sharing\\2.mp4";
        String dst2 = "C:\\Users\\Administrator\\Desktop\\sharing\\3.mp4";

        long t = System.currentTimeMillis();
        copy(src, dst1);
        t = System.currentTimeMillis() - t;
        System.out.println("copy time: " + t);

        t = System.currentTimeMillis();
        zeroCopy(src, dst2);// DMA
        t = System.currentTimeMillis() - t;
        System.out.println("zeroCopy time: " + t);
    }

    public static void zeroCopy(String from, String to) throws IOException {

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(from).getChannel();
            destination = new FileOutputStream(to).getChannel();
            source.transferTo(0, source.size(), destination);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    public static void copy(String from, String to) throws IOException {

        byte[] data = new byte[8 * 1024];
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long bytesToCopy = new File(from).length();
        long bytesCopied = 0;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            while (bytesCopied < bytesToCopy) {
                fis.read(data);
                fos.write(data);
                bytesCopied += data.length;
            }
            fos.flush();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
