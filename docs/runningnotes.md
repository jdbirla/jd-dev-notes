# Running Notes Quickly note
https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

## How to convert Zip to TXT and TXT to ZIP
- Convert the ZIP file into a Base64 text file using:
```sh
base64 myfile.zip > myfile.txt
- Download the .txt file and decode it back:
base64 -d myfile.txt > myfile.zip
```