package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LStoreGlobal extends LInstructionReg {

	private long address_;

	public LStoreGlobal(long address, Register reg) {
		super(reg);
		address_ = address;
	}

	public long address() {
		return address_;
	}

	@Override
	public Opcode op() {
		return Opcode.StoreGlobal;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException, Exception {
		tw.writeBytes("stor." + RegisterName(reg()) + " " + address());
	}

}
