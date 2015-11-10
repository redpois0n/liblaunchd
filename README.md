# liblaunchd

Mac OS X launchd daemon/agent Java library

## Examples

### Creating agent

```java
Agent a = new Agent("name");
Key key = new Key(Agent.KEY_PROGRAM);
a.add(key);
a.add("/path/to/script");
```

### Creating agent with multiple program arguments

```java
Agent a = new Agent("name");
Key key = new Key(Agent.KEY_PROGRAM_ARGUMENTS);
a.add(key);

Array arr = new Array();

arr.add("/path/to/script");
arr.add("--version");

a.add(arr);
```