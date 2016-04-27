package com.filipkesteli.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Spinner spColors;
    private CheckBox cbCroatian;
    private CheckBox cbEnglish;
    private CheckBox cbItalian;
    private ToggleButton tbMusic;
    private RadioGroup rgLanguages;

    //dynamic adapter:
    private static String [] colors = {"Cyan", "Magenta", "Grey"};
    private static String [] cities = {"Zagreb", "Istanbul", "Bukurest"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();

        populateSpinner();
//        populateListView();
    }

//    private void populateListView() {
//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
//                this, android.R.layout.simple_list_item_activated_1, cities
//        );
//    }

    private void populateSpinner() {
//        ArrayAdapter<CharSequence> adapter =
//                ArrayAdapter.createFromResource(
//                        this,
//                        R.array.colors,
//                        android.R.layout.simple_list_item_1
//                );
//        spColors.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<CharSequence>(
                        this,
                        android.R.layout.simple_list_item_activated_1,
                        colors
                );

        spColors.setAdapter(adapter);
    }

    private void initWidgets() {
        cbCroatian = (CheckBox) findViewById(R.id.cbCroatian);
        cbEnglish = (CheckBox) findViewById(R.id.cbEnglish);
        cbItalian = (CheckBox) findViewById(R.id.cbItalian);
        tbMusic = (ToggleButton) findViewById(R.id.tbMusic);
        rgLanguages = (RadioGroup) findViewById(R.id.rgLanguages);
        spColors = (Spinner) findViewById(R.id.spColors);
    }

    private void setupListeners() {
        tbMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCheckboxes();
                checkRadioGroup();
            }
        });
    }


    private void checkCheckboxes() {
        if (cbCroatian.isChecked()) {
            Toast.makeText(MainActivity.this, R.string.croatian, Toast.LENGTH_SHORT).show();
        }
        if (cbEnglish.isChecked()) {
            Toast.makeText(MainActivity.this, R.string.english, Toast.LENGTH_SHORT).show();
        }
        if (cbItalian.isChecked()) {
            Toast.makeText(MainActivity.this, R.string.italian, Toast.LENGTH_SHORT).show();
        }
    }

    private void checkRadioGroup() {
        int selectedId = rgLanguages.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.rbCroatian:
                Toast.makeText(MainActivity.this, R.string.croatian, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbEnglish:
                Toast.makeText(MainActivity.this, R.string.english, Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbItalian:
                Toast.makeText(MainActivity.this, R.string.italian, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
