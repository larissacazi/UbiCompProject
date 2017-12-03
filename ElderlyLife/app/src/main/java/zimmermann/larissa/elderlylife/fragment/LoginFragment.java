package zimmermann.larissa.elderlylife.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.Structure.OwnerUser;
import zimmermann.larissa.elderlylife.UserAppActivity;
import zimmermann.larissa.elderlylife.MainActivity;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.service.RetrofitService;
import zimmermann.larissa.elderlylife.service.ServiceGenerator;
import zimmermann.larissa.elderlylife.utils.Utils;


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
                login();
            }
        });


        return view;
    }

    private void login() {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        Call<JsonObject> call = service.login(username, password);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (response.isSuccessful()) {
                    JsonObject respostaServidor = response.body();
                    //verifica aqui se o corpo da resposta não é nulo
                    if (respostaServidor != null) {
                        //Get Token
                        String token = "Token " + respostaServidor.get("token").toString().replaceAll("[\"]", "");
                        AppDataSingleton.getInstace().setToken(token);

                        //Get User Type
                        String mJsonString = respostaServidor.toString();
                        JsonObject user = respostaServidor.getAsJsonObject("user");
                        int userType = user.get("userType").getAsInt();
                        Gson gson = new Gson();
                        AppDataSingleton.getInstace().setUserType(userType);

                        //Set User Object
                        if(AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
                            String userApp = respostaServidor.getAsJsonObject("user").toString();
                            AppUser appUser = gson.fromJson(userApp , AppUser.class);
                            AppDataSingleton.getInstace().setAppUser(appUser);
                            Log.d(TAG, appUser.getId() + " " + appUser.getUser().getFirst_name() + " " + appUser.getResidentialAddress().getStreet());

                        } else if(AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
                            String userOwner = respostaServidor.getAsJsonObject("user").toString();
                            OwnerUser ownerUser = gson.fromJson(userOwner , OwnerUser.class);
                            AppDataSingleton.getInstace().setOwnerUser(ownerUser);
                            Log.d(TAG, ownerUser.getId() + " " + ownerUser.getUser().getFirst_name() + " " + ownerUser.getOccupation());
                        }

                        //Start new Activity
                        Intent intent = new Intent(getActivity(), UserAppActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }else {

                        Toast.makeText(getContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getContext(), "Falha de comunicação", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}
