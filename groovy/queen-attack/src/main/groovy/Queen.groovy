class Queen {

    Integer row
    Integer column

    Queen(int row, int column) {
        if (row < 0 || column < 0 || row > 7 || column > 7) {
            throw new Exception()
        } else {
            this.row = row
            this.column = column
        }
    }
}
