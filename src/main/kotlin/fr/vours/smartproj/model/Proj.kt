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
    @DBRef
    var medias: MutableList<Media> = ArrayList<Media>()
) {
    public fun addMedia(media: Media) {
        this.medias.add(media)
    }
}