package telefony;

//Moze i nie umie za dużo
//Ale się stara
public class StaraNokia implements IPhone {

    @Override
    public void call(String number) {
        System.out.println("Dzwonię z niezniszczalnej Nokii do: " + number);
    }

    @Override
    public void sendSms(String number, String message) {
        System.out.println("Wysyłam SMS do " + number + ": " + message);
    }

    // --- SEKCJA PROBLEMÓW (ZŁAMANE ZASADY) ---

    @Override
    public void takePhoto() {
        // Łamie LSP: Klient spodziewa się, że telefon robi zdjęcie, a dostaje błąd.
        throw new UnsupportedOperationException("Błąd: Nokia 3310 nie ma aparatu!");
    }

    @Override
    public void connectTo5G() {
        // Łamie LSP: Brak kompatybilności wstecznej funkcjonalności.
        throw new UnsupportedOperationException("Błąd: 5G w 2000 roku? Zapomnij.");
    }

    @Override
    public void browseInternet() {
        // Łamie LSP: Użytkownik interfejsu IPhone zostanie zaskoczony wyjątkiem.
        throw new UnsupportedOperationException("Błąd: Brak przeglądarki internetowej.");
    }

    @Override
    public void charge(String chargerType) {
        // Łamie OCP: Jeśli zechcesz dodać nowy typ ładowania (np. Solarne),
        // musisz modyfikować kod każdej klasy telefonu.
        if (chargerType.equals("Pin")) {
            System.out.println("Ładowanie grubym bolcem...");
        } else if (chargerType.equals("Thin-Pin")) {
            System.out.println("Ładowanie cienkim bolcem...");
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }
}