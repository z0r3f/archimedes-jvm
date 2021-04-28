package io.archimedesfw.data

interface Entity<K> {

    val id: K

    fun isNewEntity(): Boolean

    fun isSameEntity(other: Entity<*>): Boolean {
        if (this === other) return true
        if (!javaClass.isAssignableFrom(other.javaClass)) return false
        return this.id == other.id
    }

    fun entityHashCode(): Int = id?.hashCode() ?: 0
    fun entityToString(): String = "Entity(id=$id)"

}
