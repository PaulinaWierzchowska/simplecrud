package pl.sda.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCar(CarDTO carDTO) {
        if (carWithVinExists(carDTO.getVin())) {
            throw new CarExistsException("Samochód o nr vin istnieje:" + carDTO.getVin());
        }
        Car car = Car.apply(carDTO);
        carRepository.save(car);
        System.out.println("Samochód zapisany");
    }

    public List<CarDTO> showCarList() {
        return carRepository.findAll().stream()
                .map(c -> c.toDTO())
                .collect(Collectors.toList());
    }

    private boolean carWithVinExists(String vin) {
        return carRepository.findByVin(vin).isPresent();
    }

    public CarDTO findCarById(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        return changeCarToCarDTO(car, "Nie znaleziono samochodu o podanym ID");
    }

    public CarDTO findCarByVin(String vin) {
        Optional<Car> car = carRepository.findByVin(vin);
        return changeCarToCarDTO(car, "Nie znaleziono samochodu o podanym VIN");
    }

    private CarDTO changeCarToCarDTO(Optional<Car> car, String message) {
        return car
                .map(c -> c.toDTO())
                .orElseThrow(() -> new RuntimeException(message));
    }

    public CarDTO updateCar(CarDTO carDTO){
        Optional<Car> carOptional = carRepository.findById(carDTO.getId());
        Car car = carOptional.orElseThrow(()-> new RuntimeException("Nie znaleziono samochodu"));
        car.update(carDTO);
        return carRepository.save(car).toDTO();
    }
}
