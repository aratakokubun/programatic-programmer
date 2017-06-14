# coding:utf-8 -*-

"""Tokenizer for time expressions."""

# Imports
import ply.lex as lex

# List of token names. This is always required
tokens = (
    'DIGIT',
    'AMPM',
    'COLON',
)

t_ignore = ' \t'
t_AMPM = r'am|pm'
t_COLON = r':'


def t_DIGIT(t):
    r'\d+'
    t.value = int(t.value)
    return t


def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)


lexer = lex.lex()
