class SaddlePoints {

    static List<Integer> peaks(List<Integer> input) {
        Integer peakValue = input.max()
        input.withIndex().grep { value, idx -> value >= peakValue }.collect { val, idx -> idx }
    }

    static List<Integer> valleys(List<Integer> input) {
        Integer valleyValue = input.min()
        input.withIndex().grep { value, idx -> value <= valleyValue }.collect { val, idx -> idx }
    }


    static getSaddlePoints(matrix) {
        if (matrix.size() == 0) {
            return []
        }
        Integer vertical = matrix.size()
        Integer horizontal = matrix.collect { it.size() }.max()
        assert vertical > 0 && horizontal > 0

        def _peaks = matrix.withIndex().sum([]) { hor, idx -> peaks(hor).collect { [idx, it] } }
        def _valleys = matrix.transpose().withIndex().sum([]) { ver, idx -> valleys(ver).collect { [it, idx] } }
        println "P: $_peaks"
        println "V: $_valleys"
        _peaks.intersect(_valleys)
    }
}