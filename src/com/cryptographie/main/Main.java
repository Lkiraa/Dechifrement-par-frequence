/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptographie.main;

import com.cryptographie.hashage.PuzzleID;
import com.cryptograpie.methode.Decalage;
import static com.oracle.jrockit.jfr.DataType.INTEGER;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sougoule
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws InterruptedException {
//        Decalage d = new Decalage(4);
//        Scanner clavier = new Scanner(System.in);
//
//        System.out.println("Entrez votre chaine : ");
//        String chaine = clavier.nextLine();
//        System.out.println("\n************************ votre chaine decrypter donne ainsi ********************************************\n");
//        System.out.println(d.dechiffrement_par_frequence(chaine));
         PuzzleID p =   new PuzzleID();
//         int  seuil = 100000;
         int count = 1;
         Random r = new Random();
         int x  = r.nextInt();
         ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        try {
            String hx = p.hasherSHA256(x);
            while ( (hx.compareTo(p.YSha256)) > 0 ) {                
               myNumbers.add(x);
                do {       
                    
                    x  = r.nextInt();
                    
                } while (myNumbers.contains(x));
                count++;
                hx = p.hasherSHA256(x);
                
            }
            
            System.out.println("hx = "+hx+" x = "+x +" count = " +count);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
