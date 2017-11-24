package zimmermann.larissa.elderlylife.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by laris on 11/08/2017.
 */

public interface RetrofitService {

    /*
    @GET("proposicoes")
    Call<PropListResponse> getDefaultProposicaoList();        //Unidade final

    @GET("proposicoes")
    Call<PropListResponse> getProposicaoListByYear(@Query("ano") int year);        //Unidade final

    @GET("proposicoes/{id}")
    Call<PropResponse> getProposicaoById(@Path("id") int id);

    @GET("referencias/situacoesProposicao")
    Call<SituationListResponse> getAllPropSituation();

    @GET("proposicoes")
    Call<PropListResponse> getProposicaoListBySituationId(@Query("idSituacao") int id);

    @GET("deputados?ordem=ASC&ordenarPor=nome")
    Call<DeputadoListResponse> getDeputadoList();

    @GET("deputados/")
    Call<DeputadoListResponse> getDeputadoListByPage(@Query("pagina") int pagina);
    */

}
