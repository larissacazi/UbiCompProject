package zimmermann.larissa.elderlylife.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laris on 11/08/2017.
 */

public class ServiceGenerator {

    //URL base do endpoint. Deve sempre terminar com /
    public static final String API_BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
