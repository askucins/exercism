import spock.lang.Specification
import spock.lang.Unroll

import static Triangle.*

class TriangleSpec extends Specification {

    def "All sides are equal for equilateral"() {
        expect:
        isEquilateral(a, b, c) == expected

        where:
        a | b | c || expected
        2 | 2 | 2 || true
    }

    def "Any side is unequal"() {
        expect:
        isEquilateral(a, b, c) == expected

        where:
        a | b | c || expected
        2 | 3 | 2 || false
    }

    def "No sides are equal for equilateral"() {
        expect:
        isEquilateral(a, b, c) == expected

        where:
        a | b | c || expected
        5 | 4 | 6 || false
    }

    def "All zero sides is not a triangle"() {
        expect:
        isEquilateral(a, b, c) == expected

        where:
        a | b | c || expected
        0 | 0 | 0 || false
    }

    def "Sides may be floats for equilateral"() {
        expect:
        isEquilateral(a, b, c) == expected

        where:
        a   | b   | c   || expected
        0.5 | 0.5 | 0.5 || true
    }

    def "Last two sides are equal"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        3 | 4 | 4 || true
    }

    def "First two sides are equal"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        4 | 4 | 3 || true
    }

    def "First and last sides are equal"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        4 | 3 | 4 || true
    }

    def "Equilateral triangles are also isosceles"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        4 | 4 | 4 || true
    }

    def "No sides are equal for isosceles"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        2 | 3 | 4 || false
    }

    def "First triangle inequality violation"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        1 | 1 | 3 || false
    }

    def "Second triangle inequality violation"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        1 | 3 | 1 || false
    }

    def "Third triangle inequality violation"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a | b | c || expected
        3 | 1 | 1 || false
    }

    def "Sides may be floats for isosceles"() {
        expect:
        isIsosceles(a, b, c) == expected

        where:
        a   | b   | c   || expected
        0.5 | 0.4 | 0.5 || true
    }

    def "No sides are equal for scalene"() {
        expect:
        isScalene(a, b, c) == expected

        where:
        a | b | c || expected
        5 | 4 | 6 || true
    }

    def "All sides are equal for scalene"() {
        expect:
        isScalene(a, b, c) == expected

        where:
        a | b | c || expected
        4 | 4 | 4 || false
    }

    def "Two sides are equal"() {
        expect:
        isScalene(a, b, c) == expected

        where:
        a | b | c || expected
        4 | 4 | 3 || false
    }

    def "May not violate triangle inequality"() {
        expect:
        isScalene(a, b, c) == expected

        where:
        a | b | c || expected
        7 | 3 | 2 || false
    }

    def "Sides may be floats for scalene"() {
        expect:
        isScalene(a, b, c) == expected

        where:
        a   | b   | c   || expected
        0.5 | 0.4 | 0.6 || true
    }

    @Unroll
    def "All sides must be non-zero, so do (#a, #b, #c) make a triangle? #expected"() {
        expect:
        isTriangle(a, b, c) == expected

        where:
        a    | b   | c   || expected
        1.0  | 1.0 | 1.0 || true
        1.0  | 1.0 | 0.0 || false
        1.0  | 0.0 | 0.0 || false
        0.0  | 0.0 | 0.0 || false
        -1.0 | 5.0 | 6.0 || false

    }
}
