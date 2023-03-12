package ir.rev.zenlypet.auth

import androidx.fragment.app.Fragment
import ir.rev.zenlypet.firebaseroot.FirebasePlugin

/**
 * предаставляет зависимости для работы с auth модулем
 */
object AuthPlugin {

    /** проверяем авторизован ли юзер */
    fun isUserAuth(): Boolean = FirebasePlugin.isUserAuth()

    /** возвращаем экземпляр фрагмента auth */
    fun getAuthFragment(): Fragment = AuthFragment.newInstance()
}