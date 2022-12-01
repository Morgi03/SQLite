package hu.petrik.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button adatokOlvasasaBtn;
    private Button adatokRogziteseBtn;
    private Button adatokModositasaBtn;
    private Button adatTorlese;
    private TextView adatokTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        adatokRogziteseBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DataRead.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        adatokOlvasasaBtn = findViewById(R.id.adatokOlvasasaBtn);
        adatokRogziteseBtn = findViewById(R.id.adatokRogziteseBtn);
        adatokModositasaBtn = findViewById(R.id.adatokModositasaBtn);
        adatTorlese = findViewById(R.id.adatTorlese);
        adatokTextView = findViewById(R.id.adatokTextView);
    }
}