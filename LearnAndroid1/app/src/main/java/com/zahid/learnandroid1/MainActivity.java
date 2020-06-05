package com.zahid.learnandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etDisplay;
    AutoCompleteTextView autoTvDisplay;
    Spinner spinner;
    CheckBox checkBox;
    RadioGroup radioGroup;

    Button login;

    String[] country_name_array;
    String[] year;
    String gender;
    String birth_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay=findViewById(R.id.editText);
        autoTvDisplay=findViewById(R.id.autoComContry);
        spinner=findViewById(R.id.spinner);
        checkBox=findViewById(R.id.checkbox);
        radioGroup=findViewById(R.id.radio_group);

        login=findViewById(R.id.login_btn);




        country_name_array=getResources().getStringArray(R.array.country_name);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,country_name_array);
        autoTvDisplay.setThreshold(1);
        autoTvDisplay.setAdapter(adapter);



        year=getResources().getStringArray(R.array.year);
        ArrayAdapter Year_adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,year);
        spinner.setAdapter(Year_adapter);






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name=etDisplay.getText().toString();
                final String country=autoTvDisplay.getText().toString();

               int redio_btn_id=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton=findViewById(redio_btn_id);
               try {
                   gender=radioButton.getText().toString();
               }catch (Exception e){

               }

               birth_year=spinner.getSelectedItem().toString();




                if (name.matches("")){
                    Toast.makeText(MainActivity.this,"You did not enter a user name",Toast.LENGTH_SHORT).show();
                }else if (country.matches("")){
                    Toast.makeText(MainActivity.this,"You did not enter your country name",Toast.LENGTH_SHORT).show();

                }else if (!checkBox.isChecked()){
                    Toast.makeText(MainActivity.this,"You did not enter without agree out conditions",Toast.LENGTH_SHORT).show();

                }else if (gender==null){
                    Toast.makeText(MainActivity.this,"You did not enter select your gander",Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("country",country);
                    intent.putExtra("gender",gender);
                    intent.putExtra("birth_year",birth_year);
                    startActivity(intent);
                }
            }
        });
    }
}
