Parser layer does this:

- Tokenize the input SQL statement. `SELECT (c1, c3) FROM tbl` should be converted
  to `[select,(,c1,c3,),FROM,tbl`
- Turn tokenized input into an AST. Then on the AST, do some language-level optimizations: CSE,
  const folding (use visitor pattern)
- Turn AST into IR. Maybe this should be a different layer? Anyways, figure out the difference, if
  there is one, between IR and the nodes we perform logical optimizations on