# Java, Spring Boot, SQL, Git, and Cloud Interview Questions and Answers

This file is a consolidated interview Q&A reference for the most common backend topics. It is designed as a direct-answer study sheet.

## 1. Java Core

### Q1. What is the difference between JDK, JRE, and JVM?
Answer: JVM is the runtime that executes Java bytecode. JRE is the JVM plus standard libraries needed to run Java applications. JDK is the full development kit that includes the JRE, compiler, and build/debug tools.

### Q2. What is the difference between `==` and `.equals()` in Java?
Answer: `==` compares primitive values directly and compares object references for objects. `.equals()` compares logical equality if the class overrides it.

### Q3. What is the contract between `equals()` and `hashCode()`?
Answer: If two objects are equal according to `equals()`, they must return the same `hashCode()`. Otherwise hash-based collections such as `HashMap` and `HashSet` may behave incorrectly.

### Q4. What is immutability and why is it important?
Answer: An immutable object cannot change its state after creation. It improves thread-safety, predictability, caching safety, and reduces accidental side effects.

### Q5. How do you make a class immutable?
Answer: Make the class `final`, make fields `private final`, initialize all fields in the constructor, avoid setters, and defensively copy mutable inputs and outputs.

### Q6. Why is `String` immutable in Java?
Answer: It helps with security, thread-safety, string pooling, and stable hashing. Since strings are used in class loading, file paths, and map keys, immutability prevents many bugs.

### Q7. What is the difference between overloading and overriding?
Answer: Overloading means same method name with different parameter lists and is resolved at compile time. Overriding means a subclass provides a new implementation of an inherited method and is resolved at runtime.

### Q8. What is the difference between abstraction and encapsulation?
Answer: Abstraction hides implementation details and exposes essential behavior. Encapsulation bundles data and behavior together and restricts direct access to internal state.

### Q9. What are access modifiers in Java?
Answer: `public` is accessible everywhere, `protected` is accessible in the same package and subclasses, default/package-private is accessible within the same package, and `private` is accessible only inside the same class.

### Q10. What is the difference between `StringBuilder` and `StringBuffer`?
Answer: `StringBuilder` is not synchronized and is faster in single-threaded code. `StringBuffer` is synchronized and safer when multiple threads share the same buffer.

### Q11. What is autoboxing?
Answer: Autoboxing is automatic conversion between primitives and wrapper types, such as `int` to `Integer`. It improves readability but can add allocation cost and cause `NullPointerException` if unboxing null.

### Q12. What are records in Java?
Answer: Records are concise immutable data carriers introduced to reduce boilerplate for DTO-like classes. They automatically provide constructor, accessors, `equals()`, `hashCode()`, and `toString()`.

### Q13. What are sealed classes?
Answer: Sealed classes restrict which classes can extend or implement them. They are useful when modeling closed hierarchies and making domain states more explicit.

### Q14. What is type erasure?
Answer: Java generics provide compile-time type safety, but most generic type information is removed at runtime. This is why `List<String>` and `List<Integer>` have the same runtime class.

### Q15. What is the difference between checked and unchecked exceptions?
Answer: Checked exceptions must be declared or handled, while unchecked exceptions are subclasses of `RuntimeException` and do not require explicit handling.

### Q16. What is try-with-resources?
Answer: It is a `try` statement that automatically closes resources implementing `AutoCloseable`, which makes resource management safer and cleaner.

### Q17. What is the difference between `final`, `finally`, and `finalize()`?
Answer: `final` prevents modification, inheritance, or overriding depending on where it is used. `finally` is used in exception handling to run cleanup logic. `finalize()` was a legacy cleanup hook and should not be used in modern Java.

## 2. Java Collections

### Q18. What is the difference between `List`, `Set`, and `Map`?
Answer: `List` is ordered and allows duplicates, `Set` stores unique elements, and `Map` stores key-value pairs and is a separate hierarchy from `Collection`.

### Q19. What is the difference between `ArrayList` and `LinkedList`?
Answer: `ArrayList` is backed by a dynamic array and is usually better for random access and general usage. `LinkedList` is node-based and can be useful for specific insertion/removal patterns but usually has worse real-world performance.

### Q20. What is the difference between `HashMap` and `TreeMap`?
Answer: `HashMap` offers average `O(1)` lookup and does not keep keys sorted. `TreeMap` keeps keys sorted and provides `O(log n)` operations.

### Q21. What is the difference between `HashSet` and `TreeSet`?
Answer: `HashSet` is unordered and backed by hashing. `TreeSet` stores unique values in sorted order, typically using a red-black tree.

### Q22. How does `HashMap` work internally?
Answer: It uses an array of buckets. Keys are hashed to determine a bucket, and collisions are handled by linked structures that can become balanced trees when buckets get large enough.

### Q23. What is a collision in a hash table?
Answer: A collision happens when two different keys hash to the same bucket. It is handled by chaining or tree structures depending on the implementation.

### Q24. Why are mutable keys dangerous in a `HashMap`?
Answer: If a key changes after insertion and the changed field affects `equals()` or `hashCode()`, the map may no longer be able to find the entry correctly.

### Q25. What is `ConcurrentModificationException`?
Answer: It is a fail-fast exception thrown when a collection is structurally modified during iteration in a way the iterator does not support.

### Q26. What is the difference between `Hashtable` and `ConcurrentHashMap`?
Answer: `Hashtable` is a legacy synchronized map that locks more aggressively. `ConcurrentHashMap` is designed for better concurrency and higher throughput.

## 3. Java Concurrency

### Q27. What is the difference between `Thread` and `Runnable`?
Answer: `Thread` is a class representing an execution thread. `Runnable` is a task abstraction. Prefer `Runnable`, `Callable`, and executors for better design.

### Q28. What is the difference between `run()` and `start()`?
Answer: `run()` executes in the current thread. `start()` creates a new thread and then calls `run()` on that new thread.

### Q29. What does `volatile` do?
Answer: `volatile` guarantees visibility of writes across threads, but it does not make compound operations atomic.

### Q30. What does `synchronized` do?
Answer: It provides mutual exclusion and also establishes visibility guarantees between threads entering and leaving the synchronized block or method.

### Q31. What is the Java Memory Model?
Answer: It defines how threads interact through memory and when writes by one thread become visible to another thread. It explains concepts such as happens-before, visibility, and ordering.

### Q32. What is a happens-before relationship?
Answer: It is a guarantee in the Java Memory Model that memory writes before a synchronization boundary are visible to reads after that boundary.

### Q33. What is deadlock?
Answer: Deadlock happens when threads block each other permanently, usually because they acquire multiple locks in conflicting order.

### Q34. What is starvation?
Answer: Starvation happens when a thread never gets enough CPU time or access to a required resource because other threads keep winning.

### Q35. What is a race condition?
Answer: A race condition happens when output depends on the timing or ordering of thread execution and shared state is not safely coordinated.

### Q36. What is `ExecutorService`?
Answer: `ExecutorService` is a high-level concurrency API for submitting tasks, managing pools, and handling lifecycle instead of manually managing threads.

### Q37. What is the difference between `submit()` and `execute()`?
Answer: `execute()` runs a task and returns nothing. `submit()` returns a `Future` so you can track completion, exceptions, or return values.

### Q38. What is `CompletableFuture`?
Answer: It is a flexible API for asynchronous programming and composing dependent stages without blocking unnecessarily.

### Q39. What is the difference between `thenApply`, `thenCompose`, and `thenAccept`?
Answer: `thenApply` transforms a result, `thenCompose` chains another async stage, and `thenAccept` consumes the result without returning a new value.

### Q40. What is false sharing?
Answer: False sharing happens when independent variables used by different threads sit on the same CPU cache line, causing avoidable cache invalidation and performance degradation.

## 4. JVM and Performance

### Q41. How is heap memory divided in Java?
Answer: Broadly into young generation and old generation. The exact layout depends on JVM version and collector, but young generation usually handles short-lived objects and old generation handles long-lived objects.

### Q42. What is garbage collection?
Answer: Garbage collection automatically identifies unreachable objects and reclaims their memory so developers do not manually free memory.

### Q43. Can Java have memory leaks?
Answer: Yes. A memory leak happens when objects are still strongly reachable even though the business logic no longer needs them.

### Q44. What are common causes of memory leaks?
Answer: Unbounded caches, static collections, forgotten listeners, `ThreadLocal` misuse, and objects retained in long-lived contexts.

### Q45. How do you monitor JVM health?
Answer: Use GC logs, heap usage, thread dumps, allocation rate, latency metrics, and tools such as `jstack`, `jmap`, `jstat`, VisualVM, or production observability platforms.

### Q46. Why is `BigDecimal` preferred over `double` for money?
Answer: `double` uses binary floating-point approximation and can introduce rounding errors. `BigDecimal` provides exact decimal arithmetic and controlled rounding.

## 5. Spring and Spring Boot

### Q47. What is IoC?
Answer: Inversion of Control means the framework manages object creation and wiring instead of application code manually constructing everything.

### Q48. What is Dependency Injection?
Answer: Dependency Injection is a way of supplying required collaborators to a class, commonly through constructor injection in Spring.

### Q49. Why is constructor injection preferred?
Answer: It makes dependencies explicit, supports immutability, improves testability, and prevents partially initialized objects.

### Q50. What is a Spring bean?
Answer: A Spring bean is an object managed by the Spring container.

### Q51. What are common bean scopes?
Answer: Common scopes are singleton, prototype, request, and session.

### Q52. What is `@SpringBootApplication`?
Answer: It is a convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

### Q53. What is auto-configuration in Spring Boot?
Answer: Spring Boot creates beans automatically based on the classpath, configuration, and conditional rules so common setup needs less boilerplate.

### Q54. What is Spring Boot Actuator?
Answer: Actuator provides production-focused endpoints and metrics such as health, info, metrics, readiness, and liveness support.

### Q55. What is the difference between `@Component`, `@Service`, and `@Repository`?
Answer: All are stereotype annotations for component scanning. `@Service` expresses business-layer intent, `@Repository` expresses persistence-layer intent and can participate in exception translation, and `@Component` is the generic form.

### Q56. What is `@RestController`?
Answer: It is a convenience annotation combining `@Controller` and `@ResponseBody`, so handler methods return response bodies directly.

### Q57. What is `@ConfigurationProperties`?
Answer: It binds external configuration into typed Java objects and is preferred over scattering `@Value` strings throughout the code.

### Q58. What is `@Transactional`?
Answer: It declares transactional boundaries around methods or classes so database work can be committed or rolled back as one unit.

### Q59. What are transaction propagation modes?
Answer: They define how a method participates in an existing transaction, such as `REQUIRED`, `REQUIRES_NEW`, `SUPPORTS`, `MANDATORY`, `NEVER`, and `NOT_SUPPORTED`.

### Q60. Why should you avoid long transactions?
Answer: Long transactions hold locks longer, increase contention, reduce throughput, and can make failures more expensive.

### Q61. Why should you avoid remote calls inside transactions?
Answer: Network calls can be slow or fail unpredictably, which increases lock duration and makes transaction boundaries harder to reason about.

### Q62. What is `@ControllerAdvice`?
Answer: It centralizes exception handling, binding logic, and cross-cutting MVC concerns so API error responses stay consistent.

### Q63. What is the N+1 query problem?
Answer: It happens when loading one parent collection triggers many additional child queries, causing poor performance and hidden database load.

### Q64. What is lazy loading?
Answer: Lazy loading delays fetching associated data until it is actually accessed. It can improve efficiency but may cause surprises such as `LazyInitializationException`.

### Q65. What is the difference between `EntityManager` and `EntityManagerFactory`?
Answer: `EntityManagerFactory` is heavyweight and creates `EntityManager` instances. `EntityManager` is the JPA interface used for persistence operations and persistence context management.

### Q66. What is optimistic locking?
Answer: Optimistic locking uses version checking, usually with `@Version`, to detect conflicting concurrent updates without locking rows aggressively up front.

## 6. SQL and Databases

### Q67. What is the difference between DDL and DML?
Answer: DDL changes database structure with commands such as `CREATE`, `ALTER`, and `DROP`. DML changes or reads data with commands such as `INSERT`, `UPDATE`, `DELETE`, and `SELECT`.

### Q68. What is a primary key?
Answer: A primary key uniquely identifies each row in a table and does not allow null values.

### Q69. What is the difference between a primary key and a unique key?
Answer: Both enforce uniqueness, but a primary key is the main identifier for the table and does not allow nulls. A unique key also enforces uniqueness but is not necessarily the primary identifier.

### Q70. What is a foreign key?
Answer: A foreign key enforces referential integrity by linking a column to a key in another table.

### Q71. What is ACID?
Answer: Atomicity means all-or-nothing execution, Consistency means valid state transitions, Isolation controls concurrent behavior, and Durability means committed changes persist.

### Q72. What is a transaction?
Answer: A transaction is a logical unit of work that must either fully succeed or fully fail.

### Q73. What are common isolation levels?
Answer: Read Uncommitted, Read Committed, Repeatable Read, and Serializable.

### Q74. What is the difference between inner join and outer join?
Answer: Inner join returns only matching rows. Outer joins return matches plus unmatched rows from one or both sides depending on left, right, or full outer semantics.

### Q75. What is an index?
Answer: An index is a data structure that speeds up lookups and some sorts or joins at the cost of extra storage and slower writes.

### Q76. Why can too many indexes hurt performance?
Answer: Every insert, update, and delete may need to maintain those indexes, which increases write cost and storage overhead.

### Q77. What is normalization?
Answer: Normalization organizes data to reduce redundancy and improve integrity, commonly discussed through normal forms such as 1NF, 2NF, and 3NF.

### Q78. What is denormalization?
Answer: Denormalization intentionally adds redundancy to improve read performance or simplify query patterns.

### Q79. What is a view?
Answer: A view is a stored query that behaves like a virtual table.

### Q80. What is a materialized view?
Answer: A materialized view physically stores query results and typically needs refresh logic to stay current.

### Q81. What is a subquery?
Answer: A subquery is a query nested inside another query, for example in a `WHERE`, `FROM`, or `SELECT` clause.

### Q82. How do you tune slow SQL queries?
Answer: Start with execution plans, examine joins, filters, cardinality, sort operations, and indexing strategy, then measure before and after changes.

### Q83. What is partitioning?
Answer: Partitioning splits large tables or indexes into smaller parts, often by date, range, hash, or list, to improve manageability and sometimes performance.

## 7. Git

### Q84. What is Git?
Answer: Git is a distributed version control system that tracks changes to files and supports branching, merging, and collaboration.

### Q85. What is the difference between `git fetch` and `git pull`?
Answer: `git fetch` downloads remote changes without merging them. `git pull` usually performs a fetch followed by merge or rebase.

### Q86. What is the difference between merge and rebase?
Answer: Merge combines histories and preserves branch structure. Rebase rewrites commits onto a new base to create a cleaner linear history.

### Q87. What is a fast-forward merge?
Answer: It happens when the target branch has not diverged and Git can simply move the branch pointer forward.

### Q88. What is a conflict in Git?
Answer: A conflict occurs when Git cannot automatically reconcile overlapping changes from different histories.

### Q89. What does `git stash` do?
Answer: It temporarily saves uncommitted changes so you can switch context without making a full commit.

### Q90. What is the difference between `git reset` and `git revert`?
Answer: `git reset` moves pointers and can rewrite local history. `git revert` creates a new commit that reverses a previous commit and is safer for shared history.

### Q91. What is cherry-pick?
Answer: `git cherry-pick` applies selected commits from one branch onto another branch.

### Q92. What is `HEAD` in Git?
Answer: `HEAD` points to the current checked-out commit or branch reference.

### Q93. Why use feature branches?
Answer: Feature branches isolate work, reduce risk to the main branch, and make review and testing easier.

### Q94. What is a detached `HEAD` state?
Answer: It means `HEAD` points directly to a commit instead of a branch, so new commits are not attached to a named branch unless you create one.

### Q95. How do you recover a lost commit?
Answer: Often by using `git reflog` to find previous references and then restoring the commit through a branch, checkout, or reset.

### Q96. What is a good Git workflow for teams?
Answer: Keep branches small, commit logically, rebase or merge responsibly, review through pull requests, protect main branches, and automate builds/tests in CI.

## 8. Cloud

### Q97. What is cloud computing?
Answer: Cloud computing provides on-demand compute, storage, networking, and managed services over the internet with elastic scaling and usage-based billing.

### Q98. What is the difference between IaaS, PaaS, and SaaS?
Answer: IaaS provides raw infrastructure, PaaS provides a managed platform for deployment, and SaaS provides complete software delivered as a service.

### Q99. What is containerization?
Answer: Containerization packages an application and its dependencies into a portable unit that runs consistently across environments.

### Q100. What is Docker?
Answer: Docker is a platform and toolchain for building, packaging, and running containers.

### Q101. What is Kubernetes?
Answer: Kubernetes is a container orchestration platform used for deployment, scaling, service discovery, health management, and rolling updates.

### Q102. What is the difference between a container and a virtual machine?
Answer: Containers share the host OS kernel and are lighter weight. Virtual machines include a full guest OS and are more isolated but heavier.

### Q103. What is horizontal scaling vs vertical scaling?
Answer: Horizontal scaling adds more instances, while vertical scaling increases resources on a single instance.

### Q104. What is high availability?
Answer: High availability means designing the system to remain accessible despite failures, often using redundancy across instances or zones.

### Q105. What is fault tolerance?
Answer: Fault tolerance means the system continues functioning correctly even when some components fail.

### Q106. What is auto-scaling?
Answer: Auto-scaling automatically adjusts instance count or capacity based on demand or metrics.

### Q107. What is a load balancer?
Answer: A load balancer distributes traffic across multiple instances to improve scalability, availability, and resilience.

### Q108. What is the difference between stateless and stateful services?
Answer: Stateless services do not store client-specific session state locally, which makes scaling easier. Stateful services hold local session or mutable state and require more careful scaling and failover design.

### Q109. What is infrastructure as code?
Answer: Infrastructure as code manages infrastructure definitions through versioned files so environments can be reproducible, reviewable, and automated.

### Q110. What is CI/CD?
Answer: CI continuously integrates and validates code changes through automated build and test pipelines. CD automates delivery or deployment so changes can move to environments safely and frequently.

### Q111. What is blue-green deployment?
Answer: Blue-green deployment keeps two environments so traffic can switch between old and new versions with low downtime and easier rollback.

### Q112. What is canary deployment?
Answer: Canary deployment releases to a small subset of users or traffic first, then expands if health looks good.

### Q113. What is observability?
Answer: Observability is the ability to understand system behavior through metrics, logs, traces, and other signals.

### Q114. What is the difference between metrics, logs, and traces?
Answer: Metrics give numeric trends, logs capture event details, and traces show request flow across distributed components.

### Q115. What is eventual consistency?
Answer: Eventual consistency means distributed data replicas may not be immediately consistent, but they converge over time if no new updates occur.

### Q116. What is a message queue and why is it useful in cloud systems?
Answer: A message queue decouples producers and consumers, smooths spikes, and supports asynchronous workflows and resilience patterns.

### Q117. What is a circuit breaker?
Answer: A circuit breaker stops repeated calls to an unhealthy dependency so failures do not cascade through the system.

### Q118. What are common cloud security concerns?
Answer: Identity and access management, secret handling, encryption, network segmentation, audit logging, patching, and least-privilege permissions.

### Q119. What is multi-region vs multi-zone deployment?
Answer: Multi-zone improves resilience within one region. Multi-region improves disaster recovery and geographic resilience but adds complexity and consistency concerns.

### Q120. What is a good cloud answer in a senior interview?
Answer: A strong answer balances scalability, reliability, cost, operability, security, and recovery strategy instead of focusing only on technology names.

## 9. Quick Senior-Level Closing Themes

If you are interviewing for senior backend roles, add these dimensions to your answers:

- trade-offs, not just definitions
- failure handling, not just happy path
- observability and debugging
- scalability and latency
- testing and deployment safety
- data correctness and recovery
- maintainability and team impact
