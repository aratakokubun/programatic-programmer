# -*- coding: utf-8 -*-

"""Utility module for paint application."""


def ordinal(n: int) -> str:
    """Replace ordinal number.

    @param n: number to Replace
    @return oridinaled number
    """
    return "%d%s" % (
        n, "tsnrhtdd"[(n / 10 % 10 != 1) * (n % 10 < 4) * n % 10::4])
