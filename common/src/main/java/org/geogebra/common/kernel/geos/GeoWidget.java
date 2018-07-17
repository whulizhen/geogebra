package org.geogebra.common.kernel.geos;

import org.geogebra.common.euclidian.EuclidianView;
import org.geogebra.common.euclidian.EuclidianViewInterfaceCommon;
import org.geogebra.common.kernel.CircularDefinitionException;
import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.Locateable;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.arithmetic.ValueType;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.kernel.kernelND.GeoPointND;
import org.geogebra.common.main.Feature;
import org.geogebra.common.util.debug.Log;

/**
 * Base class for locateable geos like button and video.
 * 
 * @author laszlo
 *
 */
public abstract class GeoWidget extends GeoElement implements Locateable, AbsoluteScreenLocateable {
	private int width = 40;
	private int height = 30;

	private GeoPointND[] corner = new GeoPointND[3];
	/**
	 * 
	 * @param c
	 *            the construction.
	 */
	public GeoWidget(Construction c) {
		super(c);
	}

	/**
	 * 
	 * @param cons
	 *            construction
	 * @param labelOffsetX
	 *            x offset
	 * @param labelOffsetY
	 *            y offset
	 */
	public GeoWidget(Construction cons, int labelOffsetX, int labelOffsetY) {
		this(cons);
		this.labelOffsetX = labelOffsetX;
		this.labelOffsetY = labelOffsetY;
	}

	@Override
	public void setStartPoint(GeoPointND p) throws CircularDefinitionException {
		// remove old dependencies
		if (corner[0] != null) {
			corner[0].getLocateableList().unregisterLocateable(this);
		}

		// set new location
		if (p == null) {
			if (corner[0] != null) {
				corner[0] = corner[0].copy();
			} else {
				corner[0] = null;
			}
			labelOffsetX = 0;
			labelOffsetY = 0;
		} else {
			corner[0] = p;

			// add new dependencies
			corner[0].getLocateableList().registerLocateable(this);
		}
	}

	@Override
	public void removeStartPoint(GeoPointND p) {
		// empty implementation.
	}

	@Override
	public GeoPointND getStartPoint() {
		return corner[0];
	}

	@Override
	public void setStartPoint(GeoPointND p, int number) throws CircularDefinitionException {
		Log.error(p + "");
		corner[number] = p;
	}

	@Override
	public GeoPointND[] getStartPoints() {
		return corner;
	}

	@Override
	public void initStartPoint(GeoPointND p, int number) {
		Log.error(p + "");
		corner[number] = p;
	}

	@Override
	public boolean hasAbsoluteLocation() {
		return corner[0] == null || corner[0].isAbsoluteStartPoint();
	}

	@Override
	public boolean isAlwaysFixed() {
		return !kernel.getApplication().has(Feature.MOW_WIDGET_POSITIONS);
	}

	@Override
	public void setWaitForStartPoint() {
		// empty implementation
	}

	/**
	 * @return width in pixels (if it's fixed)
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            width in pixels (used for fixed size buttons)
	 */
	public void setWidth(int width) {
		this.width = width;
		if (hasScreenLocation()) {
			getScreenLocation().initWidth(width);
		}
	}

	/**
	 * 
	 * @return height in pixels (if it's fixed)
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            height in pixels (used for fixed size buttons)
	 */
	public void setHeight(int height) {
		this.height = height;
		if (hasScreenLocation()) {
			getScreenLocation().initHeight(height);
		}
	}

	@Override
	public ValueType getValueType() {
		return ValueType.VOID;
	}

	@Override
	final public void setUndefined() {
		// do nothing
	}

	@Override
	final public boolean isDefined() {
		return true;
	}

	@Override
	public boolean showInEuclidianView() {
		return true;
	}

	@Override
	public boolean showInAlgebraView() {
		return true;
	}

	@Override
	public void updateLocation() {
		update();
	}

	// Michael Borcherds 2008-04-30
	@Override
	final public boolean isEqual(GeoElementND geo) {
		return geo == this;
	}

	@Override
	final public boolean isAlgebraViewEditable() {
		return !isIndependent();
	}

	@Override
	public HitType getLastHitType() {
		return HitType.ON_FILLING;
	}

	@Override
	public String toValueString(StringTemplate tpl) {
		return "";
	}

	@Override
	public double getRealWorldLocX() {
		return corner[0] == null ? 0 : corner[0].getInhomX();
	}

	@Override
	public double getRealWorldLocY() {
		return corner[0] == null ? 0 : corner[0].getInhomY();
	}

	@Override
	public boolean isAbsoluteScreenLocActive() {
		return corner[0] == null;
	}

	@Override
	public boolean isAbsoluteScreenLocateable() {
		return true;
	}

	@Override
	public void setAbsoluteScreenLoc(int x, int y) {
		labelOffsetX = x;
		labelOffsetY = y;
		if (corner[0] != null) {
			updateRelLocation(kernel.getApplication().getActiveEuclidianView());
		}
		if (!hasScreenLocation()) {
			setScreenLocation(x, y);
		}
	}

	@Override
	public int getAbsoluteScreenLocX() {
		return labelOffsetX;
	}

	@Override
	public int getAbsoluteScreenLocY() {
		return labelOffsetY;
	}

	/**
	 * 
	 * @param ev
	 *            the euclidian view.
	 * @return x coordinate of screen location.
	 */
	public int getScreenLocX(EuclidianViewInterfaceCommon ev) {
		return this.corner[0] == null ? labelOffsetX : ev.toScreenCoordX(corner[0].getInhomX());
	}

	/**
	 * 
	 * @param ev
	 *            the euclidian view.
	 * @return y coordinate of screen location.
	 */
	public int getScreenLocY(EuclidianViewInterfaceCommon ev) {
		return this.corner[0] == null ? labelOffsetY : ev.toScreenCoordY(corner[0].getInhomY());
	}

	@Override
	public void setAbsoluteScreenLocActive(boolean flag) {
		EuclidianView ev = kernel.getApplication().getActiveEuclidianView();
		if (flag && corner[0] != null) {
			updateAbsLocation(ev);

			corner[0] = null;
		} else if (!flag) {
			corner[0] = new GeoPoint(cons);
			updateRelLocation(ev);
		}
	}

	/**
	 * Update absolute location according to relative location in given view
	 * (when rel. position active)
	 * 
	 * @param ev
	 *            view
	 */
	public void updateAbsLocation(EuclidianView ev) {
		if (corner[0] != null) {
			labelOffsetX = ev.toScreenCoordX(corner[0].getInhomX());
			labelOffsetY = ev.toScreenCoordY(corner[0].getInhomY());
		}
	}

	private void updateRelLocation(EuclidianView ev) {
		corner[0].setCoords(ev.toRealWorldCoordX(labelOffsetX), ev.toRealWorldCoordY(labelOffsetY),
				1);
	}

	@Override
	public void setRealWorldLoc(double x, double y) {
		corner[0] = new GeoPoint(cons);
		corner[0].setCoords(x, y, 1);
	}

	/**
	 * @return total screen width, overridden in GeoInputBox
	 */
	@Override
	public int getTotalWidth(EuclidianViewInterfaceCommon ev) {
		return getWidth();
	}

	@Override
	public int getTotalHeight(EuclidianViewInterfaceCommon ev) {
		return getHeight();
	}
}