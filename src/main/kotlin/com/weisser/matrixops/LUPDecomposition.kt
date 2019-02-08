package com.weisser.matrixops

import kotlin.math.abs

data class LUPDecomposition(var l: Matrix<Double>, var u: Matrix<Double>, var p: Matrix<Double>, var pi: Pi)

class SingularMatrixException : Exception("Singular Matrix Exception")

// TODO Isn't this the same as an Int Vector?
// TODO So create IntVector class and let it implement our Vector interface.
class Pi(dimension: Int) {
    private var values = IntArray(dimension)

    operator fun set(index: Int, value: Int) {
        values[index - 1] = value
    }

    operator fun get(index: Int) : Int {
        return values[index - 1]
    }
}

/**
 * In-Place LUP decomposition.
 * See "Introduction to Algorithms" page 752.
 *
 * Remember that the original matrix gets modified!
 * Since it it passed by reference, it also changes for the caller.
 */
fun lupDecomposition(a: Matrix<Double>) : LUPDecomposition {
    val pivotEpsilon = 0.0001
    val n = a.dim()
    val l = a.create(n)
    val u = a.create(n)
    val p = a.create(n)
    val pi = Pi(n)

    for (i in 1 .. n) {
        pi[i] = i
    }

    for (k in 1 .. n) {
        var pivot = 0.0
        var k1 = 0

        for (i in k .. n) {
            if (abs(a[i, k]) > pivot) {
                pivot = abs(a[i, k])
                k1 = i
            }
        }

        if (pivot < pivotEpsilon) {
            throw SingularMatrixException()
        }

        // swap pi[k] <-> pi[k1]
        pi[k] = pi[k1].also {
            pi[k1] = pi[k]
        }

        for (i in 1 .. n) {
            // swap a[k,i] <-> a[k1,i]
            a[k, i] = a[k1, i].also {
                a[k1, i] = a[k, i]
            }
        }

        for (i in k + 1 .. n) {
            a[i, k] = a[i, k] / a[k, k]
            for (j in k + 1 .. n) {
                a[i, j] = a[i, j] - a[i, k] * a[k, j]
            }
        }

    }

    // TODO This step is optional... move it to separate functions
    // Transfer the in-place result to separate matrices l, u (for debugging)
    for (i in 1 .. n) {
        for (j in 1 .. n) {
            if (i > j) {
                l[i, j] = a[i, j]
            } else {
                u[i, j] = a[i, j]
            }
        }
        l[i, i] = 1.0
    }

    // Transfer the in-place result to separate matrix p (for debugging)
    for (i in 1 .. n) {
        val j = pi[i]
        p[i, j] = 1.0
    }

    return LUPDecomposition(l, u, p, pi)
}
