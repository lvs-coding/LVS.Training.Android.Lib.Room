package com.example.trainingroom.data;


import com.example.trainingroom.data.local.AppDatabase;
import com.example.trainingroom.data.model.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> getAll();
}
