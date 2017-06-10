# -*- coding: utf-8 -*-

"""Parser module for painting application command."""

# Imports
from abc import ABCMeta, abstractmethod
from ICommandFactory import ICommand


class ICommandParser(metaclass=ABCMeta):
    """Abstract parser class for painting application command."""

    @abstractmethod
    def parse(self, command_str: str) -> ICommand:
        """Parser command string."""
        raise NotImplemented()
