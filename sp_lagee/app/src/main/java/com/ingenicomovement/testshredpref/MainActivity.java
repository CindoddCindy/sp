package com.ingenicomovement.testshredpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ingenicomovement.testshredpref.pojo.UserLoginResponse;
import com.ingenicomovement.testshredpref.retro.RetroMetod;
import com.ingenicomovement.testshredpref.retro.RetroUrl;
import com.ingenicomovement.testshredpref.util.SignatureUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    public Button button_datah;
    private SignatureUtility signatureUtility;

    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        button_datah=findViewById(R.id.btn_data);

        signatureUtility  = new SignatureUtility();


        /*
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
*/
        button_datah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatah();
            }
        });
    }

/*
    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");

    }

    public void Get(View view) {
        name = (TextView) findViewById(R.id.etName);
        email = (TextView) findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

 */

    public void getDatah(){
        String nama =  name.getText().toString();
        String passwerd= email.getText().toString();
        String _datetime  = (String) DateFormat.format("yyyyMMddhhmmss", new java.util.Date());
        String _signature = signatureUtility.doSignature(_datetime, nama);

        RetroMetod retroMetod =  RetroUrl.getRetrofit().create(RetroMetod.class);
        Call<UserLoginResponse> call = retroMetod.loginUserTech(nama,passwerd,_datetime,_signature);
        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {



                if(response.body() != null) {
                    if (response.body().getSuccess().contains("false")) {
                        Toast.makeText(MainActivity.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();



                    } else {

                        Bundle bundle = new Bundle();
                        bundle.putString("data1", name.getText().toString());
                        bundle.putString("data2", email.getText().toString());
                        bundle.putString("data_tiga", response.body().getData().get(0).getId());
                        Intent intent = new Intent(MainActivity.this, GetData.class);
                        intent.putExtras(bundle);
                        startActivity(intent);


                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

               /* if (response.isSuccessful()){
                    Bundle bundle = new Bundle();
                    bundle.putString("data1", name.getText().toString());
                    bundle.putString("data2", email.getText().toString());
                    bundle.putString("data_tiga", response.body().getData().get(0).getId());
                    Intent intent = new Intent(MainActivity.this, GetData.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

                */
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {

            }
        });

    }

}
