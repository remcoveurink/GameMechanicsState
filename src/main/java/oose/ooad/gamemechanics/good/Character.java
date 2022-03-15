package oose.ooad.gamemechanics.good;


public class Character {
    private CharacterState state;

    public Character() {
        state = new GroundedCharacterState(this);
    }

    private void Update() {
        state.Update();
    }

    private void HandleInput(Input input) {
        state.HandleInput(input);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public static void main(String[] args) {
        Character character = new Character();
        character.Update();
        character.HandleInput(Input.PRESS_CTRL);
        character.Update();
        character.HandleInput(Input.RELEASE_CTRL);
        character.Update();
    }
}
