# BurgerKing Ordering System

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [How to Use](#how-to-use)
- [Contributors](#contributors)
- [License](#license)

## Introduction

This Java project implements a simple ordering system for a fictional fast-food restaurant called BurgerKing. The system allows users to order burgers, juices, and ice. It incorporates design patterns such as Singleton, Strategy, Observer, Decorator, Adapter, and Factory.

## Project Structure

The project is organized into several packages:

1. **Decorator**: Implements the decorator pattern for customizing burgers with toppings like cheese and lettuce.
    - `BasicBurger`: Represents a basic burger.
    - `Burger`: Defines the interface for burgers.
    - `Cheese` and `Lettuce`: Decorator classes for adding cheese and lettuce toppings.
    - `ToppingDecorator`: Abstract class for topping decorators.

2. **Adapter**: Implements the adapter pattern to adapt the internal stock system to the BurgerKing ordering system.
    - `InternalBKSystem`: Interface for the internal BurgerKing system.
    - `Stock`, `StockSystem`: Represents the stock system and its interface.
    - `StockManagementAdapter`: Adapter class for integrating the stock system with the ordering system.

3. **Factory**: Implements the factory pattern for creating different types of juices.
    - `Juice`, `JuiceFactory`: Defines the interface for juices and a factory for creating them.
    - `AppleJuice`, `GrapeJuice`, `OrangeJuice`: Concrete implementations of juices.

4. **Observer**: Implements the observer pattern for notifying clients about promotions or events.
    - `Client`: Represents a client with information such as ID, name, and VIP status.
    - `NotificationManager`, `Observed`, `Observer`: Implements the observer pattern for handling notifications.

5. **Singleton_Strategy**: Implements the singleton and strategy patterns for handling loyalty discounts and managing the BurgerKing instance.
    - `Basket`: Represents the basket of ordered products.
    - `BurgerKing`: Singleton class representing the BurgerKing restaurant and ordering system.
    - `LoyaltyDiscountStrategy`, `RegularCustomerDiscount`, `VIPCustomerDiscount`: Implements the strategy pattern for loyalty discounts.
    - `Product`: Interface for products.

6. **Main**: Contains the main class for running the BurgerKing ordering system.
    - `Main`: Main class with the `main` method for user interaction.

## How to Use

1. Run the `Main` class.
2. Follow the on-screen instructions to choose and customize burgers, order juices, view the check, and perform other actions.
3. Clients can be notified of promotions or events using the "makeAnons" option.

## Contributors

- [Alibek]

