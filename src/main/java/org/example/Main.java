package org.example;


import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfWriter;




//https://www.concretepage.com/itext/add-header-and-footer-in-pdf-using-itext-in-java

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {


        Enterprise enterprise1 = new Enterprise();

        Address address1 = new Address();
        BankDetails bankDetails = new BankDetails();
        Person manager = new Person();

        enterprise1.setId(685586);
        enterprise1.setLegalPerson(true);
        enterprise1.setName("ARA und Ko GmbH");
        enterprise1.setWebsite("www.araundco.at");
        enterprise1.setHeadOfEnterprise("General Manager");
        enterprise1.setRefisterPlace("Wien");
        enterprise1.setRegisterNr("67868687");
        enterprise1.setUstId("2022/4044-22");
        enterprise1.setEmail("sales@araundco.at");
        enterprise1.setPhoneNr("+43 663 321 23 34");

        address1.setId(45254);
        address1.setStreet("Delustrasse");
        address1.setHouseNr("34b");
        address1.setPremises("3");
        address1.setPostcode("2003");
        address1.setPlace("Berlin");

        enterprise1.setAddress(address1);

        BankDetails bankDetails1 = new BankDetails();
        bankDetails1.setBankName("Raiffeisen");
        bankDetails1.setContoOwnerName(enterprise1.getName());
        bankDetails1.setIban("AT61 1904 3002 3457 3201");
        bankDetails1.setBic("WWWBHT");

        enterprise1.setBankDetails(bankDetails1);

        Person manager1 = new Person();
        manager1.setName("Sam");
        manager1.setFamilyName("Picard");
        manager1.setId(65585);
        manager1.setPhoneNr("+43 663 646 36 37");
        manager1.setEmail("picard@aragmbh.at");
        manager1.setSalutation(Salutation.MR);
        enterprise1.setContactPerson(manager1);

        Client client1 = new Client();
        client1.setId(73614);
        client1.setName("Wasser Lieferung AG");
        client1.setBusinessPerson(true);

        Person clientContactPerson1 = new Person();
        clientContactPerson1.setName("Anna");
        clientContactPerson1.setFamilyName("Berger");
        clientContactPerson1.setId(68773);
        clientContactPerson1.setSalutation(Salutation.FRAU);

        client1.setContactPerson(clientContactPerson1);

        Address client1Address = new Address();

        client1Address.setStreet("Kaasgrabegasse");
        client1Address.setHouseNr("20A");
        client1Address.setId(5675);
        client1Address.setPlace("Wien");
        client1Address.setPostcode("1190");

        client1.setAddress(client1Address);

        Invoice invoice1 = new Invoice();
        invoice1.setId(668633);
        invoice1.setInvoiceNr("23323322");
        invoice1.setClient(client1);
        invoice1.setEnterprise(enterprise1);
        invoice1.setPaymentTerm(14);

        System.out.println(enterprise1.toString());
        System.out.println(client1.toString());



        /* document creation */
        String path = String.format("src/main/java/invoice_No_" + invoice1.getInvoiceNr() +".pdf");
        PdfWriter pdfWriter = new PdfWriter(path);

       // Rectangle rectangle = pdfWriter.getBoxSize("art");






//        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
//        pdfWriter.setPageEvent(event);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);


        PdfInvoiceGenerator pdfInvoiceGenerator = new PdfInvoiceGenerator(invoice1);

        /* header. address to client*/
        pdfInvoiceGenerator.formHeaderAddressToClient(client1, document);

        pdfInvoiceGenerator.formHeaderEnterprise(document);
        pdfInvoiceGenerator.setDateAndNumber(document);

        pdfInvoiceGenerator.setFreeSpace(document, 1);
        pdfInvoiceGenerator.writeInvoice(document);
        pdfInvoiceGenerator.setFreeSpace(document, 1);
        pdfInvoiceGenerator.addressContactPerson(document);

        pdfInvoiceGenerator.setFreeSpace(document, 1);

        pdfInvoiceGenerator.setProductTable(document);
        pdfInvoiceGenerator.setFreeSpace(document, 1);
        pdfInvoiceGenerator.writeTextUnderTable(document);
        pdfInvoiceGenerator.setFreeSpace(document, 2);
        pdfInvoiceGenerator.formFooter(document);

//        PdfPTable footer = new PdfPTable(3);
//        footer.setWidths(new int[]{24, 2, 1});
//        footer.setTotalWidth(527);
//        footer.setLockedWidth(true);
//        footer.getDefaultCell().setFixedHeight(40);
//        footer.getDefaultCell().setBorder(Rectangle.TOP);
//        footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
//        // add copyright
//        footer.addCell(new Phrase("\u00A9 Memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
//
//        // add current page count
//        footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//        footer.addCell(new Phrase(String.format("Page of", new Font(Font.FontFamily.HELVETICA, 8))));







        document.setBottomMargin(34f);





        /* document closing */
        document.close();

        System.out.println("Hello world!");
    }
}