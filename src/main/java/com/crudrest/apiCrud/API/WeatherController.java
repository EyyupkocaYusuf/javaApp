package com.crudrest.apiCrud.API;

import com.crudrest.apiCrud.BusinessLayer.Interfaces.IWeatherForCityService;
import com.crudrest.apiCrud.EntityLayer.WeatherForCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    /* En son controller view ile model arasında ilişki kuracak metotlarımızı yazarız.
    burada da tekrar dan interfaceten nesne örneği alıp
    dependecy injection ile loosley cooped dediğimiz düşük bağlılık ile gerçekleştiririz.
     */

    private IWeatherForCityService weatherForCityService;

    @Autowired
    public WeatherController(IWeatherForCityService weatherForCityService) {
        this.weatherForCityService = weatherForCityService;
    }

    //metodun get olduğunu ve url de getAll ile kullanıldığını belirttim.
    // veritabanında ki WeatherForCity e ait tüm verileri getirir.
    @GetMapping("getAll")
    public List<WeatherForCity> GetAll()
    {
        return weatherForCityService.GetAll();
    }

    /* metodun get olduğunu ve url de "/get/{city_name}" ile kullanıldığını belirttim.
    * bu metot ile gönderidğimiz şehir ismine göre bir request yollarız,
    *  veritabanında eşleşen bir kayıt var ise onu response eder.*/
    @GetMapping("/get/{city_name}")
    public ResponseEntity<Object> GetByCityName(@PathVariable String city_name)
    {
        WeatherForCity weather = weatherForCityService.GetByName(city_name);
        if (weather != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Status = success, " + weather);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status = failure");
        }
    }

    /* Bu da yukarıda ki metodun post metotudur.
    * Yukarıdaki metotda veriler kullanıcıyı tarafında görünürken
    * bu metot da post işlemi yaptığından veriler arka tarafta gizlenir ve url kısmında gösterilmez. */
    @PostMapping("/post/{city_name}")
    public ResponseEntity<Object> PostByCityName(@PathVariable String city_name) {
        WeatherForCity weather = weatherForCityService.GetByName(city_name);

        if (weather != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Status = success, " + weather);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status = failure");
        }
    }

}

