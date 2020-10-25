package pl.sda.simplecrud;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CarDTO { //data transfer object

    private Integer id;
    private String model;
    private String vin;
    private String colour;

    public CarDTO(Integer id, String model, String vin, String colour) {
        this.id = id;
        this.model = model;
        this.vin = vin;
        this.colour = colour;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public String getColour() {
        return colour;
    }
}
