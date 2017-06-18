# -*- coding:utf-8 -*-

"""Src code generator interface module."""

# Imports
from abc import ABCMeta, abstractmethod
from typing import List


class IGenerator(metaclass=ABCMeta):
    """Code Generator Interface."""

    @abstractmethod
    def generate(self, lines: List[str]) -> None:
        """Generate src code.

        Interface does not specify the output style.
        @param lines: list of data to generate src
        """
        raise NotImplemented()
