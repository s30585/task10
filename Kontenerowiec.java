import java.util.*;

public class Kontenerowiec {
    private double maksymalnaPredkosc;
    private int maksymalnaIloscKontenerow;
    private double maksymalnaWaga;
    private List<Kontener> kontenery = new ArrayList<>();

    public Kontenerowiec(int maksymalnaIloscKontenerow, double maksymalnaWaga, double maksymalnaPredkosc) {
        this.maksymalnaIloscKontenerow = maksymalnaIloscKontenerow;
        this.maksymalnaWaga = maksymalnaWaga;
        this.maksymalnaPredkosc = maksymalnaPredkosc;
    }

    public List<Kontener> getKontenery() {
        return kontenery;
    }
    public void dodajKontener(Kontener k) throws Exception {
        if (kontenery.size()>=maksymalnaIloscKontenerow) {
            throw new Exception("Za dużo kontenerów na statku");
        }
        if(obliczWage()+k.wagaCalkowita()>maksymalnaWaga*1000){
            throw new Exception("Za duża waga całkowita");
        }
        kontenery.add(k);
    }
    public void usunKontener(String numer){
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                kontenery.remove(i);
                break;
            }
        }
    }
    public void zamienKontener(String numer, Kontener nowy){
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                kontenery.set(i, nowy);
                break;
            }
        }
    }
    public void przeniesKontener(Kontenerowiec inny, String numer)throws Exception{
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                inny.dodajKontener(kontenery.get(i));
                kontenery.remove(i);
                break;
            }
        }
    }
    public boolean zaladujKontener(Kontener kontener) throws OverfillException {
        if (kontenery.size() >= maksymalnaIloscKontenerow)
            throw new OverfillException("Przekroczono limit liczby kontenerów");

        double aktualnaWaga = kontenery.stream().mapToDouble(Kontener::wagaCalkowita).sum();
        if (aktualnaWaga + kontener.wagaCalkowita() > maksymalnaWaga * 1000)
            throw new OverfillException("Za duża masa całkowita kontenerów na statku");

        kontenery.add(kontener);
        return true;
    }

    public double obliczWage() {
        double suma = 0.0;
        for (int i = 0; i < kontenery.size(); i++) {
            suma += kontenery.get(i).wagaCalkowita();
        }
        return suma;
    }

    public void wypiszInformacje() {
        System.out.println("Prędkość maksymalna: " + maksymalnaPredkosc + " węzłów");
        System.out.println("Maks. liczba kontenerów: " + maksymalnaIloscKontenerow);
        System.out.println("Maks. waga ładunku: " + maksymalnaWaga + " ton");
        System.out.println("Kontenery na pokładzie:");
        for (Kontener k : kontenery) {
            System.out.println(k.getNumerSeryjny() + " masa ładunku: " + k.wagaCalkowita() + " kg");
        }
    }
}
