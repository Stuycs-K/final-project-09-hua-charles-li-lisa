encode:
	@javac encoder.java
	@java encoder encode $(ARGS)
decode:
	@javac decoder.java
	@java decoder decode $(ARGS)
clean:
	@rm *.class
