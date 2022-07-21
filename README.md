# Java_DemocratieAPP
In an era where many actions must now be carried out in telework and where voting can become a problem to respect the rules health, there is a need for a new nationwide protocol that already exists in companies via solutions such as DémocratieApp and which can be used by any citizen to vote reliably and securely from a computer without having to go to a polling station. 

So to respond to this project, we want to create a Java application with a database that allows each citizen to vote in a way secured. Two views will be available: 

The "voter" view: which will include a home page, a connection, a space for consulting candidates' programs, a space consultation of the results, a voting space, a user space and a space allowing you to download a certificate of participation in the vote. 

The "administrator" view: which will include a login page, a space for adding and deleting and modifying candidates and their program, a space for adding, modifying and deleting voters, a election creation and modification space. An election monitoring space where will be possible to launch the vote, follow the statistics, close the vote and then proclaim the result. 

Registration will require the national voter number, the number of social security, as well as a password sent by registered mail with acknowledgment of receipt which will be encrypted within the database to guarantee the security. We thought a time realizes a system of double authentication depending on the weather, but we put it on a low priority objective. 

The project will consist of an application created in Java and which will be linked to a MariaDB database containing all the information. The exchanges and queries between the application and the database will be encrypted so ensure data security and guarantee the anonymity of votes.
