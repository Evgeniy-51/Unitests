from typing import List
from statistics import mean


class List_compare:

    def __init__(self, lst1: List[float] = [], lst2: List[float] = []):
        self.lst1 = lst1
        self.lst2 = lst2

    def compare(self):
        if not isinstance(self.lst1, List) or not isinstance(self.lst2, List):
            raise TypeError("Метод должен принимать только списки!")
        try:
            avg1 = mean(self.lst1)
            avg2 = mean(self.lst2)
        except:
            raise ValueError("Метод должен принимать только списки числовых значений!")

        if avg1 > avg2:
            print("Первый список имеет большее среднее значение")
        elif avg1 < avg2:
            print("Второй список имеет большее среднее значение")
        else:
            print("Средние значения равны")


if __name__ == '__main__':
    lst_ex1 = [1, 2, 3]
    lst_ex2 = (10, 20, 30)
    lst_ex3 = [1, 2, 3, "a"]
    ex = List_compare(lst_ex1, lst_ex2)
    ex.compare()
