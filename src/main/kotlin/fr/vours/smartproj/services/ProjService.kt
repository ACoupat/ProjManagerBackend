package fr.vours.smartproj.services

import fr.vours.smartproj.model.Proj
import fr.vours.smartproj.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProjService(val projDAO: ProjDAO):BasicCrud<String, Proj>{
    override fun getAll(pageable: Pageable): Page<Proj> = projDAO.findAll(pageable)


    override fun getById(id: String): Optional<Proj> = projDAO.findById(id)

    override fun insert(obj: Proj): Proj = projDAO.insert(obj)

    override fun update(obj: Proj): Proj {

        return if(projDAO.existsById(obj.id)){//check if book exists because the save method will insert a record if does not exists
            projDAO.save(obj)//re-insert author from db to avoid inconsistency
        }else{
            throw object: Exception("Proj not found"){}
        }}

    override fun deleteById(id: String): Optional<Proj> {
        return projDAO.findById(id).apply {
            this.ifPresent { projDAO.delete(it) }
        }
    }

}