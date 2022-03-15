package oose.ooad.gamemechanics.good;

public class DuckingCharacterState implements CharacterState {
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
            this.character.setState(new GroundedCharacterState(character));
        } else {
            System.out.println("Illegal input");
        }
    }
}
