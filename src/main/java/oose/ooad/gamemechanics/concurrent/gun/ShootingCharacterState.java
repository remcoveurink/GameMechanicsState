package oose.ooad.gamemechanics.concurrent.gun;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.CharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class ShootingCharacterState implements CharacterState {
    private Character character;
    private CharacterState origin;

    public ShootingCharacterState(Character character, CharacterState origin) {
        this.character = character;
        this.origin = origin;
    }

    @Override
    public void Update() {
        System.out.println("Character is shooting with: "
                + origin.getClass().getSimpleName().replace("CharacterState", ""));
    }

    @Override
    public void HandleInput(Input input) {
        if (input == Input.RELEASE_MOUSE_LEFT) {
            this.character.setGunState(origin);
        }
    }
}
