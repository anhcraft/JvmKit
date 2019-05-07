# JvmKit
[![Release](https://travis-ci.org/anhcraft/JvmKit.svg?branch=master)](https://travis-ci.org/anhcraft/JvmKit)

My personal utility kit for JVM languages (currently are Java and Kotlin).<br>
This library only works on Java SE 11 and above, so you must use the right version of those languages.

## package
- **builders**: this is a collection of builders. A builder has the capacity of creating complex things in simpler steps than usual. You command it by calling methods, and the builder will "memorise" that instruction in variables. When you are ready, you tell it to start by calling the build method. An advantage of builders is that you can reuse them with no limit and no performance problems.
- **helpers**: this is a collection of helpers. A helper is similar to a builder but the different of a helper is that it can manage and manipulate extra things after creating. Memorising instruction is optional for a helper. A helper performs immediately after listening to so you can get the result in time. Reusing a helper, in fact, is not recommended like a builder.
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
