# -*- coding: utf-8 -*-

"""None type command module for painting application command."""

# Imports
from ICommandFactory import ICommand


class NoneCommand(ICommand):
    """Command to select specified pen."""

    def __init__(self, command_str: str = "") -> None:
        """Initialize pen command."""
        self._command_str = command_str

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return True

    def create(self, command_str: str) -> 'NoneCommand':
        """Create command instance for this class."""
        return NoneCommand(command_str)

    def print(self) -> None:
        """Print command string to show the reason for None command."""
        print("None command for {0}".format(repr(self._command_str)))
