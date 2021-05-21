package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LLoadLocal extends LInstructionRegStack {

	public LLoadLocal(long offset, Register reg) {
		super(reg, offset);
	}

	@Override
	public Opcode op() {
		return Opcode.LoadLocal;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("load.s." + RegisterName(reg()) + " " + offset());
	}

}
