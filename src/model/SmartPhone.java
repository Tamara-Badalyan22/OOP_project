package model;

import exceptions.InputException;

public abstract class SmartPhone extends Technique {
    private String operatingSystem;
    private double screenSize;
    private int cameraMP;
    private int ram;
    private boolean NFC;
    private boolean wifiConnection;

    public SmartPhone(String modelName, int price, int year, String country) {
        super(modelName, price, year, country);
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        if (operatingSystem != null && operatingSystem.length() > 2)
            this.operatingSystem = operatingSystem;
        else
            throw  new InputException();
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize > 0)
            this.screenSize = screenSize;
        else
            throw  new InputException();
    }

    public int getCameraMP() {
        return cameraMP;
    }

    public void setCameraMP(int cameraMP) {
        if (cameraMP > 0)
            this.cameraMP = cameraMP;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram > 0)
            this.ram = ram;
    }

    public boolean isNFC() {
        return NFC;
    }

    public void setNFC(boolean NFC) {
        this.NFC = NFC;
    }

    public boolean isWifiConnection() {
        return wifiConnection;
    }

    public void setWifiConnection(boolean wifiConnection) {
        this.wifiConnection = wifiConnection;
    }

    public abstract boolean downloadingApps(String appName);

    public abstract void sendMessage(String text, String phoneNumber);

    public abstract void call(String phoneNumber);

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("OperatingSystem : " + getOperatingSystem());
        System.out.println("ScreenSize : " + getScreenSize());
        System.out.println("Camera : " + getCameraMP());
        System.out.println("RAM : " + getRam());
        System.out.println("NFC : " + isNFC());
        System.out.println("WifiConnection : " + isWifiConnection());
    }
}
