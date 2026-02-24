import sys
x=1
y=2


sys.set_int_max_str_digits(0)   # limiti kaldırır (veya örn: 100000)

for i in range(1,10100):
    x=x*i
    print(x)
