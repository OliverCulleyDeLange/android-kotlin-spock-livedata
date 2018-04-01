package uk.co.oliverdelange.android_kotlin_spock_livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.view.View

class MainViewModel : ViewModel() {

    val name: MutableLiveData<String> = MutableLiveData<String>().also {
        it.value = ""
    }
    val nameError: MutableLiveData<String> = MutableLiveData()
    val welcomeMessage: LiveData<String> = Transformations.map(name) {
        "Welcome, " + it
    }

    fun submit(view: View) {
        if (name.value.isNullOrBlank()) nameError.value = "Can not be empty"
        else {
            nameError.value = null
        }
    }
}