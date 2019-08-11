class RunLengthEncodingMineSpec extends RunLengthEncodingSpec {
    def setupSpec() {
        runLengthEncoder = new RunLengthEncodingMine()
        println "Encoder (inside): ${runLengthEncoder.class.toString()}"
    }
}