class Allergies {
    enum allergy {
        eggs(1),
        peanuts(2),
        shellfish(4),
        strawberries(8),
        tomatoes(16),
        chocolate(32),
        pollen(64),
        cats(128)

        private Integer code

        private allergy(Integer code) {
            this.code = code
        }
    }
    private Integer score

    Allergies(int score) { this.score = score }

    Boolean allergicTo(String substance) {
        allergy.valueOf(substance).code & score
    }

    List<String> list() {
        allergy.values().grep { it.code & score }*.name()
    }
}