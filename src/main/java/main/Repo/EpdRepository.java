package main.Repo;

import main.Model.EPD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpdRepository extends JpaRepository<EPD, Integer> {

}
