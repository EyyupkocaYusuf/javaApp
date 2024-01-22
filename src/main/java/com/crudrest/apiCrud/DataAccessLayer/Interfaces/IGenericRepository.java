package com.crudrest.apiCrud.DataAccessLayer.Interfaces;

import com.crudrest.apiCrud.EntityLayer.WeatherForCity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGenericRepository {

    /* DataAccess katmanı bu katmandır. Bu katmanda biz veritabanı ilişkilerini, seederlari, entity katmanındaki
    class ların konfigürasyon ayarlarını ve UnitOfWork Design patternını da bu katmanda kullanırız.*/

    WeatherForCity GetByName(String city_name);

    List<WeatherForCity> GetAll();
}
