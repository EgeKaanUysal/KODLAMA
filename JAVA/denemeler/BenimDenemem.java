package denemeler;
import java.math.BigInteger;
public class BenimDenemem {
    public static void main (String[] args){
        BigInteger sayi = new BigInteger("1");
        while (sayi.compareTo(BigInteger.valueOf(1000000)) < 0){
            sayi=sayi.add(BigInteger.valueOf(2));
            if (sayi.isProbablePrime(40)){
                System.out.println(sayi);           
        }
        // BigInteger sayi =new BigInteger("9973");
        
    }
}

}