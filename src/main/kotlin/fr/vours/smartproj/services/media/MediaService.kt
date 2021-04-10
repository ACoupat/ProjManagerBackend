package fr.vours.smartproj.services.media

import fr.vours.smartproj.model.Media
import fr.vours.smartproj.model.Proj
import fr.vours.smartproj.services.proj.ProjDAO
import fr.vours.smartproj.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MediaService(val mediaDAO: MediaDAO) : BasicCrud<String, Media> {
    override fun getAll(pageable: Pageable): Page<Media> = mediaDAO.findAll(pageable)


    override fun getById(id: String): Optional<Media> = mediaDAO.findById(id)

    override fun insert(obj: Media): Media {
        return mediaDAO.insert(obj)
    }

    override fun update(id: String, obj: Media): Media {

        return if (mediaDAO.existsById(id)) {
            mediaDAO.save(obj)
        } else {
            throw object : Exception("Media not found") {}
        }
    }

    override fun deleteById(id: String): Optional<Media> {
        return mediaDAO.findById(id).apply {
            this.ifPresent { mediaDAO.delete(it) }
        }
    }
}

