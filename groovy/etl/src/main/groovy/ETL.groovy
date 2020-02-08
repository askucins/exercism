import java.util.Map.Entry

class ETL {

    static Map transform(Map input) {
        //transformMine(input)
        transformMine2(input)
        //transformCommunity(input)
    }

    static Map transformMine(Map input) {
        input.inject([:]) { output, Entry weightForLetters ->
            String weight = weightForLetters.key
            List<String> letters = weightForLetters.value as List
            letters.each { letter ->
                output[letter.toString().toLowerCase()] = weight.toInteger()
            }
            output as Map
        }
    }

    static Map transformMine2(Map input) {
        input.inject([:]) { output, weight, letters ->
            letters.each { letter ->
                output[letter.toString().toLowerCase()] = weight.toInteger()
            }
            output as Map
        }
    }
    
    // Based on community solutions
    static Map transformCommunity(Map input) {
        input.collectEntries { score, letters ->
            letters.collectEntries { [(it.toString().toLowerCase()): score as Integer] }
        }
    }
}