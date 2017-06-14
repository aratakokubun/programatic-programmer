# coding:utf-8 -*-

"""Tokenizer for time expressions."""

# Imports
import ply.yacc as yacc
import timelex

tokens = timelex.tokens


def p_time(p):
    '''time : DIGIT AMPM
        | DIGIT COLON DIGIT
        | DIGIT COLON DIGIT AMPM'''
    p[0] = "".join(map(str, p[1:]))
    print(p[0])


def p_error(t):
    print("Syntax error at '%s'" % t.value)


parser = yacc.yacc(start='time')


if __name__ == "__main__":
    data = "14:15am"
    lexer = timelex.lexer
    lexer.input(data)

    while True:
        tok = lexer.token()
        if not tok:
            break      # No more input
        print(tok)

    parser = yacc.yacc()
    parser.parse(data)
