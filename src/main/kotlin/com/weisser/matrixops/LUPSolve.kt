package com.weisser.matrixops

fun lupSolve(l: Matrix<Double>, u: Matrix<Double>, pi: Pi, b: Vector<Double>) : DoubleVector {
    val n = l.dim()
    val y = DoubleVector(n)
    val x = DoubleVector(n)

    fun sum1(i: Int) : Double {
        var result = 0.0

        for (j in 1 until i) {
            result += l[i, j] * y[j]
        }

        return result
    }

    fun sum2(i: Int) : Double {
        var result = 0.0

        for (j in i + 1 .. n) {
            result += u[i, j] * x[j]
        }

        return result
    }

    for (i in 1 .. n) {
        val i1 = pi[i]
        y[i] = b[i1] - sum1(i)
    }

    for (i in n downTo 1) {
        val z = (y[i] - sum2(i)) / u[i, i]
        x[i] = z
    }

    return x
}
