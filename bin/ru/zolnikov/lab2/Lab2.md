# Задания

| №варианта | №1 | №2 | №3 | №4 | №5 |
|:---------:|:--:|:--:|:--:|:--:|:--:|
| 1 | 1 | 1 | 1 | 1,2 | 3 |

## №1 Точка координат

Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:

* Координата Х: число
* Координата Y: число
* Может возвращать текстовое представление вида “{X;Y}”

Необходимо создать три точки с разными координатами и вывести на экран их текстовое
представление

## №2 Прямая

Создайте сущность Линия, расположенную на двумерной плоскости, которая описывается:

* Координата начала: Точка
* Координата конца: Точка
* Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”

Для указания координат нужно использовать сущность Точка, разработанную в задании 1.1. Создайте
линии со следующими характеристиками:

1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}.
2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
3. Линия 3, которая начинается всегда там же, где начинается линия 1, и заканчивается всегда там же, где заканчивается линия 2. Таким образом, если положение первой или второй линии
меняется, то меняется и третья линия.
4. После создания всех трех объектов измените координаты первой и второй линий, причем
сделайте это таким образом, чтобы положение третьей линии соответствовало требованиям
пункта 3.
5. Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей
линии.

## №3 Студент

Создайте сущность Студент, которая описывается:

* Имя: строка
* Оценки: массив целых чисел.
* Может возвращать текстовое представление вида “Имя: [оценка1, оценка2,…,оценкаN]”

Необходимо выполнить следующие задачи:

1. Создать студента Васю с оценками: 3,4,5.
2. Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с
оценками Васи полю с оценками Пети.
3. Заменить первую оценку Пети на число 5. Вывести на экран строковое представление
Васи и Пети. Объяснить результат
4. Создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок
Васи не влияло на Андрея.

## №4

### Создаем Точку

Измените сущность Точка из задачи 1.1. В соответствии с новыми требованиями создать объект
Точки можно только путем указания обеих координат:X и Y.
Необходимо выполнить следующие задачи:

* Создайте и выведите на экран точку с координатами 3;5
* Создайте и выведите на экран точку с координатами 25;6
* Создайте и выведите на экран точку с координатами 7;8

### Создаем Линию

Измените сущность Линия из задачи 2.1. Новые требования включают:

* Создание Линии возможно с указанием Точки начала и Точки конца (Точки из задачи 4.1)
* Создание Линии возможно с указанием координат начала и конца как четырех чисел
(x1,y1,x2,y2)

Создайте линии со следующими характеристиками:

1. Линия 1 с началом в т. {1;3} и концом в {23;8}.
2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.
3. Линия 3 которая начинается всегда там же где начинается линия 1, и заканчивается
всегда там же, где заканчивается линия 2.

## №5 Длина Линии

Измените сущность Линия из задачи **4.2**. Добавьте ей возможность возвращать по запросу
пользователя расстояние между точками начала и конца (в виде целого числа). Создайте линию
из точки {1;1} в точку {10;15} и выведите на экран её длину.