public abstract class Kontener {
    protected double masaLadunku;
    protected double wysokosc;
    protected double wagaWlasna;
    protected double glebokosc;
    protected String numerSeryjny;
    protected double maksymalnaLadownosc;

    public Kontener(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maksymalnaLadownosc) {
        this.masaLadunku = masaLadunku;
        this.wysokosc = wysokosc;
        this.wagaWlasna = wagaWlasna;
        this.glebokosc = glebokosc;
        this.numerSeryjny = "KON-" + numerSeryjny;
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }

    public double getMasaLadunku() {
        return masaLadunku;
    }

    public void setMasaLadunku(int masaLadunku) {
        this.masaLadunku = masaLadunku;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getWagaWlasna() {
        return wagaWlasna;
    }

    public void setWagaWlasna(int wagaWlasna) {
        this.wagaWlasna = wagaWlasna;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(int glebokosc) {
        this.glebokosc = glebokosc;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    public double getMaksymalnaLadownosc() {
        return maksymalnaLadownosc;
    }

    public void setMaksymalnaLadownosc(double maksymalnaLadownosc) {
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }
    public abstract void zaladujLadunek(double masa) throws OverfillException;
    public abstract void oproznij();

    public double wagaCalkowita() {
        double wagaCalowita = 0;
        wagaCalowita = getMasaLadunku() + getWagaWlasna();
        return wagaCalowita;
    }

    @Override
    public String toString() {
        return "Kontener{" +
                "masaLadunku=" + masaLadunku +
                ", wysokosc=" + wysokosc +
                ", wagaWlasna=" + wagaWlasna +
                ", glebokosc=" + glebokosc +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                ", maksymalnaLadownosc=" + maksymalnaLadownosc +
                '}';
    }
}
