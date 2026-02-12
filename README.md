# Speed Reader

## About

Week 3 Lab & Project: Speed-reader

### Authors

*  Valeriia Kosse and Juan Diego 

### Resources

*   Lab Manual: https://osera.cs.grinnell.edu/ttap/data-structures-labs/semantic-mysteries.html
*   Project Description: https://osera.cs.grinnell.edu/ttap/data-structures-labs/speed-reader.html
*   VSCode + quickfix functionality for @throws
*   `DrawingPanel.java` adapted from _[Building Java Programs](https://www.buildingjavaprograms.com/) by Reges and Stepp.
*   Words per Minute explained(to understand the waiting time for displaying): https://muted.io/bpm-to-ms/#:~:text=Just%20take%2060%2C000%20(the%20amount,given%20a%20BPM%20of%20111:
*   test1.txt: https://en.wikipedia.org/wiki/Super_Bowl_LX
*   test2.txt: https://en.wikipedia.org/wiki/Super_Mario
*   test3.txt: https://en.wikipedia.org/wiki/Clownfish
*   test4.txt: https://en.wikipedia.org/wiki/Galaxy
*   test5.txt: https://en.wikipedia.org/wiki/Greenland
*   test6.txt: https://en.wikipedia.org/wiki/Sabellastarte_spectabilis
*   test7.txt: https://en.wikipedia.org/wiki/Battle_of_Stalingrad
*   test8.txt: https://en.wikipedia.org/wiki/Tennis

* WordCounter: https://wordcounter.net



## Write-up

### Semantic Mysteries

#### Problem 1.1

- change1 takes a copy of the value of input parameter x, and changing x only affects the local copy
- change2 takes the reference to the Cell object, so modifying c.x modifies the original object's variable
- change3: takes the reference to the Cell object, so modifying c.x modifies the original object's variable; later c = new Cell(0) reassigns c to point to a new object, but original variable still points to the original object

Java is similar to C, where the actual value of primitive data types is copied, but the reference (memory address) to objects is copied

#### Problem 1.2

"this" is an implicit reference to the current object's parameter/method

Counter1.increment(): value refers to the instance field, so value += 1 increments the object's field by 1

Counter2.increment(int value): naming ambiguity, the value field of the object is never accessed or modified, value parameter is only changed locally and 'wasted'

Counter3.increment(int value): naming ambiguity, but this.value explicitly refers to the value field of the object, so this.value += value increments field value by the value of input parameter

Counter4.increment(int value): naming ambiguity, but this.value explicitly refers to the value field of the object; yet, value += this.value adds the value of field value to teh input parameter, so it is only changed locally and 'wasted'

#### Problem 1.3

Non-static variables/methods belong to individual objects, meanwhile static ones belong to the class itself and are shared by all objects created from this class. The problem with the Counter code is using 'this' with static field; instead static variables should be accessed via class name 
(so like Counter.value). Also, all Counter objects share the same value, so incrementing one affects all (not always what we want to do).

The printGreetings code doesn't work because main is static and printGreeting() is non-static, so there has to be an object of class Static, so that printGreeting() can be called on that object within main. 

#### Problem 1.4

c1 == c2: 
can expect to print true since both counters have value = 0, but prints false, because the == operator compares memory addresses, not the actual contents of objects. c1 and c2 are two separate Counter objects stored at different locations in memory.

string literals: 
prints true, because if the compiler encounters identical string literals like "hello", it stores only one copy in a special memory area for string literals. s1 and s2 reference the exact same String object in memory.

Scanner: 
even if the user types the exact same text for both inputs, this prints false, because nextLine() creates new String objects in memory, so even though the strings have identical contents, they're stored at different memory addresses.

#### Problem 2.1

(always: ✓, sometimes: ?, never: ✗)

*   Point A:
    + `x1 == 0`: ?
    + `x2 < 0`: ?
*   Point B:
    + `x1 == 0`: ?
    + `x2 < 0`: x
*   Point C:
    + `y1 < 5`: ?
    + `y2 > 0`: ?
*   Point D:
    + `z > y1`: x
    + `z < 0`: ?

#### Problem 2.2

(always: ✓, sometimes: ?, never: ✗)

|         | `s.length >= 2` | `ret.length() > 0` | `ret.length() % 2 == 0`
| ------- | --------------- | ------------------ | -----------------------
| Point A |       ?         |          x         |           ✓
| Point B |       ✓         |          x         |           ✓
| Point C |       ✓         |          ?         |           ✓
| Point D |       ✓         |          ✓         |           ✓
| Point E |       ✓         |          ✓         |           ✓

### Empirical Complexity Analysis

As the size of the array grows at an exponential rate the runtime (wall-clock time) increases much more significantly than at exponetial rate. It is most observable when increasing from 1000 to 100000 (or even 10000) as the time needed for 
- length 10 is 0.048 sec, 
- length 1000 is 0.137 sec,
- meanwhile length 10000 and 100000 cannot be computed (the program runs infinitely(ish))


Same tendency is observed for count and the nr of times the array is accessed increases more than exponentially:
- length 10: count 301
- length 1000: count 167670440
- length 10000 or 100000: count uncomputable as the run is never completed (the program runs infinitely(ish))

What we can observe is that compute1 takes the most computation power and time since its design involves another loop through the array. 


### SpeedReader test - human computer interaction

The results of this study reveal that normal, self-paced reading produced the best comprehension at 67% (across 3 students), so controlling your own speed remains the best practice for understanding text. There appears to be a comprehension threshold somewhere in the 350-500 wpm range. Some readers are able to maintain good comprehension at these higher speeds, while others experience significant drops in understanding. Most surprisingly though, slower speed reading at 250 WPM did not improve comprehension as expected, but performed worse than faster speeds, which could indicate that this pace is too slow to maintain reader engagement.