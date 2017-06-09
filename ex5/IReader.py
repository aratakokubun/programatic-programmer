# -*- coding: utf-8 -*-

"""Reader interface module for painting application command."""

# Imports
from typing import List
from abc import ABCMeta, abstractmethod


class IReader(metaclass=ABCMeta):
    """Reader Interface for painting application command."""

    @abstractmethod
    def read(self) -> List[str]:
        """Read data and generate list of commands.

        @return list of commands string
        """
        raise NotImplemented()
