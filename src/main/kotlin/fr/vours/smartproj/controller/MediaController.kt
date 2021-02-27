package fr.vours.smartproj.controller

import fr.vours.smartproj.model.Media
import fr.vours.smartproj.services.media.MediaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(origins = ["*"])//"http://localhost:8081", "http://192.168.1.6:8081", "192.168.1.48:8081", "http://192.168.1.32"])
@RestController//declare this class as rest controller able to catch http request
@RequestMapping("media")//controller root path
class MediaController(private val mediaService: MediaService) {

    @GetMapping
    fun getAll(pageable: Pageable): Page<Media> = mediaService.getAll(pageable)

    @GetMapping("{isbn}")
    fun getById(@PathVariable isbn: String): Optional<Media> = mediaService.getById(isbn)

    @PostMapping
    fun insert(): Media = mediaService.insert(Media())

}