class SUB extends EXPR_BINARY
{
  SUB(EXPR l, EXPR r)
  {
    this.left = l;
    this.right = r;
  }

  int eval()
  {
    return this.left.eval() + this.right.eval();
  }
}
