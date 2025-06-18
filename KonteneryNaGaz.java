public class KonteneryNaGaz extends Kontener implements IHazardNotifier{
    private double cisnienie;

    public KonteneryNaGaz(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maksymalnaLadownosc) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maksymalnaLadownosc);
        this.cisnienie = cisnienie;
        this.numerSeryjny = "KON-G-" + numerSeryjny;
    }

    @Override
    public void zaladujLadunek(double masa) throws OverfillException {
        if (masaLadunku> maksymalnaLadownosc * 0.5){
            hazardNotify("Niebezpieczne zdarzenie w kontenerze: " + numerSeryjny);
            throw new OverfillException("Przekroczono ładowność kontenera z gazem");
        }
    }

    @Override
    public void oproznij() {
        masaLadunku *= 0.05;
    }

    @Override
    public void hazardNotify(String wiadomosc) {
        System.out.println(wiadomosc);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
