package telefony;

public interface IPhone {
    void call(String number);
    void sendSms(String number, String message);
    void takePhoto();
    void connectTo5G();
    void browseInternet();
    void charge(String chargerType);
}