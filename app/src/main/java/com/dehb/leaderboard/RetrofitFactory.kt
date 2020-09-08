package com.dehb.leaderboard

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface{
@GET("api/hours")
suspend fun getLearningHours(): Response<List<LearningHoursModel>>
//    suspend fun getLearningHours(): Response<GenericResponse<ArrayList<LearningHoursModel>>>
    @GET("api/skilliq")
    suspend fun getSkillIq(): Response<List<SkillIqModel>>
//    suspend fun getSkillIq(): Response<GenericResponse<ArrayList<SkillIqModel>>>
}

class RetrofitFactory {

    companion object {
        val Base_Url: String = "https://gadsapi.herokuapp.com/"
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
}
}