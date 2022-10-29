package com.example.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.model.GuestModel

class GuestRepository (context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()


    fun insert(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return guestDataBase.getAll()
    }

    fun getPresentGuests(): List<GuestModel> {
        return guestDataBase.getPresentGuests()
    }

    fun getAbsentGuests(): List<GuestModel> {
        return guestDataBase.getAbsentGuests()
    }
}