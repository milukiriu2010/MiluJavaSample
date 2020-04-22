module MiluJavaSample {
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.controls;
	
	exports milu.fx.begin;
	opens milu.fx.begin to javafx.graphics;
}