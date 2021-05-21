package lysis.instructions;

import lysis.lstructure.LBlock;

import java.io.DataOutputStream;
import java.io.IOException;

public class LJump extends LInstructionJump {

	public LJump(LBlock target, long target_offs) {
		super(target_offs, target);
	}

	public LBlock target() {
		return getSuccessor(0);
	}

	@Override
	public Opcode op() {
		return Opcode.Jump;
	}

	@Override
	public void print(DataOutputStream tw) throws IOException {
		tw.writeBytes("jump block" + target().id());
	}

}
