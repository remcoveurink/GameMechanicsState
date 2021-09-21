package oose.ooad.gamemechanics.good;

public class JumpingCharacterState implements ICharacterState {
    private Character character;

    public JumpingCharacterState(Character character) {
        this.character = character;
    }

    @Override
    public void Update() {
        System.out.println("Character is jumping");
        this.character.setState(new GroundedCharacterState(character));
    }

    @Override
    public void HandleInput(Input input) {
        System.out.println("Illegal input");
    }
}
