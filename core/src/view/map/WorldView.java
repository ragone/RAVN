package view.map;

import controller.map.OrthoCamController;
import controller.map.WorldController;
import model.map.WorldMap;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import utils.SimplexNoise;

public class WorldView implements ApplicationListener {

    private WorldController controller;

	private WorldRenderer renderer;
	private OrthographicCamera camera;
	private OrthoCamController cameraController;
	private BitmapFont font;
	private SpriteBatch batch;
    private WorldMap map;

    public void create () {
        controller = new WorldController(this);
        map = controller.getWorldMap();
        font = new BitmapFont();
        batch = new SpriteBatch();

		setupCamera();

		renderer = new WorldRenderer(controller.getWorldMap());
	}

    public void setupCamera() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, (w / h) * 512, 512);
        camera.update();

        cameraController = new OrthoCamController(camera);
        Gdx.input.setInputProcessor(cameraController);
    }

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		renderer.setView(camera);
		renderer.render();
		batch.enableBlending();
		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}