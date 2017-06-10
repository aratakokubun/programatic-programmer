# -*- coding: utf-8 -*-

"""Execute commands for paintg app."""

# Imports
from ConcreteCommandFactory import CommandFactory
from PenCommand import SelectPenCommand, DownPenCommand, UpPenCommand
from MoveCommand import MoveNorth, MoveEast, MoveSouth, MoveWest
from CommandParser import CommandParser
from ConcreteReader import FileReader

if __name__ == '__main__':

    defined_commands = [SelectPenCommand(), DownPenCommand(), UpPenCommand(),
                        MoveNorth(), MoveEast(), MoveSouth(), MoveWest()]
    factory = CommandFactory(defined_commands)
    parser = CommandParser(factory)
    reader = FileReader("./data/commands.cmd")

    command_lines = reader.read()
    commands = [parser.parse(line) for line in command_lines]

    for command in commands:
        command.print()
