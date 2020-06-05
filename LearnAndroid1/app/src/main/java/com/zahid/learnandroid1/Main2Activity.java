package com.zahid.learnandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.graphics.Color.rgb;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Database task=new Database();

    int numOfTask;

    LinearLayout main_layout;
    LinearLayout sub_mainLayout;
    LinearLayout no_task;
    LinearLayout task_View;

    TextView tvdisplay_name;
    TextView tvdisplay_country;
    TextView tvdisplay_gender;
    TextView tvdisplay_age;
    TextView tvdisplay_day;
    TextView tvdisplay_date;

    ImageView Ivdisplay_gender;
    ImageView Ivdisplay_age;
    ImageView Ivdisplay_country;

    Button add_task;

    ToggleButton toggleButton;
    DigitalClock digitalClock;

//layout.xml veriable..

    Button set_date;
    Button set_time;
    Button set_task;

    EditText task_name;
    TimePicker set_timePicker;
    DatePicker set_datePicker;
    ImageView demo_img;
    LinearLayout task_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


//layout.xml veriable findView..
        set_date=findViewById(R.id.set_date);
        set_time=findViewById(R.id.set_time);
        set_task=findViewById(R.id.set_task);

        task_name=findViewById(R.id.task_name);
        set_timePicker=findViewById(R.id.set_timePicker);
        set_datePicker=findViewById(R.id.set_datePicker);
        demo_img=findViewById(R.id.task_demo_image);
        task_layout=findViewById(R.id.add_task_layout);




//get data from 1st activity..

        Bundle bundle=getIntent().getExtras();

        String name=bundle.getString("name");
        String country=bundle.getString("country");
        final String gender=bundle.getString("gender");
        int birth_year=Integer.parseInt(bundle.getString("birth_year"));

        main_layout=findViewById(R.id.main_layout);
        no_task=findViewById(R.id.no_task);
        task_View=findViewById(R.id.task_view);

        sub_mainLayout=findViewById(R.id.sub_mainLayout);
        digitalClock=findViewById(R.id.digital_clock);
        Ivdisplay_country=findViewById(R.id.img_country);
        add_task=findViewById(R.id.add_task);

//set onclick listiner..

        add_task.setOnClickListener(this);
        set_date.setOnClickListener(this);
        set_time.setOnClickListener(this);
        set_task.setOnClickListener(this);


//set name in textview..

        tvdisplay_name=findViewById(R.id.tv_name);
        tvdisplay_name.setText(name);

//set country name in textview..

        tvdisplay_country=findViewById(R.id.txt_country);
        tvdisplay_country.setText(country);


//set gender and avater in textview and ImageView..

        tvdisplay_gender=findViewById(R.id.txt_gender);
        Ivdisplay_gender=findViewById(R.id.img_gender);
        Ivdisplay_age=findViewById(R.id.img_age);

        tvdisplay_gender.setText(gender);
        if (gender.equals("Female")){
            Ivdisplay_gender.setImageResource(R.drawable.female);
            Ivdisplay_age.setImageResource(R.drawable.woman_dark_age);
        }


//set date and day in textview..

        tvdisplay_day=findViewById(R.id.day);
        tvdisplay_date=findViewById(R.id.date);

        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy");
        int current_date= Integer.parseInt(dateFormat.format(date));

        DateFormat cuDate=new SimpleDateFormat("dd-mm-yyyy");
        String cureentDate=cuDate.format(date);
        tvdisplay_date.setText(cureentDate);

        DateFormat sub_today=new SimpleDateFormat("EEEE");
        String today=sub_today.format(date);
        tvdisplay_day.setText(today);


//culculate age and show age...

        String age=current_date-birth_year+" years";
        tvdisplay_age=findViewById(R.id.txt_age);
        tvdisplay_age.setText(age);




//code for change theme dark and white using toggle button...


        toggleButton=findViewById(R.id.toggle_btn);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    main_layout.setBackgroundColor(rgb(0, 0, 0));

                    tvdisplay_country.setTextColor(rgb(255, 255, 255));
                    tvdisplay_age.setTextColor(rgb(255, 255, 255));
                    tvdisplay_gender.setTextColor(rgb(255, 255, 255));
                    digitalClock.setTextColor(rgb(255, 255, 255));
                    tvdisplay_date.setTextColor(rgb(255, 255, 255));

                    task_name.setTextColor(rgb(255, 255, 255));
                    task_name.setHintTextColor(rgb(255, 255, 255));


                    Ivdisplay_country.setImageResource(R.drawable.earth_light);



                }else {
                    main_layout.setBackgroundColor(rgb(255, 255, 255));

                    tvdisplay_country.setTextColor(rgb(0, 0, 0));
                    tvdisplay_age.setTextColor(rgb(0, 0, 0));
                    tvdisplay_gender.setTextColor(rgb(0, 0, 0));
                    digitalClock.setTextColor(rgb(0, 0, 0));
                    tvdisplay_date.setTextColor(rgb(0, 0, 0));

                    task_name.setTextColor(rgb(0, 0, 0));
                    task_name.setHintTextColor(rgb(0, 0, 0));


                    Ivdisplay_country.setImageResource(R.drawable.earth_dark);
                }
            }
        });



//check arrayList ie ematy and set view....

//arraylist er te just task name check kore view set kora hobe..

             numOfTask=task.taskName.size();

            if (numOfTask<=0){
                no_task.setVisibility(View.VISIBLE);
                task_View.setVisibility(View.GONE);
            }else {
                task_View.setVisibility(View.VISIBLE);
                no_task.setVisibility(View.GONE);
            }
}



    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.set_date){
            set_datePicker.setVisibility(View.VISIBLE);
            demo_img.setVisibility(View.GONE);
            set_timePicker.setVisibility(View.GONE);

        } else if (v.getId()==R.id.set_time){
            set_timePicker.setVisibility(View.VISIBLE);
            demo_img.setVisibility(View.GONE);
            set_datePicker.setVisibility(View.GONE);


        }else if (v.getId()==R.id.add_task){

            sub_mainLayout.setVisibility(View.GONE);
            task_layout.setVisibility(View.VISIBLE);

//set data in database....

        }else if (v.getId()==R.id.set_task){

            String new_task=task_name.getText().toString();
            if (!new_task.isEmpty()){
                task.taskName.add(new_task);
            }



            if (set_datePicker.isSelected()){
                task.day.add(set_datePicker.getDayOfMonth());
                task.month.add(set_datePicker.getMonth());
                task.year.add(set_datePicker.getYear());
            }

           if (set_timePicker.isSelected()){
               task.minute.add(set_timePicker.getMinute());
               task.hours.add(set_timePicker.getHour());

           }

            task_layout.setVisibility(View.GONE);
            sub_mainLayout.setVisibility(View.VISIBLE);
            Toast.makeText(this,numOfTask+" ",Toast.LENGTH_SHORT).show();
        }

    }
}
