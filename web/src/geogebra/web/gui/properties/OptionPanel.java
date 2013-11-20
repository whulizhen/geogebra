package geogebra.web.gui.properties;

import geogebra.common.gui.dialog.options.model.OptionsModel;

import com.google.gwt.user.client.ui.Widget;

public abstract class OptionPanel {
	OptionsModel model;
	private Widget widget;

	public boolean update(Object[] geos) {
		getModel().setGeos(geos);
		if (!(getModel().checkGeos())) {
			if (widget != null) {
				widget.setVisible(false);
			}
			return false;
		}
		if (widget != null) {
			widget.setVisible(true);
		}

		getModel().updateProperties();
		setLabels();
		return true;
	}

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

	public OptionsModel getModel() {
		return model;
	}

	public void setModel(OptionsModel model) {
		this.model = model;
	}

	public abstract void setLabels();
}
