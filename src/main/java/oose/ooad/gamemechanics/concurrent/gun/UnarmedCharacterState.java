package oose.ooad.gamemechanics.concurrent.gun;

import oose.ooad.gamemechanics.concurrent.Character;
import oose.ooad.gamemechanics.concurrent.ICharacterState;
import oose.ooad.gamemechanics.concurrent.Input;

public class UnarmedCharacterState implements ICharacterState {
    private Character character;

    public UnarmedCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is unarmed");
    }

    @Override
    public void HandleInput(Input input) {
        if (input == Input.PRESS_L) {
            this.character.setGunState(new GrenadeLauncherCharacterState(character));
        } else if (input == Input.PRESS_R) {
            this.character.setGunState(new ArmedRifleCharacterState(character));
        } else if (input == Input.PRESS_G) {
            this.character.setGunState(new ArmedGunCharacterState(character));
        }
    }
}
