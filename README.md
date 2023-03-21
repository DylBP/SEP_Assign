****
****
Software Engineering Practice Assignment
Year 2 - Semester 2
Applied Computing/Computer Forensics & Security
****
****
Dylan Butler Parry, Jordan Coady, Dean Doyle
*****

The code contained within here is an example of production code, as well as their associated unit testing cases.

The production code is for validating that the user has inputted a valid email address, this has been done using the email validation 
within the OWASP Validation Regex Repository.

There is another piece of production code for admin panel login, where the username and password has been base64 encoded. It will return true or false
if the inputted username and password matches the encoded variant. In a real world scenario, this would be interfaced with a database instead of hard-coded values.
N.B. A user would log into the system through the home page, prompting them for an email and password
     An admin would log in through a different page located elsewhere, where they will be prompted for a username and password (rootuser, rootpassword123)

****
