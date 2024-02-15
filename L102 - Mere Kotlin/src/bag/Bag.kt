package bag

interface Bag<E> {
    /** Add a new item to this bag.
     * Returns true if the item is added, or false if not. */
    fun add(item: E): Boolean

    /** Remove one unspecified item from this bag, if possible.
     * Returns the removed item, if an item was removed, or null if not. */
    fun remove(): E?

    /** Remove one occurrence of the given item from this bag.
     * Returns true if the item was removed, or false if not. */
    fun remove(item: E): Boolean

    /** Remove all items from this bag. */
    fun removeAll()

    /** Return whether this bag is empty. */
    fun isEmpty(): Boolean

    /** Return the count of the given item in this bag. */
    fun countOf(item: E): Int

    /** Return whether this bag contains the given item. */
    fun contains(item: E): Boolean

    /** Return an array with all the entries in this bag. */
    fun toArray(): Array<Any>
}
