package com.weisser.matrixops

fun multiplyMatrices(a: Matrix<Double>, b: Matrix<Double>) : Matrix<Double> {
    assert(a.dim() == b.dim())
    assert(a.dim() >= 1)

    val dim = a.dim()
    val c = a.create(dim)

    for (i in 1 .. dim) {
        for (j in 1 .. dim) {
            var sum = 0.0
            for (k in 1 .. dim) {
                sum += a[i, k] * b[k, j]
            }
            c[i, j] = sum
        }
    }

    return c
}