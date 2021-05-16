package com.streamliners.sendingobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.streamliners.sendingobject.databinding.ActivityObjectViewerBinding;
import com.streamliners.sendingobject.models.Student;


public class ObjectViewerActivity extends AppCompatActivity {

    ActivityObjectViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding  = ActivityObjectViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the title of the activity
        setTitle(" View Details");

        // Getting data through the intents
        getData();
    }

    /**
     * To get the data which is coming from another activity
     */
    private void getData() {
        // Validate student object which is coming through the intent
        Student student =(Student) getIntent().getSerializableExtra(Constant.STUDENT_KEY);

        // Checking that the student is not null
        if (student == null){
            Toast.makeText(this, "No data received!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Showing data in the text fields
        binding.showNameTextField.getEditText().setText(student.getName());
        binding.showGenderTextField.getEditText().setText(student.getGender());
        binding.showRollNumberTextField.getEditText().setText(student.getRollNumber());
        binding.showMobileNumberTextField.getEditText().setText(student.getMobileNumber());
    }
}