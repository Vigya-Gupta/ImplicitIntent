package vigya.digipodium.implicitintent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class FifthFragment extends Fragment implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {


    private TextView timeShow;
    private TextView dateShow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timeShow = view.findViewById(R.id.timeShow);
        dateShow = view.findViewById(R.id.dateShow);
        ImageView timeSelect = view.findViewById(R.id.timeSelect);
        ImageView dateSelect = view.findViewById(R.id.dateSelect);
        timeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                new TimePickerDialog(getActivity(), FifthFragment.this, hour, min, false).show();
            }

        });

        dateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(getActivity(),FifthFragment.this,year,month,day).show();
            }
        });
    }
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeShow.setText(hourOfDay+" : "+minute);
                createAlarm("Sample",hourOfDay,minute);
            }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateShow.setText(dayOfMonth+" / "+month+" / "+year);
        //addEvent("Sample Event",true,dayOfMonth);

    }
    public void addEvent(String title,boolean all_day,long begin) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,all_day)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}