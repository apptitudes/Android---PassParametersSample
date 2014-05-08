package fr.apptitudes.passparameterssample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class LauncherActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.button1 :
                intent = new Intent(this, fr.apptitudes.passparameterssample.constructorMethod.MainActivity.class);
            break;
            case R.id.button2 :
                intent = new Intent(this, fr.apptitudes.passparameterssample.bundleMethod.MainActivity.class);
            break;
            case R.id.button3 :
                intent = new Intent(this, fr.apptitudes.passparameterssample.parentClassMethod.MainActivity.class);
            break;
            case R.id.button4 :
                intent = new Intent(this, fr.apptitudes.passparameterssample.factoryMethod.MainActivity.class);
            break;
            case R.id.button5 :
                intent = new Intent(this, fr.apptitudes.passparameterssample.parcelableMethod.MainActivity.class);
            break;
            default:
                intent = new Intent(this, fr.apptitudes.passparameterssample.constructorMethod.MainActivity.class);
            break;
        }
        startActivity(intent);
    }
}
