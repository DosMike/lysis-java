lysis-java
==========

Lysis - SourceMod .smx decompiler

This is an improved Java port of BAILOPAN's sourcepawn decompiler [Lysis](https://forums.alliedmods.net/showthread.php?t=170898).
Originally written C#.

[Original repository](https://hg.alliedmods.net/users/dvander_alliedmods.net/lysis/)

## Building
This project uses Gradle to build. Run `gradlew jar` to download all dependencies and build a runnable jar which will be located in `build/libs`.
Run `gradlew eclipse` to generate an eclipse project for editing.

## Changes in this fork
The purpose of this for is to provide lysis-java as library.

This fork should be jitpack compatible, but I haven't tried yet.

The main difference to [peace-maker/lysis-java](/peace-maker/lysis-java) is the LibLysis class that has a handful of methods
that decompile with streams.