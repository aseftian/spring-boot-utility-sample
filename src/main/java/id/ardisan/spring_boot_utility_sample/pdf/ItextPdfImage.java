package id.ardisan.spring_boot_utility_sample.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfImage {

  public static void main(String... args) {

    try {
      File img = new File("image1.jpg");
      byte[] imgByte = FileUtils.readFileToByteArray(img);
      Document document = new Document();
      ByteArrayOutputStream outbyte = new ByteArrayOutputStream();
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("PdfImage.pdf"));
      Rectangle rect1 = new Rectangle(595f, 842f); // ukukran A4 dalam pixel 72dpi
      document.setPageSize(rect1);
      document.setMargins(55f, 55f, 55f, 55f);
      document.open();
      Image image = Image.getInstance(imgByte);
      float imgWidth = image.getWidth();
      float imgHeight = image.getHeight();

      float widthRatio = imgWidth / rect1.getWidth() * 100;
      float heightRatio = imgHeight / rect1.getHeight() * 100;
      System.out.println("widthRatio: " + widthRatio);
      System.out.println("heightRatio: " + heightRatio);

      if (widthRatio > 100f || heightRatio > 100f) {
        if (widthRatio > heightRatio) {
          float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
               - document.rightMargin() - 0) / image.getWidth()) * 100;
          image.scalePercent(scaler);
        } else {
          float scaler = ((document.getPageSize().getHeight() - document.topMargin()
               - document.bottomMargin() - 0) / image.getHeight()) * 100;
          image.scalePercent(scaler);
        }
      }

      document.add(image);

      document.close();
      writer.close();

      // return outbyte;
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
