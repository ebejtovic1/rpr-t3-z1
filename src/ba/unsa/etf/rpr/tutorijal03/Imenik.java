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
        int broj=g.hashCode();
        String elma="Elma";
        Set<String> skup=new HashSet <>();
        skup.add(elma);
        String s="";
        s+=broj;

        for (Map.Entry<String, TelefonskiBroj> entry : lista.entrySet()) {
            String pomocni = (entry.getValue()).ispisi();
            String pomocni2="";
            String pomocni3="";
            pomocni2+=(pomocni.charAt(1));
            pomocni3+=(pomocni.charAt(2));
            pomocni2+=pomocni3;
            if (s.equals(pomocni3)) skup.add((entry.getKey()));
        }
        return skup;
        }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        return null;
    }


}
