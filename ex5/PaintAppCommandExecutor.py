# -*- coding: utf-8 -*-

"""Execute commands for paintg app."""

# Imports
from ConcreteCommandFactory import CommandFactory
from PenCommand import SelectPenCommand


if __name__ == '__main__':

    commands = [SelectPenCommand()]
    factory = CommandFactory(commands)
