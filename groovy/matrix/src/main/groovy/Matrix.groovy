class Matrix {
    def rows
    def columns

    Matrix(String asString) {
        rows = asString
                .split(/\n/)
                .collect { it.split(/\s+/)*.toInteger() }
        columns = rows.transpose()
    }

    int[] row(int rowNumber) {
        rows[(rowNumber)] as int[]
    }

    int[] column(columnNumber) {
        columns[(columnNumber)]
    }
}
