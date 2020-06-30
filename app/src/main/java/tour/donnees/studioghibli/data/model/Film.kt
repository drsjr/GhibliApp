package tour.donnees.studioghibli.data.model

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("director") val director: String,
    @SerializedName("producer") val producer: String,
    @SerializedName("release_data") val releaseData: String,
    @SerializedName("rt_score") val rtScore: String,
    @SerializedName("people") val people: String,
    @SerializedName("species") val species: String,
    @SerializedName("locations") val locations: String,
    @SerializedName("url") val url: String
)