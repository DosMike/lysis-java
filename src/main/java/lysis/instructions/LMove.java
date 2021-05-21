package lysis.instructions;

import lysis.lstructure.Register;

import java.io.DataOutputStream;
import java.io.IOException;

public class LMove extends LInstructionReg {

	public LMove(Register reg) {
		super(reg);
	}

	@Override
	public Opcode op() {
		return Opcode.Move;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("move." + RegisterName(reg()) + ", "
				+ (reg() == Register.Pri ? RegisterName(Register.Alt) : RegisterName(Register.Pri)));
	}

}
