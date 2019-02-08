package com.weisser.matrixops

/**
 * Square matrix of type T
 */
interface Matrix<T> {
    fun create(dimension: Int) : Matrix<T>
    fun copy() : Matrix<T>

    fun dim() : Int

    operator fun get(row: Int, column: Int) : T
    operator fun set(row: Int, column: Int, value: T)

    fun column(column: Int): Vector<T>
    fun setColumn(column: Int, x: Vector<T>)

    fun print()
    fun isIdentity(epsilon: Double = 0.00001): Boolean
}
