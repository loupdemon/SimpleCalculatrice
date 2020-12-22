class PARSER
{
  private static String src;
  private static int idx;

  private static char last_char;
  private static int last_cst;

  private static boolean read_char(char c)
  {
    if ((idx < src.length()) && (src.charAt(idx) == c))
    {
      idx++;
      last_char = c;
      return true;
    }
    return false;
  }

  private static boolean read_cst()
  {
    int c;
    if (idx < src.length() && src.charAt(idx) != '*' && src.charAt(idx) != '/' && src.charAt(idx) != '+' && src.charAt(idx) != '-')
    {
      last_cst = 0;
      while (idx < src.length() && Character.isDigit(src.charAt(idx)))
      {
        c = src.charAt(idx) - '0';
        last_cst = last_cst * 10 + c;
        idx++;
      }
      return true;
    }
    return false;
  }

  private static EXPR read_e()
  {
    EXPR e, right;
    char op;
    e = read_e_mul();
    if(e != null)
    {
      while((read_char('+') || (read_char('-'))))
      {
        op = last_char;
        right = read_e_mul();
        if (right == null)
          error();
        if (op == '+')
          e = new ADD(e,right);
        else
          e = new SUB(e,right);
      }
    }
    return e;
  }

  private static EXPR read_e_mul()
  {
    EXPR e, right = null;
    char op;
    e = read_e_unary();
    if(e != null)
    {
      while((read_char('*') || (read_char('/'))))
      {
        op = last_char;
        right = read_e_unary();
        if (right == null)
          error();
        if (op == '*')
          e = new MUL(e,right);
        else
          e = new DIV(e, right);
      }
    }
    return e;
  }

  private static EXPR parenth()
  {
    EXPR res = null;
    if (read_char('('))
    {
      res = read_e();
      if (!(read_char(')')))
        error();
    }
    else if (read_cst())
      res = new CST(last_cst);
    return res;
  }

  private static EXPR read_e_unary()
  {
    read_char('-');
    read_char('+');
    EXPR e;
    e = parenth();
    char op;
    if (e != null)
    {
      if (last_char == '-')
        e = new NEG(e);
      else
        e = new NEUTRAL(e);
    }
    return e;
  }

  private static EXPR read_e_cst()
  {
    EXPR e;
    e = null;
    if (read_cst())
      e = new CST(last_cst);
    else
      error();
    return e;
  }

  private static void error()
  {
    int j;
    System.out.println(src);
    for (j=0; j<idx; j++)
      System.out.println(' ');
    System.out.println('I');
    System.exit(1);
  }

  static EXPR parse_on(String txt)
  {
    EXPR e;
    src = txt;
    idx = 0;
    e = read_e();
    if ((e == null) || (idx < src.length()))
      error();
    return e;
  }
}
