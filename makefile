encode:
  @javac encoder.java
  @java encoder $(ARGS)
decode:
  @javac decoder.java
  @java decoder $(ARGS)
clean:
	@rm *.class
