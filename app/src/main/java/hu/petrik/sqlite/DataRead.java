package hu.petrik.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataRead extends AppCompatActivity {

    private EditText vezeteknevEditText;
    private EditText keresztnevEditText;
    private EditText jegyEditText;
    private Button rogzitesBtn;
    private Button visszaBtn;

    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_read);
        init();
        visszaBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        rogzitesBtn.setOnClickListener(view -> {
            String vezeteknev = vezeteknevEditText.getText().toString().trim();
            String keresztnev = keresztnevEditText.getText().toString().trim();
            String jegyString = jegyEditText.getText().toString().trim();
            if (vezeteknev.isEmpty() || jegyString.isEmpty() || keresztnev.isEmpty()) {
                Toast.makeText(this, "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
            } else {
                int jegy = Integer.parseInt(jegyString);
                if (adatbazis.rogzites(vezeteknev, keresztnev, jegy)) {
                    Toast.makeText(this, "Sikeres adatrögzítés", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Sikertelen adatrögzítés", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        vezeteknevEditText = findViewById(R.id.vezeteknevEditText);
        keresztnevEditText = findViewById(R.id.keresztnevEditText);
        jegyEditText = findViewById(R.id.jegyEditText);
        rogzitesBtn = findViewById(R.id.rogzitesBtn);
        visszaBtn = findViewById(R.id.visszaBtn);
        adatbazis = new DBHelper(DataRead.this);
    }
}