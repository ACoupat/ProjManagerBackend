package fr.vours.smartproj.util

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

interface BasicCrud<K,T> {
    fun getAll(pageable: Pageable): Page<T>
    fun getById(id:K):Optional<T>
    fun insert(obj:T):T
    fun update(obj:T):T
    fun deleteById(id: K): Optional<T>
}

object Objects {
    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
}
fun String.toLocalDate() = LocalDate.parse(this, Objects.dateFormat)