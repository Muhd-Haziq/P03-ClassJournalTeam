package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ModuleArrayAdapter extends ArrayAdapter<Module> {

    private Context context;
    private ArrayList<Module> moduleArrayList;

    public ModuleArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Module> modules) {
        super(context, resource, modules);
        this.context = context;
        this.moduleArrayList = modules;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.module_list_item, parent, false);

        // Get Current Module
        Module module = moduleArrayList.get(position);

        // Init Views
        TextView moduleNameTV, moduleCodeTV;
        moduleNameTV = view.findViewById(R.id.module_name_text_view);
        moduleCodeTV = view.findViewById(R.id.module_code_text_view);

        // Set Data
        moduleNameTV.setText(module.getModuleName());
        moduleCodeTV.setText(module.getModuleCode());

        return view;

    }
}
