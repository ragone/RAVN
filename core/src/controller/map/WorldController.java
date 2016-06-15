package controller.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import model.map.WorldMap;
import model.map.WorldTile;
import utils.SimplexNoise;
import view.map.WorldView;

public class WorldController {
    private final WorldView view;
    private final WorldMap worldMap;
    private int mod = 1;

    private double[][] heightMap = SimplexNoise.generateOctavedSimplexNoise(WorldMap.SIZE, WorldMap.SIZE, 3, 0.4f, 0.005f);

    public WorldController(WorldView view) {
        this.view = view;

        worldMap = new WorldMap();
        MapLayers layers = worldMap.getLayers();

        TiledMapTileLayer layer = new TiledMapTileLayer(WorldMap.SIZE, WorldMap.SIZE, 32, 32);

        for(int x = 0; x < WorldMap.SIZE; x++) {
            for(int y = 0; y < WorldMap.SIZE; y++) {
                TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
                float alpha = (float) heightMap[x][y];
                Sprite sprite = new Sprite(new Texture(Gdx.files.internal("white.png")), 32, 32);
                sprite.setColor(new Color(1,0,0,1));
                WorldTile tile = new WorldTile(sprite);
                cell.setTile(tile);
                layer.setCell(x, y, cell);
            }
        }

       layers.add(layer);
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }
}
