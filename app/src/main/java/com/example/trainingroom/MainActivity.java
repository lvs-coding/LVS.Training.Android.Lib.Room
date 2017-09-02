package com.example.trainingroom;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.trainingroom.data.local.AppDatabase;
import com.example.trainingroom.data.model.Country;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_save_data)
    public void btnSave_onClick(View view) {
        DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));
        List<Country> countries = DatabaseInitializer.getAll(AppDatabase.getAppDatabase(this));

        for (Country c:countries) {
            Log.d(TAG,c.getName());

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }
}
