package model

class Kategori(
    val navn: String,
    val prisKrSingle: Int,
    val prisKrDouble: Int
) {
    override fun toString(): String {
        return navn
    }
}
