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

import java.util.List;

import javolution.util.FastTable;
import wblut.math.WB_Math;

/**
 *
 */
public class WB_Segment extends WB_Linear implements WB_Curve {
	/**
	 *
	 */
	protected double length;
	/**
	 *
	 */
	protected WB_Point endpoint;
	private WB_GeometryFactory geometryfactory = new WB_GeometryFactory();

	/**
	 *
	 */
	public WB_Segment() {
		super();
		endpoint = new WB_Point();
		length = 0;
	}

	/**
	 *
	 *
	 * @param o
	 * @param d
	 * @param l
	 */
	public WB_Segment(final WB_Coord o, final WB_Coord d, final double l) {
		super(o, d);
		length = l;
		endpoint = new WB_Point(direction).mulSelf(l).addSelf(origin);
	}

	/**
	 *
	 *
	 * @param p1
	 * @param p2
	 */
	public WB_Segment(final WB_Coord p1, final WB_Coord p2) {
		super(p1, new WB_Vector(p1, p2));
		endpoint = new WB_Point(p2);
		length = Math.sqrt(WB_GeometryOp.getSqDistance3D(p1, p2));
	}

	/**
	 *
	 *
	 * @param p1x
	 * @param p1y
	 * @param p1z
	 * @param p2x
	 * @param p2y
	 * @param p2z
	 */
	public WB_Segment(final double p1x, final double p1y, final double p1z, final double p2x, final double p2y,
			final double p2z) {
		super(new WB_Point(p1x, p1y, p1z), new WB_Vector(p2x - p1x, p2y - p1y, p2z - p1z));
		endpoint = new WB_Point(p2x, p2y, p2z);
		length = Math.sqrt(WB_GeometryOp.getSqDistance3D(origin, endpoint));
	}

	/**
	 *
	 *
	 * @param t
	 * @return
	 */
	public WB_Point getParametricPointOnSegment(final double t) {
		final WB_Point result = new WB_Point(direction);
		result.scaleSelf(WB_Math.clamp(t, 0, 1) * length);
		result.addSelf(origin);
		return result;
	}

	/**
	 *
	 *
	 * @param t
	 * @param result
	 */
	public void getParametricPointOnSegmentInto(final double t, final WB_MutableCoord result) {
		result.set(new WB_Vector(direction).mulSelf(WB_Math.clamp(t, 0, 1) * length).addSelf(origin));
	}

	/**
	 *
	 *
	 * @return
	 */
	public WB_Coord getEndpoint() {
		return endpoint;
	}

	public WB_Point getCenter() {
		return new WB_Point(endpoint).addSelf(origin).mulSelf(0.5);
	}

	/**
	 *
	 *
	 * @return
	 */
	public double getLength() {
		return length;
	}

	/**
	 *
	 *
	 * @param segs
	 * @return
	 */
	public static List<WB_Segment> negate(final List<WB_Segment> segs) {
		final List<WB_Segment> neg = new FastTable<WB_Segment>();
		for (int i = 0; i < segs.size(); i++) {
			neg.add(segs.get(i).negate());
		}
		return neg;
	}

	/**
	 *
	 *
	 * @return
	 */
	public WB_Segment negate() {
		return new WB_Segment(endpoint, origin);
	}

	/**
	 *
	 */
	public void reverse() {
		set(endpoint, origin);
	}

	public WB_Segment apply(final WB_Transform T) {
		return geometryfactory.createSegment(new WB_Point(origin).applyAsPoint(T),
				new WB_Point(endpoint).applyAsPoint(T));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.geom.WB_Curve#curvePoint(double)
	 */
	@Override
	public WB_Point curvePoint(final double u) {
		if (u < 0 || u > 1) {
			return null;
		}
		return this.getParametricPointOnSegment(u);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.geom.WB_Curve#loweru()
	 */
	@Override
	public double getLowerU() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.geom.WB_Curve#upperu()
	 */
	@Override
	public double getUpperU() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.geom.WB_Curve#curveDirection(double)
	 */
	@Override
	public WB_Vector curveDirection(final double u) {

		return new WB_Vector(direction);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.geom.WB_Curve#curveDerivative(double)
	 */
	@Override
	public WB_Vector curveDerivative(final double u) {
		return new WB_Vector(direction);
	}
}