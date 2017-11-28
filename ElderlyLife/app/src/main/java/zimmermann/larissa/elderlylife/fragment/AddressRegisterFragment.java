package zimmermann.larissa.elderlylife.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import zimmermann.larissa.elderlylife.MainActivity;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.utils.Utils;


public class AddressRegisterFragment extends Fragment {

    private static final String TAG = "AddressRegisterFragment";

    private EditText streetText;
    private EditText numberText;
    private EditText neighborText;
    private EditText stateText;
    private EditText countryText;
    private EditText zipcodeText;
    private CardView cardRegisterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_address_register, container, false);

        cardRegisterButton = (CardView)view.findViewById(R.id.addressRegisterButtonID);
        streetText = (EditText)view.findViewById(R.id.streetTextID);
        numberText = (EditText)view.findViewById(R.id.numberTextID);
        neighborText = (EditText)view.findViewById(R.id.neighborTextID);
        stateText = (EditText)view.findViewById(R.id.stateTextID);
        countryText = (EditText)view.findViewById(R.id.countryTextID);
        zipcodeText = (EditText)view.findViewById(R.id.zipcodeTextID);

        Log.d(TAG, "onCreateView: started.");

        cardRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Utils.isEditTextEmpty(streetText)) {
                    streetText.setError("Street Name is required");
                }
                else if(Utils.isEditTextEmpty(numberText)) {
                    numberText.setError("Street Number is required");
                }
                else if(Utils.isEditTextEmpty(neighborText)) {
                    neighborText.setError("Neighbor Name is required");
                }
                else if(Utils.isEditTextEmpty(stateText)) {
                    stateText.setError("State Name is required");
                }
                else if(Utils.isEditTextEmpty(countryText)) {
                    countryText.setError("Country Name is required");
                }
                else if(Utils.isEditTextEmpty(zipcodeText)) {
                    zipcodeText.setError("Zipcode Number is required");
                }
                else {
                    ((MainActivity)getActivity()).setViewPager(0); //Login Fragment
                }
            }
        });

        return view;
    }

}
