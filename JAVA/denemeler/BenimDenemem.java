package denemeler;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BenimDenemem {
    static ArrayList<BigInteger> list = new ArrayList<>();
    static BigInteger carpim = BigInteger.ONE;
    static BigInteger carpimartibir;
    static List<BigInteger> sonuc = new ArrayList<>();
    


    public static void main (String[] args){
        long count=1;
        BigInteger sayi = new BigInteger("1");
        while (sayi.compareTo(BigInteger.valueOf(100)) < 0){
            sayi=sayi.add(BigInteger.valueOf(2));
            if (sayi.isProbablePrime(40)){
                if (count%1==0){
                    System.out.println(sayi);
                }
               count++;
                list.add(sayi);           
        }
        // BigInteger sayi =new BigInteger("9973");
     }
     System.out.println(BenimDenemem.sonuc);

     ispat();
     asalMi();


}
public static void ispat(){
        
        for (BigInteger sayi : list) {
            carpim = carpim.multiply(sayi);
        }
         carpimartibir=carpim.add(BigInteger.ONE);
        System.out.println("Çarpım: " + carpim);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("yeni sayı: " + carpimartibir);
    }

    public static void asalMi(){
        boolean flag =carpimartibir.isProbablePrime(40);
    if(flag){
        System.out.println("Yeni asal bulundu");
    }
    else{
        asalCarpanlar();
    }

}
 public static void asalCarpanlar() {
      
        BigInteger iki = BigInteger.valueOf(2);

        // 2'leri ayır
        while (carpimartibir.mod(iki).equals(BigInteger.ZERO)) {
            sonuc.add(iki);
            carpimartibir = carpimartibir.divide(iki);
        }

        // tek bölenleri dene: 3,5,7,...
        BigInteger i = BigInteger.valueOf(3);
        while (i.multiply(i).compareTo(carpimartibir) <= 0) {
            while (carpimartibir.mod(i).equals(BigInteger.ZERO)) {
                sonuc.add(i);
                carpimartibir = carpimartibir.divide(i);
                System.out.println(sonuc);
            }
            i = i.add(iki);
            
        }

        // elde kalan >1 ise asaldır
        if (carpimartibir.compareTo(BigInteger.ONE) > 0) {
            sonuc.add(carpimartibir);
        }
System.out.println("bitti");
       
    }

    public static void bulma(){

    }

}
