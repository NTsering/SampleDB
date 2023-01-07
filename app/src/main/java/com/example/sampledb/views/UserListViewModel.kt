package com.example.sampledb.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampledb.db.User
import com.example.sampledb.repo.DatabaseHelperImpl
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users
    lateinit var databaseHelperImpl: DatabaseHelperImpl
    fun loadUsers() {
        viewModelScope.launch {
            _users.postValue(databaseHelperImpl.getUsers())
        }
    }
}
