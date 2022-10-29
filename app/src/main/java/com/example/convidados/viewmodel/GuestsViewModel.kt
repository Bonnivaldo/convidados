package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val allGuestsList = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = allGuestsList

    fun getAllList() {
        allGuestsList.value = repository.getAll()
    }

    fun getPresentList() {
        allGuestsList.value = repository.getPresentGuests()
    }

    fun getAbsentList() {
        allGuestsList.value = repository.getAbsentGuests()
    }

    fun delete(id: Int){
        repository.delete(id)
    }
}