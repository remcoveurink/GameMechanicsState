package oose.ooad.gamemechanics.concurrent.movement;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.CharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class JumpingCharacterState implements CharacterState {
    private Character character;

    public JumpingCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is jumping");
        this.character.setMovementState(new GroundedCharacterState(character));
    }

    @Override
    public void HandleInput(Input input) {}
}
