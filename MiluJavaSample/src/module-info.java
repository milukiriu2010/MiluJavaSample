module MiluJavaSample {
	requires transitive java.desktop;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;
	requires poi;
	//requires poi.ooxml;
	
	exports milu.db.oracle;
	opens milu.db.oracle to javafx.graphics;
	
	exports milu.encrypt;
	opens milu.encrypt to javafx.graphics;	

	exports milu.entity;
	opens milu.entity to com.google.gson;

	exports milu.entity.team;
	opens milu.entity.team to com.google.gson;
	
	exports milu.fx.begin;
	opens milu.fx.begin to javafx.graphics;
	
	exports milu.fx.combo;
	opens milu.fx.combo to javafx.graphics;
}
