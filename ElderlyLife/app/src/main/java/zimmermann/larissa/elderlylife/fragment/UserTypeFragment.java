package zimmermann.larissa.elderlylife.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zimmermann.larissa.elderlylife.MainActivity;
import zimmermann.larissa.elderlylife.R;

public class UserTypeFragment extends Fragment {

    private static final String TAG = "UserTypeFragment";

    private CardView cardUserButton;
    private CardView cardOwnerButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_user_type, container, false);

        cardUserButton = (CardView)view.findViewById(R.id.cardViewUserID);
        cardOwnerButton = (CardView)view.findViewById(R.id.cardViewOwnerID);

        cardUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO call the User Register fragment
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });

        cardOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO call the Register fragment
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });

        return view;
    }
}
