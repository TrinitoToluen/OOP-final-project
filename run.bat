rm bin/*.class
javac src/*.java src/forms/*.java -cp src  -d ./bin
java -cp ./bin App