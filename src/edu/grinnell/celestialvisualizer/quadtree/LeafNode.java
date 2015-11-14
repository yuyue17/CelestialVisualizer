package edu.grinnell.celestialvisualizer.quadtree;

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
	public Vector2d calculateAcceleration(Point p, BoundingBox bb, double thresh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node insert(double mass, Point p, BoundingBox bb) {
		// TODO Auto-generated method stub
		return null;
	}

}
