/*
    North American Numbering Plan
    - international country code: 1
    - 10 digits (so 11 with the country code)
    - 3 digits of Numbering Plan Area code (aka 'area code')
    - 7 digits of local number
    - first 3 digits of the local number are the 'exchange code'
    - remaining 4 digit number is the 'subscriber number'
    - typical format: (NXX)-NXX-XXXX
    - where N is from 2..9, X is from 0..9

    Assumptions:
    - should remove punctuation (parens, points, dashes)
    - only country code 1 is supported (remove it if present): 1, +1, 001
 */

class PhoneNumber {
    String number
    String areaCode
    private String exchangeCode
    private String subscriberCode

    PhoneNumber(String input) {
        number = clean(input)
        areaCode = number.take(3)
        exchangeCode = number.drop(3).take(3)
        subscriberCode = number.drop(6).take(4)
    }

    @Override
    String toString() {
        "(${areaCode}) ${exchangeCode}-${subscriberCode}"
    }

    static String clean(String input) {
        String number = input.replaceAll(/[^0-9]/, '')
        if (number.size() < 10) {
            throw new Exception()
        }
        if (number.size() > 11) {
            throw new Exception()
        }
        if (number.size() == 11 && number[0] != '1') {
            throw new Exception()
        }
        if (number.size() == 11 && number[0] == '1') {
            number = number.drop(1)
        }
        if (['0', '1'].contains(number[0]) || ['0', '1'].contains(number[3])) {
            throw new Exception()
        }
        return number
    }

}
