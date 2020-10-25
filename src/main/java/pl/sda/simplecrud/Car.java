package pl.sda.simplecrud;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String model;
    private String vin;

    @Enumerated
    private Colour colour; //fixMe :)

    public Car() {
    }

    public Car(String model, String vin, Colour colour) {
        this.model = model;
        this.vin = vin;
        this.colour = colour;
    }

    public static Car apply(CarDTO carDTO) {
        Car car = new Car();
        car.colour = Colour.valueOf(carDTO.getColour());
        car.model = carDTO.getModel();
        car.vin = carDTO.getVin();
        car.id = carDTO.getId();
        return car;
    }
}
