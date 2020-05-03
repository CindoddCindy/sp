package com.ingenicomovement.testshredpref.frgmnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ingenicomovement.testshredpref.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrgamentDua extends Fragment {
    public static String KEY_ACTIVITY = "msg_activity";

   EditText name, pass, id;


    public FrgamentDua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_frgament_dua, container, false);
            name=view.findViewById(R.id.et_nama);
            pass=view.findViewById(R.id.et_pass);
            id=view.findViewById(R.id.et_id);

            getData();

        return view;
    }

    public void getData(){
        try {
            String message = getArguments().getString(KEY_ACTIVITY);

            if (message != null) {
                name.setText(message);
                //pass.setText(message);
               // id.setText(message);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
