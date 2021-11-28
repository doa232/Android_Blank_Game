package com.doado.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

// ApplicationAdapter is a sub-branch from ApplicationListener
//It holds main game states: Create,Dispose, Pause, Resume

public class libGdxGame extends ApplicationAdapter {
	private OrthographicCamera cam; //declaration for 3d Camera
	private ShapeRenderer sr;
	private Vector3 pos; // position of the mouse or finger

	public void create(){
		sr = new ShapeRenderer();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// y will be bigger when you travel downwards on the screen
		// getWidth and get Height gets the size of the screen respectively

		pos = new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2,0);
		// Divided by 2 because the starting position will be in the middle of the screen

	}
	public void render() {
		//Logic
		cam.update(); // The camera update loop
		if(Gdx.input.isTouched()){
			// If the user touch the screen
			pos.set(Gdx.input.getX(), Gdx.input.getY(),0); // getting the pos
			cam.unproject(pos); // set the coordinates to the camera
		}
		//Drawing
		Gdx.gl.glClearColor(1,1,1,1); // to clear the screen with black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Also clear the screen
		sr.begin(ShapeRenderer.ShapeType.Filled); // shape type
		sr.setColor(Color.GREEN); // color of the circle
		sr.circle(pos.x,pos.y,64); // sets the the circle radius and pos
		sr.end();

	}
	public  void dispose() {
		sr.dispose(); // disposing the sr when is not running to save memory
	}
}