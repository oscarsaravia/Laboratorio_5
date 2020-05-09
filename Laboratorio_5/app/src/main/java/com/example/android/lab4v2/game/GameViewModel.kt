package com.example.android.lab4v2.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.lab4v2.Guest

class GameViewModel: ViewModel(){

    val index = MutableLiveData<Int>()
    val name = MutableLiveData<String>()
    val mail = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val namelist = MutableLiveData<String>()
    var  registered = 0
    var guests = 0
    var listSize = 0
    var invitednum = 0
    lateinit var people: MutableList<Guest>

    init{
        setList()
        listSize = people.size
        index.value = 0
        namelist.value = "EMPTY"

    }

    private fun setList(){
        people = mutableListOf(
            Guest(
                name="OscarSaravia",
                phone="57469845",
                mail="oscarsaravia@gmail.com"
            ),
            Guest(
                name="CarlosPerez",
                phone="67345698",
                mail="carlosperez@gmail.com"
            ),
            Guest(
                name="MariaSuarez",
                phone="45673459",
                mail="msuarez@gmail.com"
            ),
            Guest(
                name="CarlaLopez",
                phone="34890567",
                mail="carlop@gmail.com"
            ),
            Guest(
                name="RaulJimenez",
                phone="34567654",
                mail="rjimenez@gmail.com"
            )
        )


    }

    private fun nextGuest() {
        if (index.value != people.size) {

            name.value = people[index.value!!].name
            mail.value = people[index.value!!].mail
            phone.value = people[index.value!!].mail


        }
    }

    fun isAssisting(){
        registered ++
        guests ++
        nextGuest()

    }

    fun notAssisting(){
        guests ++
        nextGuest()
    }

    fun setFirst(){
        nextGuest()
    }

    fun isAssistingLast(){
        registered ++
        guests ++
    }
    fun notAssistingLast(){
        guests ++
    }

    fun addtoList(){
        namelist.value = "CAMBIOOOOOO"
    }
}