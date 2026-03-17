package telefony;

//Moze i nie umie za dużo
//Ale się stara
public class StaraNokia implements IPhone {
    public int batteryLevel = 100;

    @Override
    public void call(String number) {
        if (batteryLevel > 5){
            System.out.println("Dzwonię z niezniszczalnej Nokii do: " + number);
            batteryLevel -= 5;
        }
        else {
            System.out.println("Bateria jest za słaba, aby zadzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        System.out.println("Wysyłam SMS do " + number + ": " + message);
    }

    @Override
    public void takePhoto() {
        throw new UnsupportedOperationException("Błąd: Nokia 3310 nie ma aparatu!");
    }

    @Override
    public void connectTo5G() {
        throw new UnsupportedOperationException("Błąd: 5G w 2000 roku? Zapomnij.");
    }

    @Override
    public void browseInternet() {
        throw new UnsupportedOperationException("Błąd: Brak przeglądarki internetowej.");
    }

    @Override
    public void backupPhotos() {
        throw new UnsupportedOperationException("XD no na pewno to zadziała tutaj");
    }

    @Override
    public void charge(String chargerType) {
        if (chargerType.equals("Pin")) {
            this.batteryLevel += 30;
        } else if (chargerType.equals("Thin-Pin")) {
            this.batteryLevel += 15;
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }
}