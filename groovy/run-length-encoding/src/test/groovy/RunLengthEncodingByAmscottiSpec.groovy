class RunLengthEncodingByAmscottiSpec extends RunLengthEncodingSpec {
    def setupSpec() {
        runLengthEncoder = new RunLengthEncodingByAmscotti()
        println "Encoder (inside): ${runLengthEncoder.class.toString()}"
    }
}