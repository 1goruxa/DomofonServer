package main.Service;

import main.Api.Request.EpdRequest;
import main.Api.Response.DeviceResponse;
import main.Api.Response.EpdUpdateResponse;
import main.Model.EPD;
import main.Model.EPD2device;
import main.Repo.DeviceRepository;
import main.Repo.EPD2DeviceRepository;
import main.Repo.EpdRepository;
import main.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EndPointDeviceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    EpdRepository epdRepository;
    @Autowired
    EPD2DeviceRepository epd2DeviceRepository;

    public EpdUpdateResponse updateDevice(EpdRequest epdRequest){
        EpdUpdateResponse epdUpdateResponse = new EpdUpdateResponse();
        //Формируем и возвращаем обновление для конечного устройства
        Optional<EPD> edpOptional = epdRepository.findById(epdRequest.getId());
        System.out.println(epdRequest.getId() + " id");
        if (edpOptional.isPresent()){
            epdUpdateResponse.setResult(true);
            List<EPD2device> epd2devicesArrayList = epd2DeviceRepository.findDevicesByIdEPD(edpOptional.get().getId());
            ArrayList<DeviceResponse> deviceArrayList = new ArrayList<>();
            epd2devicesArrayList.forEach(e -> {
                DeviceResponse deviceResponse = new DeviceResponse();
                deviceResponse.setId(e.getDevice().getId());
                deviceResponse.setName(e.getDevice().getName());
                deviceResponse.setMac(e.getDevice().getMac());
                deviceArrayList.add(deviceResponse);
            });

            epdUpdateResponse.setDevices(deviceArrayList);
        }
        else {
            epdUpdateResponse.setResult(false);
            epdUpdateResponse.setError("Конечное устройство не зарегистрировано");
        }
        return epdUpdateResponse;
    }

}
