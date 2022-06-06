/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Aluno
 */
public class CryptoUtil {

    public static String getHash(String valor)  {

        
//        return valor;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //md.update();
            byte[] digest = md.digest(valor.getBytes());
            //String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            BigInteger no = new BigInteger(1, digest);
            
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
            
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

}
