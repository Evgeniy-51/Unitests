import pytest
import main


class Tests:
    def test_value_error_1(self):
        """Передается только один список"""
        with pytest.raises(ValueError):
            lst_ex1 = [1, 2, 3]
            main.List_compare(lst_ex1).compare()

    def test_value_error_2(self):
        """В списке присутствует нечисловое значение"""
        with pytest.raises(ValueError):
            lst_ex1 = [1, 2, 3]
            lst_ex3 = [1, 2, 3, "1"]
            main.List_compare(lst_ex1, lst_ex3).compare()

    def test_value_error_3(self):
        """Один список пуст"""
        with pytest.raises(ValueError):
            lst_ex1 = [1, 2, 3]
            lst_ex2 = []
            main.List_compare(lst_ex1, lst_ex2).compare()

    def test_type_error_4(self):
        """Передается кортеж вместо списка"""
        with pytest.raises(TypeError):
            lst_ex1 = [1, 2, 3]
            lst_ex2 = (4, 5, 6)
            main.List_compare(lst_ex1, lst_ex2).compare()

    def test_type_error_5(self):
        """Передается число вместо списка"""
        with pytest.raises(TypeError):
            lst_ex1 = [1, 2, 3]
            lst_ex2 = 5
            main.List_compare(lst_ex1, lst_ex2).compare()

    def test_correct_values_1(self, capsys):
        """Первый список имеет большее среднее значение"""
        lst_ex1 = [10, 20, 30]
        lst_ex2 = [1, 2, 3]
        main.List_compare(lst_ex1, lst_ex2).compare()
        captured = capsys.readouterr()
        assert captured.out == "Первый список имеет большее среднее значение\n"

    def test_correct_values_2(self, capsys):
        """Второй список имеет большее среднее значение"""
        lst_ex1 = [1, 2, 3]
        lst_ex2 = [10, 20, 30]
        main.List_compare(lst_ex1, lst_ex2).compare()
        captured = capsys.readouterr()
        assert captured.out == "Второй список имеет большее среднее значение\n"

    def test_correct_values_3(self, capsys):
        """Средние значения равны"""
        lst_ex1 = [1, 2, 3]
        lst_ex2 = [1, 2, 3]
        main.List_compare(lst_ex1, lst_ex2).compare()
        captured = capsys.readouterr()
        assert captured.out == "Средние значения равны\n"
