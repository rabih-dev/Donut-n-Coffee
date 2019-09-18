package com.example.donutncoffee

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore

object Database {

    val db = FirebaseFirestore.getInstance()

    fun add(collection: String, document : String, data: Any): Task<*> {
        val task = db.collection(collection).document(document).set(data)
        return task
    }
}