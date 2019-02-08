package com.weisser.matrixops

import org.junit.Test

import org.junit.Assert.*

class LUPSolveKtTest {

    @Test
    fun lupSolve() {
        val epsilon = 0.00001

        // Introduction to algorithms", p. 746
        val a = DoubleMatrix.of(
            1.0, 2.0, 0.0,
            3.0, 4.0, 4.0,
            5.0, 6.0, 3.0
        )

        val b = DoubleVector.of(3.0, 7.0, 8.0)

        val lup = lupDecomposition(a)

        val x = lupSolve(lup.l, lup.u, lup.pi, b)

        // TODO Implement vector compare (with epsilon)
        assertEquals(-1.4, x[1], epsilon)
        assertEquals(2.2, x[2], epsilon)
        assertEquals(0.6, x[3], epsilon)
    }
}