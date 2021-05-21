package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LIncReg extends LInstructionReg {

	public LIncReg(Register reg) {
		super(reg);
	}

	@Override
	public Opcode op() {
		return Opcode.IncReg;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("inc." + RegisterName(reg()));
	}

}
