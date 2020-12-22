class CST extends EXPR
{
  int value;
  CST(int v)
  {
    this.value = v;
  }
  int eval()
  {
    return this.value;
  }
}
