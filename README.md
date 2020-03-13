# SQL String to List

Just a simple IntelliJ IDEA plugin to assist with quick editing of strings. 

I got tired of copy/paste/find/replace/fix using a text editor and it's something easily done in Java. 
This plugin offers two similar features. Both are useful when dealing with a comma-separated string 
received in a SQL query result. The first takes the string, splits it at the commas, then surrounds each 
element with single quotes. The second does the same thing, but gives each element its own line; 
this is useful when dealing with lengthy results, especially UUIDs.

Example:
`abc,def,ghi` becomes `'abc','def','ghi'`.

---
To install locally, run the `buildPlugin` Gradle task, then look for the `.zip` file in the `/build/distributions/` directory of the project. On IntelliJ 2019+, there's a cogwheel on the menu of the Plugins screen in Preferences...
