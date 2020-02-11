package be.mickverm.viewbinding.data.dummy

import java.util.*

object DummyContent {

    /**
     * An array of sample items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            ITEMS.add(createDummyItem(i))
        }
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item $position", makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
