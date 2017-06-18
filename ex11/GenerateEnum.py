# -*- coding: utf-8 -*-

"""Create enum module."""

# Imports
from typing import List
from ConcreteOutputer import FileOutputer
from GeneratorForC import GeneratorForCSrc, GeneratorForCHeader


def read(file_path: str) -> List[str]:
    with open(file_path, "r") as file:
        return file.readlines()


def main() -> None:
    input_path = './name.txt'
    csrc_path = './name.c'
    cheader_path = './name.h'

    lines = read(input_path)
    csrc_outputer = FileOutputer(csrc_path)
    cheader_outputer = FileOutputer(cheader_path)
    csrc_generator = GeneratorForCSrc(csrc_outputer)
    cheader_outputer = GeneratorForCHeader(cheader_outputer)

    csrc_generator.generate(lines)
    cheader_outputer.generate(lines)


if __name__ == "__main__":
    main()
