package com.example.trainingroom.data;


import android.content.Context;

import com.example.trainingroom.data.local.AppDatabase;
import com.example.trainingroom.data.model.Country;

import java.util.List;

public class CountryDataRepository implements CountryRepository {
    AppDatabase db;

    public CountryDataRepository(AppDatabase db) {
        this.db = db;
    }

    @Override
    public List<Country> getAll() {
        return db.countryDao().getAll();
    }
}
