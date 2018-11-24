package game;

public class World {
	
	public Block[][][] blocks;
	
	public World() {
		int x = 32; 
		int y = 32;
		int z = 32;
		blocks = new Block[x][y][z];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					blocks[i][j][k] = new Block(k == 0 ? Block.Type.GROUND : Block.Type.AIR, i, j, k);
				}
			}
		}
	}
	
	public World(int x, int y, int z) {
		blocks = new Block[x][y][z];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					blocks[i][j][k] = new Block(k == 0 ? Block.Type.GROUND : Block.Type.AIR, i, j, k);
				}
			}
		}
	}
	
	public void print() {
		for(int i = 0; i < blocks.length; i++) {
			for(int j = 0; j < blocks[0].length; j++) {
				for(int k = 0; k < blocks[0][0].length; k++) {
					if(blocks[k][j][i].type == Block.Type.AIR) {
						System.out.print("-");
					}else {
						System.out.print("0");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	

}
