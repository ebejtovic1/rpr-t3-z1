package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    public enum Grad { JAJCE ("030"), ODZAK("031"), ZENICA("032"), SARAJEVO("033"), LIVNO("034"), TUZLA("035"), MOSTAR("036"), BIHAC("037"), GORAZDE("038"), LJUBUSKI(("039"));
        private String pozivni;

        Grad(String pozivni) {
            this.pozivni = pozivni;
        }

        public String getPozivni() {
            return pozivni;
        }

    }

    public Grad getGrad() {
        return grad;
    }

    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad,String broj){
        this.grad = grad;
        this.broj = broj;
    }
    @Override
    public String ispisi(){
        String s = "";
        s += grad.getPozivni() + "/" + broj;
        return s;
    }
}