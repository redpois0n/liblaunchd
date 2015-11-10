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