package com.example.trainingroom;


import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.trainingroom.data.local.AppDatabase;
import com.example.trainingroom.data.model.Country;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Country addCountry(final AppDatabase db, Country country) {
        db.countryDao().insertAll(country);
        return country;
    }

    public static List<Country> getAll(final AppDatabase db) {
        return db.countryDao().getAll();
    }

    private static void populateWithTestData(AppDatabase db) {
        Country country = new Country();
        country.setName("France");
        country.setTown("Paris");
        addCountry(db, country);

        List<Country> countryList = db.countryDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + countryList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}

