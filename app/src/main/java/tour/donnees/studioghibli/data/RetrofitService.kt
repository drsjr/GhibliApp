package tour.donnees.studioghibli.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getHttpClient())
            .baseUrl(STUDIO_GHIBLI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            //.addInterceptor(::addHeaders)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }
    
    private fun addHeaders(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            //.addHeader(API_KEY_HEADER_NAME, BuildConfig.NEWS_API_KEY)
            .build()
        return chain.proceed(request)
    }
    
    companion object {
        const val STUDIO_GHIBLI_URL = "https://ghibliapi.herokuapp.com/"
    }
    
}