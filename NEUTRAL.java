class NEUTRAL extends EXPR_UNARY
{
  NEUTRAL(EXPR u)
  {
    this.unique = u;
  }

  int eval()
  {
    return this.unique.eval();
  }
}
