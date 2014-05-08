package fr.apptitudes.passparameterssample.parentClassMethod;

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
    private Car mCurrentCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            String brand = savedInstanceState.getString("bundle");
            String model = savedInstanceState.getString("model");
            String color = savedInstanceState.getString("color");

            mCurrentCar = new Car(brand,model,color);
        }

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
        mCurrentCar = mCar1;
        CarDetailsFragment carDetailsFragment = new CarDetailsFragment();
        ((Activity)mContext).getFragmentManager().beginTransaction()
                .replace(R.id.container, carDetailsFragment)
                .commit();
    }

    private void button2Clicked(){
        mCurrentCar = mCar2;
        CarDetailsFragment carDetailsFragment = new CarDetailsFragment();
        ((Activity)mContext).getFragmentManager().beginTransaction()
                .replace(R.id.container, carDetailsFragment)
                .commit();
    }

    public Car getmCurrentCar(){
        return mCurrentCar;
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("brand", mCurrentCar.getBrand());
        outState.putString("model", mCurrentCar.getModel());
        outState.putString("color", mCurrentCar.getColor());
    }

}
