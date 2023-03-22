package ir.rev.zenlypet.firebaseroot

import ir.rev.response_models.OtherPeopleGeo

interface FirebaseDataBaseRepository {

    /** отправить данные на сервер */
    fun uploadGeo( latitude: Double, longitude: Double)

    /** получить список других пользователей */
    /* реализацию сделаешь сам */
    fun getOthersUsers()

}