package maps;

import tiles.ForestTile;
import tiles.SwampTile;
import tiles.Tile;
import tiles.WaterTile;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int r = rand.nextInt(3);
        return switch (r) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}