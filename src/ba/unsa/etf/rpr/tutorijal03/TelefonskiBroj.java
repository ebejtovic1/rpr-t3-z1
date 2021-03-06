package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {
    public abstract String ispisi();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(TelefonskiBroj broj) {
        return ispisi().compareTo(broj.ispisi());
    }
}