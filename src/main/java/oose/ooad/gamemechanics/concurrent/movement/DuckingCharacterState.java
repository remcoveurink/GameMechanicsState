package oose.ooad.gamemechanics.concurrent.movement;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.ICharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class DuckingCharacterState implements ICharacterState {
    private Character character;

    public DuckingCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is ducking");
    }

    @Override
    public void HandleInput(Input input) {
        if (input == Input.RELEASE_CTRL) {
            this.character.setMovementState(new GroundedCharacterState(character));
        }
    }
}
