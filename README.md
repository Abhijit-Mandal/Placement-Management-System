# 🧑‍🎓 **Placement Management System** 🧑‍🎓
### **PLACEMENT (OF STUDENTS IN A COLLEGE) DATA MANAGEMENT SYSTEM:**
- This project is a simple Placement Data Management System. In this project you will be learning how to add new students record to the database, how to generate a 5 digit unique ID for each student, how to remove a student from non-placed list to the placed list, student company location, package. Also, you will be implementing the following operations add, view, show status, etc. The status will show all the details of the students including name, id, date of birth, company, package, etc.

### 💻 **IMPLEMENTATION:** 💻
- Design GUI based inter-face for user, by using which user able to login to system with proper authentication.
- Specify operation according to types of use i.e., if the user is administrator he/she able to insert, update, and display data from database. If the user is a general user he only able to see the information of a student.
- User able to get the status of the students in a nicely formatted text file.
- Use any database (Oracle/MySQL) to store the required data.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)   ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

_**GUI (Graphical User Interface)** in Java is an easy-to-use visual experience builder for Java applications. It is mainly made of graphical components like buttons, labels, windows, etc. through which the user can interact with an application. GUI plays an important role to build easy interfaces for Java applications. For this project, we need to create a GUI based JAVA program for the Placement Data Management System. We will be having two types of users that will login in to the system i.e. Students and Admin, both will require their own interface as per the requirement. The Student can only view his/her details given that he provides his name and UID correctly. Student cannot edit their details. Admin can add, update and view Student details as per college’s requirement. To solve the above problem, I have created two tabs, admin and student individually. Admin will open the Admin Panel and login and Students will open Student Panel and View their details with proper authentication details._



_**Java Database Connectivity (JDBC)** is an application programming interface (API) for the programming language Java, which defines how a client may access a database. 
It is a Java-based data access technology used for Java database connectivity. It is part of the Java Standard Edition platform, from Oracle Corporation. It provides methods to query and update data in a database, and is oriented toward relational databases. A JDBC-to-ODBC bridge enables connections to any ODBC-accessible data source in the Java virtual machine (JVM) host environment. For this project, I have used MySQL software to store the Student details and authentication details. Whenever any Student or Admin will login, MySQL will run a query using given data and will authenticate only if the data is matched with the Database entries._

### **FlowChart of the Problem:** 💡
![](https://i.imgur.com/KKvNKGJl.png)

### **App Preview:**
![Imgur](https://i.imgur.com/Nz8xhGWl.png)
![Imgur](https://i.imgur.com/SodcQ9El.png)
![Imgur](https://i.imgur.com/6hGQxm1l.png)
