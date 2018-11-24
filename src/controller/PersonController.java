package controller;


import game.Block;
import game.Person;
import game.World;
import renderer.Camera;

public class PersonController {
	
	World w;
	Person p;
	Boolean f, b, l, r, j;

	public PersonController(Person person, World w) {
		this.w = w;
		this.p = person;
	}

	public void jump() {
		j = true;
	}
	
	public void unjump() {
		j = false;
	}
	
	public void forward() {
		f = true;
	}
	
	public void unforward() {
		f = false;
	}
	
	public void left() {
		l = true;
	}
	
    public void unleft() {
		l = false;
	}
	
	public void right() {
		r = true;
	}
    
	public void unright() {
		r = false;
	}
	
	public void back() {
		b = true;
	}
	
    public void unback() {
		b = false;
	}

    public void update() {
		int[] pos = p.getBlock();
		if(f && !b) {
			// add code to pick direction and make the character move;
		}
    	this.p.move();
    	if (p.vel_z != 0) p.vel_z -= Person.ACCEL;
    	if(p.pos_z - p.vel_z > 0 && (int)(p.pos_z - p.vel_z) != (int) p.pos_z) {
    		//falling into next block
    		if(w.blocks[pos[0]][pos[1]][pos[2] - 1].type == Block.Type.GROUND) {
    			p.vel_z = 0;
    			p.pos_z = (int)p.pos_z;
    		}
    	}
    	if(pos[2] - 1 > 0 && w.blocks[pos[0]][pos[1]][pos[2] - 1].type == Block.Type.AIR) {
    		p.vel_z = -0.11;
    	}
    }

	public Camera getCamera() {
		return p.getCamera();
	}
}
