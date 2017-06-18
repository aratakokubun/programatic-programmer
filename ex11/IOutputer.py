# -*- coding:utf-8 -*-

"""Output src code interface module."""

# Imports
from abc import ABCMeta, abstractmethod
from typing import List


class IOutputer(metaclass=ABCMeta):
    """Output src interface."""

    @abstractmethod
    def output(self, lines: List[str]) -> None:
        """Output src code.

        @param lines: lines to output
        """
        NotImplemented()
