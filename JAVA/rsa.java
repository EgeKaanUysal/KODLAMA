import java.util.Random;
import java.math.BigInteger;
@SuppressWarnings("unused")
public class rsa {
    public static void main(String[] args) {
      RsaEncryption rsaEncryption = new RsaEncryption(asalVer(),asalVer());
      long a = rsaEncryption.encryption(12_45_20_23L);
      System.out.println(a);
      System.out.println("------------------");
      System.out.println("decrypted massege :"+rsaEncryption.decryption());
      
    }
    static long asalVer(){
 Random rnd = new Random();

while (true) {
    int n = rnd.nextInt(10000, 200000);

    if (n % 2 == 0) continue;

    boolean prime = true;
    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0) {
            prime = false;
            break;
        }
    }

    if (prime) {
      System.out.println("asal sayı :"+n);
        return n;
        
    }
}

    

    }}  

