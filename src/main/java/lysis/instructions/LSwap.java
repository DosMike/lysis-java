package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LSwap extends LInstructionReg {

	public LSwap(Register reg) {
		super(reg);
	}

	@Override
	public Opcode op() {
		return Opcode.Swap;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException, Exception {
		tw.writeBytes("swap." + RegisterName(reg()));
	}

}
