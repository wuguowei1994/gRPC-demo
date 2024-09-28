# 1. Mac install protobuf 
```bash
brew install automake
brew install libtool
brew install protobuf
protoc --version
```
Let's suppose the output is `28.2`. Then the `protobuf-java` version must be `4.28.2` in `pom.xml`.

# 2. Mac install gRPC extensions
1. Download `protoc-gen-grpc-java-1.45.1-osx-x86_64.exe` from the following link:
    - [Download Link](https://repo.maven.apache.org/maven2/io/grpc/protoc-gen-grpc-java/1.45.1/)

2. Install

   ```bash
   mv /Users/apple/Downloads/protoc-gen-grpc-java-1.45.1-osx-x86_64.exe /Users/apple/Downloads/protoc-gen-grpc-java
   chmod +x /Users/apple/Downloads/protoc-gen-grpc-java
   xattr -d com.apple.quarantine /Users/apple/Downloads/protoc-gen-grpc-java
   ```

3. Generate java class

   ```bash
   cd /Users/apple/GitCode/grpc-demo
   # normal java class
   protoc --java_out=src/main/java src/proto/helloworld.proto
   # service java class
   protoc --java_out=src/main/java --grpc-java_out=src/main/java \
   --plugin=protoc-gen-grpc-java=/Users/apple/Downloads/protoc-gen-grpc-java src/proto/helloworld.proto
   ```
