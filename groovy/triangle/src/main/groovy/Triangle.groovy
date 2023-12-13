import groovy.transform.Canonical

@Canonical
class Triangle {

    Number a, b, c

    boolean isTriangle() {
        isTriangle(a, b, c)
    }

    boolean isEquilateral() {
        isEquilateral(a, b, c)
    }

    boolean isIsosceles() {
        isIsosceles(a, b, c)
    }

    boolean isScalene() {
        isScalene(a, b, c)
    }

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
