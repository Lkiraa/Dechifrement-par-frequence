/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptographie.hashage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sougoule
 */
public class PuzzleID {

    public static String id = "Sougoule Cisse";
    public String YSha1 = "03b1663dda6549a0939ffdd712a852e0d4234e6b";
    public String YSha256 = "00005d10cc11e27bd8d4d1ce91bc725665ddbaa6ca2498ef38a88a58ad48cdb4";

    public PuzzleID() {

    }

    public String hasherSHA1(int x) throws NoSuchAlgorithmException {
      String codes = id+Integer.toString(x);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(codes.getBytes());

        byte byteData[] = md.digest();

        //convertir le tableau de bits en une format hexadécimal
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
         
        }
        return sb.toString();
        

    }
    
    
    public String hasherSHA256(int x) throws NoSuchAlgorithmException {
      String codes = id+Integer.toString(x);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(codes.getBytes());

        byte byteData[] = md.digest();
    
        //convertir le tableau de bits en une format hexadécimal
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
         
        }
        return sb.toString();
        

    }
}
