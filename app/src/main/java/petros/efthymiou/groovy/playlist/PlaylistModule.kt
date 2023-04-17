package petros.efthymiou.groovy.playlist

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class PlaylistModule {
    @Provides
    fun playlistAPI(retrofit: Retrofit) = retrofit.create(PlaylistAPI::class.java)


    @Provides
    fun retrofit() = Retrofit.Builder()
    .baseUrl("http://192.168.0.114:3000/")
    .client(OkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}