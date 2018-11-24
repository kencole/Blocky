package game;

public class World {
	
	public Block[][][] blocks;
	
	public World() {
		
	}
	
	public World(int x, int y, int z) {
		this();
		blocks = new Block[x][y][z];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					blocks[i][j][k] = new Block(k == 0 ? Block.Type.GROUND : Block.Type.AIR, i, j, k);
				}
			}
		}
	}
	

}
