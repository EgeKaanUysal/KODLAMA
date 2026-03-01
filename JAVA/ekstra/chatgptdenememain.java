package ekstra;
import java.math.BigInteger;
import java.security.SecureRandom;
public class chatgptdenememain {
    public static void main(String[] args) {
        for (int i=0; i<1; i++ ){
            
        

        randomprime randomprime = new randomprime();
        ConvertChart convertChart = new ConvertChart();
        BigInteger messege =convertChart.stringToBigInteger("Bu çok gizli bir mesaj kimse bunu okuyamaz");

            // 10^100 ile başla, daha büyük istersen pow() değerini artır
            BigInteger min = BigInteger.TEN.pow(200);
            BigInteger max = BigInteger.TEN.pow(211);

        BigInteger p = randomprime.randomPrimeInRange(min, max);
        BigInteger q = randomprime.randomPrimeInRange(min, max);

        chatgptdeneme rsaEncryption = new chatgptdeneme(p, q);

       
        BigInteger cipher = rsaEncryption.encryption(messege);

        System.out.println("------------------");
        System.out.println("Original message: " + messege);
        System.out.println("------------------");
        System.out.println("Encrypted: " + cipher);
        System.out.println("------------------");
        System.out.println("Decrypted message: " + rsaEncryption.decryptionToString());
        }
    }
}

class randomprime{
 BigInteger randomPrimeInRange(BigInteger minInclusive, BigInteger maxInclusive) {
        SecureRandom rnd = new SecureRandom();
        BigInteger range = maxInclusive.subtract(minInclusive).add(BigInteger.ONE);
        
        while (true) {
            // BigInteger aralığında random sayı üret
            BigInteger candidate = new BigInteger(range.bitLength(), rnd)
                .add(minInclusive);
            
            // Aralıkta olduğundan emin ol
            if (candidate.compareTo(maxInclusive) > 0) {
                candidate = candidate.mod(range).add(minInclusive);
            }
            
            // Tek sayı yap
            if (candidate.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                candidate = candidate.add(BigInteger.ONE);
            }
            
            if (candidate.isProbablePrime(40)) {
                System.out.println("asal sayı :" + candidate);
                return candidate;
            }
            // denemeye devam
        }
    }
}
class ConvertChart{
    public BigInteger stringToBigInteger(String message) {
        StringBuilder numericString = new StringBuilder();
        for (char c : message.toCharArray()) {
            int charValue = (int) c;
            numericString.append(String.format("%03d", charValue));
        }
        return new BigInteger(numericString.toString());
    }

    public String bigIntegerToString(BigInteger bigInt) {
        String numericString = bigInt.toString();
        // Başında sıfır varsa geri ekle (3'e bölünecek şekilde)
        while (numericString.length() % 3 != 0) {
            numericString = "0" + numericString;
        }
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < numericString.length(); i += 3) {
            String charCode = numericString.substring(i, i + 3);
            int charValue = Integer.parseInt(charCode);
            message.append((char) charValue);
        }
        return message.toString();
    }
}
@SuppressWarnings("unused")

class chatgptdeneme {
    

    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger n;
    private final BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private BigInteger encryptedMessage;
    private  ConvertChart convertChart = new ConvertChart();
   

    public chatgptdeneme(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        calculateE();
        calculateD();
    
        
    }

    // e seçimi: 3'ten başlayıp tek sayılarla devam eder, gcd(e, phi) == 1 olana kadar
    private void calculateE() {
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);
        int count =0;
        for (BigInteger candidate = BigInteger.valueOf(3);
             candidate.compareTo(phi) < 0  ;
             candidate = candidate.add(two)) {
            if (candidate.gcd(phi).equals(one)){
                count++;
            }
            if (candidate.gcd(phi).equals(one)& count==4) {
                e = candidate;
                System.out.println("e nin değeri : " + e);
                return;
            }
        }
        throw new RuntimeException("Uygun e bulunamadı.");
        // e=BigInteger.valueOf(257);
    }

    // d = e^{-1} (mod phi)
    private void calculateD() {
        d = e.modInverse(phi);
        System.out.println("d nin değeri : " + d);
    }

    // Şifreleme: m^e mod n
    public BigInteger encryption(BigInteger originalMessage) {
        encryptedMessage = originalMessage.modPow(e, n);
        System.out.println("n nin değeri : " + n);
        return encryptedMessage;
    }

    // Deşifreleme: (şifrelenmiş mesaj)^d mod n
    // public BigInteger decryption() {
    //     if (encryptedMessage == null) return BigInteger.ZERO;
    //     return encryptedMessage.modPow(d, n);
    // }
    public BigInteger decryption() {
        if (encryptedMessage == null) return BigInteger.ZERO;
        return encryptedMessage.modPow(d, n);
    }
    public String decryptionToString() {
        // return convertChart.bigIntegerToString(new BigInteger("67"));
        return convertChart.bigIntegerToString(encryptedMessage.modPow(d, n));
    }

    // yardımcı getter'lar istersen ekleyebilirsin
    public BigInteger getN() { return n; }
    public BigInteger getE() { return e; }
    public BigInteger getD() { return d; }
}
