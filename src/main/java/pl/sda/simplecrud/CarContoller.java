package pl.sda.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarContoller {

    @Autowired
    private CarService carService;

    @PostMapping
    public void addCar(@RequestBody CarDTO carDTO){
        carService.addCar(carDTO);
    }

    @GetMapping
    public List<CarDTO> showCarList(){
        return carService.showCarList();
    }

    @GetMapping("/{id}")
    public CarDTO findCarById(@PathVariable Integer id){
        return carService.findCarById(id);
    }

    @GetMapping("/vin/{vin}")
    public CarDTO findCarByVin(@PathVariable String vin){
        return carService.findCarByVin(vin);
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Integer id, @RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }

}
