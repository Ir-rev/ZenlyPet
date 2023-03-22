package ir.rev.map_repository

import ir.rev.response_models.OtherPeopleGeo
import ir.rev.zenlypet.firebaseroot.FirebasePlugin

/**
 * предаставляет зависимости для работы с модулем карты
 */
object MapRepositoryPlugin {

    private val firebaseDataBaseRepository = FirebasePlugin.getFirebaseDataBaseRepository()

    private val mapDataBaseRepository by lazy {
        object : MapDataBaseRepository {

            override fun uploadGeo(latitude: Double, longitude: Double) =
                firebaseDataBaseRepository.uploadGeo(latitude, longitude)

            override fun getOthersUsers(): List<OtherPeopleGeo> = firebaseDataBaseRepository.getOthersUsers()

        }
    }

    fun getMapRepository(): MapDataBaseRepository = mapDataBaseRepository

}