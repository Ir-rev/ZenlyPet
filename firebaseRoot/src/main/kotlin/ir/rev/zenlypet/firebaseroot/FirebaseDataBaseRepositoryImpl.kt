package ir.rev.zenlypet.firebaseroot

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ir.rev.response_models.OtherPeopleGeo

internal class FirebaseDataBaseRepositoryImpl : FirebaseDataBaseRepository {

    private val firestore = Firebase.firestore

    override fun uploadGeo(latitude: Double, longitude: Double) {
        firestore.collection("UsersGeo").add(
            hashMapOf("latitude" to latitude, "longitude" to longitude, "name" to FirebasePlugin.getUserId())
        ).addOnSuccessListener { documentReference ->
            Log.d("checkResult", "uploadGeo: успешно добавлено")
        }
            .addOnFailureListener { e ->
                Log.d("checkResult", "uploadGeo: $e")
            }
    }

    override fun getOthersUsers() {
        //чето делаем с файрбейзом
    }
}