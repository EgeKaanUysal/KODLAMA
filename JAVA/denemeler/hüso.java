package denemeler;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


public class hüso {
    
    static boolean flag=true;
    static boolean ifprime; static int count=0;
    static long x;
    static BigInteger sayi=new BigInteger("1");
    
   public static void main(String... args){

// farklışey();
ilkşey();

BigInteger zk = sayi.divide(new BigInteger("31536000"));
System.out.println("Bölüm: " + zk);

}


static void farklışey(){
    x=1;
    System.out.println(x);
for (long i=1;i<=50;i++){
    x=x*i;
    System.out.println(x);
    
}
}
static void ilkşey(){
 

for (int i=1;i<=52;i++){
    BigInteger başkasayı = BigInteger.valueOf(i);

sayi=sayi.multiply(başkasayı);
System.out.println(sayi);
// System.out.println(i);
}

}
}