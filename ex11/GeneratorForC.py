# -*- coding: utf-8 -*-

"""Create enum module for C language."""

# Imports
from IGenerator import IGenerator
from IOutputer import IOutputer
from typing import List


class GeneratorForCSrc(IGenerator):
    """docstring for EnumCreaterForC."""

    def __init__(self, outputer: IOutputer) -> None:
        """Initialize output file path."""
        super(GeneratorForCSrc, self).__init__()
        self._outputer = outputer

    def generate(self, lines: List[str]) -> None:
        """Generate c src."""
        name = ''.join(lines[0].splitlines())
        states = list(map(lambda s: ''.join(s.splitlines()), lines[1:]))

        header = GeneratorForCSrc.__generate_head(name)
        footer = GeneratorForCSrc.__generate_foot()
        out_lines = list(map(GeneratorForCSrc.__generate_state, states))
        out_lines.insert(0, header)
        out_lines.append(footer)
        self._outputer.output(out_lines)

    @staticmethod
    def __generate_head(type_name: str) -> str:
        return 'const char* {0}_names[] = {{'.format(type_name.upper())

    @staticmethod
    def __generate_foot() -> str:
        return '};'

    @staticmethod
    def __generate_state(state_name: str) -> str:
        return '"{0}",'.format(state_name)


class GeneratorForCHeader(IGenerator):
    """docstring for EnumCreaterForC."""

    def __init__(self, outputer: IOutputer) -> None:
        """Initialize output file path."""
        super(GeneratorForCHeader, self).__init__()
        self._outputer = outputer

    def generate(self, lines: List[str]) -> None:
        """Generate c src."""
        name = ''.join(lines[0].splitlines())
        states = list(map(lambda s: ''.join(s.splitlines()), lines[1:]))

        header = GeneratorForCHeader.__generate_head(name)
        footer = GeneratorForCHeader.__generate_foot(name)
        out_lines = list(map(GeneratorForCHeader.__generate_state, states))
        out_lines.insert(0, header)
        out_lines.append(footer)
        self._outputer.output(out_lines)

    @staticmethod
    def __generate_head(type_name: str) -> str:
        return '''extern const char* {0}_names[];
typedef enum {{'''.format(type_name.upper())
    
    @staticmethod
    def __generate_foot(type_name: str) -> str:
        return '}} {0};'.format(type_name.upper())

    @staticmethod
    def __generate_state(state_name: str) -> str:
        return '{0},'.format(state_name)
