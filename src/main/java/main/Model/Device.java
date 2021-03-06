package main.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mac;

    @ManyToOne(targetEntity=User.class,optional=false)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(targetEntity = EPD2device.class, mappedBy = "device")
    private List<EPD2device> epd2DeviceList;

    public List<EPD2device> getEpd2DeviceList() {
        return epd2DeviceList;
    }

    public void setEpd2DeviceList(List<EPD2device> epd2DeviceList) {
        this.epd2DeviceList = epd2DeviceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
