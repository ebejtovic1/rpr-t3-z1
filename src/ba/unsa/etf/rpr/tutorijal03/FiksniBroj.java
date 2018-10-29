package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj{
    public enum Grad{TRAVNIK, ORASJE, ZENICA, SARAJEVO,
        LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKIBRIJEG, BRCKO;

    }
    private Grad grad;
    private String broj;




    public FiksniBroj(Grad grad, String broj){
        this.grad=grad;
        this.broj=broj;
    }


@Override
public int hashCode(){
        return 0;
}

@Override
    public String ispisi(){
    int a = 0;
    if(this.grad==Grad.SARAJEVO)a = 33;
    if(this.grad==Grad.TRAVNIK)a = 30;
    if(this.grad==Grad.ORASJE) a =31;
    if(this.grad==Grad.ZENICA)a = 32;
    if(this.grad==Grad.LIVNO)a = 34;
    if(this.grad==Grad.TUZLA)a = 35;
    if(this.grad==Grad.MOSTAR)a = 36;
    if(this.grad==Grad.BIHAC)a = 37;
    if(this.grad==Grad.GORAZDE)a = 38;
    if(this.grad==Grad.SIROKIBRIJEG)a = 39;
    if(this.grad==Grad.BRCKO)a = 49;
        return "0" + a + "/" + broj;
}
}