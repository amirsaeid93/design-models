package states;

import character.*;

public class NoviceState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You trained hard and gained 20 XP!");
        character.gainExperience(20);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("❌ Cannot meditate at Novice level!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("❌ Cannot fight at Novice level!");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}