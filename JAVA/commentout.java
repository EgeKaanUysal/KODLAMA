// import java.math.BigInteger;

// public class commentout {
//     private static void uI1(chatgptdeneme rsaencryption){
//      while (true){
//         System.out.println("encryption için 1 decryption için 0 gir bitirmek için 3: ");
//         int choicedecryptencryption = scanner.nextInt();
//         scanner.nextLine(); // Buffer'ı temizle
//         if (choicedecryptencryption==1){ //encryption

            
//             System.out.println("şifrelenecek mesajı gir :");

//             String nonencryptmessage= scanner.nextLine();
//            BigInteger nonencryptmessageBigInt= convertChart.stringToBigInteger(nonencryptmessage);
//                 rsaencryption.encryption(nonencryptmessageBigInt);

            

//             System.out.println("şifreli mesaj : " + rsaencryption.encryptedMessage);
//             break;
        
//             }else if (choicedecryptencryption==0){ //decryption
//                 System.out.println("şifreli mesajı gir :");
//                 rsaencryption.encryptedMessage = scanner.nextBigInteger();
               

               

//                 System.out.println("decrypted message : " + rsaencryption.decryptionToString());

//                 break;
                 
//             }else if (choicedecryptencryption==3) {break ;}
//             else{
//                 System.out.println("doğru gir ");}
//             }
     
// }

// private static void uI2(chatgptdeneme rsaencryption){
//      while (true){
//         System.out.println("encryption için 1 decryption için 0 gir  bitirmek için 3: ");
//         int choicedecryptencryption = scanner.nextInt();
//         scanner.nextLine(); // Buffer'ı temizle
//         if (choicedecryptencryption==1){

//             if (rsaencryption.e != null){
//                 System.out.println("mesajı gir :");

//                 String nonencryptmessage= scanner.nextLine();
//                 BigInteger nonencryptmessageBigInt= convertChart.stringToBigInteger(nonencryptmessage);
//                 rsaencryption.encryption(nonencryptmessageBigInt);

//                 System.out.println("şifreli mesaj : " + rsaencryption.encryptedMessage);
//                 break;
//             }

//             System.out.println("e'nin değerini gir:");
//             rsaencryption.e = scanner.nextBigInteger();
//             System.out.println("mesajı gir :");

//             BigInteger nonencryptmessage= scanner.nextBigInteger();
//             rsaencryption.encryption(nonencryptmessage);

//             System.out.println("şifreli mesaj : " + rsaencryption.encryptedMessage);
//             break;
        
//             }else if (choicedecryptencryption==0){
//                 if (rsaencryption.d != null){
//                     System.out.println("şifreli mesajı gir :");
//                     rsaencryption.encryptedMessage = scanner.nextBigInteger();
//                     System.out.println("decrypted message : " + rsaencryption.decryptionToString());
//                     break;
//                 }
//             System.out.println("d'nin değerini gir:");
//             rsaencryption.d = scanner.nextBigInteger();
//             break;
            
//             }else if (choicedecryptencryption==3) {break ;}
//             else {
//                 System.out.println("doğru gir ");}
//             }
     
// }}
// }



// BigInteger MURATBUDEĞİŞKENİKULLAN= new BigInteger(""); //buraya şifreli mesajı yaz
// rsaencryption.encryptedMessage=(MURATBUDEĞİŞKENİKULLAN); //şifreli mesajı buraya yaz

//  BigInteger nonencryptmessageBigInt= convertChart.stringToBigInteger("Yaptım çalışıyor");//buraya yaz
//  rsaencryption.encryption(nonencryptmessageBigInt);