package oose.ooad.gamemechanics.good;

public class GroundedCharacterState implements ICharacterState {
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
            character.setState(new DuckingCharacterState(character));
        } else if (input == Input.PRESS_SPACE) {
            character.setState(new JumpingCharacterState(character));
        } else {
            System.out.println("Illegal input");
        }
    }
}
