package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private int requestCodeForAdd = 1;

    private ArrayList<DailyCA> dailyArray = new ArrayList<>();
    private DailyCAAdapter dailyCAAdapter;

    // Views
    private MaterialButton btnInfo, btnEmail;
    private ListView lv;
    private TextView tvWeek, titleTV;
    private ExtendedFloatingActionButton fabAdd;

    private Module module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lvInfo);
        tvWeek = findViewById(R.id.textViewWeek);
        titleTV = findViewById(R.id.title_text_view);

        btnInfo = findViewById(R.id.button);
//        btnAdd = findViewById(R.id.button2);
        btnEmail = findViewById(R.id.button3);
        fabAdd = findViewById(R.id.add_ca_fab);

        dailyCAAdapter = new DailyCAAdapter(this, R.layout.dailyca_list_item, dailyArray);
        lv.setAdapter(dailyCAAdapter);

        // Get Selected Module
        Intent i = getIntent();
        module = (Module) i.getSerializableExtra("module");

        dailyArray.clear();
        for (DailyCA dailyCA: module.getAlDailyCA()) {
            dailyArray.add(dailyCA);
        }
        dailyCAAdapter.notifyDataSetChanged();

        // Set title of activity
//        setTitle("Info for " + module.getModuleCode());
        titleTV.setText(module.getModuleCode());

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Add.class);
                i.putExtra("week", dailyArray.size() + 1);
                startActivityForResult(i, requestCodeForAdd);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent infoIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                infoIntent.setData(Uri.parse(module.getInfoUrl()));
                startActivity(infoIntent);
            }
        });

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(SecondActivity.this, Add.class);
//                i.putExtra("week", dailyArray.size() + 1);
//                startActivityForResult(i, requestCodeForAdd);
//            }
//        });


        //String finalMessage = message;
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text

                String emailGrades = "";
                for(int i = 0; i < dailyArray.size(); i++){
                    emailGrades += "Week " + dailyArray.get(i).getWeek() + ": " + "  DG: " + dailyArray.get(i).getDgGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{module.getInCharge()});

                email.putExtra(Intent.EXTRA_TEXT, "Hi faci,\n\n" +
                        "I am ...\n" +
                        "Please see my remarks so far, thank you!\n\n" +
                        emailGrades);

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

    } // <-- end of onCreate method -->

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("DailyGrade", "Test");

        // Only handle when 2nd activity closed normally
        // and data contains something

        if(resultCode == RESULT_OK){
            if(data != null){
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");

                dailyArray.add(new DailyCA(grade, module.getModuleCode(), dailyArray.size()+1));
                dailyCAAdapter.notifyDataSetChanged();

                //Toast.makeText(SecondActivity.this, "" + dailyArray.size(), Toast.LENGTH_LONG).show();
            }
        }
    }
}