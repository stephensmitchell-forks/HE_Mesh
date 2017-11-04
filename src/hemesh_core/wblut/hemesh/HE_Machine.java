/*
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package wblut.hemesh;

import wblut.core.WB_ProgressTracker;

/**
 *
 */
public abstract class HE_Machine {
	private String name;
	/**
	 *
	 */
	public static final WB_ProgressTracker tracker = WB_ProgressTracker.instance();

	/**
	 *
	 *
	 * @param mesh
	 * @return
	 */
	public abstract HE_Mesh apply(HE_Mesh mesh);

	/**
	 *
	 *
	 * @param selection
	 * @return
	 */
	public abstract HE_Mesh apply(HE_Selection selection);

	public String getName() {
		return name;
	}

	public String setName(final String name) {
		this.name = name;
	}

}
