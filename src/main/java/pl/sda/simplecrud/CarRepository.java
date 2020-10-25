package pl.sda.simplecrud;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE lower(c.vin) =lower(?1)")//to nie jest SQL to jest JPQL
    Optional<Car> findByVin(String vin);




}
