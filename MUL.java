class MUL extends EXPR_BINARY
{
  MUL(EXPR l, EXPR r)
  {
    this.left = l;
    this.right = r;
  }

  int eval()
  {
    return this.left.eval() * this.right.eval();
  }
}
