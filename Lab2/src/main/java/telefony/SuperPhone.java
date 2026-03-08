package telefony; /**
 * INTERFEJS - Łamie ISP (Interface Segregation Principle)
 * Jest zbyt "tłusty". Każdy telefon (nawet stary model) musiałby to implementować.
 */

import kamery.PrzedniaKamera;
import kamery.SzerokokatnaKamera;
import kamery.TylniaKamera;
import kamery.WymiaryZdjecia;

class SuperPhone implements IPhone {

    private PrzedniaKamera przedniaKamera;
    private SzerokokatnaKamera szerokokatnaKamera;
    private TylniaKamera tylniaKamera;

    //być może nie aż tak potrzebny stan telefonu
    private String aktywnyTrybAparatu = "none";

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
            this.przedniaKamera = new PrzedniaKamera();
            this.tylniaKamera = null;
            this.szerokokatnaKamera = null;
            this.aktywnyTrybAparatu = "SONY";
            return;
        } else if (type.equalsIgnoreCase("SAMSUNG")) {
            this.tylniaKamera = new TylniaKamera();
            this.przedniaKamera = null;
            this.szerokokatnaKamera = null;
            this.aktywnyTrybAparatu = "SAMSUNG";
            return;
        } else if (type.equalsIgnoreCase("PINHOLE")) {
            this.szerokokatnaKamera = new SzerokokatnaKamera();
            this.przedniaKamera = null;
            this.tylniaKamera = null;
            this.aktywnyTrybAparatu = "PINHOLE";
            return;
        }

        throw new IllegalArgumentException("Nieznany typ kamery: " + type);
    }

    @Override
    public void takePhoto() {
        if (aktywnyTrybAparatu.equals("PRZEDNIA") && przedniaKamera != null) {
            //tu sa wymiary w centymetrach (bo tak)
            przedniaKamera.zrobSelfie(100, 30);
        } else if (aktywnyTrybAparatu.equals("TYLNIA") && tylniaKamera != null) {
            //a tu w pixelach
            tylniaKamera.uchwyćMoment(1920, 1080);
        } else if (aktywnyTrybAparatu.equals("SZEROKOKATNA") && szerokokatnaKamera != null) {
            //a tu se wgl zrobil programista wlasny obiekt
            szerokokatnaKamera.pstryknijPanorame(new WymiaryZdjecia(1920, 1080));
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
        //
    }
}