package zimmermann.larissa.elderlylife.fragment;

import android.content.Intent;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import zimmermann.larissa.elderlylife.Structure.AppUser;
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
                //TODO send the username and password
                //TODO open the other activity
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

                                String mJsonString = respostaServidor.toString();
                                JsonObject user = respostaServidor.getAsJsonObject("user");
                                int userType = user.get("userType").getAsInt();
                                Log.d(TAG, "userType = " + userType);
                                Log.d(TAG, "JsonObject: " + mJsonString);
                                Gson gson = new Gson();

                                AppDataSingleton.getInstace().setUserType(userType);
                                if(AppDataSingleton.getInstace().getUserType() == Utils.APP_USER) {
                                    String userApp = respostaServidor.getAsJsonObject("user").toString();
                                    AppUser appUser = gson.fromJson(userApp , AppUser.class);

                                    Log.d(TAG, appUser.getId() + " " + appUser.getUser().getFirst_name() + " " + appUser.getResidentialAddress().getStreet());

                                } else if(AppDataSingleton.getInstace().getUserType() == Utils.OWNER_USER) {
                                    String ownerUser = user.getAsString();
                                    AppUser appUser = gson.fromJson(ownerUser , AppUser.class);

                                    Log.d(TAG, appUser.getId() + " " + appUser.getUser().getFirst_name() + " " + appUser.getResidentialAddress().getStreet());
                                }

                                Intent intent = new Intent(getActivity(), UserAppActivity.class);
                                startActivity(intent);
                               /* JsonParser parser = new JsonParser();
                                JsonElement mJson =  parser.parse(mJsonString);
                                Gson gson = new Gson();
                                // MyDataObject object = gson.fromJson(mJson, MyDataObject.class);*/

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
        });


        return view;
    }
}
