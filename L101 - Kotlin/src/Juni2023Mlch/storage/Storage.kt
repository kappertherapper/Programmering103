package storage

import model.Kategori
import model.Bane
import model.Spiller

object Storage {
    private val _alleSpillere: MutableList<Spiller> = mutableListOf()
    val alleSpillere: List<Spiller>
        get() = _alleSpillere
    private val _alleBaner: MutableList<Bane> = mutableListOf()
    val alleBaner: List<Bane>
        get() = _alleBaner
    private val _alleKategorier: MutableList<Kategori> = mutableListOf()
    val alleKategorier: List<Kategori>
        get() = _alleKategorier

    fun addSpiller(spiller: Spiller) = _alleSpillere.add(spiller)
    fun addBane(bane: Bane) = _alleBaner.add(bane)
    fun addKategori(kategori: Kategori) = _alleKategorier.add(kategori)
}
