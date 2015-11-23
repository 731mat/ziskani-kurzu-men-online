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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String xml = "";
        try {
            //url adresa pro xml data - kdybych chtěl přidat nějaký kurz měny tak do kulatých závorek
            URL convert = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDCZK%22,%22EURCZK%22)&env=store://datatables.org/alltableswithkeys");
            //načte data z seteamu a uloží do bufferu
            try (BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()))) { // try kdyby se náhodou nepřipojil k internetu
                String line;
                while (( line= in.readLine()) != null) { // projde buffer dokud nebude null
                    xml += line;                           // pridání do string
                }
            }
        }catch (IOException ioe) {
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
        
        String oddelovace = "[<>]+";
        String[] radky = xml.split(oddelovace);  //rozparsování řetězce
        ArrayList<String> l = new ArrayList<>(); //vytvoření listu kde pole jsou string 
        String[] znacky = {"Name","Date", "Time", "Ask"}; //názvy hodnot keré chceme uložit 
        for (int i = 0; i < radky.length; i++) {  // projde rozparsovaný xml soubor bez <>
            for (String s : znacky) {               // projde arry list 
                if (radky[i].equals(s)) {           // zjistí zkusí zda string ze značek neodpovídá stringu z rozparsovaného xml
                    l.add(radky[i + 1]);            // když ano tak přidá položkudo pole
                }
            }
        }
        System.out.println(l); //výpis listu
    }
}
