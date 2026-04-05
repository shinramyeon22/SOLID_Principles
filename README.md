# Order System Refactored with SOLID Principles

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)
![SOLID](https://img.shields.io/badge/SOLID%20Principles-Applied-success?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Design%20Patterns-green?style=for-the-badge)

**A clean, maintainable Java demonstration of the Interface Segregation Principle (ISP) from the SOLID principles.**

---

## 📋 Table of Contents
- [Project Overview](#-project-overview)
- [Problem Statement](#-problem-statement)
- [SOLID Principles Applied](#-solid-principles-applied)
- [Solution Architecture](#-solution-architecture)
- [UML Class Diagram](#-uml-class-diagram)
- [Key Benefits](#-key-benefits)
- [How to Run](#-how-to-run)
- [Project Structure](#-project-structure)
- [References](#-references)

---

## 🚀 Project Overview

This project demonstrates a **professional-grade refactoring** of a monolithic “fat interface” into a SOLID-compliant design. The original code forced classes and clients to depend on methods they didn’t need. The refactored version follows industry best practices taught in the *SOLID Principles in Object-oriented Programming* module.

**Language:** Java 21+  
**Focus Principle:** Interface Segregation Principle (ISP)  
**Secondary Improvements:** Single Responsibility Principle (SRP) + Dependency Inversion Principle (DIP)

---

## ❌ Problem Statement

The original design violated the **Interface Segregation Principle (ISP)** (SOLID Principles.pdf, pages 10–12):

- A single large `Order` interface contained four unrelated responsibilities:
  - Calculating totals
  - Placing orders
  - Generating invoices
  - Sending email notifications
- `OrderAction` and every client (including `OrderTest`) were forced to implement or depend on **all** methods — even those not needed for a particular use case.
- This led to:
  - Tight coupling
  - Brittle, hard-to-test code
  - Poor maintainability and scalability
  - Violation of the “clients should not depend on interfaces they do not use” rule

> “Fat interfaces contain many methods… Clients then end up implementing methods they don’t need.”  
> — *SOLID Principles.pdf, page 10*

---

## ✅ SOLID Principles Applied

| Principle | How It Was Applied | Reference in PDF |
|-----------|--------------------|------------------|
| **ISP**   | Split fat `Order` interface into four small, client-specific interfaces | Pages 10–12 |
| **SRP**   | Each interface now has a single, clear responsibility | Pages 2–4 |
| **DIP**   | High-level clients depend on abstractions (interfaces), not concrete classes | Pages 12–14 |
| **OCP**   | New order types can be added by implementing only required interfaces — no modification of existing code | Pages 4–6 |

---

## 📐 Solution Architecture

The refactored design uses **four cohesive, segregated interfaces**:

- `OrderCalculator` – Handles total calculation
- `OrderPlacer` – Handles order placement
- `InvoiceGenerator` – Handles invoice creation
- `NotificationSender` – Handles email notifications

`OrderAction` implements **only** the interfaces it actually needs. Clients receive the exact abstraction they require, eliminating unnecessary dependencies.

---

## 🧩 UML Class Diagram



- Four small, segregated interfaces  
- `OrderAction` implementing only the interfaces it needs  
- `OrderTest` depending on specific abstractions (ISP in action)

```mermaid
classDiagram
    class OrderCalculator {
        +void calculateTotal(double price, int quantity)
    }
    class OrderPlacer {
        +void placeOrder(String customerName, String address)
    }
    class InvoiceGenerator {
        +void generateInvoice(String fileName)
    }
    class NotificationSender {
        +void sendEmailNotification(String email)
    }

    class OrderAction {
    }

    OrderAction ..|> OrderCalculator : implements
    OrderAction ..|> OrderPlacer : implements
    OrderAction ..|> InvoiceGenerator : implements
    OrderAction ..|> NotificationSender : implements

    class OrderTest {
        +main(String[] args)
    }

    note for OrderTest "Clients depend only on the specific interfaces they need"
