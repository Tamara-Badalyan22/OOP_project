package services;

import interfaces.ISmartPhone;
import model.ApplePhone;
import model.SamsungPhone;
import model.SmartPhone;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhoneService implements ISmartPhone {


    @Override
    public void printInfoOfPhone(SmartPhone phone) {
        System.out.println("************************");
        System.out.println("ModelName : " + phone.getModelName());
        System.out.println("Price : " + phone.getPrice());
        System.out.println("Year : " + phone.getYear());
        System.out.println("Country : " + phone.getCountry());
        System.out.println("OperatingSystem : " + phone.getOperatingSystem());
        System.out.println("ScreenSize : " + phone.getScreenSize());
        System.out.println("Camera : " + phone.getCameraMP());
        System.out.println("RAM : " + phone.getRam());
        System.out.println("NFC : " + phone.isNFC());
        System.out.println("WifiConnection : " + phone.isWifiConnection());
        if (phone instanceof SamsungPhone) {
            SamsungPhone s = (SamsungPhone) phone;
            System.out.println("TouchId : " + s.isTouchId());
            System.out.println("Pencil : " + s.isPencil());
        } else if (phone instanceof ApplePhone) {
            ApplePhone a = (ApplePhone) phone;
            System.out.println("FaceId : " + a.isFaceId());
            System.out.println("TouchId : " + a.isTouchId());
            System.out.println("BatteryCharger : " + a.isBatteryCharger());
        }
    }

    @Override
    public void printInfoOfPhones(SmartPhone[] phones) {
        for (SmartPhone phone :
                phones) {
            printInfoOfPhone(phone);
            System.out.println("***********************");
        }
    }

    @Override
    public SmartPhone[] readFromFile(String path) {
        File file = new File(path);
        String result = null;
        SmartPhone model;
        List<SmartPhone> phones = new ArrayList<SmartPhone>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                result = scanner.nextLine();
                String[] items = result.split(",");
                if (items[4].contains("ios")) {
                    ApplePhone aModel = new ApplePhone(items[0], Integer.parseInt(items[1]), Integer.parseInt(items[2]), items[3]);
                    aModel.setOperatingSystem(items[4]);
                    aModel.setScreenSize(Double.parseDouble(items[5]));
                    aModel.setCameraMP(Integer.parseInt(items[6]));
                    aModel.setRam(Integer.parseInt(items[7]));
                    aModel.setNFC(Boolean.parseBoolean(items[8]));
                    aModel.setWifiConnection(Boolean.parseBoolean(items[9]));
                    aModel.setFaceId(Boolean.parseBoolean(items[10]));
                    aModel.setTouchId(Boolean.parseBoolean(items[11]));
                    aModel.setBatteryCharger(Boolean.parseBoolean(items[12]));
                    phones.add(aModel);
                } else if (items[4].contains("android")) {
                    SamsungPhone sModel = new SamsungPhone(items[0], Integer.parseInt(items[1]), Integer.parseInt(items[2]), items[3]);
                    sModel.setOperatingSystem(items[4]);
                    sModel.setScreenSize(Double.parseDouble(items[5]));
                    sModel.setCameraMP(Integer.parseInt(items[6]));
                    sModel.setRam(Integer.parseInt(items[7]));
                    sModel.setNFC(Boolean.parseBoolean(items[8]));
                    sModel.setWifiConnection(Boolean.parseBoolean(items[9]));
                    sModel.setTouchId(Boolean.parseBoolean(items[10]));
                    sModel.setPencil(Boolean.parseBoolean(items[11]));
                    phones.add(sModel);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return phones.toArray(new SmartPhone[phones.size()]);
    }

    @Override
    public void addPhoneIntoFile(String path) {
        String result = null;
        System.out.println("Enter 's' for SamsungModel or 'a' for AppleModel");
        Scanner s = new Scanner(System.in);
        String opType = s.next();
        if (opType.equals("s")) {
            result = addSamsungPhone() + "\n";

        } else if (opType.equals("a")) {
            result = addApplePhone() + "\n";
        } else {
            //exception;
        }
        try {
            Files.write(Paths.get(path), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private String addApplePhone() {
        String result;
        Scanner s = new Scanner(System.in);
        System.out.println("***Please fill these fields***");
        System.out.println("ModelName : ");
        String modelName = s.next();
        System.out.println("Price : ");
        int price = s.nextInt();
        System.out.println("Year : ");
        int year = s.nextInt();
        System.out.println("Country : ");
        String country = s.next();
        ApplePhone aModel = new ApplePhone(modelName, price, year, country);
        System.out.println("Operating system : ");
        aModel.setOperatingSystem(s.next());
        System.out.println("ScreenSize : ");
        aModel.setScreenSize(s.nextInt());
        System.out.println("CameraMP : ");
        aModel.setCameraMP(s.nextInt());
        System.out.println("RAM : ");
        aModel.setRam(s.nextInt());
        System.out.println("NFC(true/false) : ");
        aModel.setNFC(s.nextBoolean());
        System.out.println("WifiConnection(true/false) : ");
        aModel.setWifiConnection(s.nextBoolean());
        System.out.println("FaceId(true/false) : ");
        aModel.setFaceId(s.nextBoolean());
        System.out.println("TouchID(true/false) : ");
        aModel.setTouchId(s.nextBoolean());
        System.out.println("BatteryCharger(true/false) : ");
        aModel.setBatteryCharger(s.nextBoolean());

        result = modelToString(aModel);

        return result;
    }

    private String addSamsungPhone() {
        String result;
        Scanner s = new Scanner(System.in);
        System.out.println("***Please fill these fields***");
        System.out.println("ModelName : ");
        String modelName = s.next();
        System.out.println("Price : ");
        int price = s.nextInt();
        System.out.println("Year : ");
        int year = s.nextInt();
        System.out.println("Country : ");
        String country = s.next();
        SamsungPhone aModel = new SamsungPhone(modelName, price, year, country);
        System.out.println("Operating system : ");
        aModel.setOperatingSystem(s.next());
        System.out.println("ScreenSize : ");
        aModel.setScreenSize(s.nextInt());
        System.out.println("CameraMP : ");
        aModel.setCameraMP(s.nextInt());
        System.out.println("RAM : ");
        aModel.setRam(s.nextInt());
        System.out.println("NFC(true/false) : ");
        aModel.setNFC(s.nextBoolean());
        System.out.println("WifiConnection(true/false) : ");
        aModel.setWifiConnection(s.nextBoolean());
        System.out.println("TouchID(true/false) : ");
        aModel.setTouchId(s.nextBoolean());
        System.out.println("Pencil(true/false) : ");
        aModel.setPencil(s.nextBoolean());

        result = modelToString(aModel);

        return result;
    }

    private String modelToString(SmartPhone model) {
        StringBuffer s = new StringBuffer();
        s.append(model.getModelName() + ",");
        s.append(model.getPrice() + ",");
        s.append(model.getYear() + ",");
        s.append(model.getCountry() + ",");
        s.append(model.getOperatingSystem() + ",");
        s.append(model.getScreenSize() + ",");
        s.append(model.getCameraMP() + ",");
        s.append(model.getRam() + ",");
        s.append(model.isNFC() + ",");
        s.append(model.isWifiConnection() + ",");
        if (model instanceof SamsungPhone) {
            SamsungPhone sModel = (SamsungPhone) model;
            s.append(sModel.isTouchId() + ",");
            s.append(sModel.isPencil() + ",");
        } else if (model instanceof ApplePhone) {
            ApplePhone sModel = (ApplePhone) model;
            s.append(sModel.isFaceId() + ",");
            s.append(sModel.isTouchId() + ",");
            s.append(sModel.isBatteryCharger() + ",");
        }
        return s.toString();
    }

    @Override
    public int maxPrice(SmartPhone[] phones) {
        int maxPrice = phones[0].getPrice();
        for (int i = 1; i < phones.length; i++) {
            if (phones[i].getPrice() > maxPrice) {
                maxPrice = phones[i].getPrice();
            }
        }
        return maxPrice;
    }

    @Override
    public SmartPhone newestPhone(SmartPhone[] phones) {
        int year = phones[0].getYear();
        SmartPhone phone = null;
        for (int i = 1; i < phones.length; i++) {
            if (phones[i].getYear() > year) {
                year = phones[i].getYear();
                phone = phones[i];
            }
        }
        return phone;
    }

    @Override
    public void orderByPrice(SmartPhone[] phones) {
        for (int i = 0; i < phones.length - 1; i++) {
            for (int j = 0; j < phones.length - 1 - i; j++) {
                if (phones[j].getPrice() < phones[j + 1].getPrice()) {
                    SmartPhone tmp = phones[j];
                    phones[j] = phones[j + 1];
                    phones[j + 1] = tmp;
                }
            }
        }
        printInfoOfPhones(phones);
    }

    @Override
    public SmartPhone cheapestPhone(SmartPhone[] phones) {
        int minPrice = phones[0].getPrice();
        SmartPhone phone = null;
        for (int i = 1; i < phones.length; i++) {
            if (phones[i].getPrice() < minPrice) {
                minPrice = phones[i].getPrice();
                phone = phones[i];
            }
        }
        return phone;
    }

    @Override
    public void someActionsOfPhone(SmartPhone[] phones) {
        for (SmartPhone phone:
             phones) {
            phone.call("374555555");
            phone.sendMessage("Hello","374555555");
        }
    }
}
