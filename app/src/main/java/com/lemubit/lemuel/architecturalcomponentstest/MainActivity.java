package com.lemubit.lemuel.architecturalcomponentstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lemubit.lemuel.architecturalcomponentstest.db.Model;
import com.lemubit.lemuel.architecturalcomponentstest.viewModel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    EditText etxtName, etxtAge;
    Button btnAdd, btnCount, btnIncrement;
    TextView txtcount, txtIncrement;
    int incrementValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Created", Toast.LENGTH_LONG).show();

        etxtName = findViewById(R.id.etxt_name);
        etxtAge = findViewById(R.id.etxt_age);

        btnAdd = findViewById(R.id.btn_add);
        btnCount = findViewById(R.id.btn_count);
        btnIncrement = findViewById(R.id.btn_increment);

        txtcount = findViewById(R.id.txt_count);
        txtIncrement = findViewById(R.id.txt_increment);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.getCount().observe(this, integer -> {
            txtcount.setText(String.valueOf(integer));
        });

        btnAdd.setOnClickListener(v -> {
            String name = etxtName.getText().toString();
            int age = Integer.valueOf(etxtAge.getText().toString());

            Model model = new Model();
            model.name = name;
            model.age = age;

            userViewModel.insert(model);
            clearText();
        });

        btnIncrement.setOnClickListener(v ->
        {
            // incrementTextWithoutViewModel();
            incrementTextWithViewModel();
        });


        //Using View Model to prevent data clear on create
        //remove when using incrementTextWithoutViewModel()
        txtIncrement.setText(String.valueOf(userViewModel.plusOne));
    }

    public void clearText() {
        etxtName.setText("");
        etxtAge.setText("");
    }


    public void incrementTextWithoutViewModel() {
        incrementValue++;
        txtIncrement.setText(String.valueOf(incrementValue));
    }

    //Using View Model to prevent data clear on create
    public void incrementTextWithViewModel() {
        userViewModel.plusOne++;
        txtIncrement.setText(String.valueOf(userViewModel.plusOne));
    }
}
