package com.weisser.matrixops

fun main() {
    println("LU Decomposition: ")

    val a = DoubleMatrix.of(
        2, 3, 1, 5,
        6, 13, 5, 19,
        2, 19, 10, 23,
        4, 10, 11, 31
    )

    val lu = luDecomposition(a)
    println("Original Matrix A[][]")
    a.print()
    println("---")
    println("Lower triangular matrix L[][]")
    lu.l.print()
    println("---")
    println("Upper triangular matrix U[][]")
    lu.u.print()

    // LUP Decomposition
    val b = DoubleMatrix.of(
        2.0, 0.0, 2.0, 0.6,
        3.0, 3.0, 4.0, -2.0,
        5.0, 5.0, 4.0, 2.0,
        -1.0, -2.0, 3.4, -1.0
    )
    println("LUP Decomposition")
    val lup = lupDecomposition(b)
    println("Permutation vector p[]")
    lup.p.print()
    println("---")
    println("Lower triangular matrix L[][]")
    lup.l.print()
    println("---")
    println("Upper triangular matrix U[][]")
    lup.u.print()
    println("---")

    println("LUP Solve")
    val b1 = DoubleVector.of(1.0, 2.0, 3.0, 4.0)

    val x = lupSolve(lup.l, lup.u, lup.pi, b1)
    println("Solution vector x[]")
    x.print()

    println("Matrix Inversion")
    val inverse = inverse(b)
    inverse.print()
}
