package sef.module6.activity;

/**
 * @author  John Doe
 * 
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D{
	
	private double z;

	/**
	 * Creates a Point3D object with the default coordinate of 0,0,0 
	 *
	 */
	public Point3DImpl(){
		super();
		this.z = 0; 
	}
	
	/**
	 * Creates a Point3D object at the specified coordinates
	 * 
	 * @param x coordinate along the x axis
	 * @param y coordinate along the y axis
	 * @param z coordinate along the z axis
	 */
	public Point3DImpl(double x, double y, double z){
		super(x,y);
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#setZ(double)
	 */
	public final void setZ(double z){
		this.z = z;
	
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getZ()
	 */
	public final double getZ(){
		return this.z;
	}
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#move(double, double, double)
	 */
	public void move(double x2, double y2, double z2){
		super.move(x2, y2);
		this.z = z2;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#translate(double, double, double)
	 */
	public void translate(double x2, double y2, double z2){
		super.translate(x2, y2);
		this.z = this.z + z2;
		
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#equals(double, double, double)
	 */
	public boolean equals(double x2, double y2, double z2){
		if(this.z == z2 && super.equals(x2, y2))
			return true;
		return false;
	}
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameter
	 * 
	 * @param p the coordinates to compare
	 * 
	 * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
	 */
	public boolean equals(Object p){
		if(p instanceof Point3D) {
			
			if(this.x == ((Point3D) p).getX() && this.y == ((Point3D) p).getY() && this.z == ((Point3D) p).getZ()) {
				return true;
			}
		}
		return false;
		
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
	 */
	public double getDistance(Point3D p){
		double x3 = p.getX() - this.x; 
		double y3 = p.getY() - this.y;
		double z3 = p.getZ() - this.z;
		x3 *= x3;
		y3 *= y3;
		z3 *= z3;
		return Math.sqrt((x3 + y3 + z3));
		
	
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(double, double, double)
	 */
	public double getDistance(double x2, double y2, double z2){
		double x3 = x2 - this.x; 
		double y3 = y2 - this.y;
		double z3 = z2 - this.z;
		x3 *= x3;
		y3 *= y3;
		z3 *= z3;
		return Math.sqrt((x3 + y3 + z3));
	
	}
	

}
