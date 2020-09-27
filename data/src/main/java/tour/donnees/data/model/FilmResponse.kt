package tour.donnees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmResponse(
    @Expose @SerializedName ("id") val id: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("description") val description: String
    /*@Expose  @SerializedName("director") val director: String,
    @Expose @SerializedName("producer") val producer: String,
    @Expose  @SerializedName("release_data") val releaseData: String,
    @Expose @SerializedName("rt_score") val rtScore: String,
    @Expose @SerializedName("people") val people: String,
    @Expose @SerializedName("species") val species: String,
    @Expose @SerializedName("locations") val locations: String,
    @Expose @SerializedName("url") val url: String*/
): Serializable