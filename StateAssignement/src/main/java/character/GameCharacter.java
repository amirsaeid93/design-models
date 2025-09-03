package character;

import states.*;

public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // start as novice
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void gainExperience(int points) {
        experience += points;
        checkLevelUp();
    }

    public void loseHealth(int points) {
        health -= points;
        if (health < 0) health = 0;
    }

    public void gainHealth(int points) {
        health += points;
        if (health > 100) health = 100;
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    private void checkLevelUp() {
        if (experience >= 100 && state instanceof NoviceState) {
            System.out.println("🌟 Level up! Reached Intermediate.");
            setState(new IntermediateState());
        } else if (experience >= 250 && state instanceof IntermediateState) {
            System.out.println("🌟 Level up! Reached Expert.");
            setState(new ExpertState());
        } else if (experience >= 500 && state instanceof ExpertState) {
            System.out.println("🌟 Level up! Reached Master!");
            setState(new MasterState());
        }
    }

    public String getStatus() {
        return String.format("Name: %s | Level: %s | XP: %d | HP: %d",
                name, state.getLevelName(), experience, health);
    }

    public CharacterState getState() {
        return state;
    }
}