package petros.efthymiou.groovy.playlist

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistRepository(
    private val playlistService: PlaylistService
) {
    suspend fun getPlaylists(): Flow<Result<List<Playlist>>> {
        return playlistService.fetchPlaylists()
    }

}
