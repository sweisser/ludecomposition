package com.weisser.matrixops

class IntVector(private val dimension: Int) : Vector<Int> {
    private val values = IntArray(dimension)

    override fun dim(): Int = dimension

    override fun get(index: Int): Int = values[index - 1]

    override fun set(index: Int, value: Int) {
        values[index - 1] = value
    }

    override fun print() {
        print("[")
        for (i in 1 .. dimension) {
            print(get(i))
            if (i < dimension) {
                print(", ")
            }
        }
        println("]")
    }

    override fun copy(): IntVector {
        val copy = IntVector(dimension)
        values.forEachIndexed { i, value -> copy.values[i] = value }
        return copy
    }

    companion object {
        fun of(vararg values: Int) : IntVector {
            val dimension = values.size
            val vector = IntVector(dimension)

            for (i in 1 .. dimension) {
                vector[i] = values[i - 1]
            }

            return vector
        }
    }
}
