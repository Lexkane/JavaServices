package com.company.fishinggoods;

public class LakeGood extends Good {

  private int depth;

  public LakeGood(final String fishtype, final String price,
      final int depth) {
    super(fishtype, price);
    this.depth = depth;
  }

  public final int getDepth() {
    return depth;
  }

  @Override
  public final void showParameters() {
    System.out.println(toString());
  }

  @Override
  public final String toString() {
    return "<< LakeGood: " + super.toString()
        + ", depth=" + depth + " >>";
  }
}
