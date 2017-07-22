#!/usr/bin/env bash
find . -type f -name "*.pl"|xargs grep -L '^use strict;$'|while read l;do grep -m 1 -n -v "^[\s]*#" "$l"|cut -f1 -d :|while read k;do gsed -i.bak -e $k"i use strict;" "$l";done;done
