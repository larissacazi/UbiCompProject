package zimmermann.larissa.elderlylife.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zimmermann.larissa.elderlylife.R;
import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.Structure.OwnerUser;
import zimmermann.larissa.elderlylife.Structure.Tag;
import zimmermann.larissa.elderlylife.Structure.TagList;
import zimmermann.larissa.elderlylife.UserAppActivity;
import zimmermann.larissa.elderlylife.data.AppDataSingleton;
import zimmermann.larissa.elderlylife.service.RetrofitService;
import zimmermann.larissa.elderlylife.service.ServiceGenerator;
import zimmermann.larissa.elderlylife.utils.SpinnerItem;
import zimmermann.larissa.elderlylife.utils.Utils;

public class AddEventFragment extends Fragment {

    private static final String TAG = "AddEventFragment";

    private EditText eventName;
    private EditText eventDescription;
    private EditText eventDate;
    private EditText eventHour;
    private Spinner eventSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_add_event, container, false);

        eventName = (EditText)view.findViewById(R.id.eventNameID);
        eventDescription = (EditText)view.findViewById(R.id.eventDescriptionID);
        eventDate = (EditText)view.findViewById(R.id.eventDateID);
        eventHour = (EditText)view.findViewById(R.id.eventHourID);
        eventSpinner = (Spinner)view.findViewById(R.id.eventSpinnerID);

        if(AppDataSingleton.getInstace().getTags() == null) {
            loadTags();
        }
        else{
            //TODO ADD TAGS TO SPINNER
        }

        return view;
    }

    private void loadTags() {
        String token = AppDataSingleton.getInstace().getToken();
        RetrofitService service = ServiceGenerator.getClient().create(RetrofitService.class);
        Call<TagList> call = service.getAllTags(token);

        call.enqueue(new Callback<TagList>() {
            @Override
            public void onResponse(Call<TagList> call, Response<TagList> response) {

                if (response.isSuccessful()) {
                    TagList tagList = response.body();
                    if(tagList != null) {

                        AppDataSingleton.getInstace().setTags(tagList.getData());

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, R.id.itemText);
                        for(int i = 0; i<tagList.getData().size(); i++) {
                            String spinnerItem = tagList.getData().get(i).getName();
                            arrayAdapter.add(spinnerItem);
                        }

                        arrayAdapter.sort(new Comparator<String>() {
                            @Override
                            public int compare(String arg1, String arg0) {
                                return arg1.compareTo(arg0);
                            }
                        });

                        eventSpinner.setAdapter(arrayAdapter);

                    }else {

                        Toast.makeText(getContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getContext(), "Falha de comunicação", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TagList> call, Throwable t) {
                Toast.makeText(getContext(), "Falha!!!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, t.getMessage());
            }
        });
    }

}
