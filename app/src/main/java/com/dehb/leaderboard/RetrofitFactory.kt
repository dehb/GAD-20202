package com.dehb.leaderboard

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface{
@GET("api/hours")
suspend fun getLearningHours(): Response<List<LearningHoursModel>>

    @GET("api/skilliq")
    suspend fun getSkillIq(): Response<List<SkillIqModel>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.284483984") githubLink: String): Call<Void>

}

class RetrofitFactory {

    companion object {
        val Base_Url: String = "https://gadsapi.herokuapp.com/"
        val Post_Base_Url = "https://docs.google.com/forms/d/e/"
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }


        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(
                Interceptor {chain ->
                    val builder = chain.request().newBuilder()
                            return@Interceptor chain.proceed(builder.build())
        }
        ).addInterceptor(interceptor)
    }.build()

        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Base_Url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getRetrofitInstanceForm(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Post_Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}
}