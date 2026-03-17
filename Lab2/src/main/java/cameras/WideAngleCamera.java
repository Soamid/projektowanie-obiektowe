package cameras;

public class WideAngleCamera {
    public void performOperationCommonlyKnownAsMakingPhoto(PhotoSize wymiaryZdjecia) {
        System.out.printf("Aparat szerokokątny: Przetwarzanie szerokiego pola widzenia... Gotowe. Wymiary foty: %d px X %d px", wymiaryZdjecia.width(), wymiaryZdjecia.height());
    }
}

