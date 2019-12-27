package com.example.esoftwarica.AddStudent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.esoftwarica.HomeActivity;
import com.example.esoftwarica.Model.Students;
import com.example.esoftwarica.R;

import java.util.ArrayList;
import java.util.List;

//import Fragment;

public class AddStudentFragment extends Fragment {

    public static List<Students> studentsList = new ArrayList<>();
   //List<Students> studentsList;
    private EditText etStudentName, etStudentAge,etStudentAddress;
    private RadioGroup Gender;
    private RadioButton rbtnMale,rbtnFemale,rbtnOther;
    private Button Register;
    private int Image, age;
    private String name, address, gender;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_student,container,false);
        etStudentName=view.findViewById(R.id.studentName);
        etStudentAge=view.findViewById(R.id.studentAge);
        etStudentAddress = view.findViewById(R.id.studentAddress);
        Gender = view.findViewById(R.id.selectGender);
        rbtnMale = view.findViewById(R.id.rdoMale);
        rbtnFemale = view.findViewById(R.id.rdoFemale);
        rbtnOther = view.findViewById(R.id.rdoOthers);
        Register = view.findViewById(R.id.btnRegistration);

        final int[] image = {R.drawable.boy, R.drawable.girl, R.drawable.other};
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validation
                if(etStudentName.getText().toString().matches("")){
                    etStudentName.setError("Enter Student Name");
                    return;
                }

                if(etStudentAge.getText().toString().matches("")){
                    etStudentAge.setError("Enter Student Age");
                    return;
                }
                if(etStudentAddress.getText().toString().matches("")){
                    etStudentAddress.setError("Enter Student Address");
                    return;
                }

                name = etStudentName.getText().toString();
                address = etStudentAddress.getText().toString();
                age = Integer.parseInt(etStudentAge.getText().toString());


                try {
                    int selectGender = Gender.getCheckedRadioButtonId();
                    RadioButton radioButton = view.findViewById(selectGender);
                    gender = radioButton.getText().toString();
                    if (gender.equals("Male")) {
                        Image = image[0];
                    } else if (gender.equals("Female")) {
                        Image = image[1];
                    } else if (gender.equals("Others")) {
                        Image = image[2];
                    }
//                else if(gender.matches(""))
//                {
//                    Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_LONG).show();
//                }
                    Students students = new Students(name, address, gender, age, Image);
                    studentsList = HomeActivity.studentsList;
                    studentsList.add(students);
                    Toast.makeText(getActivity(),"Student registration successful",Toast.LENGTH_LONG).show();
                    etStudentName.getText().clear();
                    etStudentAddress.getText().clear();
                    etStudentAge.getText().clear();
                    Gender.clearCheck();

                }
                catch(Exception e) {
                    Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_LONG).show();
                }


            }
        });
        return view;
    }
}
