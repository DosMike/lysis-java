package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LDecReg extends LInstructionReg {

	public LDecReg(Register reg) {
		super(reg);
	}

	@Override
	public Opcode op() {
		return Opcode.DecReg;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("dec." + RegisterName(reg()));
	}

}
