package ir.rev.zenlypet.firebaseroot

import com.google.firebase.auth.FirebaseAuth

object FirebasePlugin {

    private val firebaseAuthRepository by lazy {
        FirebaseAuthRepositoryImpl()
    }

    /** Предоставляет имплементацию репозитория [FirebaseAuthRepository] */
    fun getFirebaseAuthRepository(): FirebaseAuthRepository = firebaseAuthRepository

    /** Проверяем зарегистрирован ли юзер */
    fun isUserAuth(): Boolean = FirebaseAuth.getInstance().currentUser != null

}