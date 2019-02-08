package com.weisser.matrixops

interface Vector<T> {
    fun copy() : Vector<T>

    fun dim() : Int

    operator fun get(index: Int) : T
    operator fun set(index: Int, value: T)

    fun print()
}
