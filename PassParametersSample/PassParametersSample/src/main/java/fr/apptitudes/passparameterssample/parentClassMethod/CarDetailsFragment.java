package fr.apptitudes.passparameterssample.parentClassMethod;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.apptitudes.passparameterssample.R;


public class CarDetailsFragment extends Fragment {

    private Car mCar;

    public CarDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_details, container, false);

        TextView brandTV = (TextView) view.findViewById(R.id.brand);
        TextView modelTV = (TextView) view.findViewById(R.id.model);
        TextView colorTV = (TextView) view.findViewById(R.id.color);

        mCar = ((MainActivity)getActivity()).getmCurrentCar();

        brandTV.setText(mCar.getBrand());
        modelTV.setText(mCar.getModel());
        colorTV.setText(mCar.getColor());

        return view;
    }
}
