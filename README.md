# Java Parking Lot - Semaphore

## Description
A simple Java project that simulates a parking lot with limited capacity
using a counting semaphore.

## Concepts Used
- Java Threads
- Runnable
- Semaphore
- P() and V()
- Shared Resources
- Thread Synchronization

## How It Works
- Multiple cars try to enter the parking lot.
- The semaphore controls the number of cars that can park at the same time.
- Each car calls P() before entering the parking lot.
- After leaving, the car calls V() to release the parking space.

## Technologies
- Java
- Git & GitHub
