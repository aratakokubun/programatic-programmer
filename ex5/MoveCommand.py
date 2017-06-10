# -*- coding: utf-8 -*-

"""Move command module for painting application command."""

# Imports
from ICommandFactory import ICommand
import re


class MoveNorth(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'^N\s([0-9]+)'

    def __init__(self, distance: int = 0) -> None:
        """Initialize move command."""
        self._distance = distance

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'MoveNorth':
        """Create command instance for this class."""
        distance = re.search(self._PATTERN, command_str).group(1)
        return MoveNorth(int(distance))

    def print(self) -> None:
        """Print select pen detail."""
        print("Move north {0} cm.".format(self._distance))


class MoveEast(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'^E\s([0-9]+)'

    def __init__(self, distance: int = 0) -> None:
        """Initialize move command."""
        self._distance = distance

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'MoveNorth':
        """Create command instance for this class."""
        distance = re.search(self._PATTERN, command_str).group(1)
        return MoveNorth(int(distance))

    def print(self) -> None:
        """Print select pen detail."""
        print("Move east {0} cm.".format(self._distance))


class MoveSouth(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'^S\s([0-9]+)'

    def __init__(self, distance: int = 0) -> None:
        """Initialize move command."""
        self._distance = distance

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'MoveNorth':
        """Create command instance for this class."""
        distance = re.search(self._PATTERN, command_str).group(1)
        return MoveNorth(int(distance))

    def print(self) -> None:
        """Print select pen detail."""
        print("Move south {0} cm.".format(self._distance))


class MoveWest(ICommand):
    """Command to select specified pen."""

    _PATTERN = r'^W\s([0-9]+)'

    def __init__(self, distance: int = 0) -> None:
        """Initialize move command."""
        self._distance = distance

    def match(self, command_str: str) -> bool:
        """Judge if the given str match for the command."""
        return re.match(self._PATTERN, command_str) is not None

    def create(self, command_str: str) -> 'MoveNorth':
        """Create command instance for this class."""
        distance = re.search(self._PATTERN, command_str).group(1)
        return MoveNorth(int(distance))

    def print(self) -> None:
        """Print select pen detail."""
        print("Move west {0} cm.".format(self._distance))
