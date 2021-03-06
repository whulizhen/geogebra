package com.himamis.retex.renderer.share.commands;

import com.himamis.retex.renderer.share.AccentedAtom;
import com.himamis.retex.renderer.share.Atom;
import com.himamis.retex.renderer.share.PhantomAtom;
import com.himamis.retex.renderer.share.Symbols;
import com.himamis.retex.renderer.share.TeXLength;
import com.himamis.retex.renderer.share.TeXParser;
import com.himamis.retex.renderer.share.UnderOverAtom;

public class CommandUnderTilde extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new UnderOverAtom(a,
				new AccentedAtom(new PhantomAtom(a, true, false, false),
						Symbols.WIDETILDE),
				new TeXLength(TeXLength.Unit.MU, 0.3), true, false);
	}

	@Override
	public Command duplicate() {
		return new CommandUnderTilde();
	}

}
