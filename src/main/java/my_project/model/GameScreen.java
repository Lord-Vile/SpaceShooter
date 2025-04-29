package my_project.model;


/*
public class GameScreen implements Screen {
    private final SpaceShooterGame game;
    private Texture background;
    private SpriteBatch batch;

    public GameScreen(SpaceShooterGame game) {
        this.game = game;
        this.background = game.backgrounds[game.selectedBackgroundIndex];
        this.batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new LobbyScreen(game));
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {
        batch.dispose();
        // background not disposed here, as managed by SpaceShooterGame
    }
}

 */