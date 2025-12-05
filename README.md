# 🏢 Hostel Room Allocation System

[![Java](https://img.shields.io/badge/Java-24.0.2-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-9.2-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)]()

A robust, console-based Java application for efficient hostel room management with MySQL database integration. Features include room allocation, guest management, and real-time data persistence with a user-friendly menu-driven interface.

---

## 📋 Table of Contents

- [Features](#-features)
- [System Requirements](#-system-requirements)
- [Installation](#-installation)
- [Database Setup](#-database-setup)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Technical Details](#-technical-details)

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| ➕ **Add Room** | Register new rooms with room number, type, price, and availability |
| 📊 **View Rooms** | Display all rooms in a formatted table |
| 🔄 **Update Availability** | Modify room occupancy status (Available/Occupied) |
| 🗑️ **Delete Room** | Remove rooms from the system |
| 🔍 **Search by Type** | Find rooms by accommodation type (Single/Double/Triple) |

---

## 💻 System Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **MySQL Server**: Version 8.0 or higher
- **MySQL Connector/J**: JDBC Driver (included in project)
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512 MB RAM
- **Disk Space**: 50 MB free space

---

## 🚀 Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/NikithaKunapareddy/Hostel-Room-Allocation-System.git
cd Hostel-Room-Allocation-System
```

### Step 2: Install MySQL
Download and install MySQL Server from [https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)

### Step 3: Download MySQL Connector
1. Download MySQL Connector/J from [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
2. Extract the ZIP file
3. Copy `mysql-connector-j-9.5.0.jar` to the project directory

---

## 🗄️ Database Setup

### Step 1: Start MySQL Service

**Windows:**
```powershell
net start MySQL92
```

**Linux/Mac:**
```bash
sudo service mysql start
```

### Step 2: Create Database and Table

Run the following SQL commands in MySQL Workbench or command line:

```sql
CREATE DATABASE IF NOT EXISTS hostel_db;

USE hostel_db;

CREATE TABLE IF NOT EXISTS rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT UNIQUE NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    availability VARCHAR(20) NOT NULL
);
```

Or execute the provided SQL file:
```bash
mysql -u root -p < setup.sql
```

### Step 3: Configure Database Connection

Update `DBConnection.java` with your MySQL credentials:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hostel_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";  // Change this!
```

---

## 🎮 Usage

### Compile the Application
```bash
javac -cp ".;mysql-connector-j-9.5.0.jar" DBConnection.java HostelRoomSystem.java
```

### Run the Application
```bash
java -cp ".;mysql-connector-j-9.5.0.jar" HostelRoomSystem
```

**Note:** On Linux/Mac, use `:` instead of `;`:
```bash
javac -cp ".:mysql-connector-j-9.5.0.jar" DBConnection.java HostelRoomSystem.java
java -cp ".:mysql-connector-j-9.5.0.jar" HostelRoomSystem
```

---

## 📖 Main Menu Interface

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

---

## 💡 Sample Workflow

### Adding a New Room
```
CHOOSE AN OPTION: 1
ENTER ROOM NUMBER: 101
ENTER ROOM TYPE (Single/Double/Triple): Single
ENTER ROOM PRICE: 5000
ENTER AVAILABILITY (Available/Occupied): Available
Room added successfully!
```

### Viewing All Rooms
```
CHOOSE AN OPTION: 2

CURRENT ROOMS:
| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |
|---------|-------------|-----------|------------|--------------|
| 1       | 101         | Single    | 5000.00    | Available    |
| 2       | 102         | Double    | 7500.00    | Occupied     |
| 3       | 103         | Triple    | 9000.00    | Available    |
```

### Updating Room Availability
```
CHOOSE AN OPTION: 3
ENTER ROOM NUMBER TO UPDATE: 101
ENTER NEW AVAILABILITY (Available/Occupied): Occupied
Room availability updated successfully!
```

### Searching by Room Type
```
CHOOSE AN OPTION: 5
ENTER ROOM TYPE TO SEARCH (Single/Double/Triple): Single

ROOMS OF TYPE: Single
| ROOM ID | ROOM NUMBER | ROOM TYPE | PRICE      | AVAILABILITY |
|---------|-------------|-----------|------------|--------------|
| 1       | 101         | Single    | 5000.00    | Occupied     |
```

### Deleting a Room
```
CHOOSE AN OPTION: 4
ENTER ROOM NUMBER TO DELETE: 103
Room deleted successfully!
```

---

## 📁 Project Structure

```
Hostel-Room-Allocation-System/
│
├── HostelRoomSystem.java           # Main application with menu logic
├── DBConnection.java                # MySQL database connection handler
├── setup.sql                        # Database schema setup script
├── mysql-connector-j-9.5.0.jar     # MySQL JDBC driver
├── README.md                        # Project documentation
└── .gitignore                       # Git ignore configuration
```

---

## 🔧 Technical Details

### Room Types Supported

| Type | Capacity | Typical Price Range |
|------|----------|---------------------|
| 🛏️ **Single** | 1 Person | ₹4,000 - ₹6,000 |
| 🛏️🛏️ **Double** | 2 Persons | ₹7,000 - ₹9,000 |
| 🛏️🛏️🛏️ **Triple** | 3 Persons | ₹9,000 - ₹12,000 |

### Database Schema

**Table: `rooms`**
| Column | Type | Constraints |
|--------|------|-------------|
| room_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| room_number | INT | UNIQUE, NOT NULL |
| room_type | VARCHAR(50) | NOT NULL |
| price | DECIMAL(10,2) | NOT NULL |
| availability | VARCHAR(20) | NOT NULL |

### Data Persistence

- **Storage**: MySQL Relational Database
- **Persistence**: Permanent data storage
- **ACID Compliance**: Full transactional support
- **Advantage**: Data survives application restarts
- **Connection**: JDBC (Java Database Connectivity)

### Key Technologies

- **Language**: Java SE 24.0.2
- **Database**: MySQL 9.2
- **JDBC Driver**: MySQL Connector/J 9.5.0
- **Design Pattern**: MVC-inspired architecture
- **I/O**: Scanner for console input/output
- **Version Control**: Git & GitHub

---

## 🎯 Key Highlights

- ✅ **Persistent Storage** - MySQL database for permanent data retention
- ✅ **CRUD Operations** - Complete Create, Read, Update, Delete functionality
- ✅ **Zero Data Loss** - Data persists even after program termination
- ✅ **SQL Integration** - Professional database connectivity
- ✅ **User-Friendly** - Simple menu-driven interface
- ✅ **Input Validation** - Prevents duplicate room numbers
- ✅ **Error Handling** - Graceful error messages
- ✅ **Clean Code** - Well-structured and maintainable

---

## 📊 View Data in MySQL Workbench

After adding rooms, you can view them in MySQL Workbench:

```sql
USE hostel_db;
SELECT * FROM rooms;
```

This will display all stored room data in a table format.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Developed with ☕ using Java and MySQL**

GitHub: [@NikithaKunapareddy](https://github.com/NikithaKunapareddy)

---

## 📞 Support

For issues and queries, please create an issue in the repository.

---

**⭐ Star this repository if you found it helpful!**

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
