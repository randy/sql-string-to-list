# SQL String to List

Just a simple IntelliJ IDEA plugin to assist with quick editing of strings. 

I got tired of copy/paste/find/replace/fix using a text editor and it's something easily done in Java. 
This plugin offers two similar features. Both are useful when dealing with a comma-separated string received in a SQL query result. The first take the string, splits it at the commas, then surround each element with single quotes. The second does the same thing, but gives each element its own line; this is useful when dealing with lengthy results, especially UUIDs.

Example:
`abc,def,ghi` becomes `'abc','def','ghi'`.