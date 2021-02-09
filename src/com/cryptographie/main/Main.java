/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptographie.main;

import com.cryptograpie.methode.Decalage;
import java.util.Scanner;

/**
 *
 * @author Sougoule
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Decalage d = new Decalage(4);
        Scanner clavier = new Scanner(System.in);

        System.out.println("Entrez votre chaine : ");
        String chaine = clavier.nextLine();
        System.out.println("\n************************ votre chaine decrypter donne ainsi ********************************************\n");
        System.out.println(d.dechiffrement_par_frequence(chaine));

    }
}
