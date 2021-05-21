package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LStoreLocalRef extends LInstructionRegStack {

	public LStoreLocalRef(Register reg, long offset) {
		super(reg, offset);
	}

	@Override
	public Opcode op() {
		return Opcode.StoreLocalRef;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("sref.s." + RegisterName(reg()) + " " + offset());
	}

}
