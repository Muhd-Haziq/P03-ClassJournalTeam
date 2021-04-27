package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvWeek;

    ArrayList<DailyCA> dailyArray = new ArrayList<>();
    DailyCAAdapter dailyCAAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lvInfo);
        tvWeek = findViewById(R.id.textViewWeek);

        dailyCAAdapter = new DailyCAAdapter(this, R.layout.row, dailyArray);
        lv.setAdapter(dailyCAAdapter);

        Intent i = getIntent();
        Module module = (Module) i.getSerializableExtra("module");

        dailyArray.clear();
//        if(module.equals("C347")){
//            dailyArray.add(new DailyCA("A", "C347", 1));
//            dailyArray.add(new DailyCA("B", "C347", 2));
//            dailyArray.add(new DailyCA("C", "C347", 3));
//        }
//        else if (module.equals("C302")){
//            dailyArray.add(new DailyCA("A", "C302", 1));
//            dailyArray.add(new DailyCA("B", "C302", 2));
//            dailyArray.add(new DailyCA("C", "C302", 3));
//        }
        for (DailyCA dailyCA: module.getAlDailyCA()) {
            dailyArray.add(dailyCA);
        }
        dailyCAAdapter.notifyDataSetChanged();


    }
}