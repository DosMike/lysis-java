package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LConstant extends LInstructionReg {

	private long val_;

	public LConstant(long val, Register reg) {
		super(reg);
		val_ = val;
	}

	public long val() {
		return val_;
	}

	@Override
	public Opcode op() {
		return Opcode.Constant;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("const." + RegisterName(reg()) + " " + val());
	}

}
