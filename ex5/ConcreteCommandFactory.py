# -*- coding: utf-8 -*-

"""Concrete command facotry module for painting application command."""

# Imports
from ICommandFactory import ICommandFactory


class CommandFactory(ICommandFactory):
    """Command in the painting application."""

    def createCommand(self, command_str):
        pass
