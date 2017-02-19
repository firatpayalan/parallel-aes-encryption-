package payalan;

/**
 * Tek proses,multithreaded bir yapida sifreleme yapmaktadir.Thread sayisi
 * statik bir degiskende tutulmaktadir.Giris verisi yaklasik 4 MB buyuklugunde
 * olmaktadir.
 *
 */
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CJavaThreadedEncryption extends CKernel implements Runnable
{

    byte[]                   encBytes       = new byte[16];                   //sifreleme oncesi gelen buyuk veriyi parcalamada kullanilan kucuk 16 byte blok.
    ArrayList<byte[]>        encryptedValue = new ArrayList<>();              //sifrelenmiş parcali verilerin bir ArrayList te tutulmasi.
    SecureRandom             sec            = new SecureRandom();
    byte[]                   source         = sec.generateSeed(plainByteSize); //sifrelenmeye hazirlanacak giris verisi burada olusturulmaktadir.
    int                      index          = 0;                              //Giris(plain) veriyi bloklar halinde parcalamak icin kullanilacak pointer index degiskenidir.
    private static final int NTHREDS        = 10;                             //Olusturulan thread sayisi.

    @Override
    public void run()
    {

        getCipher().encrypt(encBytes);
        //        System.out.println("Encrypted text = " + Hex.encodeHexString(encBytes));
        encryptedValue.add(encBytes);

    }

    public void encrypt()
    {
        //        System.out.println("Data size = " + source.length + " byte");
        System.out
                .println("AES ENCRYPTION WITH JAVA THREADED WORKFLOW........");
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        startTime = System.currentTimeMillis();
        while (index < source.length)
        {
            System.arraycopy(source, index, encBytes, 0,
                    Math.min(source.length, 16));
            executor.execute(this);
            index = index + 16;
        }
        executor.shutdown();
        stopTime = System.currentTimeMillis();
        measuredTime = stopTime - startTime;
        System.out.println("Elapsed time=" + measuredTime + " ms");
    }

}
