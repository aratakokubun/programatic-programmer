# -*- coding: utf-8 -*-

"""None type command module for painting application command."""

# Imports
from ICommandFactory import ICommand


class NoneCommand(ICommand):
    """Command to select specified pen."""

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return True

    def create(self, command_str: str) -> 'SelectPenCommand':
        """Create command instance for this class."""
        return NoneCommand()
