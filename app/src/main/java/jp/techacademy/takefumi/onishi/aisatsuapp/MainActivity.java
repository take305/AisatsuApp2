package jp.techacademy.takefumi.onishi.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int mDay;
    int mMinute;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            showTimePickerDialog();


        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        mDay = hourOfDay;
                        mMinute = minute;
                        if (mDay >= 18||1>=mDay) {
                            textView.setText("こんばんは");
                        }else if (mDay>=2&&9>=mDay){
                            textView.setText("おはよう");

                        }else if (mDay>=10&&17>=mDay){
                            textView.setText("こんにちは");
                        }
                    }
                },
                13,
                0,
                true);

        timePickerDialog.show();

    }


}
