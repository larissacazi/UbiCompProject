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
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zimmermann.larissa.elderlylife.MainActivity;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.Structure.Address;
import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.Structure.OwnerUser;
import zimmermann.larissa.elderlylife.Structure.User;
import zimmermann.larissa.elderlylife.Structure.UserType;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.service.RetrofitService;
import zimmermann.larissa.elderlylife.service.ServiceGenerator;
import zimmermann.larissa.elderlylife.utils.Utils;


public class RegisterFragment extends Fragment {

    private static final String TAG = "RegisterFragment";


    private EditText firstNameText;
    private EditText lastNameText;
    private EditText emailText;
    private EditText occupationText;
    private EditText phoneText;
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
        occupationText = (EditText)view.findViewById(R.id.occupationID);
        phoneText = (EditText)view.findViewById(R.id.phoneID);
        emailText = (EditText)view.findViewById(R.id.emailID);
        passwordText = (EditText)view.findViewById(R.id.passwordID);
        confirmPasswordText = (EditText)view.findViewById(R.id.confirmPasswordTextID);
        usernameText = (EditText)view.findViewById(R.id.usernameID);

        Log.d(TAG, "onCreateView: started.");

        cardRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check all fields and send rest requisition
                if(Utils.isEditTextEmpty(firstNameText)) {
                    firstNameText.setError("First Name is required");
                }
                else if(Utils.isEditTextEmpty(lastNameText)) {
                    lastNameText.setError("Last Name is required");
                }
                else if(Utils.isEditTextEmpty(emailText)) {
                    emailText.setError("E-mail is required");
                }
                else if(Utils.isEditTextEmpty(occupationText)) {
                    occupationText.setError("Occupation is required");
                }
                else if(Utils.isEditTextEmpty(phoneText)) {
                    phoneText.setError("Phone Number is required");
                }
                else if(Utils.isEditTextEmpty(usernameText)) {
                    usernameText.setError("Username is required");
                }
                else if(Utils.isEditTextEmpty(passwordText)) { //Password
                    passwordText.setError("Password is required");
                }
                else if(Utils.isEditTextEmpty(confirmPasswordText)) {
                    confirmPasswordText.setError("Confirm your password");
                }
                else if(Utils.checkPassword(passwordText, confirmPasswordText) == false) {
                    passwordText.setError("Passwords don't match");
                    confirmPasswordText.setError("Passwords don't match");
                }
                else if(Utils.checkPassword(passwordText, confirmPasswordText) && passwordText.getText().toString().length() < 6){
                    passwordText.setError("Passwords must have at leat 6 characters");
                    confirmPasswordText.setError("Passwords must have at leat 6 characters");
                }
                else {
                    User user = new User(0, usernameText.getText().toString(),
                            passwordText.getText().toString(), firstNameText.getText().toString(),
                            lastNameText.getText().toString(), emailText.getText().toString(),
                            " ", " ", false);

                    AppDataSingleton.getInstace().setOwnerUser(new OwnerUser(0, user, occupationText.getText().toString(), Utils.OWNER_USER, phoneText.getText().toString()));

                    //Send this AppUser to server
                    uploadOwnerUser();

                    ((MainActivity)getActivity()).setViewPager(0); //Login Fragment
                }
            }
        });


        return view;
    }

    private void uploadOwnerUser() {
        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        Call<OwnerUser> call = service.createNewOwnerUser(AppDataSingleton.getInstace().getOwnerUser());

        call.enqueue(new Callback<OwnerUser>() {
            @Override
            public void onResponse(Call<OwnerUser> call, Response<OwnerUser> response) {

                boolean answer = response.isSuccessful();

                if (response.isSuccessful()) {
                    OwnerUser respostaServidor = response.body();
                    //verifica aqui se o corpo da resposta não é nulo
                    if (respostaServidor != null) {
                        //Get Token
                        Log.d(TAG, "Resposta servidor foi recebida!");

                    }else {

                        Toast.makeText(getContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getContext(), "Falha de comunicação", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OwnerUser> call, Throwable t) {
                Toast.makeText(getContext(), "Falha!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, t.getMessage());
            }
        });
    }

}
