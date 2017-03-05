javac -d bin src/xyz/thelostlambda/util/*.java
javac -d bin -cp bin src/xyz/thelostlambda/runners/*.java
java -cp bin xyz.thelostlambda.runners.Runner
