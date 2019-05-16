## spring-cloud 

This sample modules contains projects with microservices and expose data as rest end points, based on spring cloud netflix architecture

# This project follows following REST principles

1. Uniform Interface:
  a.  Individual resources are identified using URLS. 
  b.  Client can manipulate the resource through the representations with permissions. 
  c.  Each message sent between the client and the server is self-descriptive and includes enough information to describe how it is to be   processed. 
  d.  The hypermedia (hyperlinks) and hypertext act as the engine for state transfer.

2. Stateless Interactions:
  a.  Clients context is to be stored on the server. 
  b.  All of the information necessary to service the request is contained in the URL, query parameters, body or headers.

3. Cacheable:
  a.  Clients can cache the responses. 
  b.  The responses must define themselves as cacheable or not to prevent the client from sending the inappropriate data in response to further requests.

4. Client-Server:
  a.  The clients and the server are separated from each other.
  b.  Client is not concerned with the data storage.
  c.  Server is not concerned with the client interference implementation is simpler and easy to scale.

5. Layered System:
  a.  At any time client cannot tell if it is connected to the end server or to an intermediate. 
  b.  Intermediate layer helps enforce security policies and improve the system scalability by enabling load-balancing

## Source code style/navigation
  a.  setting will be found in properties/yml file
  b.  configurations will be found in *Config.java file
