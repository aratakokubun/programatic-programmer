# -*- coding: utf-8 -*-

"""Pen command module for painting application command."""

# Imports
from ICommandFactory import ICommand
import re


class SelectPenCommand(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'P ([d])'

    def __init__(self, pen_type: int) -> None:
        """Initialize pen command."""
        self._pen_type = pen_type

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'SelectPenCommand':
        """Create command instance for this class."""
        pen_type = re.search(self._PATTERN, command_str).group(1)
        return SelectPenCommand(int(pen_type))
