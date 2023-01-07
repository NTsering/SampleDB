package com.example.sampledb.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampledb.db.User
import com.example.sampledb.repo.DatabaseHelper
import com.example.sampledb.repo.DatabaseHelperImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInputViewModel @Inject constructor(private val databaseHelper: DatabaseHelper) : ViewModel() {
    private val _text = MutableLiveData("Hello")

    val text: LiveData<String>
        get() = _text

    fun changeText(text: String) {
        _text.postValue("Hello world $text")
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            databaseHelper.insert(user)
        }
    }
}
