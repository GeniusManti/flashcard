package com.kuzniarski.generators;

import com.kuzniarski.domain.FlashCard;
import com.kuzniarski.input.FileReader;
import com.lowagie.text.*;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class PdfGenerator {

    private List<FlashCard> cardSet ;
    private String pathToSave;

    public PdfGenerator(String fileName, String regex, String pathAndFileNameToSave) {

        List<String> textList = FileReader.read(fileName);

        cardSet = new CardSetGenerator().generateFlashCard(textList, regex);
        pathToSave = pathAndFileNameToSave;
    }

    public void generatePdf() throws IOException, DocumentException {
        createPdf(pathToSave);
    }

    private void createPdf(String filename)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();



        document.add(createTable(getTextList(), false));
        document.newPage();
        document.add(createTable(getTranslationList(), true));

        document.close();
    }

    private List<String> getTextList() {
        return cardSet.stream().map(FlashCard::getText).collect(Collectors.toList());
    }

    private List<String> getTranslationList() {
        return cardSet.stream().map(FlashCard::getTranslation).collect(Collectors.toList());
    }

    private PdfPTable createTable(List<String> list, boolean isTranslation) {
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        Font font = new Font(Font.HELVETICA, 7, Font.NORMAL, GrayColor.black);

        if(!isTranslation) {
            list.forEach(f ->
                    table.addCell(createCell(font, f)
                    ));
        } else {
            for (int i = 1; i <= list.size()/5+1 ; i++) {
                for (int j = (i*5)-1; j >= (i-1)*5; j--) {
                    if(list.size() > j)
                        table.addCell(createCell(font, list.get(j)));
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

}
