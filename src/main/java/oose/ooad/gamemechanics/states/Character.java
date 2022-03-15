package oose.ooad.gamemechanics.states;

public class Character {
    private CharacterState state = CharacterState.GROUNDED;

    public void Update() {
        // Update the player depending on the private fields
        //E.G.
        switch (state) {
            case JUMPING:
                System.out.println("Character is jumping");
                state = CharacterState.GROUNDED;
                break;
            case GROUNDED:
                System.out.println("Character is grounded");
                break;
            case DUCKING:
                System.out.println("Character is ducking");
                break;
        }
    }

    public void HandleInput(Input input) {
        switch (input) {
            case PRESS_SPACE:
                if (state == CharacterState.GROUNDED) {
                    state = CharacterState.JUMPING;
                }
                break;
            case PRESS_CTRL:
                if (state == CharacterState.GROUNDED) {
                    state = CharacterState.DUCKING;
                }
                break;
            case RELEASE_CTRL:
                if (state == CharacterState.DUCKING) {
                    state = CharacterState.GROUNDED;
                }
                break;
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
