package ziskani_kurzu_men_online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Matěj
 */
public class Ziskani_kurzu_men_online {
    static String Zmeny;
    static String DOmeny;
    static double HODNOTAmeny;
    static String Datum;
    static String Cas;
    
    
    Ziskani_kurzu_men_online(String mena,String HODNOTAmeny,String Datum,String Cas){
        Ziskani_kurzu_men_online.Zmeny= mena;
        Ziskani_kurzu_men_online.DOmeny= mena;
        Ziskani_kurzu_men_online.HODNOTAmeny= Double.parseDouble(HODNOTAmeny);
        Ziskani_kurzu_men_online.Cas= Cas;
        Ziskani_kurzu_men_online.Datum= Datum;
    }
    

    public void ziskej() {
        
        ArrayList<Ziskani_kurzu_men_online> seznam = new ArrayList<Ziskani_kurzu_men_online>();
        String xml = "";
        try {
            //url adresa pro xml data - kdybych chtěl přidat nějaký kurz měny tak do kulatých závorek
            URL convert = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDCZK%22,%22EURCZK%22)&env=store://datatables.org/alltableswithkeys");
            //načte data z seteamu a uloží do bufferu
            BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream())); // try kdyby se náhodou nepřipojil k internetu
            String line;
            while ((line = in.readLine()) != null) { // projde buffer dokud nebude null
                xml += line;                           // pridání do string
            }
        } catch (IOException ioe) {
            System.out.println(ioe); //ošetření chyb při try
        }

        // <rate id="EURCZK">
        // <Name>EUR/CZK</Name>
        // <Rate>27.0259</Rate>
        // <Date>11/23/2015</Date>
        // <Time>3:51pm</Time>
        // <Ask>27.0340</Ask>
        // <Bid>27.0179</Bid>
        // </rate>
        // </results>
        String[] radky = xml.split("[<>]+");  //rozparsování řetězce
        for (int i = 0; i < radky.length; i++) {  // projde rozparsovaný xml soubor bez <> 
            if (radky[i].equals("Name")) {           // zjistí zkusí zda string ze značek neodpovídá stringu z rozparsovaného xml
                //l.add(radky[i + 1]); 
                Ziskani_kurzu_men_online v = new Ziskani_kurzu_men_online(radky[i + 1], radky[i + 4], radky[i + 7], radky[i + 10]);
                seznam.add(v);
            }
            System.out.println(radky[i]);
        }
    }

    public static void main(String[] args) {
        ziskej();

    }

}
