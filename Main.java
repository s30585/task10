public class Main {
    public static void main(String[] args) {
        try{
            Kontenerowiec kontenerowiec = new Kontenerowiec(20, 60, 3050);
            KontenerNaPlyny kontener1 = new KontenerNaPlyny(10, 10, 67, 30, "123", 60, true);
            KonteneryNaGaz kontener2 = new KonteneryNaGaz(80, 21, 350, 31, "456", 50);
            KontenerChlodniczy kontener3 = new KontenerChlodniczy(25, 31, 999, 32, "789", 80, "banany", 20, 20);

            kontenerowiec.dodajKontener(kontener1);
            kontenerowiec.dodajKontener(kontener2);
            kontenerowiec.dodajKontener(kontener3);

            kontenerowiec.wypiszInformacje();

        }catch (Exception e){
            System.out.println("Błąd: " + e.getMessage());}


    }

}
