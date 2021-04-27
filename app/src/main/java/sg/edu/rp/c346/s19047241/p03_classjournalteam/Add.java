package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    TextView txtWeek;
    Button btnSubmit;
    RadioGroup radioGradeGroup;
    RadioButton radioGradeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtWeek = findViewById(R.id.tvWeekAdd);
        btnSubmit = findViewById(R.id.btnSubmit);
        radioGradeGroup = findViewById(R.id.radioGroup);

        Intent i = getIntent();
        int newWeek = i.getIntExtra("week", 0);

        txtWeek.setText("Week " + newWeek);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGradeGroup.getCheckedRadioButtonId();
                radioGradeButton = findViewById(selectedId);
                String selectedGrade = (String) radioGradeButton.getText();

                //Toast.makeText(Add.this, selectedGrade, Toast.LENGTH_SHORT).show();


                // Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("grade", selectedGrade);

                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}