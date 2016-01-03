/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */
package wblut.processing;

import processing.core.PVector;
import wblut.geom.WB_Coord;
import wblut.geom.WB_MutableCoord;

public class WB_PVector extends PVector implements WB_MutableCoord {
    /**
     *
     */
    private static final long serialVersionUID = 3211029434911447698L;

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#xd()
     */
    @Override
    public double xd() {
	return x;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#yd()
     */
    @Override
    public double yd() {
	return y;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#zd()
     */
    @Override
    public double zd() {
	return z;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#wd()
     */
    @Override
    public double wd() {
	return 0;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#getd(int)
     */
    @Override
    public double getd(final int i) {
	if (i == 0) {
	    return x;
	} else if (i == 1) {
	    return y;
	} else if (i == 2) {
	    return z;
	}
	return 0;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#xf()
     */
    @Override
    public float xf() {
	return x;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#yf()
     */
    @Override
    public float yf() {
	return y;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#zf()
     */
    @Override
    public float zf() {
	return z;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#wf()
     */
    @Override
    public float wf() {
	return 0;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_Coord#getf(int)
     */
    @Override
    public float getf(final int i) {
	if (i == 0) {
	    return x;
	} else if (i == 1) {
	    return y;
	} else if (i == 2) {
	    return z;
	}
	return 0;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#setX(double)
     */
    @Override
    public void setX(final double x) {
	this.x = (float) x;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#setY(double)
     */
    @Override
    public void setY(final double y) {
	this.y = (float) y;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#setZ(double)
     */
    @Override
    public void setZ(final double z) {
	this.z = (float) z;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#setW(double)
     */
    @Override
    public void setW(final double w) {
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#setCoord(int, double)
     */
    @Override
    public void setCoord(final int i, final double v) {
	if (i == 0) {
	    this.x = (float) v;
	} else if (i == 1) {
	    this.y = (float) v;
	} else if (i == 2) {
	    this.z = (float) v;
	}
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#set(wblut.geom.WB_Coord)
     */
    @Override
    public void set(final WB_Coord p) {
	x = p.xf();
	y = p.yf();
	z = p.zf();
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#set(double, double)
     */
    @Override
    public void set(final double x, final double y) {
	this.x = (float) x;
	this.y = (float) y;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#set(double, double, double)
     */
    @Override
    public void set(final double x, final double y, final double z) {
	this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }

    /* (non-Javadoc)
     * @see wblut.geom.WB_MutableCoord#set(double, double, double, double)
     */
    @Override
    public void set(final double x, final double y, final double z,
	    final double w) {
	this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }
}
