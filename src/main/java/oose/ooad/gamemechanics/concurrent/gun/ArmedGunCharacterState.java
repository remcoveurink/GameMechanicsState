package oose.ooad.gamemechanics.concurrent.gun;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.ICharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class ArmedGunCharacterState implements ICharacterState {
    private Character character;

    public ArmedGunCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is holding a gun");
    }

    @Override
    public void HandleInput(Input input) {
        if (input == Input.PRESS_MOUSE_LEFT) {
            this.character.setGunState(new ShootingCharacterState(character, this));
        } else if (input == Input.PRESS_L) {
            this.character.setGunState(new GrenadeLauncherCharacterState(character));
        } else if (input == Input.PRESS_R) {
            this.character.setGunState(new ArmedRifleCharacterState(character));
        } else if (input == Input.PRESS_U) {
            this.character.setGunState(new UnarmedCharacterState(character));
        }
    }
}
