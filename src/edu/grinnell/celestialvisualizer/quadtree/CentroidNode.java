package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;
import edu.grinnell.celestialvisualizer.physics.Centroid;
import edu.grinnell.celestialvisualizer.physics.Physics;

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

	/**
     * Calculates the acceleration on this point according to the quad tree.
     * The rules for calculating acceleration on a body from a quad tree are:
     * 
     * The centroid node exerts a force as though it was a "virtual" body
     *    at its centroid unless at least one of these conditions hold:
     *    
     *    (a) the point being accelerated is inside the bounding box of the
     *        quad tree, or
     *    (b) the distance between the centroid and the body is below some
     *        threshold (i.e., magnitude(p2 - p1) < thresh)
     *        
     *    In these cases, we consider the point too close to the masses in the
     *    quad tree to use the centroid as an approximation.  We instead
     *    recursively calculate accelerations on the point due to the four
     *    quad subtrees and sum them for a better approximation.
     * 
     * @param p the point we are calculating the acceleration over
     * @param bb the bounding box of the world
     * @param thresh the threshold value, defined above
     * @return the acceleration on p by the quad tree
     */
	public Vector2d calculateAcceleration(Point p, BoundingBox bb, double thresh) {
		double distance = (this.centroid.getPosition()).distance(p).magnitude();
		if (bb.contains(p) || thresh < distance){
			
			return  this.q1.calculateAcceleration(p, bb, thresh).add(
					this.q2.calculateAcceleration(p, bb, thresh).add(
					this.q3.calculateAcceleration(p, bb, thresh).add(
					this.q4.calculateAcceleration(p, bb, thresh))));
		}else {
			return Physics.calculateAccelerationOn(p, this.centroid.getMass(), this.centroid.getPosition());
		}
	}

	@Override
	public Node insert(double mass, Point p, BoundingBox bb) {
		// TODO Auto-generated method stub
		return null;
	}

}
