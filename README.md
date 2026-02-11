# Calorie Tracker

A beginner Java programming exercise written in **March 2022** when first learning object-oriented programming.

## Purpose
Calculate daily calorie balance by tracking food intake and exercise. Implements file I/O, class design, calorie formulas (gender/age/weight/height-based), and command processing with output generation.

## Usage
```bash
javac *.java
java Main command.txt
```

Reads `people.txt`, `food.txt`, `sport.txt` and processes commands from `command.txt`. Outputs tracking data to `monitoring.txt`.

**Commands:** `personID foodID portions` | `personID sportID duration` | `print(personID)` | `printList` | `printWarn`
