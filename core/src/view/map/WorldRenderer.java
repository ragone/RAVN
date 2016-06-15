package view.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class WorldRenderer extends OrthogonalTiledMapRenderer {
    public WorldRenderer(TiledMap map) {
        super(map);
    }

    public Batch getSpriteBatch() {
        return batch;
    }
}
