# -*- coding: utf-8 -*-

"""Concrete command facotry module for painting application command."""

# Imports
from ICommandFactory import ICommand, ICommandFactory
from NoneCommand import NoneCommand
from typing import List
import more_itertools as mit


class CommandFactory(ICommandFactory):
    """Command in the painting application."""

    def __init__(self, commands: List[ICommand]) -> None:
        """Initialize commands to generate in this factory.

        @param commands: list of commands
        """
        self._commands = commands

    def createCommand(self, command_str: str) -> ICommand:
        """Create command."""
        return mit.first_true(self._commands, default=NoneCommand(),
                              pred=lambda c: c.match(command_str))
