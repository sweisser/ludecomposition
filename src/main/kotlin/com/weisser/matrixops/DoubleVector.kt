package com.weisser.matrixops

class DoubleVector(private val dimension: Int) : Vector<Double> {
    private val values = DoubleArray(dimension)

    override fun dim(): Int = dimension

    override fun get(index: Int): Double = values[index - 1]

    override fun set(index: Int, value: Double) {
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

    override fun copy(): DoubleVector {
        val copy = DoubleVector(dimension)
        values.forEachIndexed { i, value -> copy.values[i] = value }
        return copy
    }

    companion object {
        fun of(vararg values: Double) : DoubleVector {
            val dimension = values.size
            val vector = DoubleVector(dimension)

            for (i in 1 .. dimension) {
                vector[i] = values[i - 1]
            }

            return vector
        }
    }
}
