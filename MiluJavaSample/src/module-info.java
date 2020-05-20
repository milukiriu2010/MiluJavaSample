module MiluJavaSample {
	requires transitive java.desktop;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires com.google.gson;
	requires jdk.jsobject;
	//requires poi;
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
	
	exports milu.fx.cursor;
	opens milu.fx.cursor to javafx.graphics;
	
	exports milu.fx.drag;
	opens milu.fx.drag to javafx.graphics;
	
	exports milu.fx.event;
	opens milu.fx.event to javafx.graphics;	
	
	exports milu.fx.key;
	opens milu.fx.key to javafx.graphics;	
	
	exports milu.fx.label;
	opens milu.fx.label to javafx.graphics;	
	
	exports milu.fx.line;
	opens milu.fx.line to javafx.graphics;	
	
	exports milu.fx.list;
	opens milu.fx.list to javafx.graphics;	
	
	exports milu.fx.mouse;
	opens milu.fx.mouse to javafx.graphics;	
	
	exports milu.fx.overlay;
	opens milu.fx.overlay to javafx.graphics;	

	exports milu.fx.pane;
	opens milu.fx.pane to javafx.graphics;	

	exports milu.fx.plot;
	opens milu.fx.plot to javafx.graphics;	

	exports milu.fx.progress;
	opens milu.fx.progress to javafx.graphics;	
}
