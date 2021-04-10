package fr.vours.smartproj.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Year

@Document(collection = "projs")
data class Proj(
    @Id val _id: String? = null,
    var name: String = "",
    var brand: String = "",
    var manufacturingYear: String = "",
    var acquisitionYear: String = "",
    var acquisitionPrice: String = "",
    var acquisitionPlace: String = "",
    var notes: String = "",

    @DBRef
    var medias: MutableList<Media> = ArrayList<Media>()
) {
    public fun addMedia(media: Media) {
        this.medias.add(media)
    }
}