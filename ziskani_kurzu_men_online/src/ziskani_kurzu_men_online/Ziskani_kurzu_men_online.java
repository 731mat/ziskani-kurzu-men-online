/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziskani_kurzu_men_online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.net.URL;
import java.util.ArrayList;

import static sun.org.mozilla.javascript.internal.Token.XML;


/**
 *
 * @author Matěj
 */
public class Ziskani_kurzu_men_online {
    private static Object phrase;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String xml = "";
        try {
            URL convert = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDCZK%22,%22EURCZK%22)&env=store://datatables.org/alltableswithkeys");
            BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
            
            String line="";
            while ((line = in.readLine()) != null) 
                xml += line;

            in.close();
            System.out.println(xml);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        String delims = "[<>]+";
        String[] tokens = xml.split(delims);
        ArrayList<String> l = new ArrayList<String>();
        
        
        for (int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("USD/CZK")){ l.add(tokens[i]);}
            if(tokens[i].equals("CZK/EUR")){ l.add(tokens[i]);}
            if(tokens[i].equals("Time")){ l.add(tokens[i+1]);}
            if(tokens[i].equals("Ask")){ l.add(tokens[i+1]);}
            //System.out.println(tokens[i]);
        }
        System.out.println(l);
    }


}
