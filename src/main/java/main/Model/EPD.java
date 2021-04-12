package main.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EPD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @OneToMany(targetEntity = EPD2device.class, mappedBy = "epd")
    private List<EPD2device> epd2DeviceList;

    public List<EPD2device> getEpd2DeviceList() {
        return epd2DeviceList;
    }

    public void setEpd2DeviceList(List<EPD2device> epd2DeviceList) {
        this.epd2DeviceList = epd2DeviceList;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
