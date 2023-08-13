package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//la url donde la api se conectara.
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//Creacion del compilador de moshi para convertir las strings de la api.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Ejecutamos una variable con el compilador de Retrofit, quien nos leera la api.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
//Aqui obtendremos el string que se va a recibir de la web, por eso utilizamos el GET.
interface MarsApiService {
    @GET("photos")
    fun getPhotos(): List<MarsPhoto>
}

//Objeto para poder inicializar la api.
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
}

