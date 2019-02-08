package com.weisser.matrixops

import org.junit.Test

import org.junit.Assert.*

class InverseKtTest {
    @Test
    fun inverse() {
        val a = DoubleMatrix.of(
            1.0, 2.0, -1.0,
            2.0, 1.0, 0.0,
            -1.0, 1.0, 2.0
        )

        // Copy of a, since a gets destroyed during lupDecomposition
        val a1 = a.copy()
        val b = inverse(a1)
        val c = multiplyMatrices(a, b)

        assertTrue(c.isIdentity())
    }
}
