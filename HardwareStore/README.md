# Hardware Store Simulator
A hardware store shopping cart simulator created with List and PriorityQueue. 
This simulator will display in the terminal: 
* Each customer's receipt including list of items added in, each items individual price, plus total cost spend at the end of the customer's individual receipt.
* Total Store Revenue at the end

## Setup
### src/invertory.txt
List of store items and their price.
```
Item_Name_1 Item_1_Price_In_Cents
Item_Name_2 Item_2_Price_In_Cents
...
Item_Name_n Item_n_Price_In_Cents
```
[Example](https://github.com/anyichen212/Projects/blob/master/HardwareStore/src/inventory.txt)
```
Hammer 1050
Screw 55
ScrewDriver 845
...
```

### src/event.txt
List of customers and their individual cart of items waiting to be calculated.
```
First_Name Last_Name Num_Of_Different_Items Item_1_Amount Item_1_Name .... Item_N_Amount Item_N_Name
```

[Example](https://github.com/anyichen212/Projects/blob/master/HardwareStore/src/event.txt)
```
Anyi Chen 4 1 ScrewDriver 10 Screw 1 Door 20 Tile
Bob Yesman 1 2 Paint
Fir La 2 2 Lock 1 Door
```
## How To Run
- Make sure Java is install in your terminal
- Downlowd the HardwareStore project
- In your terminal
```
cd /HardwareStore/src
javac Main.java
java Main
```
