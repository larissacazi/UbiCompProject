package zimmermann.larissa.elderlylife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import zimmermann.larissa.elderlylife.MainActivity;
import zimmermann.larissa.elderlylife.R;


public class RegisterFragment extends Fragment {

    private static final String TAG = "RegisterFragment";


    private EditText firstNameText;
    private EditText lastNameText;
    private EditText emailText;
    private EditText usernameText;
    private EditText passwordText;
    private EditText confirmPasswordText;
    private CardView cardRegisterButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_register, container, false);

        cardRegisterButton = (CardView)view.findViewById(R.id.registerID);
        firstNameText = (EditText)view.findViewById(R.id.firstNameID);
        lastNameText = (EditText)view.findViewById(R.id.lastNameID);
        emailText = (EditText)view.findViewById(R.id.lastNameID);
        passwordText = (EditText)view.findViewById(R.id.passwordID);
        confirmPasswordText = (EditText)view.findViewById(R.id.confirmPasswordTextID);
        usernameText = (EditText)view.findViewById(R.id.usernameID);

        Log.d(TAG, "onCreateView: started.");

        cardRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check all fields and send rest requisition
                if(isEditTextEmpty(firstNameText)) {
                    firstNameText.setError("First Name is required");
                }
                else if(isEditTextEmpty(lastNameText)) {
                    lastNameText.setError("Last Name is required");
                }
                else if(isEditTextEmpty(emailText)) {
                    emailText.setError("E-mail is required");
                }
                else if(isEditTextEmpty(usernameText)) {
                    usernameText.setError("Username is required");
                }
                else if(isEditTextEmpty(passwordText)) { //Password
                    passwordText.setError("Password is required");
                }
                else if(isEditTextEmpty(confirmPasswordText)) {
                    confirmPasswordText.setError("Confirm your password");
                }
                else if(checkPassword() == false) {
                    passwordText.setError("Passwords don't match");
                    confirmPasswordText.setError("Passwords don't match");
                }
                else if(checkPassword() && passwordText.getText().toString().length() < 6){
                    passwordText.setError("Passwords must have at leat 6 characters");
                    confirmPasswordText.setError("Passwords must have at leat 6 characters");
                }
                else {
                    ((MainActivity)getActivity()).setViewPager(0); //Login Fragment
                }
            }
        });


        return view;
    }

    private boolean isEditTextEmpty(EditText editText) {
        String text = editText.getText().toString();
        if(TextUtils.isEmpty(text)) return true;
        return false;
    }

    private boolean checkPassword() {
        String pwd = passwordText.getText().toString();
        String confirmPwd = confirmPasswordText.getText().toString();

        if(pwd.matches(confirmPwd)) return true;

        return false;
    }
}
