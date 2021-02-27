package fr.vours.smartproj.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "medias")
data class Media(
    @Id val _id: String? = null,
    var title: String = "",
    var description: String = ""
) {
}
