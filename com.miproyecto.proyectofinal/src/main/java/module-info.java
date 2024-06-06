module com.miproyecto.proyectofinal.com.miproyecto.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires org.jfree.jfreechart;
	requires java.desktop;
	requires org.apache.poi.ooxml;
	requires org.apache.pdfbox;

    opens com.miproyecto.proyectofinal to javafx.fxml;
    exports com.miproyecto.proyectofinal;
}
