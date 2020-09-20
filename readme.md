agent entry set:
```xml
<manifestEntries>
    <Agent-Class>com.sample.agent.AttachAgentDemo</Agent-Class>
</manifestEntries>
```

1. start tomcat first
2. use `mvn clean install -Dmaven.test.skip=true` to generate your agent jar
3. run test case (remember replace your agent's file path)
4. check your console output