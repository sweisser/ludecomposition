package com.weisser.matrixops

import kotlin.math.abs
import kotlin.math.sqrt

class DoubleMatrix(private val dimension: Int) : Matrix<Double> {
    private val values = DoubleArray(dimension * dimension)

    override fun dim(): Int = dimension

    override fun get(row: Int, column: Int): Double = values[index(
        row,
        column,
        dimension
    )]

    override fun set(row: Int, column: Int, value: Double) {
        values[index(row, column, dimension)] = value
    }

    override fun column(column: Int) : DoubleVector {
        val result = DoubleVector(dimension)

        for (i in 1 .. dimension) {
            result[i] = get(i, column)
        }

        return result
    }

    override fun setColumn(column: Int, x: Vector<Double>) {
        for (i in 1 .. dimension) {
            set(i, column, x[i])
        }
    }

    override fun create(dimension: Int): DoubleMatrix =
        DoubleMatrix(dimension)

    override fun print() {
        for (i in 1 .. dimension) {
            print("[")

            for (j in 1 .. dimension) {
                print(get(i, j))
                if (j < dimension) {
                    print(", ")
                }
            }

            if (i < dimension) {
                println("],")
            } else {
                println("]")
            }
        }
    }

    override fun copy(): DoubleMatrix {
        val copy = DoubleMatrix(dimension)
        values.forEachIndexed { i, value -> copy.values[i] = value }
        return copy
    }

    override fun isIdentity(epsilon : Double) : Boolean {
        for (i in 1 .. dimension) {
            for (j in 1 .. dimension) {
                if (i == j && abs(get(i, j) - 1.0) >= epsilon) {
                    return false
                } else if (i != j && abs(get(i, j)) >= epsilon) {
                    return false
                }
            }
        }
        return true
    }

    companion object {
        fun index(row: Int, column: Int, dimension: Int) : Int = (row - 1) * dimension + column - 1

        fun of(vararg values: Double) : DoubleMatrix {
            val dimension = sqrt(values.size.toDouble()).toInt()
            val matrix = DoubleMatrix(dimension)
            for (i in 1 .. dimension) {
                for (j in 1 .. dimension) {
                    val index = index(i, j, dimension)
                    val value = values[index]
                    matrix[i, j] = value
                }
            }

            return matrix
        }

        fun of(vararg values: Int) : DoubleMatrix {
            val dimension = sqrt(values.size.toDouble()).toInt()
            val matrix = DoubleMatrix(dimension)
            for (i in 1 .. dimension) {
                for (j in 1 .. dimension) {
                    val index = index(i, j, dimension)
                    val value = values[index].toDouble()
                    matrix[i, j] = value
                }
            }

            return matrix
        }
    }
}
