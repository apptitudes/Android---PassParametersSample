package fr.apptitudes.passparameterssample.parcelableMethod;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.apptitudes.passparameterssample.R;

public class MainActivity extends Activity {

    private Context mContext;
    private Car mCar1;
    private Car mCar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mContext = this;
        mCar1 = new Car("Peugeot", "3008", "black");
        mCar2 = new Car("Citroën", "DS4", "white");

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setText(mCar1.getBrand());
        button2.setText(mCar2.getBrand());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Clicked();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2Clicked();
            }
        });
    }

    private void button1Clicked(){
        CarDetailsFragment carDetailsFragment = new CarDetailsFragment();
        Bundle carBundle = new Bundle();
        carBundle.putParcelable("Car", mCar1);
        carDetailsFragment.setArguments(carBundle);

        ((Activity)mContext).getFragmentManager().beginTransaction()
                .replace(R.id.container, carDetailsFragment)
                .commit();
    }

    private void button2Clicked(){
        CarDetailsFragment carDetailsFragment = new CarDetailsFragment();
        Bundle carBundle = new Bundle();
        carBundle.putParcelable("Car", mCar2);
        carDetailsFragment.setArguments(carBundle);

        ((Activity)mContext).getFragmentManager().beginTransaction()
                .replace(R.id.container, carDetailsFragment)
                .commit();
    }
}
