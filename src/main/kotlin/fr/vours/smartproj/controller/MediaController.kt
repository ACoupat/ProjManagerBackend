package fr.vours.smartproj.controller

import fr.vours.smartproj.model.Media
import fr.vours.smartproj.services.media.MediaService
import fr.vours.smartproj.services.proj.ProjService
import fr.vours.smartproj.services.proj.StorageService
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import java.io.File
import java.io.FileNotFoundException

@CrossOrigin(origins = ["*"])//"http://localhost:8081", "http://192.168.1.6:8081", "192.168.1.48:8081", "http://192.168.1.32"])
@RestController//declare this class as rest controller able to catch http request
@RequestMapping("media")//controller root path
class MediaController(
    private val mediaService: MediaService,
    private val storageService: StorageService,
    private val projService: ProjService
) {

    @GetMapping
    fun getAll(pageable: Pageable): Page<Media> = mediaService.getAll(pageable)

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Media> = mediaService.getById(id)

    @GetMapping("downloadFile/{id}", produces = [MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE])
    fun downloadFile(@PathVariable id: String): ByteArray {
        var fileName = this.getById(id)?.get()?.title;
        if (fileName != null) {
            var file = storageService.downloadFile(fileName);
            return file.readBytes();
        }
        throw FileNotFoundException("The file $fileName doesn't exist")
    }

    @PostMapping
    fun handleFileUpload(
        @RequestParam(required = true) fileName: String,
        @RequestParam(required = true) projId: String,
        @RequestBody file: MultipartFile
    ) {
        storageService.store(file, fileName)
        val media = mediaService.insert(Media(null, fileName, ""))
        var proj = projService.getById(projId).get();
        proj?.addMedia(media);
        projService.update(projId, proj);
    }

}