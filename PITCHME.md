---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## Computer Science II

### Lecture 3

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## Getting connected

Today will be our first day working with code in the Git repository
- Using GitKraken, clone the [Lecture 3 materials](https://github.com/compsci-at-ccd/csc-161-400/tree/Lecture-3), or more specifically the code directory

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## Open and begin
It will start empty, but we will fill in the blanks.  At the end of class, I will commit our changes.

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## ArrayList and the JCF

### Creating an ArrayList

```java
ArrayList<Person> Personnel = new ArrayList<>();
```
@[1](What do the angle braces mean?)

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## ArrayList and the JCF

### Populating an ArrayList
```java
Personnel.add(new Person("Dave"));
```
@[1](How does this anonymous class work?)

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## ArrayList and the JCF

### What about LinkedList and ArrayDeque?
```java
LinkedList<Person> chainMail = new LinkedList<>();
Queue<Messages> inbox = new ArrayDeque<>();
```
@[1](Shall we check out the LinkedList?  What is different?)
@[2](What are applications where the add/remove of ArrayDeque are appropriate?)

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-279914.jpg

## ArrayList and the JCF

### Shall we play with any of the others?

- We can "parking lot" suggestions for the end, if we have time, or submit a "show me"
- page 457 of the Second Ed.

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363708.jpg

## Recursion

### The most common example, factorial

Why don't we just code this one up together, knowing that the factorial of a number is just that number multiplied by its predecessors to 1.

---?code=Binary.java&lang=java

@[18](You start with an ordered array (or list)...)
@[19](...and something to look for.)
@[21](Call the binary search function.)
@[4](We will search with the arguments: the array to search, the start (the locus), the end (the radix) and what we are looking for (L))
@[5](First, we make sure that through the recursive calls we have not have the end pass the beginning...)
@[6](We calculate the middle...)
@[7](and see if it matches.  This is actually an optimization.)
@[10](If the middle is not it, we need to decide if it is the left-hand side of the array...)
@[11](...or the right.)
@[14](Or worst case, it was not found at all.)

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363708.jpg

## Recursion

### Thoughts on performance and practicality


