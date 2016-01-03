/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */
package wblut.geom;

import wblut.math.WB_MTRandom;

/**
 *
 * Random generator for vectors uniformly distributed in the halfopen rectangle
 * [-X/2,-Y/2]-(X/2,Y/2).
 *
 * @author Frederik Vanhoutte, W:Blut
 *
 */
public class WB_RandomRectangle implements WB_RandomPoint {
	private final WB_MTRandom randomGen;
	private double X, Y;
	private WB_Vector offset;

	/**
	 * 
	 */
	public WB_RandomRectangle() {
		randomGen = new WB_MTRandom();
		X = 1.0;
		Y = 1.0;
		offset = new WB_Vector();
	}

	/**
	 * 
	 *
	 * @param seed 
	 */
	public WB_RandomRectangle(final long seed) {
		randomGen = new WB_MTRandom(seed);
		X = 1.0;
		Y = 1.0;
		offset = new WB_Vector();
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#setSeed(long)
	 */
	@Override
	public WB_RandomRectangle setSeed(final long seed) {
		randomGen.setSeed(seed);
		return this;
	}

	/**
	 * 
	 *
	 * @param X 
	 * @param Y 
	 * @return 
	 */
	public WB_RandomRectangle setSize(double X, double Y) {
		this.X = X;
		this.Y = Y;
		return this;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#nextPoint()
	 */
	@Override
	public WB_Point nextPoint() {
		return new WB_Point(X * randomGen.nextCenteredDouble(), Y * randomGen.nextCenteredDouble(), 0).addSelf(offset);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#nextVector()
	 */
	@Override
	public WB_Vector nextVector() {
		return new WB_Vector(X * randomGen.nextCenteredDouble(), Y * randomGen.nextCenteredDouble(), 0).addSelf(offset);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#reset()
	 */
	@Override
	public void reset() {
		randomGen.reset();
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#setOffset(wblut.geom.WB_Coord)
	 */
	@Override
	public WB_RandomPoint setOffset(WB_Coord offset) {
		this.offset.set(offset);
		return this;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#setOffset(double, double)
	 */
	@Override
	public WB_RandomPoint setOffset(double x, double y) {
		this.offset.set(x, y, 0);
		return this;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_RandomPoint#setOffset(double, double, double)
	 */
	@Override
	public WB_RandomPoint setOffset(double x, double y, double z) {
		this.offset.set(x, y, z);
		return this;
	}
}
