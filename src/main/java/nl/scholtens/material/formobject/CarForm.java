package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Decoder;

import java.util.List;

public class CarForm extends Body {

    private List<Car> cars;

    private Car car;

    private Decoder decoder;

    private String image;

    private String bigImage;

    public CarForm(String version, String date) {
        super(version, date);
    }

    public CarForm(String version, String date, Car car) {
        super(version, date);
        setCar(car);
        setDecoder(car);
        setImage(car);
        setBigImage(getImage());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    private void setDecoder(Car car) {
        if (getCar() != null) {
            decoder = car.getDecoder();
        }
    }

    public String getImage() {
        return image;
    }

    private void setImage(Car car) {
        if (getCar() != null) {
            image = car.getImage();
        }
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String image) {

        if (getImage() != null) {
            bigImage = getImage().substring(0, getImage().length() - 6) + ".png";
        }
    }
}
