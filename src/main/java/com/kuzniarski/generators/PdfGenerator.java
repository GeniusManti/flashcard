package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.input.FileReader;
import com.lowagie.text.*;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import sun.font.FontFamily;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.kuzniarski.input.FileReader.read;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class PdfGenerator {

    public void generatePdf(String fileName, String pathAndFileNameToSave) throws IOException, DocumentException {

        List<String> textLines = FileReader.read(fileName);
        List<String[]> cardSet = CardSetGenerator.getCardSet(textLines);

        createPdf(pathAndFileNameToSave, cardSet);
    }

    private void createPdf(String filename, List<String[]> text)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();

        document.add(createTable(text, 0));
        document.newPage();
        document.add(createTable(text, 1));

        document.close();
    }

    private PdfPTable createTable(List<String[]> list, int index) {
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        Font font = new Font(Font.HELVETICA, 7, Font.NORMAL, GrayColor.black);

        if(index == 0) {
            list.forEach(f ->
                    table.addCell(createCell(font, f[index])
                    ));
        } else {
            for (int i = 1; i <= list.size()/5+1 ; i++) {
                for (int j = (i*5)-1; j >= (i-1)*5; j--) {
                    if(list.size() > j)
                        table.addCell(createCell(font, list.get(j)[index]));
                }
            }
        }

        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        return table;
    }





    private PdfPCell createCell(Font font, String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(40f);
        cell.setPaddingTop(10f);
        return cell;
    }

    public static void main(String[] args) throws IOException, DocumentException {

        new PdfGenerator().generatePdf("D:\\shebang\\algebra.txt", "D:\\workspace\\flashcard\\pdf\\default.pdf");

    }



}
