import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
public class MainEncryption {
static Scanner scanner = new Scanner(System.in);
static ConvertChart convertChart = new ConvertChart();
static Chatgptdeneme rsaencryption;

    public static void main(String[] args) {
        
        Randomprime randomprime = new Randomprime();
        

        System.out.println();

  
        
while (true) {
System.out.println("Yeni anahtar olşturmak istiyorsan 1 kendin anahtar gireceksen 0 gir : ");
var choice = scanner.nextInt();
scanner.nextLine(); // Buffer'ı temizle
if (choice == 1) {
        

        BigInteger min = BigInteger.TEN.pow(200);
        BigInteger max = BigInteger.TEN.pow(211);

        BigInteger p = randomprime.randomPrimeInRange(min, max);
        BigInteger q = randomprime.randomPrimeInRange(min, max);

        rsaencryption = new Chatgptdeneme(p, q);
        System.out.println("n'nin dereği : " + rsaencryption.n);
        System.out.println("----------------------------");
        System.out.println("bu anahtarı kimseyle paylaşma !");
        System.out.println("d'nin dereği : " + rsaencryption.d);


    


        // System.out.println("decryprion kısmı");




       


        // uI1(rsaencryption);  
    break;
}
else if (choice ==0){ 
     rsaencryption = new Chatgptdeneme();
    rsaencryption.n= new BigInteger("4800797364367639927021603100388626681531664345900731195840951166581380183538144942588425141102458350796743151410113464668029952482765247997975086729440427078806354072811356473344018179409830201418522103009280799646641264477046249541813666138845154304639611912761762368285300361921738859422049458158792699952551547268314279028265384204806025895159372156124048814309511561117116499619502272491932401321617274103292532490297");//n değerinini buraya yaz

    rsaencryption.d=new BigInteger("10863369901332986303621150493872514364633852527510634853631685616637468888375991925716615687245755800464387394672270833353987848033802606205292778972010551179247405544262611440856395747512542320753054595247725343828373679445209527494364111336875920032187114656213922089446998588973989822948715791670064899130354200322171612301129858836834886145368461865640853525454735142211660208650311977423758134828541750731377589327073");//d değerini buraya yaz
    
System.out.println("------------------------------------- \n");
// System.out.println("decryprion kısmı");


uI();

 
   

    
break;

}else {
        System.out.println("doğru gir");
}
        
    }}

    static void uI(){
        try{
            System.out.println("encrypt için mesaj decrypt için sayı gir : ");
            rsaencryption.encryptedMessage=scanner.nextBigInteger(); //sayı girdi yani decrypt
            rsaencryption.decryptionToString();
            System.out.println("decrypted message : " + rsaencryption.decryptionToString());

        }catch(Exception e){
            BigInteger nonencryptmessageBigInt=convertChart.stringToBigInteger(scanner.nextLine()); //string girdi yani encrypt
            rsaencryption.encryption(nonencryptmessageBigInt);
            System.out.println("şifreli mesaj  \n" + rsaencryption.encryptedMessage);
        }
    }
}


class Randomprime{



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
    }}

class Chatgptdeneme {
    

    public BigInteger p;
    public BigInteger q;
    public BigInteger n;
    public BigInteger phi;
    public BigInteger e = new BigInteger("65537");
    public BigInteger d;
    public BigInteger encryptedMessage;
    public  ConvertChart convertChart = new ConvertChart();
   

    public Chatgptdeneme(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        calculateD();
    
        
    }
    public Chatgptdeneme(){

    }

    // e seçimi: 3'ten başlayıp tek sayılarla devam eder, gcd(e, phi) == 1 olana kadar
    // private void calculateE() {
    //     // BigInteger one = BigInteger.ONE;
    //     // BigInteger two = BigInteger.valueOf(2);
    //     // int count =0;
    //     // for (BigInteger candidate = BigInteger.valueOf(3);
    //     //      candidate.compareTo(phi) < 0  ;
    //     //      candidate = candidate.add(two)) {
    //     //     if (candidate.gcd(phi).equals(one)){
    //     //         count++;
    //     //     }
    //     //     if (candidate.gcd(phi).equals(one)& count==4) {
    //     //         e = candidate;
                
    //     //         return;
    //     //     }
    //     // }
    //     // throw new RuntimeException("Uygun e bulunamadı.");
    // }
    private void calculateD() {
        d = e.modInverse(phi);
     
    }
       public BigInteger encryption(BigInteger originalMessage) {
        encryptedMessage = originalMessage.modPow(e, n);
        return encryptedMessage;
    }
       public String decryptionToString() {
        // return convertChart.bigIntegerToString(new BigInteger("67"));
        return convertChart.bigIntegerToString(encryptedMessage.modPow(d, n));
    }
}


//4800797364367639927021603100388626681531664345900731195840951166581380183538144942588425141102458350796743151410113464668029952482765247997975086729440427078806354072811356473344018179409830201418522103009280799646641264477046249541813666138845154304639611912761762368285300361921738859422049458158792699952551547268314279028265384204806025895159372156124048814309511561117116499619502272491932401321617274103292532490297
// muratın n'si

//12341862379496930336310705195661390526557722724672615130230208027208851342396723344237593910047933604254664159148434864707559920892267125522245828372372074552479582865068452761491620290967123497472401258689286417236300561580769897652394732602553370969957447620147087901085777049775556831129640813183595846209251341472344914256097722708632534800672622416542556700335548929155864266093319461010755508339707563601597121445271
//benim n