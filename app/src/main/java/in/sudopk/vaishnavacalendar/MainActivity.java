package in.sudopk.vaishnavacalendar;

import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.sudopk.coreandroid.Fm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        if (savedInstanceState == null) {
            Fm.replace(getSupportFragmentManager(), R.id.container, new CalendarFragment());
        }
    }
}
