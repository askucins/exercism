import java.util.Map.Entry

class ETL {

    static Map transform(Map input) {
        input.inject([:]) { output, Entry weightForLetters ->
            String weight = weightForLetters.key
            List<String> letters = weightForLetters.value as List
            letters.each { letter ->
                output[letter.toString().toLowerCase()] = weight.toInteger()
            }
            output as Map
        }
    }
}