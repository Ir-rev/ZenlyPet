package ir.rev.map_repository

import ir.rev.response_models.OtherPeopleGeo


interface MapDataBaseRepository {

    /** отправить данные на сервер */
    fun uploadGeo( latitude: Double, longitude: Double)

    /** получить список других пользователей */
    fun getOthersUsers(): List<OtherPeopleGeo>

}