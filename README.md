## spring-cloud 

This sample modules contains projects with microservices and expose data as rest end points, based on spring cloud netflix architecture

# This project follows following REST principles

1. Uniform Interface:
   - Individual resources are identified using URLS.
   - fgffbg hb7hClient can manipulate the resource through the representations with permissions. 
   - Each message sent between the client and the server is self-descriptive and includes enough information to describe how it is to be processed.
   - The hypermedia (hyperlinks) and hypertext act as the engine for state transfer.

2. Stateless Interactions:
   - Clients context is to be stored on the server.
   - All of the information necessary to service the request is contained in the URL, query parameters, body or headers.

3. Cacheable:
   - Clients can cache the responses. 
   - The responses must define themselves as cacheable or not to prevent the client from sending the inappropriate data in response to further requests.

4. Client-Server:
   - The clients and the server are separated from each other.
   - Client is not concerned with the data storage.
   - Server is not concerned with the client interference implementation is simpler and easy to scale.

5. Layered System:
   - At any time client cannot tell if it is connected to the end server or to an intermediate.
   - Intermediate layer helps enforce security policies and improve the system scalability by enabling load-balancing

## Source code style/navigation

1. Setting will be found in properties/yml file
2. Configurations will be found in *Config.java file
3. All modules follows MVC pattern and Controller -> service -> repository hirarchy for all rest api response
4. All api are rest only and consumes/produces json/xml response as standerd.
