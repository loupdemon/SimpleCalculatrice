class NEG extends EXPR_UNARY
{
  NEG(EXPR u)
  {
    this.unique = u;
  }

  int eval()
  {
    return -this.unique.eval();
  }
}
