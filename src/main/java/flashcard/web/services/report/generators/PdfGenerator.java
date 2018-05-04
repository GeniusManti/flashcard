package flashcard.web.services.report.generators;

import com.lowagie.text.*;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import flashcard.web.domain.FlashCard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 08.10.2017.
 */
public class PdfGenerator {

    private List<FlashCard> cardSet;

    public PdfGenerator(List<FlashCard> cardSet) {
        this.cardSet = cardSet;
    }

    public InputStream generatePdf()
            throws DocumentException {

        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        document.add(createTable(getTextList(), false));
        document.newPage();
        document.add(createTable(getTranslationList(), true));

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
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

        if (!isTranslation) {
            list.forEach(f ->
                    table.addCell(createCell(font, f)
                    ));
        } else {
            for (int i = 1; i <= list.size() / 5 + 1; i++) {
                for (int j = (i * 5) - 1; j >= (i - 1) * 5; j--) {
                    if (list.size() > j)
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
