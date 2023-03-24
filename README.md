# kosmoloty
Każdy kosmolot startuje z wyznaczonej pozycji x,y i charakteryzuje się stałymi prędkościami teleportacyjnymi Vx i Vy, które oznaczają o ile komórek przeteleportuje się kosmolot w każdej rundzie, w danej osi. Teleportacja odbywa się najkrótszą drogą. Rundy odbywają się co sekundę. Rundy są atomowe, tj. w jednej chwili wszystkie kosmoloty znikają i chwilę później (również jednocześnie) - pojawiają się na nowych miejscach.

 

Jeśli po teleportacji w jednej komórce znajdzie się więcej niż jeden kosmolot, wszystkie one odpadają poprzez implozję (nie powstają żadne odłamki - po prostu słuch o nich ginie, a komórka może być normalnie wykorzystana w kolejnej rundzie).

Kosmoloty, które odpadły nie mogą wygrać, bo uległy anihilacji.

 

Prędkość może wynosić 0, a i tak można wygrać.

Wygrywa ten kosmolot, który po 24 godzinach pokona większy dystans na płaszczyźnie, liczony w komórkach.

 Dany jest strumień wejściowy – lista startowa. Prawidłowy strumień wejściowy zawiera przynajmniej jeden wiersz, a każdy z wierszy jest w następującym formacie:

<nazwa>,<prędkość_x>,<prędkość_y>,<pozycja_x>,<pozycja_y>

gdzie:

<nazwa> to nazwa kosmolotu, alfanumeryczna (A-Za-z0-9), niepusta, nie dłuższa niż 10 znaków, nie może się powtarzać
<prędkość_x> prędkość teleportacyjna Vx to liczba komórek (całkowita, nie mniejsza niż -10000 i nie większa niż 10000) o którą w jednej rundzie teleportuje się kosmolot w kierunku osi x (znak traktujemy jako zwrot)
<prędkość_y> prędkość teleportacyjna Vy to liczba komórek (całkowita, nie mniejsza niż -10000 i nie większa niż 10000) o którą w jednej rundzie teleportuje się kosmolot w kierunku osi y (znak traktujemy jako zwrot)
<pozycja_x> pozycja startowa x kosmolotu (wartość całkowita od 0 do wielkość_torusa_x-1)
<pozycja_y> pozycja startowa y kosmolotu (wartość całkowita od 0 do wielkość_torusa_y-1)

Przykłady niepoprawnych nazw kosmolotów:
Pollena2000
File.*
Zażółć

Przykłady poprawnych nazw kosmolotów:
DeathStar
Sebulba1

Jako parametry uruchomienia programu podane zostaną wymiary torusa.

Jeśli wyścig będzie miał zwycięzcę, program powinien wypisać nazwę zwycięskiego kosmolotu.

Jeśli żaden z kosmolotów nie wygra, ponieważ albo wszystkie uległy anihilacji, albo największy dystans pokonał więcej niż jeden kosmolot, program powinien wypisać słowo „remis” (bez cudzysłowu).

 Program będzie uruchamiany komendą:

java Kosmoloty <wielkość_torusa_x> <wielkość_torusa_y> < plik.txt

gdzie:

<wielkość_torusa_x> to liczba całkowita od 1 do 100 000
<wielkość_torusa_y> to liczba całkowita od 1 do 100 000
