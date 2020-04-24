module MiluJavaSample {
	requires transitive java.desktop;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;
	
	exports milu.entity;
	opens milu.entity to com.google.gson;
	
	exports milu.fx.begin;
	opens milu.fx.begin to javafx.graphics;
}
