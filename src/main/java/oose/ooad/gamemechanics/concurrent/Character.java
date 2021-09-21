package oose.ooad.gamemechanics.concurrent;


import oose.ooad.gamemechanics.concurrent.gun.UnarmedCharacterState;
import oose.ooad.gamemechanics.concurrent.movement.GroundedCharacterState;

public class Character {
    private ICharacterState movementState;
    private ICharacterState gunState;

    public Character() {
        this.movementState = new GroundedCharacterState(this);
        this.gunState = new UnarmedCharacterState(this);
    }

    private void Update() {
        movementState.Update();
        gunState.Update();
    }

    private void HandleInput(Input input) {
        movementState.HandleInput(input);
        gunState.HandleInput(input);
    }

    public void setMovementState(ICharacterState state) {
        this.movementState = state;
    }

    public void setGunState(ICharacterState state) {
        this.gunState = state;
    }

    public static void main(String[] args) {
        Character character = new Character();
        character.Update();
        character.HandleInput(Input.PRESS_CTRL);
        character.Update();
        character.HandleInput(Input.RELEASE_CTRL);
        character.Update();
        character.HandleInput(Input.PRESS_L);
        character.Update();
        character.HandleInput(Input.PRESS_MOUSE_LEFT);
        character.Update();
        character.HandleInput(Input.RELEASE_MOUSE_LEFT);
        character.Update();
    }
}
