package fr.vours.smartproj.services.proj

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileNotFoundException

const val FILE_STORAGE_ROOT : String = "/home/vours/medias"

@Service
class StorageService {
    public fun store(file: MultipartFile, fileName: String){
        val newFile : File = File("$FILE_STORAGE_ROOT/$fileName")
        file.transferTo(newFile)
    }

    public fun downloadFile(fileName:String) : File{
        val file : File = File("$FILE_STORAGE_ROOT/$fileName");
        if(file.exists()){
            return file;
        }
        throw FileNotFoundException("The file $fileName doesn't exist")
    }

}