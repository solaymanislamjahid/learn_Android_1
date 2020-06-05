package com.zahid.himurhatekokhektihandsanitizer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int count=0;
    private long backPressedTime;
    private Toast backToast;
    String[] contents;

    Button homebtn;
    TextView tvContent;
    TextView page;
    ImageView fme_fb;
    ImageView lme_fb;
    TextView copy_right;
    GifImageView backHome;



    Button prv;
    Button next;
    Button home;


    Button prv1;
    Button next1;
    Button home1;

    Button prv2;
    Button next2;
    Button home2;

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    LinearLayout layout6;

    LinearLayout lastNxt;
    LinearLayout rupa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onRestart();


        homebtn=findViewById(R.id.homebtn);
        tvContent=findViewById(R.id.tvContent);
        page=findViewById(R.id.page);
        lme_fb=findViewById(R.id.lme_fb);
        fme_fb=findViewById(R.id.fme_fb);
        copy_right=findViewById(R.id.copyRight);
        backHome=findViewById(R.id.back_home);


        prv=findViewById(R.id.prv);
        next=findViewById(R.id.next);
        home=findViewById(R.id.home);


        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);
        layout3=findViewById(R.id.layout3);
        layout4=findViewById(R.id.lay