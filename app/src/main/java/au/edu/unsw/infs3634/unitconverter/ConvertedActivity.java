package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConvertedActivity extends AppCompatActivity {


    private TextView OV_TextView,OU_TextView,CV_TextView,CU_TextView, R_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted);

        OV_TextView = (TextView) findViewById(R.id.originalValue_TextView);
        OU_TextView = (TextView) findViewById(R.id.originalUnit_TextView);
        CU_TextView = (TextView) findViewById(R.id.convertedUnit_TextView);
        CV_TextView = (TextView) findViewById(R.id.convertedValue_TextView);
        R_TextView = (TextView) findViewById(R.id.textView8);


        Intent intent = getIntent();
        Bundle values = intent.getExtras();



        String convertedValue = values.getString("CONVERTED_VALUE");
        String originalValue = values.getString("INPUTTED_VALUE");
        String originalUnit = values.getString("CONVERTFROM_STRING");
        String convertedUnit = values.getString("CONVERTTO_STRING");

        //Testing Code to ensure values carried over//

        System.out.println(convertedUnit + " " + convertedValue + " " + originalValue + " " + originalUnit);



        OV_TextView.setText(String.valueOf(originalValue));
        OU_TextView.setText(String.valueOf(originalUnit));
        CU_TextView.setText(String.valueOf(convertedValue));
        CV_TextView.setText(String.valueOf(convertedUnit));
        R_TextView.setText(" " + originalValue + " " + originalUnit + "(s)" + " = "
                + convertedValue + " " + convertedUnit + "(s)");

        R_TextView.setVisibility(View.VISIBLE);




    }

    public void HelpAbout(View view) {
        Intent intent = new Intent(this, HelpAbout.class);
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}