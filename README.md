## Tools for solving algorithmic problems (Java)

* [Data structures](#data-structures)
    * [Stack](#stack)
    * [Queue](#queue)
    * [HashMap](#hashmap)
    * [Tree](#tree)
* [Sorting](#sorting)
    * [Collections](#collections)
    * [primitives](#primitives)

## Data structures

### Stack

What is a Stack? It is a pile of plates (or more abstractly, a pile of objects),
`An analogy:` imagine a stack of plates
if a new plate arrives we are putting it in the top of the stack or 
if we want to get a plate we have to take it from the top of the stack
if there is no plate we get back nothing (actually you getting an exception) :)

Those are the two fundamental operatations of a stack
1. `push` an item (this can be anything, e.g. string, numbers, object..)
2. `pop` item removal from the stack
3. `peek` examine an item without removing it

Example:
```java
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
```
Output
```
3
2
1
Exception in thread "main" java.util.EmptyStackException
```

In the above example we had a pile of integers, we add the folllowing 
values (1->2->3)
In the output we got back all three values starting from 3 and finishing with 1
You can notice that when we tried to pop some element from the stack when it was empty we got back a glorius Exception
In many books you can see it as LIFO data structure (`Last In First Out`)

## Queue

What is a queue? it is like a queue in the real world
`An analogy:` in any store (not quite true :) ) that serves customers  
the first customer that came in is going to be served first, the second is
going to be served second and so on.
This is the logic that queue works 

fundamental queue operations

1. `enqueue` you adding an item to queue
(you adding it to the end of the queue)
2. `dequeue` you removing an item from it 
(the one that is in the front)

Example:
```java
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);

    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
```
Output
```
1
2
3
```
if you notice the output, you can see that is the oposite of the stack output!
In many books you can see it as FIFO data structure (`First In First Out`)
It seems a usefull data strucutre when you want to implement something 
that has queue logic (e.g. serve or process something based on the time that came)
Moreover it is used in search algorithms like BFS (Breadth First Search)

### HashMap

if you care about uniquness this is the data structure that you are looking for (of course you can use all the implementations of Set interface, but Set doesn't supports the mapping to another object)
Actullay HashMap is a collection of `key-value pairs`
`An analogy:` Most of the citizens of the world are holding a identity, usually this is a number
If you go to a public service to perform some obligation, they are asking you the ID number, by using this number the employee can retrieve your personal info name, surname, date of birth and so on.
Imagine that the key in this case is the ID number and the value the personal info

fundamental hash map operations

1. `put` you adding an key-value pair in the collection
2. `get(key)` given a key you getting back the corresponding value (if exists) 

Example:
```java
    Map<Integer, String> personalInfo = new HashMap<>();
    personalInfo.put(123, "Konstantinos Blatsoukas");
    personalInfo.put(456, "Nikolaos Papadopoulos");

    System.out.println(personalInfo.get(123));
    System.out.println(personalInfo.get(456));
    System.out.println(personalInfo.get(433));

    personalInfo.put(123, "Nikolaos Blatsoukas");
    System.out.println(personalInfo.get(123));
```
Output
```
Konstantinos Blatsoukas
Nikolaos Papadopoulos
null
Nikolaos Blatsoukas
```
Please notice that if the key is not present you getting back a null
Another interesting thing to notice is that, if the key-value is already in
in the collection and you try to add a different value with the same key
the previous value is replaced with the new one (in the above example notice what happened to value with the key 123)

## Sorting
### primitives

how to sort a primitive array in java
Example :
```java
    char[] name = "konstantinos blatsoukas".toCharArray();
    Arrays.sort(name);
    for (int i = 0; i < name.length; i++) {
        char c = name[i];
        if (c != ' ') {
            System.out.print(c);
        }
    }
```
Output
```
aaabikklnnnooosssstttu
```
The above example sorts an array in ascending order (the Arrays.sort method supports sorting for the other primitives types as well)
### Collections
Let's see how we can sort a collection of objcects based on some attribute
bellow we have the class Person that has two attributes name and age
```java
public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
```
Let's try to sort 2 Person based on the age
```java
    Person kostas = new Person("Kostas", 32);
    Person eleni = new Person("Eleni", 34);

    Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);

    List<Person> persons = new ArrayList<>();
    persons.add(kostas);
    persons.add(eleni);

    Collections.sort(persons, ageComparator);
    for (int i = 0; i < persons.size(); i++) {
        Person person =  persons.get(i);
        System.out.println(person.getName());
    }
```
Output
```
Kostas
Eleni
```