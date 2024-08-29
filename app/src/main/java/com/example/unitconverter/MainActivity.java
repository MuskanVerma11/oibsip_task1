package com.example.unitconverter;

import static java.security.AccessController.getContext;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.appcompat.app.ActionBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public String fromUnit="";
    public String toUnit="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

//        Setting action bar background color
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primaryAppColor)));
        getWindow().setStatusBarColor(getResources().getColor(R.color.primaryAppColor));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button lengthBtn = findViewById(R.id.length);
        Button massBtn= findViewById(R.id.mass);
        Button volumeBtn = findViewById(R.id.volume);
        Button tempBtn=findViewById(R.id.temperature);
        Button speedBtn=findViewById(R.id.speed);
        Button storageBtn=findViewById(R.id.storage);
        Button timeBtn= findViewById(R.id.time);
        Button energyBtn=findViewById(R.id.energy);
        Button angleBtn=findViewById(R.id.angle);
        Button submitBtn=findViewById(R.id.submit);

        Spinner FromSpinner=findViewById(R.id.dropdown_menu);
        Spinner ToSpinner=findViewById(R.id.dropdown_menu2);

        EditText inputValue=findViewById(R.id.input);
        TextView outputText=findViewById(R.id.output);

        LinearLayout unitSelectionFrom=findViewById(R.id.unitSelectionFrom);
        LinearLayout unitSelectionTo=findViewById(R.id.unitSelectionTo);

        TextView enterInputText=findViewById(R.id.enterInput);

        LinearLayout enterInputFields=findViewById(R.id.inputFields);


//        Length Adapter
        ArrayAdapter<CharSequence> LengthAdapter = ArrayAdapter.createFromResource(this,
                R.array.length_from, android.R.layout.simple_spinner_item);

        LengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Length Button
        lengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleLengthButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);

            }

            private void handleLengthButton() {
                FromSpinner.setAdapter(LengthAdapter);
                ToSpinner.setAdapter(LengthAdapter);
            }


        });

        inputValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateSubmitButtonVisibility();
            }

            @Override
            public void afterTextChanged(Editable s) { }

            private void updateSubmitButtonVisibility() {
                if (inputValue.getText() != null && inputValue.getText().length() > 0) {
                    submitBtn.setVisibility(View.VISIBLE);
                } else {
                    submitBtn.setVisibility(View.GONE);
                    outputText.setText("");
                }
            }
        });

        //        Mass Adapter
        ArrayAdapter<CharSequence> MassAdapter = ArrayAdapter.createFromResource(this,
                R.array.mass_from, android.R.layout.simple_spinner_item);

        MassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Mass Button
        massBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleMassButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleMassButton() {
                FromSpinner.setAdapter(MassAdapter);
                ToSpinner.setAdapter(MassAdapter);
            }
        });

        //        Volume Adapter
        ArrayAdapter<CharSequence> VolumeAdapter = ArrayAdapter.createFromResource(this,
                R.array.volume_from, android.R.layout.simple_spinner_item);

        VolumeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Volume Button
        volumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleVolumeButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleVolumeButton() {
                FromSpinner.setAdapter(VolumeAdapter);
                ToSpinner.setAdapter(VolumeAdapter);
            }
        });

        //        Temp Adapter
        ArrayAdapter<CharSequence> TempAdapter = ArrayAdapter.createFromResource(this,
                R.array.temp_from, android.R.layout.simple_spinner_item);

        TempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Temp Button
        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleTempButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleTempButton() {
                FromSpinner.setAdapter(TempAdapter);
                ToSpinner.setAdapter(TempAdapter);
            }
        });

        //        Speed Adapter
        ArrayAdapter<CharSequence> SpeedAdapter = ArrayAdapter.createFromResource(this,
                R.array.speed_from, android.R.layout.simple_spinner_item);

        SpeedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        speed Button
        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleSpeedButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleSpeedButton() {
                FromSpinner.setAdapter(SpeedAdapter);
                ToSpinner.setAdapter(SpeedAdapter);
            }
        });

        //        Storage Adapter
        ArrayAdapter<CharSequence> StorageAdapter = ArrayAdapter.createFromResource(this,
                R.array.ds_from, android.R.layout.simple_spinner_item);

        StorageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Storage Button
        storageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleStorageButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleStorageButton() {
                FromSpinner.setAdapter(StorageAdapter);
                ToSpinner.setAdapter(StorageAdapter);
            }
        });

        //        Time Adapter
        ArrayAdapter<CharSequence> TimeAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_from, android.R.layout.simple_spinner_item);

        TimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Time Button
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleTimeButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleTimeButton() {
                FromSpinner.setAdapter(TimeAdapter);
                ToSpinner.setAdapter(TimeAdapter);
            }
        });

        //        Energy Adapter
        ArrayAdapter<CharSequence> EnergyAdapter = ArrayAdapter.createFromResource(this,
                R.array.energy_from, android.R.layout.simple_spinner_item);

        EnergyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Energy Button
        energyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleEnergyButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleEnergyButton() {
                FromSpinner.setAdapter(EnergyAdapter);
                ToSpinner.setAdapter(EnergyAdapter);
            }
        });

        //        Angle Adapter
        ArrayAdapter<CharSequence> AngleAdapter = ArrayAdapter.createFromResource(this,
                R.array.angle_from, android.R.layout.simple_spinner_item);

        AngleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //        Angle Button
        angleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click
                handleAngleButton();
                unitSelectionFrom.setVisibility(View.VISIBLE);
                unitSelectionTo.setVisibility(View.VISIBLE);
            }

            private void handleAngleButton() {
                FromSpinner.setAdapter(AngleAdapter);
                ToSpinner.setAdapter(AngleAdapter);
            }
        });

        // Handling Item selection
        FromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                fromUnit=parentView.getItemAtPosition(position).toString();

                if (selectedItemView != null && selectedItemView instanceof TextView) {
                    ((TextView) selectedItemView).setTextColor(getResources().getColor(R.color.black));
                }

                enterInputText.setVisibility(View.VISIBLE);
                enterInputFields.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected
            }
        });

        ToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                toUnit=parentView.getItemAtPosition(position).toString();

                    ((TextView) selectedItemView).setTextColor(getResources().getColor(R.color.black));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform conversion when submit button is clicked
                if (!inputValue.getText().toString().isEmpty()) {
                    double input = Double.parseDouble(inputValue.getText().toString());
                    double result=0.0;
                    if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                        result = (input * 9/5) + 32;
                    } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
                        result = (input - 32) * 5/9;
                    } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
                        result = input + 273.15;
                    } else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
                        result = input - 273.15;
                    } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
                        result = (input - 32) * 5/9 + 273.15;
                    } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
                        result = (input - 273.15) * 9/5 + 32;
                    } else {
                        double conversionFactor = getConversionFactor(fromUnit, toUnit);
                        result = input * conversionFactor;
                    }
                    double output = Math.round(result * 10.0) / 10.0;

                    // Display the result
                    outputText.setText(String.valueOf(result) +" ~ "+output+" "+toUnit);
                }
            }
        });

    }

    private double getConversionFactor(String fromUnit, String toUnit) {
        double factor = 1; // Default factor is 1 if the units are the same

        if (fromUnit.equals("Metre") && toUnit.equals("Kilometre")) {
            factor = 0.001;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Centimetre")) {
            factor = 0.1;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Metre")) {
            factor = 0.001;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Kilometre")) {
            factor = 0.000001;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Millimetre")) {
            factor = 10;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Metre")) {
            factor = 0.01;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Kilometre")) {
            factor = 0.00001;
        } else if (fromUnit.equals("Metre") && toUnit.equals("Millimetre")) {
            factor = 1000;
        } else if (fromUnit.equals("Metre") && toUnit.equals("Centimetre")) {
            factor = 100;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Millimetre")) {
            factor = 1000000;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Centimetre")) {
            factor = 100000;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Metre")) {
            factor = 1000;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Kilometre")) {
            factor = 1.609344;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Metre")) {
            factor = 1609.344;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Centimetre")) {
            factor = 160934.4;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Millimetre")) {
            factor = 1609344;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Mile")) {
            factor = 0.621371192;
        } else if (fromUnit.equals("Metre") && toUnit.equals("Mile")) {
            factor = 0.000621371192;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Mile")) {
            factor = 0.000006213712;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Mile")) {
            factor = 0.0000006213712;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Metre")) {
            factor = 0.3048;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Centimetre")) {
            factor = 30.48;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Millimetre")) {
            factor = 304.8;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Kilometre")) {
            factor = 0.0003048;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Mile")) {
            factor = 0.0001893939;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Inch")) {
            factor = 12;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Feet")) {
            factor = 0.0833333333;
        } else if (fromUnit.equals("Metre") && toUnit.equals("Feet")) {
            factor = 3.280839895;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Feet")) {
            factor = 0.03280839895;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Feet")) {
            factor = 0.003280839895;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Feet")) {
            factor = 3280.839895;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Feet")) {
            factor = 5280;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Millimetre")) {
            factor = 25.4;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Centimetre")) {
            factor = 2.54;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Metre")) {
            factor = 0.0254;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Kilometre")) {
            factor = 0.0000254;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Mile")) {
            factor = 0.0000157828;
        } else if (fromUnit.equals("Millimetre") && toUnit.equals("Inch")) {
            factor = 0.0393700787;
        } else if (fromUnit.equals("Centimetre") && toUnit.equals("Inch")) {
            factor = 0.3937007874;
        } else if (fromUnit.equals("Metre") && toUnit.equals("Inch")) {
            factor = 39.37007874;
        } else if (fromUnit.equals("Kilometre") && toUnit.equals("Inch")) {
            factor = 39370.07874;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Inch")) {
            factor = 63360;
        } else if (fromUnit.equals("Milligram") && toUnit.equals("Gram")) {
            factor = 0.001;
        } else if (fromUnit.equals("Milligram") && toUnit.equals("Kilogram")) {
            factor = 0.000001;
        } else if (fromUnit.equals("Milligram") && toUnit.equals("Pound")) {
            factor = 0.00000220462;
        } else if (fromUnit.equals("Gram") && toUnit.equals("Milligram")) {
            factor = 1000;
        } else if (fromUnit.equals("Gram") && toUnit.equals("Kilogram")) {
            factor = 0.001;
        } else if (fromUnit.equals("Gram") && toUnit.equals("Pound")) {
            factor = 0.00220462;
        } else if (fromUnit.equals("Kilogram") && toUnit.equals("Milligram")) {
            factor = 1000000;
        } else if (fromUnit.equals("Kilogram") && toUnit.equals("Gram")) {
            factor = 1000;
        } else if (fromUnit.equals("Kilogram") && toUnit.equals("Pound")) {
            factor = 2.20462;
        } else if (fromUnit.equals("Pound") && toUnit.equals("Milligram")) {
            factor = 453592;
        } else if (fromUnit.equals("Pound") && toUnit.equals("Gram")) {
            factor = 453.592;
        } else if (fromUnit.equals("Pound") && toUnit.equals("Kilogram")) {
            factor = 0.453592;
        } else if (fromUnit.equals("Millilitre") && toUnit.equals("Litre")) {
            factor = 0.001;
        } else if (fromUnit.equals("Millilitre") && toUnit.equals("Gallon")) {
            factor = 0.000264172;
        } else if (fromUnit.equals("Millilitre") && toUnit.equals("Quarts")) {
            factor = 0.00105669;
        } else if (fromUnit.equals("Litre") && toUnit.equals("Millilitre")) {
            factor = 1000;
        } else if (fromUnit.equals("Litre") && toUnit.equals("Gallon")) {
            factor = 0.264172;
        } else if (fromUnit.equals("Litre") && toUnit.equals("Quarts")) {
            factor = 1.05669;
        } else if (fromUnit.equals("Gallon") && toUnit.equals("Millilitre")) {
            factor = 3785.41;
        } else if (fromUnit.equals("Gallon") && toUnit.equals("Litre")) {
            factor = 3.78541;
        } else if (fromUnit.equals("Gallon") && toUnit.equals("Quarts")) {
            factor = 4;
        } else if (fromUnit.equals("Quarts") && toUnit.equals("Millilitre")) {
            factor = 946.353;
        } else if (fromUnit.equals("Quarts") && toUnit.equals("Litre")) {
            factor = 0.946353;
        } else if (fromUnit.equals("Quarts") && toUnit.equals("Gallon")) {
            factor = 0.25;
        }else if (fromUnit.equals("m/s") && toUnit.equals("km/h")) {
            factor = 3.6;
        } else if (fromUnit.equals("km/h") && toUnit.equals("m/s")) {
            factor = 1 / 3.6;
        } else if (fromUnit.equals("Bit") && toUnit.equals("Byte")) {
            factor = 1 / 8.0;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Bit")) {
            factor = 8.0;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Kilobyte")) {
            factor = 1 / 1024.0;
        } else if (fromUnit.equals("Kilobyte") && toUnit.equals("Byte")) {
            factor = 1024.0;
        } else if (fromUnit.equals("Kilobyte") && toUnit.equals("Megabyte")) {
            factor = 1 / 1024.0;
        } else if (fromUnit.equals("Megabyte") && toUnit.equals("Kilobyte")) {
            factor = 1024.0;
        } else if (fromUnit.equals("Megabyte") && toUnit.equals("Gigabyte")) {
            factor = 1 / 1024.0;
        } else if (fromUnit.equals("Gigabyte") && toUnit.equals("Megabyte")) {
            factor = 1024.0;
        } else if (fromUnit.equals("Gigabyte") && toUnit.equals("Terabyte")) {
            factor = 1 / 1024.0;
        } else if (fromUnit.equals("Terabyte") && toUnit.equals("Gigabyte")) {
            factor = 1024.0;
        } else if (fromUnit.equals("Bit") && toUnit.equals("Kilobyte")) {
            factor = 1 / (8.0 * 1024.0);
        } else if (fromUnit.equals("Kilobyte") && toUnit.equals("Bit")) {
            factor = 8.0 * 1024.0;
        } else if (fromUnit.equals("Bit") && toUnit.equals("Megabyte")) {
            factor = 1 / (8.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Megabyte") && toUnit.equals("Bit")) {
            factor = 8.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Bit") && toUnit.equals("Gigabyte")) {
            factor = 1 / (8.0 * 1024.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Gigabyte") && toUnit.equals("Bit")) {
            factor = 8.0 * 1024.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Bit") && toUnit.equals("Terabyte")) {
            factor = 1 / (8.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Terabyte") && toUnit.equals("Bit")) {
            factor = 8.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Megabyte")) {
            factor = 1 / (1024.0 * 1024.0);
        } else if (fromUnit.equals("Megabyte") && toUnit.equals("Byte")) {
            factor = 1024.0 * 1024.0;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Gigabyte")) {
            factor = 1 / (1024.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Gigabyte") && toUnit.equals("Byte")) {
            factor = 1024.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Byte") && toUnit.equals("Terabyte")) {
            factor = 1 / (1024.0 * 1024.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Terabyte") && toUnit.equals("Byte")) {
            factor = 1024.0 * 1024.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Kilobyte") && toUnit.equals("Gigabyte")) {
            factor = 1 / (1024.0 * 1024.0);
        } else if (fromUnit.equals("Gigabyte") && toUnit.equals("Kilobyte")) {
            factor = 1024.0 * 1024.0;
        } else if (fromUnit.equals("Kilobyte") && toUnit.equals("Terabyte")) {
            factor = 1 / (1024.0 * 1024.0 * 1024.0);
        } else if (fromUnit.equals("Terabyte") && toUnit.equals("Kilobyte")) {
            factor = 1024.0 * 1024.0 * 1024.0;
        } else if (fromUnit.equals("Megabyte") && toUnit.equals("Terabyte")) {
            factor = 1 / (1024.0);
        } else if (fromUnit.equals("Terabyte") && toUnit.equals("Megabyte")) {
            factor = 1024.0;
        } else if (fromUnit.equals("Second") && toUnit.equals("Minute")) {
            factor = 1 / 60.0;
        } else if (fromUnit.equals("Minute") && toUnit.equals("Second")) {
            factor = 60.0;
        } else if (fromUnit.equals("Second") && toUnit.equals("Hour")) {
            factor = 1 / 3600.0;
        } else if (fromUnit.equals("Hour") && toUnit.equals("Second")) {
            factor = 3600.0;
        } else if (fromUnit.equals("Second") && toUnit.equals("Day")) {
            factor = 1 / 86400.0;
        } else if (fromUnit.equals("Day") && toUnit.equals("Second")) {
            factor = 86400.0;
        } else if (fromUnit.equals("Minute") && toUnit.equals("Hour")) {
            factor = 1 / 60.0;
        } else if (fromUnit.equals("Hour") && toUnit.equals("Minute")) {
            factor = 60.0;
        } else if (fromUnit.equals("Minute") && toUnit.equals("Day")) {
            factor = 1 / 1440.0;
        } else if (fromUnit.equals("Day") && toUnit.equals("Minute")) {
            factor = 1440.0;
        } else if (fromUnit.equals("Hour") && toUnit.equals("Day")) {
            factor = 1 / 24.0;
        } else if (fromUnit.equals("Day") && toUnit.equals("Hour")) {
            factor = 24.0;
        } else if (fromUnit.equals("Joule") && toUnit.equals("Calories")) {
            factor = 0.239006;
        } else if (fromUnit.equals("Calories") && toUnit.equals("Joule")) {
            factor = 4.184;
        } else if (fromUnit.equals("Joule") && toUnit.equals("Kilowatt-hours")) {
            factor = 0.00027778;
        } else if (fromUnit.equals("Kilowatt-hours") && toUnit.equals("Joule")) {
            factor = 3600000;
        } else if (fromUnit.equals("Calories") && toUnit.equals("Kilowatt-hours")) {
            factor = 0.00116222;
        } else if (fromUnit.equals("Kilowatt-hours") && toUnit.equals("Calories")) {
            factor = 860.42065;
        } else if (fromUnit.equals("Degree") && toUnit.equals("Radian")) {
            factor = Math.PI / 180; // 0.0174532925
        } else if (fromUnit.equals("Radian") && toUnit.equals("Degree")) {
            factor = 180 / Math.PI; // 57.2957795131
        }

        // Round the factor to two decimal places
        return factor;
    }


}
