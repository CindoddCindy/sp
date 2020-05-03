package com.ingenicomovement.testshredpref;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ingenicomovement.testshredpref.frgmnt.BlankFragment;
import com.ingenicomovement.testshredpref.frgmnt.FrgamentDua;

public class GetData extends AppCompatActivity {
    public EditText editText_name, editText_pass, editText_id;
    BottomNavigationView bottomNavigation;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        editText_name=findViewById(R.id.et_nama);
        editText_pass=findViewById(R.id.et_pass);
        editText_id=findViewById(R.id.et_id);

        getFrgament();


         bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new BlankFragment();
                        break;

                    case R.id.person:
                        fragment = new FrgamentDua();
                       // getFrgament();
                        break;

                    }
                return getFragmentPage(fragment);
            }
        });






    }



    public void getdata(){
        String nama = null;
        String pass = null;
        String id=null;

        String namas = null;
        String passes;
        String idd;


        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
           namas= String.valueOf(nama.contains(bundle.getString("data1")));
           passes= String.valueOf(pass.contains(bundle.getString("data2")));
           idd= String.valueOf(id.contains(bundle.getString("data_tiga")));
           }

        try {
            String message = namas;
            //String message2=passes;
            //String message3=idd;
            Bundle data = new Bundle();
            data.putString(FrgamentDua.KEY_ACTIVITY,message);
           // data.putString(FrgamentDua.KEY_ACTIVITY,message2);
           // data.putString(FrgamentDua.KEY_ACTIVITY,message3);
            FrgamentDua fragtry = new FrgamentDua();
            fragtry.setArguments(data);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragtry)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }



    public void getFrgament(){
        if(getFragmentPage(new FrgamentDua())){
            getdata();
        }

    }


    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
