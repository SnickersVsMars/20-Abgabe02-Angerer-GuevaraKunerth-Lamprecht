# Queue
## What is a queue?
A queue is a dynamic data structure, that can contain a varying amount of 
elements. Elements can only be retrieved in the same order, as they were added.

A queue is working with the first-in first-out principle.

## Where to use a queue?
There are many possible areas where a queue can be used:
- request queuing on a server
- music playlists
- task scheduling
- any fifo principle related task 

## Structure of a queue
The queue has two basic functions.
- queue: add a new element to the end of the queue
- dequeue: remove the element at the beginning of the queue

![queue,dequeue](images/queue.png)

In our project we have the generic interface IQueue as base for our implementation:
```java
public interface IQueue<T> {

  boolean offer(T obj);

  T poll();

  T remove();

  T peek();

  T element();
}
``` 
The methods offer(queue) and poll(dequeue) are respective the basic methods. 

The remove method is the same as poll, but throws an exception when no element ist present.

Peek returns the first element without removing it.

Element is the same as peek, but also throws an exception when no element is present.

## Implementation

We have made 2 implementation of the interface. 
The StringQueue which uses the interface and only allows Strings as Elements and the generic implementation GenericQueue.
Generics are explained [here](/generics.html).

## Testing
We have testet our queue with these Tests:
### Initializing the queue: No elements present and maxsize must equal initial maxsize
```java
@Test
@DisplayName("testing StringQueue constructor")
public void testConstructor () {
    assertNull(q.poll());
    assertEquals(6,q.getMaxSize());
}
```
### Offer into queue till maxsize is reached. Before maxsize true must be returned, after maxsize false.
```java
@Test
@DisplayName("Testing 'offer' method")
public void testOffer() {
    assertTrue(q.offer("1"));
    assertTrue(q.offer("2"));
    assertTrue(q.offer("3"));
    assertTrue(q.offer("4"));
    assertTrue(q.offer("5"));
    assertTrue(q.offer("6"));
    assertFalse(q.offer("7"));
}
```
### Offer into queue and call poll/remove/peek/element 2 times. On the first execution element should be returned. Second Execution should throw Error/ return null. 
```java
@Test
@DisplayName("Testing 'poll' method")
public void testPoll() {
    q.offer("1");
    assertEquals("1",q.poll());
    assertNull(q.poll());
}
```


