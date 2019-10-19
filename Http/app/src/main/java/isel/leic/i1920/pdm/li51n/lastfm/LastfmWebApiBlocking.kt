package isel.leic.i1920.pdm.li51n.lastfm

import com.google.gson.Gson
import org.geniuz.lastfm.LASTFM_GET_ALBUMS
import org.geniuz.lastfm.LASTFM_SEARCH
import isel.leic.i1920.pdm.li51n.lastfm.dto.GetAlbumsDto
import isel.leic.i1920.pdm.li51n.lastfm.dto.SearchDto
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

/**
 * !!! NãO usar em Android. Apenas em testes unitários se necessário !!!!
 */
class LastfmWebApiBlocking {

    fun searchArtist(name: String, page: Int) : SearchDto {
        val url = String.format(LASTFM_SEARCH, name, page)
        val inputStream = URL(url).openStream()
        val reader = BufferedReader(InputStreamReader(inputStream))
        val gson = Gson()
        return gson.fromJson<SearchDto>(reader, SearchDto::class.java)
    }

    fun getAalbums(mbid: String, page: Int) : GetAlbumsDto {
        val url = String.format(LASTFM_GET_ALBUMS, mbid, page)
        val inputStream = URL(url).openStream()
        val reader = BufferedReader(InputStreamReader(inputStream))
        val gson = Gson()
        return gson.fromJson<GetAlbumsDto>(reader, GetAlbumsDto::class.java)
    }
}