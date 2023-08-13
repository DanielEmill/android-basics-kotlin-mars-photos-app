package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//la url donde la api se conectara.
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//Ejecutamos una variable con el compilador de Retrofit, quien nos leera la api.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Aqui obtendremos el string que se va a recibir de la web, por eso utilizamos el GET.
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}

//Objeto para poder inicializar la api.
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}

