package org.geogebra.common.gui.dialog.options.model;

import java.util.Arrays;
import java.util.List;

import org.geogebra.common.kernel.geos.GeoLine;
import org.geogebra.common.kernel.geos.GeoSegment;
import org.geogebra.common.main.App;
import org.geogebra.common.main.Localization;

public class LineEqnModel extends MultipleOptionsModel {

	private List<Integer> eqnValues;

	public LineEqnModel(App app) {
		super(app);

		eqnValues = Arrays.asList(GeoLine.EQUATION_IMPLICIT,
				GeoLine.EQUATION_EXPLICIT, GeoLine.PARAMETRIC,
				GeoLine.EQUATION_GENERAL, GeoLine.EQUATION_USER);

	}

	@Override
	public boolean isValidAt(int index) {
		if (!app.getSettings().getCasSettings().isEnabled()) {
			return false;
		}
		boolean valid = true;
		Object geo = getObjectAt(index);
		if (!(geo instanceof GeoLine) || geo instanceof GeoSegment) {
			valid = false;
		}

		return valid;
	}

	private GeoLine getLineAt(int index) {
		return (GeoLine) getObjectAt(index);
	}

	@Override
	public void updateProperties() {
		int value0 = getValueAt(0);
		boolean equalMode = true;
		for (int i = 0; i < getGeosLength(); i++) {
			if (getValueAt(i) != value0) {
				equalMode = false;
			}
		}

		getListener()
				.setSelectedIndex(equalMode ? eqnValues.indexOf(value0) : -1);

	}

	@Override
	public List<String> getChoiches(Localization loc) {

		return Arrays.asList(loc.getMenu("ImplicitLineEquation"), // index 0
				loc.getMenu("ExplicitLineEquation"), // index 1
				loc.getMenu("ParametricForm"), // index 2
				loc.getMenu("GeneralLineEquation"), // index 3
				loc.getMenu("InputForm"));

	}

	@Override
	protected void apply(int index, int value) {
		getLineAt(index).setMode(eqnValues.get(value));
		getGeoAt(index).updateRepaint();

	}

	@Override
	public int getValueAt(int index) {
		return getLineAt(index).getMode();
	}

}
