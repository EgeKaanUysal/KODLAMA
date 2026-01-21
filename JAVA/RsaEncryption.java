import java.util.Random;
import java.lang.Math;
@SuppressWarnings("unused")
public class RsaEncryption {
    long p;
    long q;
    long n;
    long phi;//tamam
    long e;//tamam
    long d; //tamam
    long encryptedmassege;
    
    public RsaEncryption(long p, long q){
        n=p*q;
        phi= (p-1)*(q-1);
        calculeteE();
        calculeteD();
        
    }   
        public void calculeteE(){
        for (e=3; e<phi;e+=2){
            
            if (gcd(e,phi)==1 ){
                System.out.println("e nin değeri :"+e);
                return;

            }}

               
        
    }
        public void calculeteD(){
            //e*d mod phi== 1 
           
            long k=1;
            byte s=0;
            while (s<1){ 
                if ((1 + k * phi) % e == 0 & k<phi) {
                    d = (1 + k * phi) / e;
                    System.out.println("d nin değeri :"+d);
                    s++;
                    
                   
                }
                k++;
            }

        }
        public long encryption(long originalMassage){
           return specialAlgorithm(originalMassage, e)%n;


        }




   public long specialAlgorithm(long m, long e ) {
    encryptedmassege = 1;
    m = m % n;   // ilk mod, taşmayı önler

    while (e > 0) {
        // Eğer e tekse (son bit 1 ise)
        if ((e & 1) == 1) {
            encryptedmassege = (encryptedmassege * m) % n;
            System.out.println("chatgpt'nin değeri :" + encryptedmassege);
        }

        // kare al
        m = (m * m) % n;

        // e'yi 2'ye böl (binary'de sağa kaydır)
        e = e >> 1;
    }

    return encryptedmassege;
}








 public long gcd(long... nums) {

    long result = nums[0];

    for (int i = 1; i <nums.length; i++) {
        result = gcd(result, nums[i]);
    }

    return result;
}

 public long gcd(long a, long b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
        long r = a % b; //r=4
        a = b;//a=12
        b = r;//4
    }
    return a;
}

public long decryption(){
    long decryptedmassege= specialAlgorithm(encryptedmassege,d );
    return decryptedmassege;
}


    // önce n'yi hesapla
    // sonra phi
    // sonra e seç 
    // en son d


    // public: (n,e)
    // close: (p,q,phi,d)

        // private long üsAlımı(long alttakiSayı, long üsttekiSayı){

        //     long ilksayı=alttakiSayı;
        //   for(var i=1; i<üsttekiSayı;i++){
        //     alttakiSayı*=ilksayı;
        //     System.out.println(alttakiSayı+"   :alttaki sayı");
        //   }

        //   return alttakiSayı;
        // }
}
// class decryption extends Rsaenyeni{
    
//     public decryption(long p, long q) {
//         super(p, q);  
//     }


// }