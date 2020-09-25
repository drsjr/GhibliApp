package tour.donnees.studioghibli.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private var retrofit: Retrofit? = null
    private val services = HashMap<Class<*>, Any?>()
    private var httpClient: OkHttpClient? = null
    
    private fun getRetrofit(): Retrofit {
        return retrofit ?: let {
            retrofit = Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl(STUDIO_GHIBLI_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit!!
        }
    }

    private fun getBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)
        //builder.addInterceptor(::addHeaders)

        return builder
    }
    
    private fun getHttpClient(): OkHttpClient {
        return httpClient ?: let {
            httpClient = getBuilder().build()
            return httpClient as OkHttpClient
        }
    }
    
    private fun addHeaders(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().addHeader("API_KEY_HEADER_NAME", "API_KEY").build()
        return chain.proceed(request)
    }

    operator fun <T> get(endpointClass: Class<T>): T {
        var endpoint: Any? = services[endpointClass]
        if (endpoint == null) {
            endpoint = getRetrofit().create(endpointClass)
            services[endpointClass] = endpointClass
        }
        return endpoint as T
    }
    
    companion object {
        const val STUDIO_GHIBLI_URL = "https://ghibliapi.herokuapp.com/"
    }
    
}