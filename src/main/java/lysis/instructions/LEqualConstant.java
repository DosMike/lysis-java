package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LEqualConstant extends LInstructionReg {

	private long value_;

	public LEqualConstant(Register reg, long value) {
		super(reg);
		value_ = value;
	}

	public long value() {
		return value_;
	}

	@Override
	public Opcode op() {
		return Opcode.EqualConstant;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException, Exception {
		tw.writeBytes("eq.c." + RegisterName(reg()) + " " + value());
	}

}
