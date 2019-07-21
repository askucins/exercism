class Series {

    static slices(String series, Integer sliceLength) {
        if (sliceLength < 1) {
            throw new ArithmeticException()
        }
        def upperLimit = series.length() - sliceLength
        if (upperLimit < 0) {
            throw new ArithmeticException()
        }
        // Original
        //(0..upperLimit).collect { series.substring(it, it + sliceLength) }
        // Based on community solutions:
        series.toList().collate(sliceLength, 1, false)*.join('')
    }
}