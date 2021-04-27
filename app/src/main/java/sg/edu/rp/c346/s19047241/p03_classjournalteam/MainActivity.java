package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Module> moduleArrayList =  new ArrayList<>();
    private ArrayAdapter<Module> moduleArrayAdapter;

    // Views
    ListView moduleLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        initViews();

        // Add Modules
        Module webServicesModule = new Module("C302", "Web Services");
        Module androidModule = new Module("C347", "Android Programming ll");
        moduleArrayList.add(webServicesModule);
        moduleArrayList.add(androidModule);

        // Add Daily CAs for each module
        // -> Web Services
        ArrayList<DailyCA> dailyCAS_C302 = new ArrayList<>();
        dailyCAS_C302.add(new DailyCA("B", webServicesModule.getModuleName(),1));
        dailyCAS_C302.add(new DailyCA("C", webServicesModule.getModuleName(),2));
        dailyCAS_C302.add(new DailyCA("A", webServicesModule.getModuleName(),3));
        webServicesModule.setAlDailyCA(dailyCAS_C302);

        // -> Android Programming 2
        ArrayList<DailyCA> dailyCAS_C347 = new ArrayList<>();
        dailyCAS_C347.add(new DailyCA("B", androidModule.getModuleName(),1));
        dailyCAS_C347.add(new DailyCA("C", androidModule.getModuleName(),2));
        dailyCAS_C347.add(new DailyCA("A", androidModule.getModuleName(),3));
        androidModule.setAlDailyCA(dailyCAS_C347);

        // Initialize Adapter
        moduleArrayAdapter = new ModuleArrayAdapter(this, R.layout.module_list_item, moduleArrayList);

        // Bridging
        moduleLV.setAdapter(moduleArrayAdapter);
    }

    private void initViews() {
        moduleLV = findViewById(R.id.modules_list_view);
        moduleLV.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Module mod = moduleArrayList.get(position);
        Log.e(TAG, "Selected Module: " + mod.getModuleName());
        Log.e(TAG, "Selected Module: " + mod.getClass().getSimpleName());

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("module", mod);
        startActivity(intent);
    }
}