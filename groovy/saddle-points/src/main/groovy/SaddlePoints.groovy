class SaddlePoints {

    // There is a subtlety here. Without that *.toInteger it apparently somehow returns List<Long>???
    // Anyway either one needs to use
    // input.findIndexValues { val -> val >= maxValue }*.toInteger()
    // or make sure both peaks and valleys contain only Integer.
    // Without intersection was *always* empty

    static List<Integer> findAllPeaks(List<Integer> input) {
        Integer maxValue = input.max()
        input.findIndexValues { val -> val >= maxValue }*.toInteger()
    }

    static List<Integer> findAllValleys(List<Integer> input) {
        Integer minValue = input.min()
        input.findIndexValues { val -> val <= minValue }*.toInteger()
    }


    static getSaddlePoints(matrix) {
        if (matrix.size() == 0) {
            return []
        }

        def peaks = matrix.withIndex().sum([]) { hor, idx -> findAllPeaks(hor).collect { [idx, it] } }
        def valleys = matrix.transpose().withIndex().sum([]) { ver, idx -> findAllValleys(ver).collect { [it, idx] } }

        peaks.intersect(valleys)
    }
}