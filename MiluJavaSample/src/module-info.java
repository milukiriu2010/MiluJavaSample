module MiluJavaSample {
	requires javafx.graphics;
	requires javafx.controls;
	
	exports milu.fx.begin;
	opens milu.fx.begin to javafx.graphics;
}