# 🏢 Hostel Room Allocation System

[![Java](https://img.shields.io/badge/Java-24.0.2-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)]()
[![Status](https://img.shields.io/badge/Status-Active-success.svg)]()
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)]()

A robust, feature-rich console-based Java application designed for efficient hostel room management. This system provides a comprehensive solution for managing room allocations, guest bookings, and hostel operations with a user-friendly menu-driven interface and real-time data management.

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

### 🔧 Core Room Management
| Feature | Description |
|---------|-------------|
| ➕ **Add Room** | Register new rooms with unique room numbers, types, pricing, and availability status |
| 📊 **View All Rooms** | Display comprehensive room inventory with guest information in a formatted table |
| 🔄 **Update Availability** | Modify room occupancy status (Available/Occupied) in real-time |
| ✏️ **Update Room Details** | Edit room type and pricing information for existing rooms |
| 🗑️ **Delete Room** | Remove rooms from the system with validation checks |

### 🔍 Advanced Search & Filter
| Feature | Description |
|---------|-------------|
| 🏷️ **Search by Type** | Find rooms by accommodation type (Single/Double/Triple) |
| 🔓 **Search by Availability** | Filter rooms based on occupancy status |
| 💰 **Search by Price Range** | Retrieve rooms within specified budget constraints |
| 🔢 **Search by Room Number** | Get detailed information for specific rooms |

### 👥 Guest Management
| Feature | Description |
|---------|-------------|
| 🛎️ **Allocate Room to Guest** | Assign available rooms to guests with name tracking |
| 🚪 **Check-Out Guest** | Process guest departures and update room availability |

### 📊 Analytics & Reporting
| Feature | Description |
|---------|-------------|
| 📈 **Room Statistics Dashboard** | View comprehensive analytics including occupancy rates, revenue, and room distribution |
| ⚡ **Sort Rooms** | Organize rooms by number, price, or type in ascending/descending order |

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
========================================
   HOSTEL ROOM ALLOCATION SYSTEM
========================================
1.  ADD ROOM
2.  VIEW ALL ROOMS
3.  UPDATE AVAILABILITY
4.  UPDATE ROOM DETAILS
5.  DELETE ROOM
6.  SEARCH BY TYPE
7.  SEARCH BY AVAILABILITY
8.  SEARCH BY PRICE RANGE
9.  SEARCH BY ROOM NUMBER
10. ALLOCATE ROOM TO GUEST
11. CHECK-OUT GUEST
12. VIEW ROOM STATISTICS
13. SORT ROOMS
0.  EXIT
========================================
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
Room added successfully!
```

#### Allocating Room to Guest
```
CHOOSE AN OPTION: 10
ENTER ROOM NUMBER TO ALLOCATE: 201
ENTER GUEST NAME: John Doe
Room allocated successfully to John Doe!
```

#### Viewing All Rooms
```
CHOOSE AN OPTION: 2

========================================
            CURRENT ROOMS
========================================
| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY | GUEST NAME      |
|---------|-------------|-----------|------------|--------------|-----------------|
| 1       | 201         | Single    | 5500.00    | Occupied     | John Doe        |
| 2       | 202         | Double    | 7500.00    | Available    | -               |
| 3       | 203         | Triple    | 9000.00    | Occupied     | Jane Smith      |
========================================
```

#### Viewing Statistics Dashboard
```
CHOOSE AN OPTION: 12

========================================
       HOSTEL ROOM STATISTICS
========================================
Total Rooms          : 15
Occupied Rooms       : 8
Available Rooms      : 7
Occupancy Rate       : 53.33%
----------------------------------------
Room Distribution:
  Single Rooms       : 6
  Double Rooms       : 5
  Triple Rooms       : 4
----------------------------------------
Average Room Price   : ₹6500.00
Current Revenue      : ₹52000.00
Potential Revenue    : ₹97500.00
========================================
```

---

## 📁 Project Structure

```
Hostel-Room-Allocation-System/
│
├── HostelRoomSystem.java    # Main application with all features
├── README.md                 # Complete documentation
└── .gitignore               # Git ignore configuration
```

### Core Components

- **`HostelRoomSystem.java`**: Main application controller with menu logic and 13 feature implementations
- **`Room` Class**: Data model representing individual room entities with encapsulated properties including guest information

---

## 🔧 Technical Details

### Room Types Supported

| Type | Capacity | Typical Price Range |
|------|----------|---------------------|
| 🛏️ **Single** | 1 Person | ₹4,000 - ₹6,000 |
| 🛏️🛏️ **Double** | 2 Persons | ₹7,000 - ₹9,000 |
| 🛏️🛏️🛏️ **Triple** | 3 Persons | ₹9,000 - ₹12,000 |

### Data Persistence

- **Storage Method**: In-memory ArrayList (session-based)
- **Session Scope**: Data persists during application runtime only
- **Advantage**: Fast, lightweight, no external dependencies
- **Note**: Data is cleared when application exits (perfect for demonstration and testing)

### Key Technologies

- **Language**: Java SE 24.0.2
- **Data Structures**: ArrayList, Iterator, Comparator
- **Design Pattern**: Object-Oriented Programming with encapsulation
- **I/O**: Scanner for console input/output
- **Sorting**: Built-in Java Comparator interface
- **Version Control**: Git & GitHub

---

## 🎯 Key Highlights

- ✅ **13 Comprehensive Features** - Complete hostel management solution
- ✅ **Zero Dependencies** - Pure Java implementation, no external libraries
- ✅ **Object-Oriented Design** - Clean, maintainable code structure
- ✅ **Real-time Updates** - Instant data modification and retrieval
- ✅ **Advanced Analytics** - Revenue tracking and occupancy statistics
- ✅ **User-Friendly Interface** - Intuitive menu-driven navigation
- ✅ **Input Validation** - Duplicate room number prevention
- ✅ **Flexible Sorting** - Multiple sort options available

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
