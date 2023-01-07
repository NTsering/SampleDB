package com.example.sampledb.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampledb.db.User
import com.example.sampledb.repo.DatabaseHelperImpl
import kotlinx.coroutines.launch

class UserInputViewModel : ViewModel() {
    private val _text = MutableLiveData<String>("Hello")

    lateinit var databaseHelperImpl: DatabaseHelperImpl

    val text: LiveData<String>
        get() = _text

    fun changeText(text: String) {
        _text.postValue("Hello world $text")
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            databaseHelperImpl.insert(user)
        }
    }
}
