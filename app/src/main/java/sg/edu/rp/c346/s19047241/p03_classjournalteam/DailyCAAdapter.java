package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class DailyCAAdapter extends ArrayAdapter<DailyCA> {

    private Context context;
    private TextView grade, week;
    private ArrayList<DailyCA> alDailyCa;
    private ImageView imageView;

    public DailyCAAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);

        alDailyCa = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dailyca_list_item, parent, false);

        DailyCA currentgrade = alDailyCa.get(position);

        grade = rowView.findViewById(R.id.tvGrade);
        week = rowView.findViewById(R.id.textViewWeek);
        imageView = rowView.findViewById(R.id.moduleImageView);

        if (currentgrade.getDgGrade().equals("X")) {
            grade.setTextColor(ContextCompat.getColor(context, R.color.red_600));
        } else {
            grade.setTextColor(ContextCompat.getColor(context, R.color.black_85));
        }

        grade.setText(currentgrade.getDgGrade());
        week.setText("Week " + currentgrade.getWeek());
        imageView.setImageResource(R.drawable.dg);

        return rowView;
    }
}
