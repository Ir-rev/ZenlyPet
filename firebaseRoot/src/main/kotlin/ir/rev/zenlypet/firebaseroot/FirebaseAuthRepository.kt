package ir.rev.zenlypet.firebaseroot

import io.reactivex.rxjava3.core.Observable
import ir.rev.response_models.AuthState

interface FirebaseAuthRepository {

    /** получить подписку на стейт репозитория */
    fun getStateObservable(): Observable<AuthState>

    /** войти через емаил и пароль */
    fun authWithEmailAddPassword(email: String, password: String)

}