# -*- coding:utf-8 -*-

"""Module for scheme and order interface."""

# Imports
from abc import ABCMeta, abstractmethod

class SchemeOrder(metaclass=ABCMeta):
  """Interface for scheme order."""

    # TODO

class Scheme(metaclass=ABCMeta):
  """Interface for scheme."""
  
  @abstractmethod
  def next(self) -> SchemeOrder:
      """Get next order in stocked order."""
      raise NotImplementedError
