package ir.rev.zenlypet.auth

import androidx.lifecycle.ViewModel
import ir.rev.zenlypet.firebaseroot.FirebaseAuthRepository
import ir.rev.zenlypet.firebaseroot.FirebasePlugin

internal class AuthViewModel() : ViewModel() {

    private val firebaseAuthRepository: FirebaseAuthRepository = FirebasePlugin.getFirebaseAuthRepository()

    fun logIn() {
        firebaseAuthRepository.authWithEmailAddPassword("siju_kust@mail.ru", "123qwe123qwe")
    }

}