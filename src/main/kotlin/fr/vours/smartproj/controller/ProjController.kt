package fr.vours.smartproj.controller

import fr.vours.smartproj.model.Proj
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import fr.vours.smartproj.services.ProjService
import java.util.*


@RestController//declare this class as rest controller able to catch http request
@RequestMapping("api/proj")//controller root path
class ProjController (private val projService: ProjService) {//injects projService by constructor


    @GetMapping fun getAll(pageable: Pageable): Page<Proj> = projService.getAll(pageable)


    @GetMapping("{isbn}") fun getById(@PathVariable isbn:String): Optional<Proj> = projService.getById(isbn)


//    @GetMapping("/byName/{regex}") fun getByName(@PathVariable regex:String):List<Proj> = projService.findByNameRegex(regex)


    @PostMapping fun insert(@RequestBody proj: Proj): Proj = projService.insert(proj)


    @PutMapping fun update(@RequestBody proj: Proj): Proj = projService.update(proj)


    @DeleteMapping("{isbn}")  fun deleteByIsbn(@PathVariable isbn: String): Optional<Proj> = projService.deleteById(isbn)
}