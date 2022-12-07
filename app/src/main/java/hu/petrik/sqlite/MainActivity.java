package hu.petrik.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button adatokOlvasasaBtn;
    private Button adatokRogziteseBtn;
    private Button adatokModositasaBtn;
    private Button adatTorlese;
    private TextView adatokTextView;

    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        adatokOlvasasaBtn.setOnClickListener(view -> {
            Cursor adatok = adatbazis.listaz();
            if (adatok.getCount() == 0) {
                Toast.makeText(this, "Nincs az adatbázisban bejegyzés", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder bobTheBuilder = new StringBuilder();
                while (adatok.moveToNext()) {
                    bobTheBuilder.append("ID: ").append(adatok.getInt(0));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Vezetéknév: ").append(adatok.getString(1));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Keresztnév: ").append(adatok.getString(2));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append("Jegy: ").append(adatok.getInt(3));
                    bobTheBuilder.append(System.lineSeparator());
                    bobTheBuilder.append(System.lineSeparator());
                }
                adatokTextView.setText(bobTheBuilder.toString());
            }
        });

        adatokRogziteseBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DataRead.class);
            startActivity(intent);
            finish();
        });

        adatokModositasaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ModositasActivity.class);
                startActivity(intent);
                finish();
            }
        });

        adatTorlese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TorlesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        adatokOlvasasaBtn = findViewById(R.id.adatokOlvasasaBtn);
        adatokRogziteseBtn = findViewById(R.id.adatokRogziteseBtn);
        adatokModositasaBtn = findViewById(R.id.adatokModositasaBtn);
        adatTorlese = findViewById(R.id.adatTorlese);
        adatokTextView = findViewById(R.id.adatokTextView);
        adatbazis = new DBHelper(MainActivity.this);
    }
}