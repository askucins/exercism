// Based on https://exercism.io/tracks/groovy/exercises/run-length-encoding/solutions/cf0a7fe8968948d08e50eb34755793c3
class RunLengthEncodingByAmscotti implements RunLengthEncoding {

    String encode(String input) {
        input.replaceAll(/(\D)\1+/) { group, letter -> "${group.length()}${letter}" }
    }

    String decode(String input) {
        input.replaceAll(/(\d+)(\D)/) { _, count, letter -> letter * (count as int) }
    }
}
