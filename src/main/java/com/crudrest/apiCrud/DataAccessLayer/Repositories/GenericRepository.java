package com.crudrest.apiCrud.DataAccessLayer.Repositories;

import com.crudrest.apiCrud.DataAccessLayer.Interfaces.IGenericRepository;
import com.crudrest.apiCrud.EntityLayer.WeatherForCity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericRepository implements IGenericRepository {

    /* Bu katmanın en doğru yazımı ilk önce generic bir interface daha sonra generic bir class oluşturulur ve implemantasyonlar yapılır.
     Daha sonra her entity classının hem interface i hem de repoClassı yazılır.İnterfacei Generic İnterfaceden kalıtım alır.
     Genericten implemente edilir ve her class kendi interfacesinde özelleştirilmiş olur. Ve SOLID prensibinin Interface Segregation prensibine uyarak sadece
     kendisi ile ilgili metotları doldurur.
     Aynı zamanda bu veri katmanı olduğu icin veritabanında nesne üretilerek veritabanı işlemleri bu katmanda yapılır.*/
    private EntityManager entityManager;

    public GenericRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public WeatherForCity GetByName(String city_name) {
        try {
            WeatherForCity obj = entityManager.createQuery("SELECT p FROM WeatherForCity p WHERE p.city_name = :city", WeatherForCity.class)
                    .setParameter("city", city_name)
                    .getSingleResult();
           return obj;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<WeatherForCity> GetAll() {
        return entityManager.createQuery("From WeatherForCity", WeatherForCity.class).getResultList();
    }
}
