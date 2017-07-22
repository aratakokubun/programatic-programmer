# -*- coding:utf-8 -*-

"""Module for parser interface."""

from abc import ABCMeta, abstractmethod
from typing import TypeVar
from SchemeOrder import Scheme, SchemeOrder

# Generics Types


class Parser(metaclass=ABCMeta):
  """Parser interface."""

  @abstractmethod
  def parse(self) -> SchemeOrder:
    '''Parse data'''
    raise NotImplementedError