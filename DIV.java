class DIV extends EXPR_BINARY
{
  DIV(EXPR l, EXPR r)
  {
    this.left = l;
    this.right = r;
  }

  int eval()
  {
    if (this.right.eval() == 0)
    {
      System.out.println("Error Division by 0");
      System.exit(1);
    }
    return this.left.eval() / this.right.eval();
  }
}
