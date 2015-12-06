/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziskani_kurzu_men_online;

/**
 *
 * @author Matěj
 */
public class VlastnostMeny {
    private String Zmeny;
    private String DOmeny;
    private double HODNOTAmeny;
    private String Datum;
    private String Cas;
    
    public VlastnostMeny(String mena,String HODNOTAmeny,String Datum,String Cas){
        this.Zmeny= mena;
        this.DOmeny= mena;
        this.HODNOTAmeny= Double.parseDouble(HODNOTAmeny);
        this.Cas= Cas;
        this.Datum= Datum;
    }

    public VlastnostMeny() {
    }
    
    // ze které měny
    public String getZmeny(){
        return Zmeny;
    }
    public void setZmeny(String Zmeny){
        this.Zmeny= Zmeny;
    }
    
    //do které měny
    public String getDOmeny(){
        return DOmeny;
    }
    public void setDOmeny(String DOmeny){
        this.DOmeny= DOmeny;
    }
    
    // HODNOTA
    public double getHODNOTAmeny(){
        return HODNOTAmeny;
    }
    public void setHODNOTAmeny(double HODNOTAmeny){
        this.HODNOTAmeny= HODNOTAmeny;
    }
    
    //datum
    public String getDatum(){
        return Datum;
    }
    public void setDatum(String Datum){
        this.Datum= Datum;
    }
    
    
    //cas
    public String getCas(){
        return Cas;
    }
    public void setCas(String Cas){
        this.Cas= Cas;
    }
    
}
