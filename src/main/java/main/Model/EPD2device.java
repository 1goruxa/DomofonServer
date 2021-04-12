package main.Model;

import javax.persistence.*;


@Entity(name = "epd2devices")
public class EPD2device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;

    @OneToOne
    @JoinColumn(name = "epd_id", referencedColumnName = "id")
    private EPD epd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public EPD getEpd() {
        return epd;
    }

    public void setEpd(EPD epd) {
        this.epd = epd;
    }
}
