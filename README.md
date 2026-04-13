# Flooring Factory

A Java command-line estimation tool that calculates flooring costs for a room, built for a fictional company called "Fabulous Frank's."

## What It Does

- Calculates room area based on length and width input
- Reads available flooring types and prices from a CSV file
- Calculates material cost, labour charge, subtotal, HST, and total
- Supports multiple room estimates in one session
- Displays a grand total across all estimates at the end
- Full input validation throughout

## How to Run

Make sure you have Java installed. You also need a `floors.csv` file in the same directory as the program.

### floors.csv format

```
5
Hardwood,12.50
Laminate,8.00
Tile,10.75
Carpet,6.25
Vinyl,7.00
```

The first line is the number of flooring options. Each line after is `FlooringType,PricePerSquareMeter`.

### Compile and run

```bash
javac FlooringFactory.java
java FlooringFactory
```

## Example Output

```
Welcome to the Flooring Factory!
Welcome to Fablous Frank's! We aim to please, or at the very least, cover your floors!

Enter the length of the room in meters: 5
Enter the width of the room in meters: 4
The area of the room is: 20.0 square meters.

1. Hardwood             $ 12.50
2. Laminate             $  8.00
...

-------------------------------------------
Material cost:              250.00
Labour charge:              130.00
                          ----------
Sub-total:                  380.00
HST:                         49.40
                          ----------
TOTAL COST:                 429.40
-------------------------------------------

The grand total for all estimates is: $429.40
```

## Why I Built It

Built as a Grade 11 Java project to practice file I/O, arrays, methods, formatted output, and building a multi-step interactive program with real-world business logic.

## Built With

Java
