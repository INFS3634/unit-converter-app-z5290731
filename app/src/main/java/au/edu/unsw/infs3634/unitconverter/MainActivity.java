package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> convertAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner SConvertFromSpinner = findViewById(R.id.convertFromSpinner);
        Spinner SConvertToSpinner = findViewById(R.id.convertToSpinner);

        EditText editText = findViewById(R.id.convertFromValue);
        Button button = findViewById(R.id.button);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.length_units, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //SConvertFromSpinner.setAdapter(adapter);
        //SConvertToSpinner.setAdapter(adapter);

        // CORE LENGTH //
        Spinner SMetricSpinner = findViewById(R.id.InitialMetricSpinner);
        TextView toEditErrorText = (TextView) findViewById(R.id.textView2);

        ArrayList<String> arrayList_metricSpinner,arrayList_LengthSpinner, arrayList_MassSpinner, arrayList_VolumeSpinner, arrayList_EmptySpinner;

        arrayList_LengthSpinner = new ArrayList<>();
        arrayList_MassSpinner = new ArrayList<>();
        arrayList_VolumeSpinner = new ArrayList<>();
        arrayList_EmptySpinner = new ArrayList<>();

        arrayList_EmptySpinner.add(" ");

        arrayList_LengthSpinner.add("Centimetre");
        arrayList_LengthSpinner.add("Foot");
        arrayList_LengthSpinner.add("Inch");
        arrayList_LengthSpinner.add("Kilometre");
        arrayList_LengthSpinner.add("Metre");
        arrayList_LengthSpinner.add("Mile");
        arrayList_LengthSpinner.add("Millimetre");
        arrayList_LengthSpinner.add("Yard");

        arrayList_MassSpinner.add("Gram");
        arrayList_MassSpinner.add("Kilogram");
        arrayList_MassSpinner.add("Ounce");
        arrayList_MassSpinner.add("Pound");
        arrayList_MassSpinner.add("Stone");
        arrayList_MassSpinner.add("Tonne");

        arrayList_VolumeSpinner.add("Litre");
        arrayList_VolumeSpinner.add("Millilitre");
        arrayList_VolumeSpinner.add("Gallon");
        arrayList_VolumeSpinner.add("Pint");



        arrayList_metricSpinner = new ArrayList<>();

        arrayList_metricSpinner.add("Select a Unit");
        arrayList_metricSpinner.add("Length");
        arrayList_metricSpinner.add("Mass");
        arrayList_metricSpinner.add("Volume");

        ArrayAdapter metricSpinnerAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_metricSpinner);

        SMetricSpinner.setAdapter(metricSpinnerAdapter);
        System.out.println("Hello  " + metricSpinnerAdapter);

        // CORE LENGTH //

        // CORE LENGTH //

        SConvertToSpinner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm=(InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                return false;
            }
        }) ;

        SConvertFromSpinner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm=(InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                return false;
            }
        }) ;

        /**
         * Spinner that helps select the ArrayList based on the values of the Upper Level Measurement Spinner.
         * If cases used with position to pass specific Adapter and to set buttons and different error handling values
         */

        SMetricSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {

                    convertAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_EmptySpinner);
                    //editText.setFocusable(false);
                    toEditErrorText.setVisibility(View.VISIBLE);
                    toEditErrorText.setText("Please select a Measurement! ");
                    button.setClickable(false);
                    //editText.setTextColor(Color.GREEN);

                }

                if(position==1) {

                    convertAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_LengthSpinner);
                    //editText.setFocusable(false);
                    toEditErrorText.setVisibility(View.INVISIBLE);
                    button.setClickable(true);


                }

                if(position==2) {

                    convertAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_MassSpinner);
                    //editText.setFocusable(true);
                    toEditErrorText.setVisibility(View.INVISIBLE);
                    button.setClickable(true);
                }

                if(position==3) {

                    convertAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_VolumeSpinner);
                    //editText.setFocusable(true);
                    toEditErrorText.setVisibility(View.INVISIBLE);
                    button.setClickable(true);
                }

                SConvertFromSpinner.setAdapter(convertAdapter);
                SConvertToSpinner.setAdapter(convertAdapter);


            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * System.out.println utilised at different stages for debugging and error handling from a backend side
         */


        System.out.println(SConvertFromSpinner);
        //System.out.println(adapter);






    }

    /** Passes
     * through for different buttons
     * @param view
     */



    public void HelpAbout(View view) {
        Intent intent = new Intent(this, HelpAbout.class);
        startActivity(intent);
    }

    /**
     * The OnClick method to help ensure that the switch button between spinners work
     * @param view
     */

    public void onClick(View view) {

        Spinner TconvertFromSpinner;
        Spinner TconvertToSpinner;
        EditText TconvertFromText;
        TextView toEditText;

        TconvertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        TconvertToSpinner = (Spinner) findViewById(R.id.convertToSpinner);
        TconvertFromText = (EditText) findViewById(R.id.convertFromValue);
        toEditText = (TextView) findViewById(R.id.textView2);

        String convertFromString = (String) TconvertFromSpinner.getSelectedItem();
        String convertToString = (String) TconvertToSpinner.getSelectedItem();
        //double input = Double.valueOf(TconvertFromText.getText().toString());

        int positionSpinner1 = TconvertFromSpinner.getSelectedItemPosition();
        int positionSpinner2 = TconvertToSpinner.getSelectedItemPosition();

        if (TconvertFromSpinner.getAdapter().equals(convertAdapter)) {
            TconvertFromSpinner.setAdapter(convertAdapter);
            TconvertToSpinner.setAdapter(convertAdapter);

        } else {

            TconvertFromSpinner.setAdapter(convertAdapter);
            TconvertToSpinner.setAdapter(convertAdapter);

        }
        TconvertFromSpinner.setSelection(positionSpinner2);
        TconvertToSpinner.setSelection(positionSpinner1);

            //arrayList_LengthSpinner, arrayList_MassSpinner, arrayList_VolumeSpinner





    }

    /**
     * Button method to help convert to String, Convert the values by passing through to the
     * Converter Class and then utilising Bundles to pass data through in a simplified manner
     * @param view
     */


    public void convert(View view) {


        Spinner TconvertFromSpinner;
        Spinner TconvertToSpinner;
        EditText TconvertFromText;
        TextView toEditText;

        TconvertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        TconvertToSpinner = (Spinner) findViewById(R.id.convertToSpinner);
        TconvertFromText = (EditText) findViewById(R.id.convertFromValue);
        toEditText = (TextView) findViewById(R.id.textView2);

        if (TconvertFromText.length()==0) {

            Toast.makeText(getApplicationContext(),
                    "Please Enter a Value and Try Again!",
                    Toast.LENGTH_LONG)
                    .show();

        } else {

            String convertFromString = (String) TconvertFromSpinner.getSelectedItem();
            String convertToString = (String) TconvertToSpinner.getSelectedItem();
            double input = Double.valueOf(TconvertFromText.getText().toString());


            Converter.Unit fromUnit = Converter.Unit.converterString(convertFromString);
            Converter.Unit toUnit = Converter.Unit.converterString(convertToString);


            Converter converter = new Converter(fromUnit, toUnit);
            double result = converter.convert(input);
            String resultConvert =(String.valueOf(result));
            String inputConvert = (String.valueOf(input));
            //System.out.println(result);
            //toEditText.setText(String.valueOf(result));

            System.out.println(input + resultConvert + convertToString + convertFromString);

            Intent intent = new Intent(this,ConvertedActivity.class);
            intent.putExtra("INPUTTED_VALUE", inputConvert);
            intent.putExtra("CONVERTED_VALUE", resultConvert);
            intent.putExtra("CONVERTTO_STRING", convertToString);
            intent.putExtra("CONVERTFROM_STRING", convertFromString);


            System.out.println(intent);
            startActivity(intent);


        }


    }



}