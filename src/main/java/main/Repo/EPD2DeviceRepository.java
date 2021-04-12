package main.Repo;

import main.Model.Device;
import main.Model.EPD2device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EPD2DeviceRepository extends JpaRepository<EPD2device, Integer> {

    @Query(value = "SELECT * FROM epd2devices WHERE epd_id = :id", nativeQuery = true)
    List<EPD2device> findDevicesByIdEPD(int id);

}
