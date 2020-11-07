package fr.vours.smartproj.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Year

@Document(collection = "projs")
data class Proj(
        @Id val id: String,
        val name: String,
        val brand: String,
        val manufacturingYear: String)