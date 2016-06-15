//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import controller.map.OrthoCamController;
//import controller.map.WorldController;
//import view.map.WorldRenderer;
//
///**
// * TODO: Description of GameScreen.
// *
// * @author ragone.
// * @version 15/06/16
// */
//public class GameScreen implements Screen {
//    private final MainGame game;
//
//    public GameScreen(MainGame game) {
//        this.game = game;
//
//        controller = new WorldController(this);
//        map = controller.getWorldMap();
//        font = new BitmapFont();
//        batch = new SpriteBatch();
//
//        setupCamera();
//
//        renderer = new WorldRenderer(controller.getWorldMap());
//    }
//
//
//    public void setupCamera() {
//        float w = Gdx.graphics.getWidth();
//        float h = Gdx.graphics.getHeight();
//
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, (w / h) * 512, 512);
//        camera.update();
//
//        cameraController = new OrthoCamController(camera);
//        Gdx.input.setInputProcessor(cameraController);
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void render () {
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        camera.update();
//        renderer.setView(camera);
//        renderer.render();
//        batch.enableBlending();
//        batch.begin();
//        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
//        batch.end();
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}
