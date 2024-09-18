package com.example.hello_w;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;


public class MainActivity extends AppCompatActivity implements Sn_input_dialog.sn_input_dialog_if{
    private static final String TAG = "vuong_lk_main";

    ImageButton imgBtnSn, imgBtnQr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Start application");

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgBtnSn = findViewById(R.id.img_btn_sn);
        imgBtnQr = findViewById(R.id.img_btn_qr);

    }

    public void onInputSn(View view){
        Log.d(TAG, "Open input SN dialog callback");

        Sn_input_dialog sn_input_dialog = new Sn_input_dialog();
        sn_input_dialog.show(getSupportFragmentManager(), "Enter light id");

    }

    public void onInputQr(View view) {
        Log.d(TAG, "Open input QR dialog callback");

    }


    @Override
    public void user_typed_light_sn(String sn) {
        Log.d(TAG, "Now connect to light sn " + sn);

    }
}