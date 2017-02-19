package payalan;
/**

 * Programda kullanilan temel fonksiyonlar ve ilklendirlmeler burada yer

 * almaktadir.

 *

 * @author 11000

 */

import edu.rit.crypto.blockcipher.AES256Cipher;

public class CKernel
{
    static long          startTime, stopTime, measuredTime;
    static String        key                   = "b661ca5d5df7e4e66944751923247a91c1632bf1dc5821a5cd8d83fd4d8d439f"; //256 bit key.    
    static byte[]        byteKey               = edu.rit.util.Hex
            .toByteArray(key);                                           //String -> Byte conversion.
    private AES256Cipher cipher;
    static int           plainByteSize         = 4194304;
    static int           parallelPlainByteSize = 65536;

    public AES256Cipher getCipher()
    {
        return cipher;
    }

    public void setCipher(AES256Cipher cipher)
    {
        this.cipher = cipher;
    }

    public CKernel()
    {
        setCipher(new AES256Cipher(byteKey));

    }

}