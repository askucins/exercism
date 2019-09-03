class SpecsFactory {
    //Not used, just an example of anonymous classes
    static Collection specs() {
        [{
             encoder:
             {
                 new RunLengthEncodingMine()
             }
         } as RunLengthEncodingSpec,
         {
             encoder:
             {
                 new RunLengthEncodingByAmscotti()
             }
         } as RunLengthEncodingSpec,
        ]
    }

    // Both used in a test suite

    static class RunEncMineSpec extends RunLengthEncodingSpec {
        RunLengthEncoding encoder() {
            new RunLengthEncodingMine()
        }
    }

    static class RunEncByAmscottiSpec extends RunLengthEncodingSpec {
        RunLengthEncoding encoder() {
            new RunLengthEncodingByAmscotti()
        }
    }
}