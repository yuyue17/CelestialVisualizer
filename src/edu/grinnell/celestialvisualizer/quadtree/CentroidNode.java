package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;
import edu.grinnell.celestialvisualizer.physics.Centroid;

public class CentroidNode implements Node {
	
	Centroid centroid;
	Node q1;
	Node q2;
	Node q3;
	Node q4;
	
	public CentroidNode(Centroid centroid, Node q1, Node q2, Node q3, Node q4) {
		this.centroid = centroid;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
	}

	@Override
	public boolean lookup(Point pos, BoundingBox bb) {
		
		return  this.q1.lookup(pos, bb) || 
				this.q2.lookup(pos, bb) || 
				this.q3.lookup(pos, bb) || 
				this.q4.lookup(pos, bb);
		
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
