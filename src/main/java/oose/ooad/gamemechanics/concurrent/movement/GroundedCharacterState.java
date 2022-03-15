package oose.ooad.gamemechanics.concurrent.movement;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.CharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class GroundedCharacterState implements CharacterState {
    private Character character;

    public GroundedCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is grounded");
    }

    @Override
    public void HandleInput(Input input) {
        if (input == Input.PRESS_CTRL) {
            character.setMovementState(new DuckingCharacterState(character));
        } else if (input == Input.PRESS_SPACE) {
            character.setMovementState(new JumpingCharacterState(character));
        }
    }
}
