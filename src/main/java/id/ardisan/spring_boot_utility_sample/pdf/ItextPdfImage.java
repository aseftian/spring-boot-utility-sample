package id.ardisan.spring_boot_utility_sample.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfImage {
  
  public static void main(String... args) {
    Document document = new Document();
    document.addTitle("Itext PDF Document");

    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Itextpdf.pdf"));
      // Rectangle rect1 = new Rectangle(2480f, 3508f);
      Rectangle rect1 = new Rectangle(595f, 842f); // ukukran A4 dalam pixel 72dpi
      document.setPageSize(rect1);
      document.open();

      Image image = Image.getInstance("image1.jpg");
      // image.setAbsolutePosition(25f, 25f);
      // image.setPaddingTop(25f);
      // image.setTop(25f);
      // image.setLeft(25f);
      // System.out.println("Width: "+ document.getAccessibleAttribute(PdfName.WIDTH).toString());
      // System.out.println("Height: "+ document.getAccessibleAttribute(PdfName.HEIGHT).toString());
      // Rectangle rect1 = new Rectangle(210f, 297f);
      image.scalePercent(50f);
      document.add(image);

      document.close();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
