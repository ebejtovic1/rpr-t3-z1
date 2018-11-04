package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;
import java.util.HashMap;

public class Imenik{

    private HashMap<String, TelefonskiBroj> lista = new HashMap <String, TelefonskiBroj>();


    void dodaj(String ime, TelefonskiBroj broj){

        lista.put(ime, broj);
    }
    public String dajBroj(String ime){
        TelefonskiBroj tel=lista.get(ime);
        return tel.ispisi();

    }
    public String dajIme(TelefonskiBroj broj){
        if(lista.containsValue(broj)){
            for (String s : lista.keySet()) {
                if (lista.get(s).equals(broj)) {
                    return s;
                }
            }
        }
        return "";
    }

    public String naSlovo(char s){
        String lis="";
        int i=1;
        for (Map.Entry<String, TelefonskiBroj> entry : lista.entrySet()) {
            String rijec=entry.getKey();
            char znak=rijec.charAt(0);
            if(znak==s){
                lis+=i + ". " + entry.getKey() + " - " + lista.get(entry.getKey()).ispisi() + "\n";
                i++;
            }
        }
        return lis;
    }

    public Set<String> izGrada(FiksniBroj.Grad g) {
        Set<String> povartniSet = new TreeSet<>();
        for(Map.Entry<String, TelefonskiBroj> entry : lista.entrySet()){
            TelefonskiBroj temp = entry.getValue();
            String ime = entry.getKey();
            if( temp instanceof FiksniBroj){
                FiksniBroj fBroj = (FiksniBroj) temp;
                if( fBroj.getGrad() == g){
                    povartniSet.add(ime);
                }
            }
        }
        return povartniSet;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        Set<TelefonskiBroj> povartniSet = new TreeSet<>();
        for(Map.Entry<String, TelefonskiBroj> entry : lista.entrySet()){
            TelefonskiBroj temp = entry.getValue();
            if( temp instanceof FiksniBroj){
                FiksniBroj fBroj = (FiksniBroj) temp;
                if( fBroj.getGrad() == g){
                    povartniSet.add(temp);
                }
            }
        }
        return povartniSet;
    }


}
