package bag

class ListBag<E: Any>() : Bag<E>  {

    private var items: List<E> = listOf();

    var size = 0;


    override fun add(item: E): Boolean {
        return if (size == items.size) false
        else {
            items += item
            size++
            true
        }
    }

    override fun remove(): E? {
        return if (items.isEmpty()) {
            println("List is empty")
            null
        } else {
            val removedItem = items.last()
            items = items.dropLast(1)
            removedItem
        }
    }

    override fun removeAll() {
        items = emptyList()
    }

    override fun isEmpty(): Boolean {
        return if (items.isEmpty()) true
        else false
    }

    override fun toArray(): Array<Any> {
        TODO("Not yet implemented")
    }

    override fun contains(item: E): Boolean {
        for (i in items) if (i == item) return true
        return false
    }

    override fun countOf(item: E): Int {
        items.forEachIndexed { index, i ->
            if (i == item) return index
        }
        return -1
    }

    override fun remove(item: E): Boolean {
        return if (items.isEmpty()) {
            println("List is empty")
            false
        } else {
            val removedItem = items.last()
            items = items.dropLast(1)
            true
        }
    }
}