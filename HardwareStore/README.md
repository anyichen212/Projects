# Hardware Store
A hardware store shopping cart simulator created using List and PriorityQueue. 

## Setup
> src/invertory.txt
List of store item and their price.
```
Item_Name_1 Item_1_Price_In_Cents
Item_Name_2 Item_2_Price_In_Cents
...
Item_Name_n Item_n_Price_In_Cents
```
_Example_
```
Hammer 1050
Screw 55
ScrewDriver 845
```

> src/event.txt
List of customers and their individual cart of items waiting to be calculated
```
First_Name Last_Name Num_Of_Different_Items Item_1_Amount Item_1_Name .... Item_N_Amount Item_N_Name
```

_Example_
```
Anyi Chen 4 1 ScrewDriver 10 Screw 1 Door 20 Tile
Bob Yesman 1 2 Paint
Fir La 2 2 Lock 1 Door
```