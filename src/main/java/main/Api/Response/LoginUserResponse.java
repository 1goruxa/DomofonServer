package main.Api.Response;

import main.Model.Device;

import java.util.ArrayList;
import java.util.Set;

public class LoginUserResponse {
    private int id;
    private String name;
    private int isAdmin;
    private int groupId;
    private int balance;
    private ArrayList<DeviceResponse> deviceSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<DeviceResponse> getDeviceSet() {
        return deviceSet;
    }

    public void setDeviceSet(ArrayList<DeviceResponse> deviceSet) {
        this.deviceSet = deviceSet;
    }
}
