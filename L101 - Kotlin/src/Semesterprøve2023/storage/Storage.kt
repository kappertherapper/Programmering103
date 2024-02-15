package Semesterprøve2023.storage

import Semesterprøve2023.model.Bane
import Semesterprøve2023.model.Kategori
import Semesterprøve2023.model.Spiller

object Storage {

    private val _spillere: MutableList<Spiller> = mutableListOf(); // _ = private felt
    val spillere: List<Spiller>
        get() = _spillere

    fun addSpiller(spiller: Spiller) = _spillere.add(spiller)
    fun removeSpiller(spiller: Spiller) = _spillere.remove(spiller)

    //-------------------------------------------------------------------------------------------

    private val _baner: MutableList<Bane> = mutableListOf(); // _ = private felt
    val baner: List<Bane>
        get() = _baner

    fun addBane(bane: Bane) = _baner.add(bane)
    fun removeBane(bane: Bane) = _baner.remove(bane)

    //-------------------------------------------------------------------------------------------

    private val _kategorier: MutableList<Kategori> = mutableListOf(); // _ = private felt
    val kategorier: List<Kategori>
        get() = _kategorier

    fun addKategori(kategori: Kategori) = _kategorier.add(kategori)
    fun removeKategori(kategori: Kategori) = _kategorier.remove(kategori)

}