package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Utils {
    public static File generatePDFFromTicket(Ticket ticket) {
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("Potwierdzam."));
            document.close();
            writer.close();
            return new File("HelloWorld.pdf");
        } catch (DocumentException | FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
