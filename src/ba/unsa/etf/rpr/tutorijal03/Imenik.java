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
        Set set = lista.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry par = (Map.Entry)iterator.next();
            if(par.getValue()==broj)return (String) par.getKey();
        }
        return null;
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

    public Set<String> izGrada(FiksniBroj.Grad g){
        return null;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        return null;
    }


}
