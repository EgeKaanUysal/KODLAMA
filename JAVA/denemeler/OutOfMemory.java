package denemeler;

import java.util.ArrayList;

public class OutOfMemory {
    long a=8786554;
    long b=8786554;
    public static void main(String[] args) {
        for (int i=0; i<12; i++){
          Islem();
        }
                
            }
    
    static void Islem(){
        System.out.println("------------");
        ArrayList<OutOfMemory> list = new ArrayList<>();
             for (long i=0; i<100000000L; i++){
                             
                OutOfMemory referans= new OutOfMemory();
                list.add(referans);
                if (i%10000000==0){
                    System.out.println(i);
                }
    }
}}