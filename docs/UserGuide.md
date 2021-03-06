---
layout: page
title: User Guide
---

<a name="introduction"></a>
## Welcome to HEY MATEz
As a Club leader, are you struggling to **keep track of the ever-changing members** of your club as well as **manage 
the mountain of tasks** that have to be completed? Or perhaps it is a challenge to **keep track of the increasing 
number of tasks** and be able to **assign these tasks to members efficiently**. 

HEY MATEz is a desktop application to get rid of your woes by allowing you to **track 
members** and **tasks** within the club **efficiently and easily**! It is
a Command Line Interface (CLI) application which handles user requests that are typed into the input box as commands.

With HEY MATEz, managing and distributing tasks will never be a headache again! :smile:

## About this User Guide
This user guide includes information on the **features** of HEY MATEz as well as a walkthrough on how to use them. The features 
are further divided into 3 sections which include the **General features**, **Member related features** as well as the **Task related features**.
Member related features allow you to manage a list of members and find members. On the other hand, Task related features allow you
to manage tasks which can be identified by their unique deadlines or priorities.

* [Introduction](#introduction)  
* [Quick Start](#quick-start)  
* [Features](#features)
  + [General Features](#general)
    - [1. Clear all data in application: `clear`](#clear)
    - [2. Exiting the programme: `exit`](#exit)
    - [3. View Help: `help`](#help)
  + [Member Related Features](#members)
    - [1. Add Member: `addMember`](#addMember)
    - [2. Delete Member: `deleteMember`](#deleteMember)
    - [3. View Members: `viewMembers`](#viewMembers)
    - [4. Edit Member: `editMember`](#editMember)
    - [5. Find Members by Keywords: `findMembers`](#findMember)
  + [Task Related Features](#tasks)
    - [1. Add Task: `addTask`](#addTask)
    - [2. Delete Task: `deleteTask`](#deleteTask)
    - [3. View Tasks: `viewTasks`](#viewTasks)
    - [4. Edit Task: `editTask`](#editTask)
    - [5. Mark Task as Completed: `done`](#doneTask)
    - [6. Mark Task as Uncompleted: `undo`](#undoTask)
    - [7. Find Tasks by Keywords: `findTasks`](#findTask)
    - [8. Find Tasks due before certain date: `findBefore`](#findBefore)
    - [9. Find Tasks by Priority: `findPriority`](#findPriority)
    - [10. Remove all Members Assigned to a Task: `clearAssignees`](#clearAssignees)
    - [11. View List of Unassigned Tasks: `viewUnassignedTasks`](#findUnassigned)
    - [12. View List of Uncompleted Tasks: `viewUncompletedTasks`](#findUncompleted)
    - [13. Find Tasks Assigned to a Single Member: `findTasksFor`](#findTasksFor)
* [Data Storage](#dataStorage)
  + [Saving the data](#savingData)
  + [Editing the data file](#editData)
* [FAQ](#faq)
* [Command Summary](#summary)

--------------------------------------------------------------------------------------------------------------------
<a name="quick-start"></a>
## Quick Start

1. Ensure you have Java `11` or above installed in your Computer. You can install Java `11` [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html).

1. Download the latest `heymatez.jar` from [here](https://github.com/AY2021S2-CS2103T-W14-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your HEY MATEz.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample tasks and members.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`viewMembers`** : Lists all members.

   * **`addTask`**`Proposal d/Write out detailed proposal plan for CCA timeline b/2021-04-22` : Adds a task named `Proposal` to HEY MATEz.

   * **`deleteTask`**`3` : Deletes the 3rd task shown in the current list.

   * **`clear`** : Deletes all tasks and members.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

-------------------------------------------------------------------------------------------------------------

<a name="features"></a>
## Features

<div markdown="block" class="alert alert-info">

**:bookmark_tabs: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `addTask n/NAME`, `NAME` is a parameter which can be used as `addTask n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `d/DESCRIPTION [p/PRIORITY]` can be used as `d/Meeting p/high` or as `d/Meeting`.
    
* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[a/ASSIGNEE]…​` can be used as ` ` (i.e. 0 times), `a/Duncan`, `a/Daniel a/Benson` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.
  
* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.
  
* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* For features which use the INDEX field, the INDEX you specify must be a valid number displayed on the list of tasks.

</div>

--------------------------------------------------------------------------------------------------------------------

<a name="general"></a>
## General Features

<a name="clear"></a>
### 1. Clear all data in application: `clear`
Clears all entries from the application.

Format: `clear`

Example: `clear`

<a name="exit"></a>
### 2. Exiting the programme: `exit`
Exits the program.

Format: `exit`

Example: `exit`

<a name="help"></a>
### 3. View Help: `help`
Shows a message explaining how to access the help page.

Format: `help`

Example: `help`

-------------------------------------------------------------------------------------------------------------

<a name="members"></a>
## Member Related Features

<a name="addMember"></a>
### 1. Add Member: `addMember`

With new members joining the club, you can add a new member along with his/her contact number to the contact list.

Format: `addMember NAME p/PHONE_NUMBER e/EMAIL [r/ROLE]`

* The field ROLE is optional.
* NAME and ROLE fields can take on any values with alphanumeric characters.
* PHONE field has to have a minimum length of 3 digits and maximum length of 15 digits.
* If ROLE field is not specified, person will be assigned a default role of member.

Assumptions:
* Every member in the CCA has a different name. An error will be prompted when you add a member with the same name but with
a different phone number, email or role.

Examples: 
* `addMember Dylan p/64529356 e/dylan@gmail.com`
* `addMember Dylan p/64529356 e/dylan@gmail.com r/President`

<a name="deleteMember"></a>
### 2. Delete Member: `deleteMember`

As members leave the club, you can delete a member along with all of his/her contact details from the members list.

Format: `deleteMember NAME`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
To prevent unintentional deleting of Members, the NAME you specify must be in the currently displayed list of Members 
</div>

Examples:
* `deleteMember Rachel`

<a name="viewMembers"></a>
### 3. View Members: `viewMembers`

Displays the list of members that you have added into HEY MATEz.

Format: `viewMembers `

Examples: 
* `viewMembers`

<a name="editMember"></a>
### 4. Edit Member: `editMember`
Club members may change their emails or phone numbers after a while. This feature allows you to edit the details of the 
existing Member in the application with the name you specify.

Format: `editMember NAME [n/NEW_NAME] [p/NEW_PHONE_NUMBER] [e/NEW_EMAIL] [r/NEW_ROLE]`

* Edits the member at the specified NAME.
* The fields NEW_NAME, NEW_PHONE_NUMBER, NEW_EMAIL, NEW_ROLE are all optional.
* At least one of the optional fields must be provided.
* NEW_ROLE field can take on any values with alphanumeric characters.
* NEW_NAME field can take on any values with alphanumeric characters.    
* Existing values will be updated to the input values.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
To prevent unintentional editing of Members, the NAME you specify must be in the currently displayed list of Members 
</div>

Examples: 
* `editMember Alice n/Alice Tan`
* `editMember Alice n/Alice Tan p/98154155 e/aliceTan@gmail.com`
* `editMember Alice n/Alice Tan p/98154155 e/aliceTan@gmail.com r/Events head`

<a name="findMember"></a>
### 5. Find Members by Keywords: `findMembers`

With so many members in the club, you may want to find a particular member's details quickly. 
This feature allows you to find all members whose NAME, PHONE_NUMBER, EMAIL or ROLE contain
any of the specified keywords.

Format: `findMembers KEYWORD [MORE_KEYWORDS]...`

* KEYWORD must match an entire word exactly in order for the particular member to be found. 
  * E.g. A member whose name is `Rachel` will not be found with `findMembers Rach`.

<div markdown="span" class="alert alert-primary"> :bulb: **Tip:**
Keywords are case-insensitive.
</div>

Examples: 
* `findMembers Rachel`
* `findMembers Rachel 98562154 john@gmail.com`
* `findMembers Rachel 98562154 john@gmail.com President`

-------------------------------------------------------------------------------------------------------------
<a name="tasks"></a>
## Task Related Features

<a name="addTask"></a>
### 1. Add Task: `addTask`

With new tasks that need to be completed within the club every week, you can add a task, with its description and 
deadline to the list.

Format: `addTask TITLE d/DESCRIPTION b/DEADLINE [s/STATUS] [p/PRIORITY] [a/ASSIGNEE]...`

* If you did not specify a value for STATUS, the Task will be assigned a default status value of **uncompleted**.
* STATUS field can only take on the values **completed** or **uncompleted**.
* If you did not specify a value for PRIORITY, the Task will be assigned a default priority of **unassigned**.
* PRIORITY field can only take on the values **high**, **medium**, **low** or **unassigned**.
* ASSIGNEE is case-sensitive and format-sensitive: "Alex Yeoh" and "Alex     Yeoh" are not the same assignee.

<div markdown="span" class="alert alert-primary"> :bulb: **Tip:**
A task can have any number of assignees (including 0). To add multiple assignees, simply use multiple assignees prefix. 
</div>

Examples: 
* `addTask CCA Timeline d/Plan semester's timeline b/2021-04-04 s/completed p/high -a Rachel`
* `addTask CCA Timeline d/Plan semester's timeline b/2021-04-04 a/Rachel a/James`

<a name="deleteTask"></a>
### 2. Delete Task: `deleteTask`
Deletes a task from the list with task INDEX you specified.

Format: `deleteTask INDEX`

Examples: 
* `deleteTask 1`

<a name="viewTasks"></a>
### 3. View Tasks: `viewTasks`
Displays the list of tasks that you have added into HEY MATEz.

Format: `viewTasks`

Examples: 
* `viewTasks`

<a name="editTask"></a>
###     4. Edit Task: `editTask`
With ever-changing task requirements, you can edit a task at the task index that is specified with the new details 
you key in.

Format: `editTask INDEX [n/NEW_TITLE] [d/NEW_DESCRIPTION] [b/NEW_DEADLINE] [s/NEW_STATUS] [p/NEW_PRIORITY] [a/NEW_ASSIGNEE]...`

* Edits the Task at the specified index.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* If the assignee field is being edited, all previous assignees will be overwritten. 
* NEW_ASSIGNEE is case-sensitive and format-sensitive: "Alex Yeoh" and "Alex     Yeoh" are not the same assignee.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Any number of assignees can be specified here (including 0).    
</div>

Examples: 
* `editTask 1 n/Plan meeting d/Plan board meeting`
* `editTask 1 n/Plan meeting d/Plan board meeting b/2021-04-04`
* `editTask 1 n/Plan meeting d/Plan board meeting b/2021-04-04 a/Samuel a/Christian`
    
<a name="doneTask"></a>
### 5. Mark Task as Completed: `done`

Upon completion of a task, you can change the status of a task with the task index you specify from **uncompleted** 
to **completed**.

Format: `done INDEX`

Examples: 
* `done 1`

<a name="undoTask"></a>
### 6. Mark Task as Uncompleted: `undo`

Changes the status of a task with the task index you specify from **completed** to **uncompleted**.

Format: `undo INDEX`

Examples: 
* `undo 1`

<a name="findTask"></a>
### 7. Find Tasks by Keywords: `findTasks`

With so many tasks, you may want to find tasks with given keywords quickly.
This feature allows you to find all tasks which contains any of the specified keywords in its TITLE or DESCRIPTION.

Format: `findTasks KEYWORD [MORE_KEYWORDS]...`

* KEYWORD must match an entire word exactly in order for the particular task to be found.
  * E.g. A task with title `Proposal` will not be found with `findTasks Prop`.
  
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Keywords are case-insensitive. 
</div>

Examples: 
* `findTasks Meeting`
* `findTasks Meeting Proposal Draft`

<a name="findBefore"></a>
### 8. Find Tasks due before certain date: `findBefore`

With so many tasks that need to be completed at different times, you may want to find tasks which are due before a certain date.
This feature allows you to find all tasks with deadlines before the date you have specified.

Format: `findBefore DATE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The date specified must follow the format `YYYY-MM-DD`.
</div>

Examples: 
* `findBefore 2021-05-04`

<a name="findPriority"></a>
### 9. Find Tasks by Priority: `findPriority`

With so many tasks that are of different priority, this feature allows you to find all tasks containing the priority that 
you have specified.

* The valid input values for `findPriority` are **high**, **medium**, **low** and **unassigned**.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The input values are case sensitive.
</div>

Format: `findPriority PRIORITY`

Examples:
* `findPriority high`

<a name="clearAssignees"></a>
### 10. Remove all Members Assigned to a Task: `clearAssignees`

Removes all members assigned to a task with the task INDEX you specified.

Format: `clearAssignees INDEX`

Examples: 
* `clearAssignees 2`

<a name="findUnassigned"></a>
### 11. View List of Unassigned Tasks: `viewUnassignedTasks`

In order to efficiently distribute tasks to members, you may want to view tasks which have yet to be assigned to a member.
This feature allows you to view the list of unassigned tasks.

Format: `viewUnassignedTasks`

Examples: 
* `viewUnassignedTasks`

<a name="findUncompleted"></a>
### 12. View List of Uncompleted Tasks: `viewUncompletedTasks`

Displays the list of uncompleted tasks.

Format: `viewUncompletedTasks`

Examples: 
* `viewUncompletedTasks`

<a name="findTasksFor"></a>
### 13. Find Tasks Assigned to a Single Member: `findTasksFor`

In order to manage members efficiently, you may want to track the tasks that are assigned to each member.
This feature allows you to find all tasks assigned to a single Member.

Format: `findTasksFor NAME`

<div markdown="span" class="alert alert-primary"> :bulb: **Tip:**
The NAME specified can only belong to 1 Member while a NAME that does not exist in the Member List will return 0 tasks listed
</div>

Examples: 
* `findTasksFor Alex Yeoh`
* `findTasksFor Bernice Teo Hui Min`

--------------------------------------------------------------------------------------------------------------------
<a name="dataStorage"></a>
## Data Storage 

<a name="savingData"></a>
### Saving the data

HEY MATEz data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

<a name="editData"></a>
### Editing the data file

HEY MATEz data is saved as a JSON file `[JAR file location]/data/heymatez.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, HEY MATEz will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

<a name="faq"></a>
## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous HEY MATEz home folder.

--------------------------------------------------------------------------------------------------------------------

<a name="summary"></a>
## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help`
**Clear Data** | `clear`
**Exit Program** | `exit`
||
**Add Member** | `addMember NAME p/PHONE_NUMBER e/EMAIL [r/ROLE]` <br> e.g., `addMember Dylan p/64529356 e/dylan@gmail.com r/Member`
**Delete Member** | `deleteMember NAME` <br> e.g., `deleteMember Rachel`
**View Members** | `viewMembers`<br> e.g., `viewMembers`
**Edit Member** | `editMember NAME [n/NEW_NAME] [p/NEW_PHONE_NUMBER] [e/NEW_EMAIL] [r/ROLE]`<br> e.g.,`editMember Alice e/newAlice@gmail.com r/Events head`
**Find Members by Keywords** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `findMembers Rachel 98562154 john@gmail.com`
||
**Add Task** | `addTask TITLE d/DESCRIPTION b/DEADLINE [s/STATUS] [p/PRIORITY] [a/ASSIGNEE]` <br> e.g., Example: `addTask CCA Timeline d/Plan semester's timeline b/2021-04-04 s/completed p/high a/Rachel`
**Delete Task** | `deleteTask INDEX` <br> e.g., `deleteTask 1`
**View Tasks** | `viewTasks`<br> e.g., `viewTasks`
**Edit Task** | `editTask INDEX [n/NEW_TITLE] [d/NEW_DESCRIPTION] [b/NEW_DEADLINE] [s/NEW_STATUS] [p/NEW_PRIORITY] [a/NEW_ASSIGNEE]`<br> e.g.,`editTask 1 n/Plan meeting d/Plan board meeting b/2021-04-04`
**Mark Task as Completed** | `done INDEX`<br> e.g., `done 1`
**Mark Task as Uncompleted** | `undo INDEX`<br> e.g., `undo 1`
**Find Tasks by Keywords** | `findTasks KEYWORD [MORE_KEYWORDS]`<br> e.g., `findTasks Meeting Proposal Draft`
**Find Tasks by Priority** | `findPriority PRIORITY`<br> e.g., `findPriority high`
**Find Tasks by Deadline** | `findBefore DATE`<br> e.g., `findBefore 2021-04-05`
**Clear all Members Assigned to a Task** | `clearAssignees INDEX`<br> e.g., `clearAssignees 2`
**View Unassigned Tasks** | `viewUnassignedTasks`<br> e.g., `viewUnassignedTasks`
**View Uncompleted Tasks** | `viewUncompletedTasks`<br> e.g., `viewUncompletedTasks`
**Find Member's Tasks** | `findTasksFor NAME` <br> e.g., `findTasksFor Alice Tay`
