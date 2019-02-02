package androiddevs.alertutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AlertDialogHelper.AlertDialogListener {

    AlertDialogHelper alertDialogHelper;
    @BindView(R.id.btnAlert4)
    Button btnAlert4;
    @BindView(R.id.btnAlert1)
    Button btnAlert1;
    @BindView(R.id.btnAlert2)
    Button btnAlert2;
    @BindView(R.id.btnAlert3)
    Button btnAlert3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        try {
            // instance of the helper class
            alertDialogHelper = new AlertDialogHelper(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPositiveClick(int from) {
        Toast.makeText(getApplicationContext(), "Positive Click from :" + from, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNegativeClick(int from) {
        Toast.makeText(getApplicationContext(), "Negative Click from :" + from, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNeutralClick(int from) {
        Toast.makeText(getApplicationContext(), "Neutral Click from :" + from, Toast.LENGTH_LONG).show();
    }

    @OnClick({R.id.btnAlert4, R.id.btnAlert1, R.id.btnAlert2, R.id.btnAlert3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAlert1:
                // 1 Action Button
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", 1, true);
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", 2);
                break;
            case R.id.btnAlert2:
                // 2 Action Buttons
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", "Cancel", 1, true);
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", "Cancel", 2, false);
                break;
            case R.id.btnAlert3:
                // 3 Action Buttons
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", "Later", "Cancel", 1, false);
                alertDialogHelper.showAlertDialog("Draft", "Discard draft ?", "Discard", "Later", "Cancel", 2);
                break;
            case R.id.btnAlert4:
                // Without Title (Empty String for Title)
                alertDialogHelper.showAlertDialog("", "Discard draft ?", "Discard", 1, true);
                // Without Message (Empty String for Message)
                alertDialogHelper.showAlertDialog("Draft", "", "Discard", "Cancel", 1, true);
                break;
        }
    }
}