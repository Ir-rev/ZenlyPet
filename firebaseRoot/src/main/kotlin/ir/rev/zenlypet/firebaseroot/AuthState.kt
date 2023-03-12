package ir.rev.zenlypet.firebaseroot

sealed class AuthState {

    /** Успешная авторизация/регистрация */
    object SuccessAuth : AuthState()

    /** Не удачная авториация (показываем ошибку по мессаджу) */
    class FailAuth(val error: Throwable) : AuthState()
}
