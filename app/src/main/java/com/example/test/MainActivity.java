package com.example.test;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMobile, etAddress;
    RadioGroup rgGender;
    Button btnDate, btnSubmit;
    CheckBox cbReading, cbDancing, cbSinging, cbTravelling;
    String date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etAddress = findViewById(R.id.etAddress);
        rgGender = findViewById(R.id.rgGender);
        btnDate = findViewById(R.id.btnDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        cbReading = findViewById(R.id.cbReading);
        cbDancing = findViewById(R.id.cbDancing);
        cbSinging = findViewById(R.id.cbSinging);
        cbTravelling = findViewById(R.id.cbTravelling);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int y, int m, int d) {
                                date = d + "/" + (m + 1) + "/" + y;
                                btnDate.setText(date);
                            }
                        }, year, month, day);

                dp.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = "";
                int id = rgGender.getCheckedRadioButtonId();

                if (id != -1) {
                    RadioButton rb = findViewById(id);
                    gender = rb.getText().toString();
                }
                String hobbies = "";

                if (cbReading.isChecked()) hobbies += "Reading ";
                if (cbDancing.isChecked()) hobbies += "Dancing ";
                if (cbSinging.isChecked()) hobbies += "Singing ";
                if (cbTravelling.isChecked()) hobbies += "Travelling ";

                String result =
                        "Name: " + etName.getText().toString() +
                                "Mobile: " + etMobile.getText().toString() +
                                "Address: " + etAddress.getText().toString() +
                                "Gender: " + gender +
                                "DOB: "     + date +
                                "Hobbies: " + hobbies;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

    }
}