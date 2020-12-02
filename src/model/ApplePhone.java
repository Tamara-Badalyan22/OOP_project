package model;

import exceptions.InputException;

public class ApplePhone extends SmartPhone {
    private boolean faceId;
    private boolean touchId;
    private boolean batteryCharger;

    public ApplePhone(String modelName, int price, int year, String country) {
        super(modelName, price, year, country);
    }

    @Override
    public boolean downloadingApps(String appName) {
        if (appName.length() > 2) {
            System.out.println("Downloading from AppStore");
            return true;
        }
        System.out.println("Error");
        return false;
    }

    @Override
    public void sendMessage(String text, String phoneNumber) {
        if (text != null && phoneNumber.matches("374(.*)") && phoneNumber.length() == 11) {
            System.out.println("Message Send to -> " + phoneNumber + "with Imessage");
        } else{
            throw  new InputException();
        }
    }

    @Override
    public void call(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("374(.*)") && phoneNumber.length() == 11) {
            System.out.println("FaceTime Call to " + phoneNumber);
        } else {
            throw  new InputException();
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("FaceId : "+ isFaceId());
        System.out.println("TouchId : "+ isTouchId());
        System.out.println("BatteryCharger : " + isBatteryCharger());
    }

    public boolean isFaceId() {
        return faceId;
    }

    public void setFaceId(boolean faceId) {
        this.faceId = faceId;
    }

    public boolean isTouchId() {
        return touchId;
    }

    public void setTouchId(boolean touchId) {
        this.touchId = touchId;
    }

    public boolean isBatteryCharger() {
        return batteryCharger;
    }

    public void setBatteryCharger(boolean batteryCharger) {
        this.batteryCharger = batteryCharger;
    }
}
