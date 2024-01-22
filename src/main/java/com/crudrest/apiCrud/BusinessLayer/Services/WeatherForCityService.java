package com.crudrest.apiCrud.BusinessLayer.Services;

import com.crudrest.apiCrud.BusinessLayer.Interfaces.IWeatherForCityService;
import com.crudrest.apiCrud.DataAccessLayer.Interfaces.IGenericRepository;
import com.crudrest.apiCrud.EntityLayer.WeatherForCity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherForCityService implements IWeatherForCityService {

    /* Bu class bir servicetir. Kendisine ait interface' i implemente eder. ve Data Access katmanında bir nesne örneği oluşturarak
    * Dependency Injection gerceklestirmiş olur. Bu da bağımlılığı minimize etmek icin yapılır.
    * Aslına bakarsanız bunlar normalde IoC containerlar kullanılarak yapılır. */
    private IGenericRepository genericRepository;

    public WeatherForCityService(IGenericRepository genericRepository)
    {
        this.genericRepository = genericRepository;
    }
    @Override
    public WeatherForCity GetByName(String city_name) {
        return genericRepository.GetByName(city_name);
    }
    @Override
    public List<WeatherForCity> GetAll() {
        return genericRepository.GetAll();
    }

}
