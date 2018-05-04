package flashcard.web.services.report;

import com.lowagie.text.DocumentException;
import flashcard.web.domain.FlashCard;
import flashcard.web.services.report.generators.CardGenerator;
import flashcard.web.services.report.generators.PdfGenerator;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    @Override
    public void sendReport(HttpServletResponse httpServletResponse) throws IOException, DocumentException {
        //byte[] data = IOUtils.toByteArray(generateReport(generateReport()));

        //streamReport(httpServletResponse, data, "my_report.pdf");
    }

    @Override
    public InputStream generateReport(File file) throws IOException, DocumentException {
        List<FlashCard> flashcardSet = CardGenerator.generateFlashCardSet(FileReader.read(file), ";");
        return new PdfGenerator(flashcardSet).generatePdf();
    }

    private void streamReport(HttpServletResponse response, byte[] data, String name) throws IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}
