class Triangle {

    static boolean isTriangle(Number a, Number b, Number c) {
        [a, b, c].every { it > 0 } &&
                (a + b > c) &&
                (b + c > a) &&
                (c + a > b)
    }

    static boolean isEquilateral(Number a, Number b, Number c) {
        isTriangle(a, b, c) && a == b && b == c
    }

    static boolean isIsosceles(Number a, Number b, Number c) {
        isTriangle(a, b, c) && (a == b || b == c || c == a)
    }

    static boolean isScalene(Number a, Number b, Number c) {
        isTriangle(a, b, c) && (a != b && b != c && c != a)
    }

}
