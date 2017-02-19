package payalan;

/**
 * Tek proses,tek thread ile sifreleme yapmaktadir.Giris olarak veri buyuklugu
 * yaklasik 4 MB civarindadir. Program calistirildiktan sonra sifrelenmis
 * dosyanin buyuklugu ve sifreleme suresini gosteren cikti gonderir.
 *
 * @author 11000
 */
import java.security.SecureRandom;
import java.util.ArrayList;

public class CSequentalEncryption extends CKernel
{

    public void encrypt()
    {
        System.out.println("AES ENCRYPTION WITH SEQUENTAL WORKFLOW........");
        byte[] encBytes = new byte[16]; //sifreleme oncesi gelen buyuk veriyi parcalamada kullanilan kucuk 16 byte blok.
        ArrayList<byte[]> encryptedValue = new ArrayList<>(); //sifrelenmiş parcali verilerin bir ArrayList te tutulmasi.
        SecureRandom sec = new SecureRandom();
        byte[] source = sec.generateSeed(plainByteSize);
        //        System.out.println("Data size = " + source.length + " byte");
        int index = 0;
        startTime = System.currentTimeMillis();
        while (index < source.length)
        {
            System.arraycopy(source, index, encBytes, 0,
                    Math.min(source.length, 16));
            //            System.out.println(Hex.encodeHexString(encBytes));
            getCipher().encrypt(encBytes);
            encryptedValue.add(encBytes);
            index = index + 16;
        }
        stopTime = System.currentTimeMillis();
        //--------------------------------
        measuredTime = stopTime - startTime;
        System.out.println("Passed time =" + measuredTime + " ms");
    }

}