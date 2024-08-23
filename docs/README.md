# The Documentation of Simple Tetris

This is a simple tutorial for Java Tetris game. This game is created using Java FX.

## Architecture

This game is built using an original architecture. 

The structure of the game is as follows:

```plaintext
.
├── com
│   └── konekotech
│       └── tetris
│           ├── Main.java
│           ├── TetrisApp.java
│           ├── controllers
│           │   ├── Block.java
│           │   ├── Mino.java
│           │   └── TMino.java
│           └── ui
│               ├── Board.java
│               └── View.java
└── module-info.java

```
* `module-info.java` - The module descriptor file.
* `com.konekotech.tetris` - The main package of the game.
  * `Main.java` - The main class of the game.
  * `TetrisApp.java` - The application class of the game.
* `com.konekotech.tetris.engine` - The package that contains the user interface of the game.
  * `Board.java` - The board class of the game.
  * `View.java` - The view class of the game.
* `com.konekotech.tetris.components` - The package that contains the controllers of the game.
  * `Block.java` - The block class of the game.
  * `Mino.java` - The mino class of the game.
  * `TMino.java` - The T mino class of the game.
