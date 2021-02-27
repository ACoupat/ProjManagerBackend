package fr.vours.smartproj.services.proj

import fr.vours.smartproj.model.Proj
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
interface ProjDAO:MongoRepository<Proj,String>
