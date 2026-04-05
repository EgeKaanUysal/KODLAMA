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
        BigInteger sayi2 = new BigInteger("30");
        while (sayi.compareTo(sayi2) <= 0){
            sayi=sayi.add(BigInteger.valueOf(2));
            if (sayi.isProbablePrime(40)&&sayi.compareTo(sayi2) <= 0){
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
     BigInteger asılbaba= new BigInteger("1");
     for (BigInteger zikkim :list){
        asılbaba=asılbaba.multiply(zikkim);
     }
     System.out.println();
     System.out.println(asılbaba);
     if (carpim.equals(asılbaba)){
        // System.out.println("eşit");
     }
     else{
        // System.out.println("eşit değil");
     }
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
        boolean flag = carpimartibir.isProbablePrime(40);
        if(flag){
            System.out.println("Yeni asal bulundu");
        }
        else{
            asalCarpanlar();
        }
    }

    public static void asalCarpanlar() {
        BigInteger n = carpimartibir; // geçici kopya, carpimartibir bozulmuyor
        BigInteger iki = BigInteger.valueOf(2);

        // 2'leri ayır
        while (n.mod(iki).equals(BigInteger.ZERO)) {
            sonuc.add(iki);
            n = n.divide(iki);
        }

        // tek bölenleri dene: 3,5,7,...
        BigInteger i = BigInteger.valueOf(3);
        while (i.multiply(i).compareTo(n) <= 0) {
            while (n.mod(i).equals(BigInteger.ZERO)) {
                sonuc.add(i);
                n = n.divide(i);
            }
            i = i.add(iki);
        }

        // elde kalan >1 ise asaldır
        if (n.compareTo(BigInteger.ONE) > 0) {
            sonuc.add(n);
        }
        System.out.println("Asal çarpanlar: " + sonuc);
        System.out.println("asal çarpanların çarpımı: " + sonuc.stream().reduce(BigInteger.ONE, BigInteger::multiply));
        System.out.println("bitti");
    }

    public static void bulma(){

    }
}