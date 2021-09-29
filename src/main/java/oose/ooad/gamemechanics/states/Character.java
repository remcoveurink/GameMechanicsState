package oose.ooad.gamemechanics.states;

public class Character {
    private CharacterState state;

    public void Update()
    {
        // Update the player depending on the private fields
        //E.G.
        if (state == CharacterState.JUMPING) {
            System.out.println("Character is jumping");
            state = CharacterState.GROUNDED;
        } else if (state == CharacterState.GROUNDED) {
            System.out.println("Character is grounded");
        } else if (state == CharacterState.DUCKING) {
            System.out.println("Character is ducking");
        }
    }

    public void HandleInput(Input input)
    {
        if (input == Input.PRESS_SPACE) {
            if (state == CharacterState.GROUNDED) {
                state = CharacterState.JUMPING;
            }
        } else if (input == Input.PRESS_CTRL) {
            if (state == CharacterState.GROUNDED) {
                state = CharacterState.DUCKING;
            }
        } else if (input == Input.RELEASE_CTRL) {
            if (state == CharacterState.DUCKING) {
                state = CharacterState.GROUNDED;
            }
        }
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
