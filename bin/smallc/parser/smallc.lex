package smallc.parser;

import java_cup.runtime.Symbol;

%%

%class Lexer
%unicode
%line
%column
%cup
%implements Symbols

%{
    private Symbol token(int tag) {
        return new Symbol(tag, yyline, yycolumn);
    }
    
    private Symbol token(int tag, Object value) {
        return new Symbol(tag, yyline, yycolumn, value);
    }
%}

/* regular definitions */
delim = [" "\n\t]
whitespace = {delim}+
number = [1-9][0-9]*
onumber = 0[0-7]*
hnumber = 0[xX][a-fA-f0-9]+
id = [_a-zA-Z][_a-zA-Z0-9]*

%%

<YYINITIAL> {

    "if"          {return token(IF);}
    "else"        {return token(ELSE);}
    "continue"    {return token(CONTINUE);}
    "break"       {return token(BREAK);}
    "for"         {return token(FOR);}
    "return"      {return token(RETURN);}
    "struct"      {return token(STRUCT);}
    "int"         {return token(TYPE);}
    
    ";"           {return token(SEMI);}
    ","           {return token(COMMA);}
    "."           {return token(DOT);}
    "("           {return token(LP);}
    ")"           {return token(RP);}
    "["           {return token(LB);}
    "]"           {return token(RB);}
    "{"           {return token(LC);}
    "}"           {return token(RC);}
    
    "="           {return token(AS);}
    "+="          {return token(AA);}
    "-="          {return token(SA);}
    "*="          {return token(MA);}
    "/="          {return token(DA);}
    "&="          {return token(BAA);}
    "^="          {return token(BXA);}
    "|="          {return token(BOA);}
    "<<="         {return token(SLA);}
    ">>="         {return token(SRA);}
    
    "<<"  {return token(SL);}
    ">>"  {return token(SR);}
    
    ">="  {return token(GE);}
    ">"  {return token(GT);}
    "<=" {return token(LE);}
    "<"  {return token(LT);}
    "==" {return token(EQ);}
    "!=" {return token(NE);}
    
    "!"  {return token(LN);}
    "&&" {return token(LA);}
    "||" {return token(LO);}
    
    "~"  {return token(BN);}
    "&"  {return token(BA);}
    "|"  {return token(BO);}
    "^"  {return token(BX);}
    
    "++" {return token(PI);}
    "--" {return token(PD);}
    "*"  {return token(MUL);}
    "/"  {return token(DIV);}
    "%"  {return token(MOD);}
    "+"  {return token(ADD);}
    "-"  {return token(SUB);}
    
    {id} {return token(ID,yytext());}
    {number} {return token(INT,Integer.valueOf(yytext()));}
    {onumber} {return token(INT,Integer.parseInt(yytext(), 8));}
    {hnumber} {return token(INT,Integer.parseInt((yytext().substring(2)),16));}
    {whitespace} {/* skip */}
    
    [^] { throw new SyntaxError("Illegal character " + yytext(), yyline, yycolumn); }
}    