package com.weisser.matrixops

data class LUDecomposition(var l: Matrix<Double>, var u: Matrix<Double>)

fun luDecomposition(a: Matrix<Double>) : LUDecomposition {
    val n = a.dim()
    val l = a.create(n)
    val u = a.create(n)

    for (k in 1 .. n) {
        u[k, k] = a[k, k]

        for (i in k + 1 .. n) {
            l[i, k] = a[i, k] / u[k, k]
            u[k, i] = a[k, i]
        }

        for (i in k + 1 .. n) {
            for (j in k + 1 .. n) {
                a[i, j] = a[i, j] - l[i, k] * u[k, j]
            }
        }
    }

    return LUDecomposition(l, u)
}
