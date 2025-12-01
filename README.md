# 🏢 Hostel Room Allocation System

[![Java](https://img.shields.io/badge/Java-24.0.2-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)]()

A robust, console-based Java application designed for efficient hostel room management. Features a user-friendly menu-driven interface with in-memory data persistence for seamless room allocation and tracking.

---

## 📋 Table of Contents

- [Features](#-features)
- [System Requirements](#-system-requirements)
- [Installation](#-installation)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Technical Details](#-technical-details)
- [Contributing](#-contributing)

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| ➕ **Add Room** | Register new rooms with unique room numbers, types, pricing, and availability status |
| 📊 **View Rooms** | Display comprehensive room inventory in a formatted tabular layout |
| 🔄 **Update Availability** | Modify room occupancy status (Available/Occupied) in real-time |
| 🗑️ **Delete Room** | Remove rooms from the system with validation checks |
| 🔍 **Search by Type** | Filter and retrieve rooms based on accommodation type |

---

## 💻 System Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 256 MB RAM
- **Disk Space**: 10 MB free space

---

## 🚀 Installation

### Step 1: Clone or Download
Download the project files to your local machine.

### Step 2: Navigate to Project Directory
```bash
cd path/to/java
```

### Step 3: Compile the Application
```bash
javac HostelRoomSystem.java
```

### Step 4: Run the Application
```bash
java HostelRoomSystem
```

---

## 📖 Usage

### Main Menu Interface

```
HOSTEL ROOM ALLOCATION SYSTEM
1. ADD ROOM
2. VIEW ROOMS
3. UPDATE AVAILABILITY
4. DELETE ROOM
5. SEARCH BY TYPE
0. EXIT
CHOOSE AN OPTION:
```

### Sample Workflow

#### Adding a New Room
```
CHOOSE AN OPTION: 1
ENTER ROOM NUMBER: 201
ENTER ROOM TYPE (Single/Double/Triple): Single
ENTER ROOM PRICE: 5500.00
ENTER AVAILABILITY (Available/Occupied): Available
✓ Room added successfully!
```

#### Viewing All Rooms
```
CHOOSE AN OPTION: 2

CURRENT ROOMS:
| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |
|---------|-------------|-----------|------------|--------------|
| 1       | 101         | Single    | 5000.00    | Available    |
| 2       | 102         | Double    | 7500.00    | Available    |
| 3       | 103         | Triple    | 9000.00    | Occupied     |
```

#### Searching by Room Type
```
CHOOSE AN OPTION: 5
ENTER ROOM TYPE TO SEARCH (Single/Double/Triple): Single

ROOMS OF TYPE: Single
| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |
|---------|-------------|-----------|------------|--------------|
| 1       | 101         | Single    | 5000.00    | Available    |
| 4       | 104         | Single    | 5000.00    | Available    |
```

---

## 📁 Project Structure

```
java/
│
├── HostelRoomSystem.java    # Main application entry point
├── Room.class                # Compiled room entity class
├── HostelRoomSystem.class    # Compiled main class
└── README.md                 # Documentation
```

### Core Components

- **`HostelRoomSystem.java`**: Main application controller with menu logic and business operations
- **`Room` Class**: Data model representing individual room entities with encapsulated properties

---

## 🔧 Technical Details

### Room Types Supported

| Type | Capacity | Typical Price Range |
|------|----------|---------------------|
| 🛏️ **Single** | 1 Person | ₹4,000 - ₹6,000 |
| 🛏️🛏️ **Double** | 2 Persons | ₹7,000 - ₹9,000 |
| 🛏️🛏️🛏️ **Triple** | 3 Persons | ₹9,000 - ₹12,000 |

### Data Persistence

- **Storage Method**: In-memory ArrayList
- **Session Scope**: Data persists during application runtime
- **Pre-loaded Data**: 5 sample rooms included for demonstration

### Key Technologies

- **Language**: Java (Core)
- **Data Structures**: ArrayList, Iterator
- **Design Pattern**: Procedural with Object-Oriented principles
- **I/O**: Scanner for console input/output

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

### Development Guidelines

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 👨‍💻 Author

**Developed with ☕ using Java**

---

## 📞 Support

For issues and queries, please create an issue in the repository.

---

**⭐ Star this repository if you found it helpful!**
