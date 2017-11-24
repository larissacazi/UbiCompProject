package zimmermann.larissa.elderlylife;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";

    private CardView cardLoginButton;
    private TextView registerButton;
    private EditText passwordText;
    private EditText usernameText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_login, container, false);

        cardLoginButton = (CardView)view.findViewById(R.id.cardView);
        registerButton = (TextView)view.findViewById(R.id.registerButtonID);
        passwordText = (EditText)view.findViewById(R.id.passwordTextID);
        usernameText = (EditText)view.findViewById(R.id.usernameTextID);

        Log.d(TAG, "onCreateView: started.");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1); //Register Fragment
            }
        });

        cardLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO send the username and password
                //TODO open the other activity
                Intent intent = new Intent(getActivity(), AppActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
