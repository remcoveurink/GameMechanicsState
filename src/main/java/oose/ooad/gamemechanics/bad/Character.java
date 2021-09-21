package oose.ooad.gamemechanics.bad;

public class Character {
    private boolean isGrounded = true;
    private boolean isDucking;
    private boolean isJumping;

    public void Update()
    {
        // Update the player depending on the private fields
        //E.G.
        if (this.isJumping) {
            System.out.println("Character is jumping");
            this.isJumping = false;
            this.isGrounded = true;
        } else if (this.isGrounded) {
            System.out.println("Character is grounded");
        } else if (this.isDucking) {
            System.out.println("Character is ducking");
        }
    }

    public void HandleInput(Input input)
    {
        if (input == Input.PRESS_SPACE) {
            if (this.isGrounded && !this.isDucking) {
                this.isJumping = true;
                this.isGrounded = false;
            }
        } else if (input == Input.PRESS_CTRL) {
            if (this.isGrounded) {
                this.isDucking = true;
                this.isGrounded = false;
            }
        } else if (input == Input.RELEASE_CTRL) {
            if (this.isDucking) {
                this.isGrounded = true;
                this.isDucking = false;
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
