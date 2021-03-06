# lidia_memory

Года 3 назад плотно обсуждали диссертацию [Лиды](https://vk.com/lida_fadeeva)

Потом диссертация отложилась, потом Лида умерла. 
Текст, скорее всего, потерян. 

Доказательство одного промежуточного результата восстановил по памяти и выложу тут.


## Формулировка. 
Неориентированные графы G=(V,E) (наличие петель и кратных ребер допускается), такие что  одновремено выполнены условия
* для любой вершины G x найдется такой автоморфизм f графа G, что f(x) != x  (Условие 1) 
* для любого автоморфизма f графа G найдется вершина x, такая что f(x) == x  (Условие 2)
существуют при любом числе вершин >=10

## доказательство 
Потом обязательно сверстать его нормально

Переход от примера графа на N  вершинах G1 к примеру графа на N+K вершинах G2, K>1, очевиден.
(пусть t - максимальная степень вершины в графе G1. Рассмотрим  G2 - объединение графа G1 и полного графа на K вершинах G3, всем ребрам G3 дадим кратность t.
Условие 1 выполнено по построению, при этом любой автоморфизм G2, суженный на G1, есть автоморфизм G1, поэтому верно и условие 2)

Пусть X - подгруппа группы перестановок S(n). Определим граф, порожденный подгруппой X  G(X)
(**TODO** - расписать определение не кодом, пока можно посмотреть в файле org/lidochka/graphgenerator/GraphMatrix.java)

###Лемма 1. 
При числе вершин 2 или 3 графов, удовлетворяющим условиям 1 и 2 одновременно, не существует (очевидно, но расписать)

###Лемма 2
X, Y - подгруппы S(n), X вложена в Y
Тогда:
* Если для  G(X) выполнено условие 1 - оно выполнено и для G(Y)
* Если для  G(Y) выполнено условия 2 - оно выполнено и для G(X)
(тоже, наверное, очевидно, но расписать)

###Лемма 3
Пусть не существует графа, удовлетворяющего условиям 1 и 2, с числом вершин, меньшим чем N
Тогда для N вершин такой граф либо не существует, либо существует среди графов, 
порожденных группами, порожденными двумя перестановками из S(n) (P1 и P2)
**Тут доказательство уже нужно расписывать**

###Лемма 4
Усиление леммы 3 - для P1 и P2 можно полагать, что если перестановка содержит цикл длины K*P (P - простое, K - целое), 
то она содержит цикл длины P (Условие 3)

Доказательство.
Предположим, что G(X(P1, P2))  удовлетворяет условиям 1 и 2, а для P1 неверно условие 3. 
рассмотрим граф G1 = G(X(P1^P, P2)) - условие 1 для него выполняется по отрицанию условия 3, а условие 2 - по лемме 2



Все готово для сведения доказательства к довольно малому перебору. 
Не умаляя общности, считаем, что число подвижных элементов у первой из порождающих перестановок не меньше, чем у второй. 
Первую перестановку можем перебирать с точностью до сопряжения, с учетом леммы 4 их весьма немного (23 для N = 11)
Перебираем возможные вторые перестановки - с учетом леммы 4, не большего, чем у первой перестановки, числа подвижных элементов,
 и того, что в сочетании с первой перестановкой у порожденного графа должно выполняться условие 1 (или, что то же самое, 
 для любой вершины x из P1(x) == x следует P2(x) != х ). 
 
 Получаем список уникальных матриц порожденных графов (разным пораждающим парам могут соответствовать одинаковые порожденные матрицы, 
 так что их в итоге будет немного - для 11 вершин набралось 12769)
 Проверяем каждую из полученных матриц на условие 2. (автогенеренный метод ветвей и границ, работает быстро)
 В результате получаем доказательство отсутствия искомых графов при n<10 и примеры искомых графов  для n = 10 и n=11.

 Оба шага алгоритма отлично укладываются в map/reduce.
 
 За прекрасную библиотеку для работы с комбинаторными объектами при помощу Java8 Stream API благодарность 
 Дмитрию Паукову https://github.com/dpaukov/combinatoricslib3 
 
 **По-человечески расписать доказательство, прокомментировать-причесать код - TODO** 
 
 






