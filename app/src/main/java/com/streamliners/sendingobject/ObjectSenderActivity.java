package com.streamliners.sendingobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.streamliners.sendingobject.databinding.ActivityObjectSenderBinding;
import com.streamliners.sendingobject.models.Student;


public class ObjectSenderActivity extends AppCompatActivity {
     ActivityObjectSenderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialising binding object
       binding = ActivityObjectSenderBinding.inflate(getLayoutInflater());

       setContentView(binding.getRoot());

       //set the title of activity
        setTitle("Enter Details");

        setupOnClickListenerForButton();
        setupActionListener();
        setupHideErrorForEditText();
    }


    /**
     * To setup on click listener for button
     */
    private void setupOnClickListenerForButton() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

    }

    /**
     * To setup the listener for the mobile text
     */
    private void setupActionListener() {
        binding.phoneNumberTextField.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND) {
                    sendData();
                }
                return false;
            }
        });
    }


    /**
     * To set up watchers to the text field and hide the errors when text changes
     */
    private void setupHideErrorForEditText() {
        // Text watcher for name text field
        binding.nameTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.nameTextField.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Text watcher for mobile number text field
        binding.phoneNumberTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.phoneNumberTextField.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Text watcher for roll number text field
        binding.rollNumberTextField.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.rollNumberTextField.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    /**
     * To get information about student using user input
     * @returnn {@link Student} class object
     */
    private Student getInfo() {
        // Name of the student
        String name = binding.nameTextField.getEditText().getText().toString().trim();
        if (name.isEmpty()) {
            binding.nameTextField.setError("Please enter name");
            return null;
        }

        // Gender of the student
        String gender;

        // Type of the item chosen in the radio button
        int type = binding.genderRadioGroup.getCheckedRadioButtonId();
        if (type == binding.femaleRadioButton.getId()) {
            gender = "Female";
        } else if (type == binding.maleRadioButton.getId()) {
            gender = "Male";
        } else {
            Toast.makeText(ObjectSenderActivity.this, "Please select gender!", Toast.LENGTH_SHORT).show();
            return null;
        }

        // Roll number of the student
        String rollNumber = binding.rollNumberTextField.getEditText().getText().toString().trim();
        if (rollNumber.isEmpty()) {
            binding.rollNumberTextField.setError("Please enter roll number");
            return null;
        } else if (!rollNumber.matches("^\\d{2}[a-zA-Z]*\\d{3}")) {
            binding.rollNumberTextField.setError("Please enter valid roll number");
            return null;
        }

        // 10-digit Mobile number of the student
        String mobileNumber = binding.phoneNumberTextField.getEditText().getText().toString().trim();
        if (mobileNumber.isEmpty()) {
            binding.phoneNumberTextField.setError("Please enter mobile number");
            return null;
        } else if (!mobileNumber.matches("^\\d{10}")) {
            binding.phoneNumberTextField.setError("Please enter valid mobile number");
            return null;
        }

        Student student = new Student(name, mobileNumber, rollNumber, gender);
        return student;
    }


    /**
     * to sent the data to another activity
     */
    public void sendData() {
        // Taking student object with entered information
        Student student = getInfo();

        // Checking student if null then returns
        if (student == null) {
            return;
        }

        Intent intent = new Intent(ObjectSenderActivity.this, ObjectViewerActivity.class);
        intent.putExtra(Constant.STUDENT_KEY, student);
        startActivity(intent);
    }
}
