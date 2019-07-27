class Matrix {
    def rows
    def columns

    Matrix(String asString) {
        rows = asString
                .split(/\n/)
                .collect { it.split(/\s+/).collect { it as int } }
        columns = rows.transpose()
    }

    int[] row(int rowNumber) {
        rows[(rowNumber)]
    }

    int[] column(int columnNumber) {
        columns[(columnNumber)]
    }
}
