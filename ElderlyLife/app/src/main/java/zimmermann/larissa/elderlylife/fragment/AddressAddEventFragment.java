package zimmermann.larissa.elderlylife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.service.RetrofitService;
import zimmermann.larissa.elderlylife.service.ServiceGenerator;
import zimmermann.larissa.elderlylife.utils.Utils;


public class AddressAddEventFragment extends Fragment {

    private static final String TAG = "AddressRegisterFragment";

    private EditText streetText;
    private EditText numberText;
    private EditText neighborText;
    private EditText stateText;
    private EditText countryText;
    private EditText zipcodeText;
    private EditText cityText;
    private CardView cardRegisterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_address_add_event, container, false);

        cardRegisterButton = (CardView)view.findViewById(R.id.addressRegisterButtonID);
        streetText = (EditText)view.findViewById(R.id.streetTextID);
        numberText = (EditText)view.findViewById(R.id.numberTextID);
        neighborText = (EditText)view.findViewById(R.id.neighborTextID);
        stateText = (EditText)view.findViewById(R.id.stateTextID);
        countryText = (EditText)view.findViewById(R.id.countryTextID);
        zipcodeText = (EditText)view.findViewById(R.id.zipcodeTextID);
        cityText = (EditText)view.findViewById(R.id.cityTextID);

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
                else if(Utils.isEditTextEmpty(cityText)) {
                    cityText.setError("City is required");
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
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setStreet(streetText.getText().toString());
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setNumber(Integer.valueOf(numberText.getText().toString()));
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setCity(cityText.getText().toString());
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setNeighbor(neighborText.getText().toString());
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setState(stateText.getText().toString());
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setCountry(countryText.getText().toString());
                    AppDataSingleton.getInstace().getAppUser().getResidentialAddress().setZipcode(zipcodeText.getText().toString());

                    //Send this AppUser to server
                    uploadEvent();

                    //Close Activity
                }
            }
        });

        return view;
    }

    private void uploadEvent() {//TODO Change this function
        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        Call<AppUser> call = service.createNewAppUser(AppDataSingleton.getInstace().getAppUser());

        call.enqueue(new Callback<AppUser>() {
            @Override
            public void onResponse(Call<AppUser> call, Response<AppUser> response) {

                boolean answer = response.isSuccessful();

                if (response.isSuccessful()) {
                    AppUser respostaServidor = response.body();
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
            public void onFailure(Call<AppUser> call, Throwable t) {
                Toast.makeText(getContext(), "Falha!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, t.getMessage());
            }
        });
    }

}
