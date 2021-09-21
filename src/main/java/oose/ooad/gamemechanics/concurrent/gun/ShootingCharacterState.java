package oose.ooad.gamemechanics.concurrent.gun;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.ICharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class ShootingCharacterState implements ICharacterState {
    private Character character;
    private ICharacterState origin;

    public ShootingCharacterState(Character character, ICharacterState origin) {
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
