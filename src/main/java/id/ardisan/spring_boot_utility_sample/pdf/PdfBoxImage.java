package id.ardisan.spring_boot_utility_sample.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfBoxImage {

  public static void main(String... args) {
    PdfBoxImage clazz = new PdfBoxImage();
    clazz.embedImage();
  }

  public void embedImage() {
    try {
      String imagePath = "image1.jpg";

      File pdfFile = new File("EmbeddedImage.pdf");
      PDDocument document = new PDDocument();

      PDPage page = new PDPage();
      document.addPage(page);

      PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);

      PDPageContentStream contents = new PDPageContentStream(document, page);

      contents.drawImage(pdImage, 0, 0);

      contents.close();

      document.save(pdfFile);

      document.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
