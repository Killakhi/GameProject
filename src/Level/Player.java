package Level;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Utils.Direction;
import java.awt.Color;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected float speedUp = 2;
    protected int interactionRange = 1;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction upDown;
    protected Direction lastMovementDirection;

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.LEFT;
    protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    protected Key MOVE_UP_KEY = Key.UP;
    protected Key MOVE_DOWN_KEY = Key.DOWN;
    protected Key INTERACT_KEY = Key.SPACE;
    protected Key SPEED_UP_KEY = Key.SHIFT;

    protected boolean isLocked = false;
    public Object intersects;

    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        upDown = Direction.DOWN;

        
        previousPlayerState = playerState;
        this.affectedByTriggers = true;
    }

    public void update() {
        if (!isLocked) {
            moveAmountX = 0;
            moveAmountY = 0;

            // if player is currently playing through level (has not won or lost)
            // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
            do {
                previousPlayerState = playerState;
                handlePlayerState();
            } while (previousPlayerState != playerState);

            // move player with respect to map collisions based on how much player needs to move this frame
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
        }

        if (Keyboard.isKeyDown(Key.Z) && this.healthBar != null) {
            this.healthBar.damage(4);
        }

        handlePlayerAnimation();

        updateLockedKeys();

        // update player's animation
        super.update();
    }

    // based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                break;
            case WALKING:
                playerWalking();
                break;
        }
    }

    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
        }
    }



    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
            
        if(Keyboard.isKeyDown(SPEED_UP_KEY)){
        
        moveAmountX -= walkSpeed+2;
        facingDirection = Direction.LEFT;
        currentWalkingXDirection = Direction.LEFT;
        lastWalkingXDirection = Direction.LEFT;
        }
        else {

        moveAmountX -= walkSpeed;
        facingDirection = Direction.LEFT;
        currentWalkingXDirection = Direction.LEFT;
        lastWalkingXDirection = Direction.LEFT;
        }
    }

        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {

        if(Keyboard.isKeyDown(SPEED_UP_KEY)){
        
            moveAmountX += walkSpeed+2;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;  
            }
        else {
        
                moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
                }
        }

        else {
            currentWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyDown(MOVE_UP_KEY)) {
        
            if(Keyboard.isKeyDown(SPEED_UP_KEY)){
        
                moveAmountY -= walkSpeed+2;
                currentWalkingYDirection = Direction.UP;
                lastWalkingYDirection = Direction.UP;
                facingDirection = Direction.UP;
                }
                else {
        
                    moveAmountY -= walkSpeed;
                    currentWalkingYDirection = Direction.UP;
                    lastWalkingYDirection = Direction.UP;
                    facingDirection = Direction.UP;
                }
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)) {

            if(Keyboard.isKeyDown(SPEED_UP_KEY)){
        
                moveAmountY += walkSpeed+2;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
            facingDirection = Direction.DOWN;
                }
                else {
        
                    moveAmountY += walkSpeed;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
            facingDirection = Direction.DOWN;
                }
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }


        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)) {
            playerState = PlayerState.STANDING;
        }
    }

    protected void playerSpeedingupUpdirection(){
        if(Keyboard.isKeyDown(MOVE_UP_KEY) && (!keyLocker.isKeyLocked(SPEED_UP_KEY) && Keyboard.isKeyDown(SPEED_UP_KEY))){
            moveAmountY -= walkSpeed+2;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
            facingDirection = Direction.UP;
        }
    }

    protected void playerSpeedingupDowndirection() {
        if(Keyboard.isKeyDown(MOVE_DOWN_KEY) && (!keyLocker.isKeyLocked(SPEED_UP_KEY) && Keyboard.isKeyDown(SPEED_UP_KEY))) {
            moveAmountY += walkSpeed+2;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
            facingDirection = Direction.DOWN;
    }
}

    protected void playerSpeedingupRightdirection(){
        if(Keyboard.isKeyDown(MOVE_RIGHT_KEY) && (!keyLocker.isKeyLocked(SPEED_UP_KEY) && Keyboard.isKeyDown(SPEED_UP_KEY)))
            moveAmountX += walkSpeed+2;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;   
    }

    protected void playerSpeedingupLeftdirection(){
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) && (!keyLocker.isKeyLocked(SPEED_UP_KEY) && Keyboard.isKeyDown(SPEED_UP_KEY))) {
            moveAmountX -= walkSpeed+2;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }

    }

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && !isLocked) {
            keyLocker.unlockKey(INTERACT_KEY);
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            switch (facingDirection) {
                case DOWN:
                    this.currentAnimationName = "STAND_DOWN";
                    break;
                case LEFT:
                    this.currentAnimationName = "STAND_LEFT";
                    break;
                case RIGHT:
                    this.currentAnimationName = "STAND_RIGHT";
                    break;
                case UP:
                    this.currentAnimationName = "STAND_UP";
                    break;
                case NONE:
                    this.currentAnimationName = "STAND_DOWN";
                    break;
            }
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            switch (facingDirection) {
                case DOWN:
                    this.currentAnimationName = "WALK_DOWN";
                    break;
                case LEFT:
                    this.currentAnimationName = "WALK_LEFT";
                    break;
                case RIGHT:
                    this.currentAnimationName = "WALK_RIGHT";
                    break;
                case UP:
                    this.currentAnimationName = "WALK_UP";
                    break;
                case NONE:
                    this.currentAnimationName = "WALK_DOWN";
                    break;
            }
        }
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, GameObject entityCollidedWith) { }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 2),
                getBounds().getHeight() + (interactionRange * 2));
    }

    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    
    public void lock() {
        isLocked = true;
        playerState = PlayerState.STANDING;
        this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
    }

    public void unlock() {
        isLocked = false;
        playerState = PlayerState.STANDING;
        this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
    }

    // used by other files or scripts to force player to stand
    public void stand(Direction direction) {
        playerState = PlayerState.STANDING;
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
        
    }

    // used by other files or scripts to force player to walk
    public void walk(Direction direction, float speed) {
        playerState = PlayerState.WALKING;
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }

       else if (direction == Direction.UP) {
            this.currentAnimationName = "WALK_UP";
            moveY(speed);
        }
        else if (direction == Direction.DOWN) {
            this.currentAnimationName = "WALK_DOWN";
            moveY(-speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }

    /* 
        else if (direction == Direction.DOWN) {
            moveY(-speed);
        }
        else if (direction == Direction.UP) {
            moveY(speed);
        }
            */
    }

    // Uncomment this to have game draw player's bounds to make it easier to visualize

    /*public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
    }*/
    
}
