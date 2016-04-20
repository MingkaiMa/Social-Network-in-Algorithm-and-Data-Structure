# Social-Network-in-Algorithm-and-Data-Structure

This project implements a representation of a social network. I use various data structures. The programming language is Java.

The data structures I use in the project are following:
1.Dictionary
2.Linkedlist
3.Priority Queue
4.Queue
5.Stack
6.Graph, including: Edge.java, Graph.java, Node.java

The search algorithms are mainly Breadth-First-Search.


Project Description:

Part 1

Write a class Profile. For now, a profile only holds the username and age of the user and a wall. A wall is a collection of messages. Therefore, you need to provide a class Message to represent these messages. A message contains the content, author, a privacy setting and age limit. The privacy setting is an integer number, where 0 represents public, 1 friends, 2 friends of friends and so on. Add methods to the Profile class to post a message on the wall and to print the wall. 

Part 2 

You have implemented some basic building blocks for a social network. In this part you will extend these blocks and create an interface for the network itself. 
Besides standard messages, the network should support advertisements. These advertisement messages are posted by special kind of non-personal profiles related to companies. Add support for distinguishing personal and corporate profiles and support for advertisement messages. 

When printing a wall, ads and normal messages are alternated: for every 4 user messages one ad is inserted. Both messages and ads are sorted chronologically. The timestamp can be represented with an integer number where a higher number corresponds with a newer message. Please note that messages are not necessarily chronologically posted to the network, i.e. messages can be posted with a timestamp in the past or future. 

Your network class should contain the following methods: 
			-  createUserProfile(String name, int age) 

			-  createCorporateProfile(String name) 

			-  printWall(String username) 

			-  postMessage(String username, String message, int privacy, int ageLimit, int timestamp) 

			-  postAd(String username, String message, int ageLimit, int timestamp)
			-  
For now messages and ads are posted to the walls of all users except if the user is younger than the provided age limit. 

Part 3 

Many methods on the main network class rely on conversion of a username to the actual user object. Extend the network implementation to do this in the most efficient way. 
So far, there were no connections between users yet. Add the following method to connect two users: 
- connect(String username1, String username2)
And the following methods to print a list of friends of a given user: 
- printFriendList(String username) 
Last time we introduced corporate profiles that can post ads. Add functionality for users to give a zero to 5 stars rating to these companies: 

- rate(String username, String corporateName, int stars)
When a company posts an ad they can either post it to everyone (paid) or only to subscribers, i.e. those who rated the company: 
- postAd(String username, String message, int ageLimit, boolean paid, int timestamp) When ads are shown on the wall, these star ratings are taken into account. I.e. the higher the 
star rating the higher the ads will appear on the wall. 
You should use a datastructure that fits the characteristics of a network. When posting messages or ads however, you can still ignore privacy setting and star rating until we have seen appropriate algorithms. For now you need to implement a solid foundation to support the functionality in the next part. 
Your Network class should implement the NetworkInterface provided further in this document. 

Part 4 

In the previous parts you developed a reliable architecture for the network. In this final part you have to complete the described functionality to create a fully operational system. More specifically this means that all methods should work as expected (taking into account privacy, age limits and star ratings) in an efficient way. 
Previously we introduced timestamps, from now on we will use Unix timestamps. A Unix timestamp is an integer number in seconds starting from 1st of January 1970. In Java, you can calculate the current timestamp as follows: 
public int getCurrentTime() {
return (int) (System.currentTimeMillis() / 1000L); 
} 
When testing your network you can add or subtract time in seconds when posting messages. To combine the timestamp and star rating you can add one hour (3600 seconds) per star. For example, if the current time is 1448877872 you can add 14400 seconds for a 4-star rating, i.e. 1448892272. In other words, these posts will have a timestamp in the future and are therefore pushed forward. Paid advertisements are equivalent to a 0 star rating. 

