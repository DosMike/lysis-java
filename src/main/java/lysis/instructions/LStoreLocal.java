package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LStoreLocal extends LInstructionRegStack {

	public LStoreLocal(Register reg, long offset) {
		super(reg, offset);
	}

	@Override
	public Opcode op() {
		return Opcode.StoreLocal;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("stor.s." + RegisterName(reg()) + " " + offset());
	}

}
