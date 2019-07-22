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

    final private List<String> allergens

    Allergies(int score) {
        allergens = allergy.values().grep { it.code & score }*.name()
    }

    Boolean allergicTo(String substance) {
        allergens.contains(substance)
    }

    List<String> list() {
        allergens
    }
}