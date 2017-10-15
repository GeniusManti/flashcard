package com.kuzniarski;

import com.kuzniarski.generators.PdfGenerator;
import com.lowagie.text.DocumentException;

import java.io.IOException;

/**
 * Created by Kacper Kuźniarski on 18.10.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, DocumentException {

        new PdfGenerator("D:\\workspace\\flashcard\\source\\algebra.txt", ";", "D:\\workspace\\flashcard\\pdf\\default.pdf").generatePdf();

    }
}
