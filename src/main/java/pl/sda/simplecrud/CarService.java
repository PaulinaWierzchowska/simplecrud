package pl.sda.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCar(CarDTO carDTO){
        Car car = Car.apply(carDTO);
        carRepository.save(car);
        System.out.println("Samochód zapisany");
    }

}
