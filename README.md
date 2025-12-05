# 🏨 Hostel Room Allocation System

[![Java](https://img.shields.io/badge/Java-24.0.2-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-9.2-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)]()

A robust, console-based Java application for efficient hostel room reservation management with MySQL database integration. Features include room reservation, guest management, and real-time data persistence with a user-friendly menu-driven interface.

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
| 🛏️ **Reserve a Room** | Book rooms with guest name, contact number, room details, and pricing |
| 📊 **View Reservations** | Display all reservations in a clean formatted table |
| 🔍 **Get Room Number** | Search room by reservation ID and guest name |
| 🔄 **Update Reservations** | Modify guest details and room information |
| 🗑️ **Delete Reservation** | Remove reservations from the system |

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

DROP TABLE IF EXISTS rooms;

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100) NOT NULL,
    room_number INT NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    availability VARCHAR(20) NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
## 📖 Main Menu Interface

```
HOSTEL ROOM ALLOCATION SYSTEM
1. RESERVE A ROOM
2. VIEW RESERVATIONS
3. GET ROOM NUMBER
4. UPDATE RESERVATIONS
5. DELETE RESERVATION
0. EXIT
CHOOSE AN OPTION:
```

---

## 💡 Sample Workflow

### Reserving a Room
```
CHOOSE AN OPTION: 1
ENTER GUEST NAME: Nikki
ENTER ROOM NUMBER: 103
ENTER CONTACT NUMBER: 8976451234
ENTER ROOM TYPE: Single
ENTER PRICE: 10000.00
ENTER AVAILABILITY (Reserved/Available): Reserved
Reservation successful!
```

### Viewing All Reservations
<pre>
CHOOSE AN OPTION: 2

========================================================================================================
                                    CURRENT RESERVATIONS
========================================================================================================
ID     GUEST           ROOM NO      CONTACT         ROOM TYPE    PRICE      STATUS       DATE & TIME         
--------------------------------------------------------------------------------------------------------
3      Nikki           103          8976451234      Single       10000.00   Reserved     05-Dec-2025 14:13   
2      Krishna         102          7896543671      Double       50000.00   Available    05-Dec-2025 13:44   
1      Nikki           931          9347093126      Standard     0.00       Reserved     05-Dec-2025 13:30   
========================================================================================================
</pre>
---

### Getting Room Number
```
CHOOSE AN OPTION: 3
ENTER RESERVATION ID: 1
ENTER GUEST NAME: Nikki
Room Number: 931
```

### Updating a Reservation
```
CHOOSE AN OPTION: 4
ENTER RESERVATION ID TO UPDATE: 1
ENTER NEW GUEST NAME: Nikitha
ENTER NEW ROOM NUMBER: 931
ENTER NEW CONTACT NUMBER: 9347093126
ENTER NEW ROOM TYPE: Deluxe
ENTER NEW PRICE: 15000.00
ENTER NEW AVAILABILITY: Reserved
Reservation updated successfully!
```

### Deleting a Reservation
```
CHOOSE AN OPTION: 5
ENTER RESERVATION ID TO DELETE: 1
Reservation deleted successfully!
```

---

## 📁 Project Structure

```
Hostel-Room-Allocation-System/
│
├── HostelRoomSystem.java           # Main reservation management application
├── DBConnection.java                # MySQL database connection handler
├── setup.sql                        # Database schema setup script
├── mysql-connector-j-9.5.0.jar     # MySQL JDBC driver (9.5.0)
├── README.md                        # Complete project documentation
└── .gitignore                       # Git ignore configuration
```

### File Descriptions

| File | Purpose | Lines of Code |
|------|---------|---------------|
| `HostelRoomSystem.java` | Main application with menu interface and 5 core features | ~200 |
| `DBConnection.java` | Handles MySQL database connectivity using JDBC | ~30 |
| `setup.sql` | SQL script to create database and tables | ~15 |
| `mysql-connector-j-9.5.0.jar` | JDBC driver for MySQL connectivity | Library |
| `README.md` | Comprehensive documentation | Documentation |
| `.gitignore` | Git exclusion rules | Configuration |

### File Descriptions

| File | Purpose | Description |
|------|---------|-------------|
| `HostelRoomSystem.java` | Main Application | Contains all reservation management logic and menu interface |
| `DBConnection.java` | Database Handler | Manages MySQL connection and JDBC driver loading |
| `setup.sql` | Database Schema | SQL script to create database and tables |
| `mysql-connector-j-9.5.0.jar` | JDBC Driver | MySQL connector library for database connectivity |
| `README.md` | Documentation | Complete project documentation and usage guide |
| `.gitignore` | Version Control | Git configuration to exclude unnecessary files |

---

## 🔧 Technical Details

### Database Schema

**Table: rooms**
| Column | Type | Description |
|--------|------|-------------|
| room_id | INT (PK, AUTO_INCREMENT) | Unique reservation ID |
| guest_name | VARCHAR(100) | Guest's full name |
| room_number | INT | Allocated room number |
| contact_number | VARCHAR(20) | Guest contact number |
| room_type | VARCHAR(50) | Room category (Single/Double/Suite/etc.) |
| price | DECIMAL(10,2) | Room price |
| availability | VARCHAR(20) | Status (Reserved/Available) |
| reservation_date | TIMESTAMP | Auto-generated booking timestamp |

### Room Types Supported

| Type | Typical Price Range | Common Use |
|------|---------------------|------------|
| 🛏️ **Single** | 1 Person | ₹4,000 - ₹6,000 |
| 🛏️🛏️ **Double** | 2 Persons | ₹7,000 - ₹9,000 |
| 🛏️🛏️🛏️ **Triple** | 3 Persons | ₹9,000 - ₹12,000 |

### Database Schema

**Table: `rooms`**
| Type | Typical Price Range | Common Use |
|------|---------------------|------------|
| Single | ₹5,000 - ₹10,000 | Individual guests |
| Double | ₹7,500 - ₹15,000 | Two guests |
| Suite | ₹15,000 - ₹30,000 | Premium guests |
| Deluxe | ₹20,000 - ₹50,000 | VIP guests |

### Data Persistence

- **Storage**: MySQL Relational Database
- **Persistence**: Permanent data storage with timestamps
- **ACID Compliance**: Full transactional support
- **Advantage**: Data survives application restarts
- **Connection**: JDBC (Java Database Connectivity)
- **Auto-Timestamp**: Automatic reservation date recording

### Key Technologies

- **Language**: Java SE 24.0.2
- **Database**: MySQL 9.2
- **JDBC Driver**: MySQL Connector/J 9.5.0
- **Design Pattern**: MVC-inspired architecture
- **I/O**: Scanner for console input/output
- **Date Formatting**: SimpleDateFormat for clean timestamps
- **Version Control**: Git & GitHub

---

## 🎯 Key Highlights

- ✅ **Persistent Storage** - MySQL database for permanent data retention
- ✅ **Guest Management** - Complete reservation tracking with guest details
- ✅ **Timestamp Recording** - Automatic reservation date and time logging
- ✅ **Zero Data Loss** - Data persists even after program termination
- ✅ **SQL Integration** - Professional database connectivity
- ✅ **User-Friendly** - Simple menu-driven interface with clean table display
- ✅ **Formatted Output** - Beautiful console tables with proper alignment
- ✅ **Error Handling** - Graceful error messages
- ✅ **Clean Code** - Well-structured and maintainable

---

## 📊 View Data in MySQL Workbench

After making reservations, you can view them in MySQL Workbench:

```sql
USE hostel_db;
SELECT * FROM rooms ORDER BY reservation_date DESC;
```

This will display all stored reservation data in a table format with the latest bookings first.

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
