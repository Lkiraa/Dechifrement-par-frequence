/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptograpie.methode;

/**
 *
 * @author Sougoule
 */
public class Decalage {

    private int cle;
    protected char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Decalage(int cle) {
        this.cle = cle;
    }

    // fonction qui permet de retourner la pasition d'une lettre
    public int position(char alpa) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alpa == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }

    // fonction qui permet de retourner le nombre d'occurence d'une lettre
    public int occurence(String message, char c) {
        int oc = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == c) {
                oc++;
            }
        }

        return oc;
    }

    // permet de retourner le caractere qui a la plus grande occurance
    public char plus_grand_occurence(String message) {
        int max_oc = occurence(message, message.charAt(0));
        char max_c = message.charAt(0);
        for (int i = 1; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                if (max_oc < occurence(message, message.charAt(i))) {
                    max_oc = occurence(message, message.charAt(i));
                    max_c = message.charAt(i);
                }
            }

        }

        return max_c;
    }

// les methodes 
    // chiffrement
    public String chiffrement(String message) {
        message = message.toLowerCase();
        String message_chiffre = "";

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                message_chiffre += ' ';
            } else if (message.charAt(i) == '\'' ) {
                message_chiffre +='\'' ;
            }else{
                message_chiffre += alphabet[(position(message.charAt(i)) + this.getCle()) % 26];
            }
        }
        return message_chiffre;
    }

    // decalage
    public int retourner_decalage(char c, char e) {
        return Math.abs((position(c) - position(e)));
    }

    // 
    public String dechiffrement_par_cle(String message, int cle) {
        message = message.toLowerCase();
        String message_chiffre = "";

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                message_chiffre += ' ';
            } else if (message.charAt(i) =='\'' ) {
                message_chiffre +='\'' ;
            }else{
                message_chiffre += alphabet[Math.abs(((position(message.charAt(i)) - cle) + 26) % 26)];

            }
        }
        return message_chiffre;
    }

    // dechiffrement
    public String dechiffrement_par_frequence(String message) {
        message = message.toLowerCase();
        String message_clair = "";
        char c = plus_grand_occurence(message);
        int decalage = this.retourner_decalage(c, 'e');
        message_clair = dechiffrement_par_cle(message, decalage);
        return message_clair;
    }

    // les getters
    public char[] getAlphabet() {
        return alphabet;
    }

    public int getCle() {
        return cle;
    }

}
