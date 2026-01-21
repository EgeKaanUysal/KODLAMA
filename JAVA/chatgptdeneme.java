// import java.math.BigInteger;
// @SuppressWarnings("unused")
// public class chatgptdeneme {
    
//     private final BigInteger p;
//     private final BigInteger q;
//     private final BigInteger n;
//     private final BigInteger phi;
//     private BigInteger e;
//     private BigInteger d;
//     private BigInteger encryptedMessage;
//     private BigInteger goode=BigInteger.valueOf(25);

//     public chatgptdeneme(BigInteger p, BigInteger q) {
//         this.p = p;
//         this.q = q;
//         this.n = p.multiply(q);
//         this.phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
//         calculateE();
//         calculateD();
        
//     }

//     // e seçimi: 3'ten başlayıp tek sayılarla devam eder, gcd(e, phi) == 1 olana kadar
//     private void calculateE() {
//         BigInteger one = BigInteger.ONE;
//         BigInteger two = BigInteger.valueOf(2);
//         int count =0;
//         for (BigInteger candidate = BigInteger.valueOf(3);
//              candidate.compareTo(phi) < 0  ;
//              candidate = candidate.add(two)) {
//             if (candidate.gcd(phi).equals(one)){
//                 count++;
//             }
//             if (candidate.gcd(phi).equals(one)& count==4) {
//                 e = candidate;
//                 System.out.println("e nin değeri : " + e);
//                 return;
//             }
//         }
//         throw new RuntimeException("Uygun e bulunamadı.");
//         // e=BigInteger.valueOf(257);
//     }

//     // d = e^{-1} (mod phi)
//     private void calculateD() {
//         d = e.modInverse(phi);
//         System.out.println("d nin değeri : " + d);
//     }

//     // Şifreleme: m^e mod n
//     public BigInteger encryption(BigInteger originalMessage) {
//         encryptedMessage = originalMessage.modPow(e, n);
//         System.out.println("n nin değeri : " + n);
//         return encryptedMessage;
//     }

//     // Deşifreleme: (şifrelenmiş mesaj)^d mod n
//     public BigInteger decryption() {
//         if (encryptedMessage == null) return BigInteger.ZERO;
//         return encryptedMessage.modPow(d, n);
//     }

//     // yardımcı getter'lar istersen ekleyebilirsin
//     public BigInteger getN() { return n; }
//     public BigInteger getE() { return e; }
//     public BigInteger getD() { return d; }
// }

