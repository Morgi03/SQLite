package hu.petrik.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DataRead extends AppCompatActivity {

    private EditText vezeteknevEditText;
    private EditText keresztnevEditText;
    private EditText jegyEditText;
    private Button rogzitesBtn;
    private Button visszaBtn;

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
    }

    private void init() {
        vezeteknevEditText = findViewById(R.id.vezeteknevEditText);
        keresztnevEditText = findViewById(R.id.keresztnevEditText);
        jegyEditText = findViewById(R.id.jegyEditText);
        rogzitesBtn = findViewById(R.id.rogzitesBtn);
        visszaBtn = findViewById(R.id.visszaBtn);
    }
}