# School-Management-System
School Management System using Java FX
Attendance Management

•	Record attendance details more efficiently

•	Retrieve attendance details efficiently

•	Quick and easy leave apply




Library

•	Search books more efficiently

•	less time consuming processes

•	maintain a data base records of borrowers

•	reminder of due dates

•	very easy to work with and less complexity


Academic reports

•	Add and update marks more efficiently

•	Find the results more efficiently.

•	Maintain a database for store student marks

•	Calculate average and minimum/maximum marks automatically
profile management and notifications

•	easy searching for profiles

•	guaranteed notice distribution


Sports Management

•	easy to keep track of school’s sports achievements

•	efficient way to access team details and coach details

•	easy to check stock details


Calendar,Timetable and Inventory Management

•	Keep track of the events currently happening

•	Gets an early headcount for an event

•	Manage lab equipments

•	Manage time more efficiently


Payment Management

•	Handle payment processes easily

•	Due fees reminders make it easier to collect payments
# Profile Management

In the profile management module, login and searching for others’ profiles are main requirements.
Below are the use case scenarios and the activity diagrams for them.
 

Use case name
Primary actor

Main events
 


: Login
: Student/Staff

 

1)	System prompts the user with login interface.
2)	User enters the username and press next.
3)	User enters the password and press login.
4)	System shows the main interface.

Extensions :

2a) If the username is not found in database, display an error.
3a) If the password does not match with the given username, display an error.
Use case name Primary actor Pre-condition
 


: Search Profiles
: Student/Staff

: Successfully login to the system

 

Main events
 

1)	System prompts user with searching interface.

2)	User enters which type (student/staff), criteria (no/name/class), keyword to search. Pess search.

3)	System access database and get records with matching keywords.
4)	Display results in a table.

Extensions :

2a) If at least one field is missing, user is given an error.
3a) If no records are matching, an error is displayed.
Academic Reports

In the Academic reports module, Add marks and View marks are main requirements. Below are the use case scenarios and the activity diagrams for them.
 

Use case name
Primary actor
Pre-condition
 


: Add marks to the database
: Teacher

: Teacher successfully login to the system

 

Main events:	
1)	The teacher selects the add marks button on the main UI.
2)	System displays the add marks window.
3)	The teacher can insert marks to the database.
4)	System will prompt successfully message.
5)	Then update the table which on the window.
6)	Use case ends when teacher logged out.

Extension:

3)	a.1 teacher should enter a valid mark (0<= mark <=100). If not, system will prompt error message to enter marks again.

a.2 when teacher enter invalid student ID or subject ID again system will prompt error message.

Develop in Development Branch
