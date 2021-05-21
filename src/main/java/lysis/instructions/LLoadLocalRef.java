package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LLoadLocalRef extends LInstructionRegStack {

	public LLoadLocalRef(long offset, Register reg) {
		super(reg, offset);
	}

	@Override
	public Opcode op() {
		return Opcode.LoadLocalRef;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("lref.s." + RegisterName(reg()) + " " + offset());
	}

}
