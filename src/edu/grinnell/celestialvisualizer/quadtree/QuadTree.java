package edu.grinnell.celestialvisualizer.quadtree;

import edu.grinnell.celestialvisualizer.util.BoundingBox;
import edu.grinnell.celestialvisualizer.util.Point;
import edu.grinnell.celestialvisualizer.util.Vector2d;

public class QuadTree {
	
	public Node root;
    
    public boolean lookup(Point pos, BoundingBox bb) {
    	if(this.root == null){
    		return false;
    	} 
    	else {
        return root.lookup(pos, bb);
    	}
    }
    
    public Vector2d calculateAcceleration(Point p, BoundingBox bb, double eps) {
    	if(this.root == null){
    		return Vector2d.zero;
    	} 
    	else {
        return root.calculateAcceleration(p, bb, eps);
    	}
    }
    
    public void insert(double mass, Point pos, BoundingBox bb) {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.insert");
    }
    
    @Override
    public boolean equals(Object other) {
    	
    	return false;
    	// TODO: this
    	
//        if (other instanceof QuadTree) {
//        	other = (QuadTree) other;     	
//        	return root.equals(other.root);
//        } else {
//        	return false;
//        }
    }
    
    public static QuadTree q0() {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.q0");
    }
    
    public static QuadTree q1() {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.q1");
    }
    
    public static QuadTree q2() {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.q2");
    }
    
    public static QuadTree q3() {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.q3");
    }
    
    public static final QuadTree q4() {
        throw new edu.grinnell.celestialvisualizer.UnimplementedException("QuadTree.q4");
    }
}
