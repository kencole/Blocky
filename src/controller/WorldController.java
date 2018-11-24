package controller;

import game.World;

public class WorldController {
	
	World w;

	public WorldController(World world) {
		this.w = world;
	}

	public World getWorld() {
		return this.w;
	}

	
}
