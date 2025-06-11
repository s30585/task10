public class KontenerChlodniczy extends Kontener {
    private String rodzajProduktu;
    private double temperaturaKontenera;
    private double temperaturaProduktu;

    public KontenerChlodniczy(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maksymalnaLadownosc, String rodzajProduktu, double temperaturaKontenera, double temperaturaProduktu) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maksymalnaLadownosc);
        this.rodzajProduktu = rodzajProduktu;
        this.temperaturaKontenera = temperaturaKontenera;
        this.temperaturaProduktu = temperaturaProduktu;
        this.numerSeryjny = "KON-C-" + numerSeryjny;
    }

    @Override
    public void zaladujLadunek(double masa) throws OverfillException {
        if (temperaturaKontenera < temperaturaProduktu) {
            throw new OverfillException("Za niska temperatura w kontenerze!");
        }
    }

    @Override
    public void oproznij() {
        masaLadunku = 0;
    }
}
