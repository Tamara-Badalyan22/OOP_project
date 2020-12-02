package model;

public class SamsungPhone extends SmartPhone {
    private boolean touchId;
    private boolean pencil;

    public SamsungPhone(String modelName, int price, int year, String country) {
        super(modelName, price, year, country);
    }

    @Override
    public boolean downloadingApps(String appName) {
        if (appName.length() > 2) {
            System.out.println("Downloading from PlayMarket");
            return true;
        }
        System.out.println("Error!");
        return false;
    }

    @Override
    public void sendMessage(String text, String phoneNumber) {
        if (text != null && phoneNumber.matches("374(.*)") && phoneNumber.length() == 11) {
            System.out.println("Message Send to -> " + phoneNumber);
        } else {
            System.out.println("Invalid number");
        }
    }

    @Override
    public void call(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("374(.*)") && phoneNumber.length() == 11) {
            System.out.println("Calling  to " + phoneNumber);
        }
        else{
            System.out.println("Invalid Number!");
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("TouchId : "+ isTouchId());
        System.out.println("Pencil : " + isPencil());
    }

    public boolean isTouchId() {
        return touchId;
    }

    public void setTouchId(boolean touchId) {
        this.touchId = touchId;
    }

    public boolean isPencil() {
        return pencil;
    }

    public void setPencil(boolean pencil) {
        this.pencil = pencil;
    }


}
