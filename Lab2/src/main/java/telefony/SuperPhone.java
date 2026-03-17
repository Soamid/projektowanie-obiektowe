package telefony; /**
 * INTERFEJS - Łamie ISP (Interface Segregation Principle)
 * Jest zbyt "tłusty". Każdy telefon (nawet stary model) musiałby to implementować.
 */

import kamery.FrontCamera;
import kamery.WideAngleCamera;
import kamery.BackCamera;
import kamery.WymiaryZdjecia;

public class SuperPhone implements IPhone {

    private FrontCamera frontCamera;
    private WideAngleCamera wideAngleCamera;
    private BackCamera backCamera;

    //być może nie aż tak potrzebny stan telefonu
    private String activeCamera = "none";

    public int batteryPercentage;

    public SuperPhone() {
        this.batteryPercentage = 100; //domyślnie pełna bateria
        this.frontCamera = new FrontCamera();
        this.backCamera = new BackCamera();
        this.wideAngleCamera = new WideAngleCamera();
    }

    //SEKCJA Z DZWONIENIEM I SMSAMI
    @Override
    public void call(String number) {
        //Sprawdzanie czy numer jest poprawny
        if (number == null || !number.startsWith("+")) {
            System.out.println("BŁĄD: Numer musi zaczynać się od '+'!");
            return;
        }

        if (number.startsWith("+48")) { //Czy to polski numer
            String digits = number.substring(3);
            if (digits.length() != 9) { //walidacja dla polskiego numeru
                System.out.println("BŁĄD: Polski numer musi mieć dokładnie 9 cyfr!");
                return;
            }
        } else if (number.startsWith("+49")) { //Czy to niemiecki numer
            if (number.length() < 12 || number.length() > 15) { //Walidacja dla niemieckiego
                System.out.println("BŁĄD: Niemiecki numer musi mieć od 10 do 13 cyfr po kierunkowym!");
                return;
            }
            if (number.charAt(3) == '0') {
                System.out.println("BŁĄD: Niemiecki numer nie może mieć zera po kodzie kraju!");
                return;
            }
        } else {
            System.out.println("BŁĄD: Nieobsługiwany kraj!");
            return;
        }

        System.out.println("Dzwonię do: " + number);
    }

    @Override
    public void sendSms(String number, String message) {
        //Copy paste kodu z wyżej
        //nie ma co sie produkować za dużo
        if (number == null || !number.startsWith("+")) {
            System.out.println("BŁĄD: Numer musi zaczynać się od '+'!");
            return;
        }

        if (number.startsWith("+48")) {
            String digits = number.substring(3);
            if (digits.length() != 9) {
                System.out.println("BŁĄD: Polski numer musi mieć dokładnie 9 cyfr!");
                return;
            }
        } else if (number.startsWith("+49")) {
            if (number.length() < 12 || number.length() > 15) {
                System.out.println("BŁĄD: Niemiecki numer musi mieć od 10 do 13 cyfr po kierunkowym!");
                return;
            }
            if (number.charAt(3) == '0') {
                System.out.println("BŁĄD: Niemiecki numer nie może mieć zera po kodzie kraju!");
                return;
            }
        } else {
            System.out.println("BŁĄD: Nieobsługiwany kraj!");
            return;
        }

        System.out.println("Wysyłam SMS do " + number + ": " + message);
    }

    //SEKCJA Z KAMERAMI
    public void setCamera(String type) throws IllegalArgumentException {
        if (type.equalsIgnoreCase("SONY")) {
            this.frontCamera = new FrontCamera();
            this.backCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "SONY";
            return;
        } else if (type.equalsIgnoreCase("SAMSUNG")) {
            this.backCamera = new BackCamera();
            this.frontCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "SAMSUNG";
            return;
        } else if (type.equalsIgnoreCase("PINHOLE")) {
            this.wideAngleCamera = new WideAngleCamera();
            this.frontCamera = null;
            this.backCamera = null;
            this.activeCamera = "PINHOLE";
            return;
        }

        throw new IllegalArgumentException("Nieznany typ kamery: " + type);
    }

    @Override
    public void takePhoto() {
        if (activeCamera.equals("PRZEDNIA") && frontCamera != null) {
            //tu sa wymiary w centymetrach (bo tak)
            frontCamera.zrobSelfie(100, 30);
        } else if (activeCamera.equals("TYLNIA") && backCamera != null) {
            //a tu w pixelach
            backCamera.uchwyćMoment(1920, 1080);
        } else if (activeCamera.equals("SZEROKOKATNA") && wideAngleCamera != null) {
            //a tu se wgl zrobil programista wlasny obiekt
            wideAngleCamera.pstryknijPanorame(new WymiaryZdjecia(1920, 1080));
        } else {
            System.out.println("BŁĄD KRYTYCZNY: Nie wybrano aparatu lub sprzęt nie jest zainicjalizowany!");
            return;
        }
    }

    @Override
    public void connectTo5G() {
        System.out.println("Połączono z siecią 5G.");
    }

    @Override
    public void browseInternet() {
        System.out.println("Otwieram przeglądarkę...");
    }

    @Override
    public void backupPhotos() {
        GoogleDriveStorage googleStorage = new GoogleDriveStorage();

        System.out.println("Przygotowuję backup...");
        googleStorage.uploadAllPhotos();
    }
    @Override
    public void charge(String chargerType){
        if (chargerType.equals("Pin")) {
            this.batteryPercentage += 10;
        } else if (chargerType.equals("Thin-Pin")) {
            this.batteryPercentage += 5;
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }
}