# Java Interview Master Guide

This guide combines the strongest material from the existing interview resources into one cleaner practice document. It is designed for Java, Spring, multithreading, collections, SQL, and system design interview preparation.

## How to Answer Well in a Java Interview

Use this simple structure for most questions:

1. Definition: one clear sentence.
2. Why it matters: where it appears in real Java applications.
3. Java example: class, API, annotation, or code snippet.
4. Trade-off: one limitation or best practice.

Example:

Question: What is the difference between `ArrayList` and `LinkedList`?

Strong answer:
"`ArrayList` is backed by a dynamic array, so random access is fast. `LinkedList` is node-based, so insertions and removals can be efficient when you already have the node reference. In real Java applications, `ArrayList` is usually preferred because it has better cache locality, simpler memory layout, and better practical performance for most workloads."

## 1. Data Structures and Algorithms

### Stack vs Queue

- Stack is LIFO: last in, first out.
- Queue is FIFO: first in, first out.
- In Java, stack-like behavior is usually implemented with `Deque` rather than legacy `Stack`.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20
```

### Big O Notation

- Big O describes how time or space grows with input size.
- Always say what operation you are analyzing.
- Example: searching an unsorted array is `O(n)` because in the worst case we inspect every element once.

### BFS vs DFS

- BFS uses a queue and is useful for shortest path in an unweighted graph.
- DFS uses recursion or a stack and is useful for traversal, backtracking, and cycle detection.

```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
while (!queue.isEmpty()) {
    int node = queue.poll();
    System.out.println(node);
}
```

### Dynamic Programming

- Dynamic programming is used when subproblems overlap.
- Top-down uses recursion plus memoization.
- Bottom-up uses iteration plus tabulation.
- In interviews, explain why DP is needed instead of only naming it.

### Interview Tip

For coding questions, say:

1. "I’ll confirm the input and expected output."
2. "I’ll start with a simple correct solution."
3. "Then I’ll improve time or space complexity if needed."

## 2. Java Collections

### Core Hierarchy

- `Collection` is the parent of `List`, `Set`, and `Queue`.
- `Map` is not part of `Collection`; it is a separate hierarchy.

### ArrayList vs LinkedList

- `ArrayList` is usually the default choice.
- `LinkedList` has higher memory overhead and poor cache locality.
- Random access is fast in `ArrayList` and slow in `LinkedList`.

### HashMap

- Average lookup is `O(1)`.
- Allows one null key and multiple null values.
- Not thread-safe.
- Depends on correct `equals()` and `hashCode()`.

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Amit");
map.putIfAbsent(1, "Anu");
System.out.println(map.get(1));
```

### equals and hashCode

If two objects are equal by `equals()`, they must return the same `hashCode()`. Otherwise `HashMap` and `HashSet` can behave incorrectly.

```java
class Employee {
    private final int id;

    Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
```

### ConcurrentModificationException

- Most collection iterators are fail-fast.
- `CopyOnWriteArrayList` is safer for iteration under concurrent reads but expensive for frequent writes.

### Interview Tip

When comparing collections, mention:

1. Internal data structure
2. Time complexity
3. Ordering
4. Null handling
5. Thread-safety

## 3. Java Basics and OOP

### Overloading vs Overriding

- Overloading: same method name, different parameter list, resolved at compile time.
- Overriding: subclass redefines inherited method, resolved at runtime.

### Immutability

- Immutable objects are safer for sharing and easier to reason about.
- Common immutable Java types include `String`, wrapper classes, `BigDecimal`, `LocalDate`, and records when their components are themselves immutable.

```java
public final class Person {
    private final String name;
    private final LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
```

### Composition vs Inheritance

- Composition is usually preferred because it creates looser coupling.
- Inheritance should model a true "is-a" relationship.

### SOLID

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

### Interview Tip

If asked about good design, mention low coupling, high cohesion, clear responsibilities, testability, and readable naming.

## 4. Exceptions

### Checked vs Unchecked

- Checked exceptions must be declared or handled.
- Unchecked exceptions are subclasses of `RuntimeException`.
- Checked exceptions are useful when callers can realistically recover.

### try-with-resources

- Automatically closes resources implementing `AutoCloseable`.
- Cleaner and safer than manual `finally` blocks.

```java
try (BufferedReader reader = Files.newBufferedReader(path)) {
    return reader.readLine();
}
```

### NoClassDefFoundError vs ClassNotFoundException

- `ClassNotFoundException` is a checked exception typically seen in reflective loading.
- `NoClassDefFoundError` is an error when a class was present at compile time but missing at runtime.

## 5. Memory, JVM, and Garbage Collection

### Heap Layout

- Young generation: Eden and Survivor spaces
- Old generation: long-lived objects

### BigDecimal vs double

- `double` is a binary floating-point approximation.
- `BigDecimal` is used for exact decimal arithmetic.
- For money, `BigDecimal` is the safer choice.

```java
BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
System.out.println(a.add(b)); // 0.3
```

### Memory Leaks in Java

Java can still have memory leaks when objects are no longer useful but remain strongly reachable.

### Monitoring Tools

- `jstack`
- `jmap`
- `jstat`
- VisualVM
- JConsole

### Interview Tip

A good answer about GC includes both correctness and operations:
"I would inspect GC logs, heap usage, allocation rate, pause times, and object retention patterns."

## 6. Modern Java

### Generics

- Generics provide compile-time type safety.
- They reduce manual casting.
- Type erasure means generic type information is mostly removed at runtime.

### Lambdas and Method References

- Lambdas let us pass behavior as data.
- Method references are shorthand for simple lambdas.

```java
List<String> names = List.of("Amit", "Anu", "Bob");
names.forEach(System.out::println);
```

### Stream API

- Streams are for declarative data processing.
- They do not store data.
- Common operations: `filter`, `map`, `sorted`, `collect`, `reduce`.

```java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .sorted()
        .toList();
```

### Optional

- `Optional` makes absence explicit.
- It is useful as a return type.
- It should not usually be used for fields in JPA entities.

## 7. Multithreading and Concurrency

### Thread vs Runnable

- `Thread` is a class.
- `Runnable` is a task abstraction.
- Prefer `Runnable`, `Callable`, and executors over manually extending `Thread`.

### start vs run

- `start()` creates a new thread.
- `run()` executes in the current thread.

### synchronized vs volatile

- `synchronized` provides mutual exclusion and visibility.
- `volatile` provides visibility, not atomicity for compound operations.

### ExecutorService

- Separates task submission from thread management.
- `submit()` returns a `Future`.
- `execute()` does not.

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
Future<Integer> future = executor.submit(() -> 10 + 20);
System.out.println(future.get());
executor.shutdown();
```

### CompletableFuture

- `thenApply` transforms a result.
- `thenCompose` chains async operations.
- `thenAccept` consumes the result without returning a new value.

```java
CompletableFuture.supplyAsync(() -> "java")
        .thenApply(String::toUpperCase)
        .thenAccept(System.out::println);
```

### Common Risks

- Race conditions
- Deadlocks
- Starvation
- Sharing mutable state

### Interview Tip

If the question is about concurrency, mention both correctness and design:
"I would prefer immutable data, small shared state, and executor-based task orchestration over manual thread management."

## 8. Spring and Spring Boot

### IoC and Dependency Injection

- Spring manages object creation and wiring.
- Constructor injection is preferred because dependencies are explicit and test-friendly.

### Bean Scopes

- Singleton
- Prototype
- Request
- Session

### Common Annotations

- `@Component`
- `@Service`
- `@Repository`
- `@RestController`
- `@Configuration`
- `@Bean`
- `@Transactional`

### @SpringBootApplication

This combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

### Auto-configuration

Spring Boot creates sensible defaults based on the classpath and configuration properties.

### Practical Example

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return new UserDto(id, "Amit");
    }
}
```

### Interview Tip

For Spring answers, use actual annotations and discuss testability, bean lifecycle, transaction boundaries, and decoupling.

## 9. REST API and Microservices

### REST Basics

- Resources are identified by URIs.
- Common mappings:
  - `GET` for read
  - `POST` for create
  - `PUT` for full update
  - `PATCH` for partial update
  - `DELETE` for delete

### Good API Design

- Use nouns, not verbs, in URIs.
- Return meaningful status codes.
- Validate input.
- Use DTOs at boundaries.
- Handle exceptions centrally with `@ControllerAdvice`.

### Microservices

Common patterns:

- API Gateway
- Service Discovery
- Circuit Breaker
- Saga
- Strangler Fig migration

### Interview Tip

Mention trade-offs. Microservices improve independent deployment and scaling, but increase operational complexity, network failure modes, and observability needs.

## 10. Hibernate and JPA

### SessionFactory vs Session

- `SessionFactory` is heavyweight and thread-safe.
- `Session` is lightweight and not thread-safe.

### EntityManager

- JPA abstraction similar to Hibernate `Session`.
- `EntityManagerFactory` creates `EntityManager` instances.

### Lazy Loading

- Associations are loaded on demand.
- It can improve performance.
- It can also cause `LazyInitializationException` if used outside the persistence context.

### merge vs update

- `merge()` copies detached state into a managed instance.
- `update()` reattaches the given instance directly in Hibernate-specific APIs.

### @Version

- Used for optimistic locking.
- Helps detect conflicting concurrent updates.

### Interview Tip

When discussing JPA, mention persistence context, transaction scope, N+1 query risk, lazy vs eager loading, and DTO mapping.

## 11. SQL

### DDL vs DML

- DDL defines schema: `CREATE`, `ALTER`, `DROP`
- DML manipulates data: `INSERT`, `UPDATE`, `DELETE`, `SELECT`

### ACID

- Atomicity
- Consistency
- Isolation
- Durability

### Indexes

- Speed up reads.
- Slow down writes because indexes must be maintained.

### Joins

- Inner join
- Left join
- Right join
- Full outer join
- Cross join

### Isolation Levels

- Read Uncommitted
- Read Committed
- Repeatable Read
- Serializable

### Interview Tip

For SQL performance questions, mention indexing, query plans, join strategy, filtering selectivity, batching, and avoiding unnecessary round trips.

## 12. Java-Specific Practice Questions

### Why is String immutable in Java?

"`String` is immutable for security, thread-safety, pooling, and stable hashing. Since strings are widely used in file paths, URLs, class loading, and as map keys, immutability reduces bugs and prevents state changes after creation."

### Why override hashCode when overriding equals?

"Hash-based collections use `hashCode()` to find the bucket and `equals()` to compare values. Equal objects must produce the same hash code, otherwise lookup and duplicate detection break."

### Why is constructor injection preferred in Spring?

"It makes dependencies explicit, supports immutability, improves testability, and prevents partially initialized beans."

### Why use BigDecimal instead of double for currency?

"`double` is a binary floating-point type and may introduce rounding errors. `BigDecimal` gives exact decimal representation and controlled rounding behavior."

### What is the difference between fail-fast and fail-safe iteration?

"Fail-fast iterators detect structural modifications and usually throw `ConcurrentModificationException`. Fail-safe approaches like `CopyOnWriteArrayList` iterate over a stable snapshot."

## 13. Final Interview Tips

- Practice both a 30-second answer and a 2-minute answer for major topics.
- Prefer real Java examples over generic computer science explanations.
- Mention trade-offs, not just definitions.
- If you do not know the exact JVM detail, reason clearly instead of freezing.
- For senior interviews, talk about testability, observability, thread-safety, and maintainability.
- For coding rounds, explain your plan before writing code.
- For framework questions, mention concrete annotations, APIs, and failure cases.

## 14. Topics to Practice Daily

Review these regularly:

- Collections: `HashMap`, `ConcurrentHashMap`, `ArrayList`, `Set`
- Java basics: `equals`, `hashCode`, immutability, overriding
- Concurrency: `ExecutorService`, `CompletableFuture`, `volatile`, `synchronized`
- Spring: dependency injection, bean scopes, transactions, REST controllers
- JPA: lazy loading, persistence context, `@Version`, N+1 queries
- SQL: joins, indexes, ACID, isolation levels
- DSA: BFS, DFS, sorting, recursion, dynamic programming

Use this guide as your single study reference, then drill into the original raw files only when you want more question volume.
