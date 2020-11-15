Assignment 6 readme

ConcurrentProcessor is wrapped as the real main function where user can edit the input
and run the program. DataBucket class contains multiple thread-safe data structure that are used for interactions between producer and consumers. Producer is implemented to read the large file and consumers are implemented to handle and update the course info. Number of consumers is determined by number of courses which means each consumer is responsible for one course. 
