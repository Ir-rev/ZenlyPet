package ir.rev.auth

import androidx.fragment.app.Fragment

object AuthPlugin {

    // идем в sharedPreference и проверяем
    fun isUserAuth(): Boolean = true

    // возвращаем экземпляр фрагмента auth
    fun getAuthFragment(): Fragment = TODO()
}