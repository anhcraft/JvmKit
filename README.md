# JvmKit
[![Release](https://travis-ci.org/anhcraft/JvmKit.svg?branch=master)](https://travis-ci.org/anhcraft/JvmKit)

My personal utility kit for JVM languages (currently are Java and Kotlin).<br>
This library only works on Java SE 11 and above, so you must be use the right version of those language.

## package
- **builders**: this is a collection of builders. A builder has the capacity of creating complex things in easier steps than the usual way. A builder listens to your instructions by calling its methods. With each instruction, they store it in variables. There is always the build method which you can use to tell them to start building. An advantage of builders is that you can reuse them with no limit and no performance problems.
- **helpers**: this is a collection of helpers. Helpers are similar to builders but the aim of them is achieving something than creating something. A helper may not have the build method. Not storing instruction like a builder, a helper performs immediately after listening to so you can get the result in time. You may not able to reuse a helper as it can cause problems.
- **kit**: this is a collection of kits. A kit is based on something which is already existed but it is simpler and more understandable. Not like a builder or a helper, a kit can contain multiple classes with different functions.
- **lang**: some additions to the language.
- **utils**: a collection of utility classes.

## implement
```xml
<repository>
    <id>anhcraft-releases</id>
    <url>https://anhcraft.dev:7554/repository/maven-releases/</url>
</repository>
```

```xml
<dependency>
    <groupId>dev.anhcraft.jvmkit</groupId>
    <artifactId>JvmKit</artifactId>
    <version>VERSION</version>
</dependency>
```

## license
This library is licensed under MIT license.
