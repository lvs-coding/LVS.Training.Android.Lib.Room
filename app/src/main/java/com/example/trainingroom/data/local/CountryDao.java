package com.example.trainingroom.data.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.trainingroom.data.model.Country;

import java.util.List;

@Dao
public interface CountryDao {

    @Query("SELECT * FROM Country")
    List<Country> getAll();

    @Query("SELECT * FROM Country where name LIKE  :name")
    Country findByName(String name);

    @Query("SELECT COUNT(*) from Country")
    int countCountries();

    @Insert
    void insertAll(Country... countries);

    @Delete
    void delete(Country country);
}