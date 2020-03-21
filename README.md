XYZ console Java utility that analyzes the input file. 
Format:
java com.xyz.Main [options] file, where

options - optional parameters, taking one or more of the following values:
-m - count and display the number of characters in the file.
-w - count and display the number of words in the file.
-X - flag for the extended presentation of statistical data - in addition to the main value, a list of 10 most common occurrences will be displayed, in decreasing order of frequency.
file - a required parameter that specifies the path to the text file.
If neither -m nor -w is specified, the utility should work as if both flags were set.


to run the program you should:
1. to open cmd 
2. to be in folder java (example: D:\projects\XYZ\src\main\java)
3. to make .class files by javac com\xyz\Start.java com\xyz\service\OptionsService.java
4. to run program with arguments by java com.xyz.Start [options] file
 Example: java com.xyz.Start -mX D:\projects\XYZ\file.txt
 
 Run tests to check how this works.
