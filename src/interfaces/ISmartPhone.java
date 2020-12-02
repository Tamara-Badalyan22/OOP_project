package interfaces;

import model.SmartPhone;

public interface ISmartPhone {

    void printInfoOfPhone(SmartPhone phone);
    void printInfoOfPhones(SmartPhone[] phones);
    SmartPhone[] readFromFile(String path);
    void addPhoneIntoFile(String path);
    int maxPrice(SmartPhone[] phones);
    SmartPhone newestPhone(SmartPhone[] phones);
    void orderByPrice(SmartPhone[] phones);
    SmartPhone cheapestPhone(SmartPhone[] phones);
    void someActionsOfPhone(SmartPhone[] phones);
}
