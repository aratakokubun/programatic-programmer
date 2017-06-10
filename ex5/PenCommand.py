# -*- coding: utf-8 -*-

"""Pen command module for painting application command."""

# Imports
from ICommandFactory import ICommand
import re
import utils


class SelectPenCommand(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'^P\s([0-9]+)'

    def __init__(self, pen_type: int = 0) -> None:
        """Initialize pen command."""
        self._pen_type = pen_type

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'SelectPenCommand':
        """Create command instance for this class."""
        pen_type = re.search(self._PATTERN, command_str).group(1)
        return SelectPenCommand(int(pen_type))

    def print(self) -> None:
        """Print select pen detail."""
        print("select {0} pen.".format(utils.ordinal(self._pen_type)))


class DownPenCommand(ICommand):
    """Command to down the pen on the canvas."""

    _PATTERN = r'^D'

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'DownPenCommand':
        """Create command instance for this class."""
        return DownPenCommand()

    def print(self) -> None:
        """Print command detail."""
        print("Down the pen on the canvas.")


class UpPenCommand(ICommand):
    """Command to up the pen on the canvas."""

    _PATTERN = r'^U'

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'UpPenCommand':
        """Create command instance for this class."""
        return UpPenCommand()

    def print(self) -> None:
        """Print command detail."""
        print("Up the pen on the canvas.")
