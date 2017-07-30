//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
///**
// * Created by xtantransh on 29/7/17.
// */
//public class CreatePdf {
//
//    public static void main(String[] args) {
//        Document document=new Document();
//        try {
//            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
//            document.open();
//            document.add(new Paragraph("Welcome to CodeKul"));
//
//            PdfPTable table=new PdfPTable(3);
//            table.setWidthPercentage(105);
//            table.setSpacingBefore(11f);
//            table.setSpacingAfter(11f);
//
//            float[] colWidth={2f,2f,2f};
//            table.setWidths(colWidth);
//            PdfPCell c1=new PdfPCell(new Paragraph("Column1"));
//            PdfPCell c2=new PdfPCell(new Paragraph("Column2"));
//            PdfPCell c3=new PdfPCell(new Paragraph("Column3"));
//            table.addCell(c1);
//            table.addCell(c2);
//            table.addCell(c3);
//            document.add(table);
//
//            document.close();
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//    }
//}
