package fr.vours.smartproj

import fr.vours.smartproj.model.Proj
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import fr.vours.smartproj.services.ProjDAO
import java.time.Year

@SpringBootApplication()
open class SmartProjApplication(private val projDAO: ProjDAO) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        if (projDAO.count() < 1) {
            this.createProjs()
        }
    }

    private fun createProjs() {
        projDAO.deleteAll()

        val projs = listOf<Proj>(
                Proj("1","Pathé Baby", "Pathé", Year.of(1912)),
                Proj("2","Pathé Kok", "Pathé", Year.of(1933)),
                Proj("3","Regent", "Bell & Howell", Year.of(1933))

        )
    }


}

fun main(args: Array<String>) {
    runApplication<SmartProjApplication>(*args)
}