# -*- coding: utf-8 -*-

"""Concreate Reader  module for IReader."""

# Imports
from typing import List
from IReader import IReader


class FileReader(IReader):
    """File reader class."""

    def __init__(self, file_path: str) -> None:
        """Initialize file path."""
        self._file_path = file_path

    def read(self) -> List[str]:
        """Read from file."""
        with open(self._file_path, "r") as file:
            return file.readlines()


class CmdReader(IReader):
    """Command line reader class."""

    def read(self) -> List[str]:
        """Read from command line."""
        pass
