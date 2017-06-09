# -*- coding: utf-8 -*-

"""Concreate Reader  module for IReader."""

# Imports
from typing import List
from IReader import IReader


class FileReader(IReader):
    """File reader class."""

    def read(self) -> List[str]:
        """Read from file."""
        pass


class CmdReader(IReader):
    """Command line reader class."""

    def read(self) -> List[str]:
        """Read from command line."""
        pass
