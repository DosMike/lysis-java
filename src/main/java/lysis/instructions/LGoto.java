package lysis.instructions;

import lysis.lstructure.LBlock;

import java.io.DataOutputStream;
import java.io.IOException;

public class LGoto extends LControlInstruction {

	public LGoto(LBlock target) {
		super(target);
	}

	public LBlock target() {
		return getSuccessor(0);
	}

	@Override
	public Opcode op() {
		return Opcode.Goto;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("goto block" + target().id());
	}

}
