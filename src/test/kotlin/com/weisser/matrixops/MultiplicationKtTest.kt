package com.weisser.matrixops

import org.junit.Test

import org.junit.Assert.*

class MultiplicationKtTest {

    @Test
    fun multiplyMatrices() {
        val a = DoubleMatrix.of(
            2.0, 0.0,
            3.0, 3.0
        )
        val b = DoubleMatrix.of(
            2.0, 0.0,
            5.0, 5.0
        )
        val cr = DoubleMatrix.of(
            2.0 * 2.0 + 0.0 * 5.0, 2.0 * 0.0 + 0.0 * 5.0,
            3.0 * 2.0 + 3.0 * 5.0, 3.0 * 0.0 + 3.0 * 5.0
        )
        val c = multiplyMatrices(a, b)

        // TODO Implement Matrix compare (with epsilon)
        for (i in 1 .. 2) {
            for (j in 1 .. 2) {
                assertEquals(cr[i, j], c[i, j], 0.00001)
            }
        }
    }
}