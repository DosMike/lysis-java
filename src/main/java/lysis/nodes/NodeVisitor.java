package lysis.nodes;

import lysis.nodes.types.*;

public abstract class NodeVisitor {
	public void visit(DConstant node) throws Exception {
	}

	public void visit(DDeclareLocal local) {
	}

	public void visit(DDeclareStatic local) {
	}

	public void visit(DLocalRef lref) {
	}

	public void visit(DJump jump) {
	}

	public void visit(DJumpCondition jcc) {
	}

	public void visit(DSysReq sysreq) throws Exception {
	}

	public void visit(DBinary binary) {
	}

	public void visit(DBoundsCheck check) {
	}

	public void visit(DArrayRef aref) {
	}

	public void visit(DStore store) {
	}

	public void visit(DLoad load) throws Exception {
	}

	public void visit(DReturn ret) {
	}

	public void visit(DGlobal global) {
	}

	public void visit(DString node) {
	}

	public void visit(DCall call) throws Exception {
	}

	public void visit(DPhi phi) throws Exception {
	}

	public void visit(DBoolean phi) {
	}

	public void visit(DCharacter phi) {
	}

	public void visit(DFloat phi) {
	}

	public void visit(DFunction phi) {
	}

	public void visit(DUnary phi) {
	}

	public void visit(DIncDec phi) {
	}

	public void visit(DHeap phi) {
	}

	public void visit(DMemCopy phi) {
	}

	public void visit(DInlineArray ia) {
	}

	public void visit(DSwitch switch_) {
	}

	public void visit(DGenArray genarray) throws Exception {
	}

	public void visit(DLabel gototarget) {
	}
}
