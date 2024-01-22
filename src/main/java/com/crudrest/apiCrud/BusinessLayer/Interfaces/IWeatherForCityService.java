package com.crudrest.apiCrud.BusinessLayer.Interfaces;

import com.crudrest.apiCrud.EntityLayer.WeatherForCity;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IWeatherForCityService {

    /* Bu katman BusinessLayer katmanıdır. Bu katmanda interface ve serviclerden oluşur. Bunun dışında Valiasyon konotrllerinin yapıldığı katmandır.
    * Boylelikle controller olduğunca sade, kodlar anlaşılır ve bakım kolay olacaktır. Katmanlı mimarinin en büyük avantajları bunlardır.
    *
    * Burada da Önce Generic bir interface oluşturulur ve ve daha sonra her class icin ayrı bir interface oluşturulup Generic interface implemente edilir*/
    WeatherForCity GetByName(String city_name);
    List<WeatherForCity> GetAll();

}
