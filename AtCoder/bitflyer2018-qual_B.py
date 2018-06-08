from enum import Enum, unique

@unique
class OrderType(Enum):
    """注文の種類を定義する定数クラス"""
    S, C, E = 'S', 'C', 'E'

class CakeCount:
    """ケーキの個数の範囲を指定する親クラス"""
    def __init__(self, count=0):
        self.count_check(count)
        self.count = count

    def count_check(self, count):
        if count < 0 or count > 10 ** 5:
            raise ValueError("the count isn't contained in the range")

class ShortCakeCount(CakeCount):
    """ショートケーキの個数の範囲を指定するクラス"""
    def __init__(self, count):
        super().__init__(count)

class CheeseCakeCount(CakeCount):
    """チーズケーキの個数の範囲を指定するクラス"""
    def __init__(self, count):
        super().__init__(count)

class Shop:
    """注文をひとつずつ処理し、ケーキの個数を増減させるクラス"""
    def __init__(self, a, b):
        self.short_cake_count  = ShortCakeCount(a)
        self.cheese_cake_count = CheeseCakeCount(b)

    def sell(self, order):
        if   order == OrderType.S: self.s()
        elif order == OrderType.C: self.c()
        elif order == OrderType.E: self.e()
        else: raise ValueError("order must be 'S' or 'C' or 'E'")

    def s(self):
        if self.short_cake_count.count  > 0: self.short_cake_count.count -= 1

    def c(self):
        if self.cheese_cake_count.count > 0: self.cheese_cake_count.count -= 1

    def e(self):
        if self.short_cake_count.count == self.cheese_cake_count.count == 0: return
        if self.short_cake_count.count >= self.cheese_cake_count.count     : self.s()
        else                                                               : self.c()

if __name__ == '__main__':
    A, B, N = map(int, input().split()) 
    X = input()
    shop = Shop(A, B)
    for order in X:
        shop.sell(OrderType(order))
    print(shop.short_cake_count.count)
    print(shop.cheese_cake_count.count)
