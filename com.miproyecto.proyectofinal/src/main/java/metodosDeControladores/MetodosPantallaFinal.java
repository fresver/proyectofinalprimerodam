package metodosDeControladores;

import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javafx.stage.FileChooser;

public class MetodosPantallaFinal {

	private static int indiceWord;

	public static void verGraficaCombate(int contadorAtaques, int contadorCuras, int contadorSuerte) {
		Map<String, Integer> mapaConteo = new HashMap<>();
		mapaConteo.put("Atacar", contadorAtaques);
		mapaConteo.put("Curarse", contadorCuras);
		mapaConteo.put("Suerte", contadorSuerte);
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		datos.addValue(mapaConteo.get("Atacar"), "Estadísticas", "Veces que atacaste");
		datos.addValue(mapaConteo.get("Curarse"), "Estadísticas", "Veces que te curaste o lo intentaste");
		datos.addValue(mapaConteo.get("Suerte"), "Estadísticas", "Veces que probaste suerte");

		JFreeChart grafico = ChartFactory.createBarChart("Gráfica de estadísticas", "Acciones", "Número de veces",
				datos);

		CategoryPlot plot = grafico.getCategoryPlot();

		BarRenderer renderer = new BarRenderer();

		renderer.setSeriesPaint(0, new java.awt.Color(0, 0, 255));
		renderer.setDrawBarOutline(false);

		plot.setRenderer(renderer);

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		ChartPanel panel = new ChartPanel(grafico);
		panel.setPreferredSize(new Dimension(800, 600));

		JFrame ventana = new JFrame("RogueFX");
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);

		ventana.setContentPane(panel);
		ventana.setVisible(true);

		System.out.println("Gráfica hecha");
	}

	public static void descargarWordComabate(int contadorAtaques, int contadorCuras, int contadorSuerte)
			throws IOException {
		XWPFDocument doc = new XWPFDocument();

		XWPFParagraph titleParagraph = doc.createParagraph();
		XWPFRun titleRun = titleParagraph.createRun();
		titleRun.setText("RogueFX");
		titleRun.setBold(true);
		titleRun.setFontFamily("Arial");
		titleRun.setFontSize(36);
		titleRun.addBreak();

		XWPFParagraph tmpParagraph = doc.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText("Veces que has atacado: " + contadorAtaques);
		tmpRun.setFontFamily("Arial");
		tmpRun.addBreak();

		XWPFParagraph tmpParagraph2 = doc.createParagraph();
		XWPFRun tmpRun2 = tmpParagraph2.createRun();
		tmpRun2.setText("Veces que te has curado o lo has intentado: " + contadorCuras);
		tmpRun2.setFontFamily("Arial");
		tmpRun2.addBreak();

		XWPFParagraph tmpParagraph3 = doc.createParagraph();
		XWPFRun tmpRun3 = tmpParagraph3.createRun();
		tmpRun3.setText("Veces que has probado suerte: " + contadorSuerte);
		tmpRun3.setFontFamily("Arial");
		tmpRun3.addBreak();

		String folder = System.getProperty("user.home") + File.separator + "Desktop";
		String fileName = File.separator + "RogueFX_Estadísticas(" + indiceWord + ")" + ".docx";
		indiceWord++;

		File f = new File(folder);
		if (!f.exists()) {
			System.out.println("Carpeta creada" + folder);
			f.mkdirs();
		}

		FileOutputStream out = new FileOutputStream(new File(folder + fileName));
		doc.write(out);
		out.close();

		System.out.println("Word descargado en Escritorio o Desktop");
	}

	public static void descargarPdfCombate(int contadorAtaques, int contadorCuras, int contadorSuerte) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar PDF");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf"));

		File fileToSave = fileChooser.showSaveDialog(null);

		if (fileToSave != null) {
			try {
				PDDocument document = new PDDocument();
				PDPage page = new PDPage();
				document.addPage(page);

				try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
					float yOffset = 700;

					contentStream.beginText();
					contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 36);
					contentStream.newLineAtOffset(100, yOffset);
					contentStream.showText("RogueFX");
					contentStream.endText();

					yOffset -= 40;

					contentStream.beginText();
					contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
					contentStream.newLineAtOffset(100, yOffset);
					contentStream.showText("Veces que has atacado: " + contadorAtaques);
					contentStream.endText();

					yOffset -= 20;

					contentStream.beginText();
					contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
					contentStream.newLineAtOffset(100, yOffset);
					contentStream.showText("Veces que te has curado o lo has intentado: " + contadorCuras);
					contentStream.endText();

					yOffset -= 20;

					contentStream.beginText();
					contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
					contentStream.newLineAtOffset(100, yOffset);
					contentStream.showText("Veces que has probado suerte: " + contadorSuerte);
					contentStream.endText();
				}
				document.save(fileToSave);
				document.close();
				JOptionPane.showMessageDialog(null, "PDF generado exitosamente.");
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
			}
		}
		System.out.println("Éxito");
	}

}
