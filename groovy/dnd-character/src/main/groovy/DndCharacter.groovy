class DndCharacter {

    private static Random random = new Random()

    private static Integer rollDice() {
        random.nextInt(6) + 1
    }

    private static Integer initializeAbility() {
        (1..4)
            .collect { rollDice() }
            .sort()
            .reverse()
            .take(3)
            .sum()
    }

    // abilities
    Integer strength
    Integer dexterity
    Integer constitution
    Integer intelligence
    Integer wisdom
    Integer charisma

    // character
    Integer hitpoints

    Integer ability() {
        [strength, dexterity, constitution, intelligence, wisdom, charisma][rollDice() - 1]
    }

    Integer modifier(Integer ability) {
        Math.floor((ability - 10) / 2).toInteger()
    }

    DndCharacter() {
        strength = initializeAbility()
        dexterity = initializeAbility()
        constitution = initializeAbility()
        intelligence = initializeAbility()
        wisdom = initializeAbility()
        charisma = initializeAbility()

        hitpoints = 10 + modifier(constitution)
    }
}
