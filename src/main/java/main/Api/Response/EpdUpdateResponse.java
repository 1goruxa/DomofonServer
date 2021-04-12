package main.Api.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;

//Объект состоит из статуса обновления и свойств авторизованных абонентских устройств для конкретного epd
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EpdUpdateResponse {
    private Boolean result;
    ArrayList<DeviceResponse> devices;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public ArrayList<DeviceResponse> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<DeviceResponse> devices) {
        this.devices = devices;
    }
}
