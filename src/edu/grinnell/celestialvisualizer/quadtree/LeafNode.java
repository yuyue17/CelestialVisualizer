package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.physics.Physics;
import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

public class LeafNode implements Node {
	
	double mass;
	Point position;
	
	public LeafNode(double mass, Point position) {
		this.mass = mass;
		this.position = position;
	}

	@Override
	public boolean lookup(Point pos, BoundingBox bb) {
		return this.position.equals(pos) && bb.contains(this.position);
	}

	@Override
	
	/**
     * Calculates the acceleration on this point according to the quad tree.
     * The rules for calculating acceleration on a body from a quad tree are:
     * 
     * 
     * 2. The leaf node contains a single body---the contributed
     *    acceleration is calculated like normal.
     *
     *   
     * 
     * @param p the point we are calculating the acceleration over
     * @param bb the bounding box of the world
     * @param thresh the threshold value, defined above
     * @return the acceleration on p by the quad tree
     */
	public Vector2d calculateAcceleration(Point p, BoundingBox bb, double thresh) {
		return Physics.calculateAccelerationOn(p, this.mass, this.position);
	}
	

	@Override
	public Node insert(double mass, Point p, BoundingBox bb) {
		// TODO Auto-generated method stub
		return null;
	}

}
