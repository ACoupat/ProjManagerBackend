package fr.vours.smartproj.services.media

import fr.vours.smartproj.model.Media
import org.springframework.data.mongodb.repository.MongoRepository

interface MediaDAO: MongoRepository<Media, String>
