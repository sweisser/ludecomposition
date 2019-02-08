package com.weisser.matrixops

fun inverse(a: DoubleMatrix) : DoubleMatrix {
    val dim = a.dim()
    val lup = lupDecomposition(a)
    val inverse = DoubleMatrix(dim)

    for (i in 1 .. dim) {
        val b = DoubleVector(dim)
        b[i] = 1.0

        val x = lupSolve(lup.l, lup.u, lup.pi, b)

        inverse.setColumn(i, x)
    }

    return inverse
}
