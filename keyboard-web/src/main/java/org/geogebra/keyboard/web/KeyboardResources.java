package org.geogebra.keyboard.web;

import org.geogebra.web.resources.SVGResource;
import org.geogebra.web.resources.SassResource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * image and style resources of keyboard
 */
@SuppressWarnings("javadoc")
public interface KeyboardResources extends ClientBundle {

	KeyboardResources INSTANCE = GWT.create(KeyboardResources.class);

	// ONSCREENKEYBOARD
	@Source("org/geogebra/common/icons/png/keyboard/view_close.png")
	ImageResource keyboard_close();
	
	@Source("org/geogebra/common/icons/svg/web/keyboard/ic_more_horiz_black_24px.svg")
	SVGResource keyboard_more();
	
	@Source("org/geogebra/common/icons/svg/web/keyboard/ic_more_horiz_purple_24px.svg")
	SVGResource keyboard_more_purple();
	
	// close button for new keyboard
	@Source("org/geogebra/common/icons/svg/web/keyboard/ic_close_black_24px.svg")
	SVGResource keyboard_close_black();
	
	@Source("org/geogebra/common/icons/svg/web/keyboard/ic_close_purple_24px.svg")
	SVGResource keyboard_close_purple();

	@Source("org/geogebra/common/icons/png/keyboard/shift_purple.png")
	ImageResource keyboard_shiftDown();

	@Source("org/geogebra/common/icons/png/keyboard/shift_black.png")
	ImageResource keyboard_shift();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_shiftDown.png")
	ImageResource keyboard_shiftDownOld();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_shift.png")
	ImageResource keyboard_shiftOld();

	@Source("org/geogebra/common/icons/png/keyboard/backspace.png")
	ImageResource keyboard_backspace();
	
	// backspace for new keyboard
	@Source("org/geogebra/common/icons/png/keyboard/backspace_black.png")
	ImageResource keyboard_backspace_black();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_backspace.png")
	ImageResource keyboard_backspaceOld();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_enter.png")
	ImageResource keyboard_enter();
	
	// enter for new keyboard
	@Source("org/geogebra/common/icons/png/keyboard/keyboard_enter_black.png")
	ImageResource keyboard_enter_black();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_arrowLeft.png")
	ImageResource keyboard_arrowLeft();
	
	// left arrow for new keyboard
	@Source("org/geogebra/common/icons/png/keyboard/keyboard_arrowLeft_black.png")
	ImageResource keyboard_arrowLeft_black();
	
	@Source("org/geogebra/common/icons/png/keyboard/keyboard_arrowRight.png")
	ImageResource keyboard_arrowRight();
	
	// right arrow for new keyboard
	@Source("org/geogebra/common/icons/png/keyboard/keyboard_arrowRight_black.png")
	ImageResource keyboard_arrowRight_black();

	@Source("org/geogebra/common/icons/png/keyboard/keyboard_open.png")
	ImageResource keyboard_show();

	@Source("org/geogebra/common/icons/svg/web/keyboard/ic_keyboard_black_24px.svg")
	SVGResource keyboard_show_material();

	@Source("org/geogebra/common/icons/png/keyboard/sqrt.png")
	ImageResource sqrtPng();

	@Source("org/geogebra/keyboard/css/keyboard-styles.scss")
	SassResource keyboardStyle();

	@Source("com/materializecss/sass/components/_waves.scss")
	SassResource wavesStyle();

	@Source("com/materializecss/js/waves.js")
	TextResource wavesScript();

	@Source("org/geogebra/common/icons/png/keyboard/integral.png")
	ImageResource integral();

	@Source("org/geogebra/common/icons/png/keyboard/d_dx.png")
	ImageResource derivative();

	@Source("org/geogebra/common/icons/png/keyboard/nroot.png")
	ImageResource nroot();

	@Source("org/geogebra/common/icons/svg/web/keyboard/square.svg")
	SVGResource square();

	@Source("org/geogebra/common/icons/svg/web/keyboard/x_power.svg")
	SVGResource xPower();

	@Source("org/geogebra/common/icons/svg/web/keyboard/sqrt.svg")
	SVGResource sqrt();

	@Source("org/geogebra/common/icons/svg/web/keyboard/abs.svg")
	SVGResource abs();

	@Source("org/geogebra/common/icons/svg/web/keyboard/log.svg")
	SVGResource log();

	@Source("org/geogebra/common/icons/svg/web/keyboard/e_power.svg")
	SVGResource e_power();

	@Source("org/geogebra/common/icons/svg/web/keyboard/ten_power.svg")
	SVGResource ten_power();

	@Source("org/geogebra/common/icons/svg/web/keyboard/n_root.svg")
	SVGResource n_root();

	@Source("org/geogebra/common/icons/svg/web/keyboard/a_index.svg")
	SVGResource a_index();

	@Source("org/geogebra/common/icons/svg/web/keyboard/ceil.svg")
	SVGResource ceil();

	@Source("org/geogebra/common/icons/svg/web/keyboard/floor.svg")
	SVGResource floor();
}
