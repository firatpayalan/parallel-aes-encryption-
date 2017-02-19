import payalan.CJavaThreadedEncryption;
import payalan.CSequentalEncryption;

/**
 * Uygulama AES sifreleme teknigini iki farkli performansta sifreleme yapar.
 * 1-CSequentalEncryption Tek proses,tek thread de sifreleme yapar.
 * 2-CJavaThreadedEncryption Tek proses,multithreaded şifreleme yapar.Thread
 * sayisi CJavaThreadedEncryption sinifinin icinde tanimlidir.
 *
 * @author 11000
 *
 */
public class CTest
{
    static CSequentalEncryption        seqenc           = new CSequentalEncryption();
    static CJavaThreadedEncryption     javaThreaded     = new CJavaThreadedEncryption();

    public static void main(String args[]) throws Exception
    {
        seqenc.encrypt();
        javaThreaded.encrypt();
    }

}