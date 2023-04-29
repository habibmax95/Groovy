package petros.efthymiou.groovy.playlist

import androidx.fragment.app.Fragment
import androidx.test.espresso.IdlingResource
import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient()
val idlingResource = OkHttp3IdlingResource.create("okHttp", client)
@Module
@InstallIn(SingletonComponent::class)
class PlaylistModule {
    @Provides
    fun playlistAPI(retrofit: Retrofit) = retrofit.create(PlaylistAPI::class.java)


    @Provides
    fun retrofit() = Retrofit.Builder()
    .baseUrl("http://192.168.0.114:3000/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}