module MiluJavaSample {
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires com.google.gson;
	
	exports milu.entity;
	opens milu.entity to com.google.gson;
	
	exports milu.fx.begin;
	opens milu.fx.begin to javafx.graphics;
}
