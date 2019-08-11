class SaddlePoints {

    static List<Integer> findAllPeaks(List<Integer> input) {
        Integer maxValue = input.max()
        //input.withIndex().grep { value, idx -> value >= maxValue }.collect { val, idx -> idx }
        input.findIndexValues { val -> val >= maxValue }*.toInteger() // Number vs Integer trap
    }

    static List<Integer> findAllValleys(List<Integer> input) {
        Integer minValue = input.min()
        //input.withIndex().grep { value, idx -> value <= minValue }.collect { val, idx -> idx }
        input.findIndexValues { val -> val <= minValue }*.toInteger() // Number vs Integer trap
    }


    static getSaddlePoints(matrix) {
        if (matrix.size() == 0) {
            return []
        }

        def peaks = matrix.withIndex().sum([]) { hor, idx -> findAllPeaks(hor).collect { [idx, it] } }
        def valleys = matrix.transpose().withIndex().sum([]) { ver, idx -> findAllValleys(ver).collect { [it, idx] } }
        println "P: $peaks"
        println "V: $valleys"

        // This seems to be tricky if one falls in that Number vs Integer trap!
        // It doesn't work for List<Number> somehow or so... weird...
        peaks.intersect(valleys)
    }
}