package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner SConvertFromSpinner = findViewById(R.id.convertFromSpinner);
        Spinner SConvertToSpinner = findViewById(R.id.convertToSpinner);

        System.out.println(SConvertFromSpinner);
        System.out.println(adapter);

        SConvertFromSpinner.setAdapter(adapter);
        System.out.println(SConvertFromSpinner);
        SConvertToSpinner.setAdapter(adapter);




    }

    public void convert(View view) {
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
        double input = Double.valueOf(TconvertFromText.getText().toString());

        Converter.Unit fromUnit = Converter.Unit.converterString(convertFromString);
        Converter.Unit toUnit = Converter.Unit.converterString(convertToString);

        /**CHANGE NAMES**/

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