# -*- coding: utf-8 -*-

"""Command facotry Interface module for painting application command."""

# Imports
from abc import ABCMeta, abstractmethod


class ICommand(metaclass=ABCMeta):
    """Command interface in the painting application."""

    @abstractmethod
    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        raise NotImplemented()

    @abstractmethod
    def create(self, command_str: str) -> 'ICommand':
        """Create command instance for this class."""
        raise NotImplemented()

    @abstractmethod
    def print(self) -> None:
        """Print the command contents."""
        raise NotImplemented()


class ICommandFactory(metaclass=ABCMeta):
    """Factory interface to generate commands in the paiting application."""

    @abstractmethod
    def createCommand(self, command_str: str) -> ICommand:
        """Abstract method to create command from string.

        @return Command from the given string
        """
        raise NotImplemented()
