package com.crudrest.apiCrud.EntityLayer;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "weather_for_cities")
// bu katmanın adı EntityLayer katmanı, ilişkileri tanımladığımız ve attributleri belirlediğimiz katmandir.
public class WeatherForCity {

    //class attributlerini ve eşleşmlerini yaptım.
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city_name;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "unit")
    private String unit;


    public  WeatherForCity(String city_name,String unit,float temperature)
    {
        this.city_name = city_name;
        this.unit = unit;
        this.temperature = temperature;
    }

    // Herhangi bir yerde nesne üretirken atama yapmadığımda hata vermemesi icin oluşturdum.
    public  WeatherForCity()
    {
    }

    //private tanımlandıpı icin get-set metotlarını yazdim.
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
    public String getCity_name() {
        return city_name;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return unit;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherForCity{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", temperature=" + temperature +
                ", unit='" + unit + '\'' +
                '}';
    }
}
