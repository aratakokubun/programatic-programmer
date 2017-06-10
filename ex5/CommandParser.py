# -*- coding: utf-8 -*-

"""Parser module for painting application command."""

# Imports
from ICommandParser import ICommandParser
from ICommandFactory import ICommand, ICommandFactory


class CommandParser(ICommandParser):
    """Parser for painting application command."""

    def __init__(self, factory: ICommandFactory) -> None:
        """Initialize factory."""
        self._factory = factory

    def parse(self, command_str: str) -> ICommand:
        """Parse command string."""
        return self._factory.createCommand(command_str)
