# -*- coding:utf-8 -*-

"""Concreate output src code class module."""

# Imports
from IOutputer import IOutputer
from typing import List


class FileOutputer(IOutputer):
    """Output class for file."""

    def __init__(self, out_path: str) -> None:
        """Initialize output file path."""
        self._out_path = out_path

    def output(self, lines: List[str]) -> None:
        """Output to file."""
        with open(self._out_path, "w") as file:
            for line in lines:
                file.write(line)
                file.write('\n')
