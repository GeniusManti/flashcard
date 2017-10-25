package flashcard.web.controllers;

import flashcard.application.generators.PdfGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/generateReport.do")
public class ReportController {

    @GetMapping
    public void generateReport(HttpServletResponse response) throws Exception {

        byte[] data = IOUtils.toByteArray(new PdfGenerator("D:\\workspace\\flashcard\\source\\algebra.txt", ";").generatePdf());

        streamReport(response, data, "my_report.pdf");
    }

    protected void streamReport(HttpServletResponse response, byte[] data, String name)
            throws IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}