package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LStackAddress extends LInstructionRegStack {

	public LStackAddress(long offset, Register reg) {
		super(reg, offset);
	}

	@Override
	public Opcode op() {
		return Opcode.StackAddress;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("addr." + RegisterName(reg()) + " " + offset());
	}

}
