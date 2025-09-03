package states;

import character.*;

public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You trained and gained 25 XP!");
        character.gainExperience(25);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditated and restored 10 HP!");
        character.gainHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("❌ Cannot fight at Intermediate level!");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}
