public class KontenerNaPlyny extends Kontener implements IHazardNotifier{
    private boolean czyNiebezpieczny;

    public KontenerNaPlyny(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maksymalnaLadownosc, boolean czyNiebezpieczny) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maksymalnaLadownosc);
        this.czyNiebezpieczny = czyNiebezpieczny;
        this.numerSeryjny = "KON-P-" + numerSeryjny;
    }

    @Override
    public void zaladujLadunek(double masa) throws OverfillException {
        if(czyNiebezpieczny == true && masaLadunku > getMaksymalnaLadownosc() * 0.5) {
            hazardNotify("Próba wykonania niebezpiecznej sytucaji w kontenerze: " + numerSeryjny);
            throw new OverfillException("Przekroczono dopuszczalną masę ładunku");
        }else{
            masaLadunku = getMaksymalnaLadownosc() * 0.9;
        }
    }

    @Override
    public void oproznij() {
        masaLadunku = 0;
    }

    @Override
    public void hazardNotify(String wiadomosc) {
        System.out.println("Alert!" + wiadomosc);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
