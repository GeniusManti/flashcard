package flashcard.web.services.report;

import com.lowagie.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface ReportService {

    void sendReport(HttpServletResponse httpServletResponse) throws IOException, DocumentException;
    InputStream generateReport(File file) throws IOException, DocumentException;
}
