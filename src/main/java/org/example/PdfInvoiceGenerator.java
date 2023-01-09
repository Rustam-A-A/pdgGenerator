package org.example;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.util.Date;

public class PdfInvoiceGenerator {

    Invoice invoice;

    public PdfInvoiceGenerator(Invoice invoice) {
        this.invoice = invoice;
    }

    public PdfInvoiceGenerator() {
    }

    // TO DO: the function should take a list of i products to form i-line-table
    // all data of the products has to be getting from the product-object.
    public void setProductTable(Document document) {
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(10f)
                .setFontColor(Color.BLACK);
        float columnWidth[] = {30f, 230f, 30f, 40f, 80f, 90f};
        Table table = new Table(columnWidth);
        String[] tableHeader = {"Position",
                "Product/Service",
                "Amount",
                "Unit",
                "Price pro unit",
                "Total" };
        String[][] itemArray = {
                {"1", "Apples", "10,00", "kg", "2,50 Euro", "25,00 Euro"},
                {"2", "Bananas", "3,50", "kg", "1,00 Euro", "3,50 Euro"},
                {"3", "Vine", "1,00", "bottle", "15,00 Euro", "15,00 Euro"},
        };

        for (int x = 0; x < 6; x++) {
            table.addCell(new Cell()
                    .add(tableHeader[x])
                    .addStyle(style)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(Color.LIGHT_GRAY));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 1) {
                    table.addCell((new Cell()
                            .add(itemArray[i][j])
                            .addStyle(style))
                            .setTextAlignment(TextAlignment.LEFT)
                            .setBackgroundColor(Color.WHITE));
                } else {
                    table.addCell((new Cell()
                            .add(itemArray[i][j])
                            .addStyle(style))
                            .setTextAlignment(TextAlignment.RIGHT)
                            .setBackgroundColor(Color.WHITE));
                }

            }
        }

        document.add(table);

        float columnWidth2[] = {429f, 90f};
        Table table2 = new Table(columnWidth2);
        table2.addCell(new Cell().add("Netto price"))
                .addStyle(style)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT);

        table2.addCell(new Cell().add("43,50 Euro"))
                .addStyle(style)
                .setTextAlignment(TextAlignment.RIGHT);
        table2.addCell(new Cell().add("Zzgl. 19% USt"))
                .addStyle(style)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT);
        table2.addCell(new Cell().add("8,27 Euro"))
                .addStyle(style)
                .setTextAlignment(TextAlignment.RIGHT);
        table2.addCell(new Cell().add("Total").setBackgroundColor(Color.LIGHT_GRAY))
                .addStyle(style)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT);
        table2.addCell(new Cell().add("51,77 Euro").setBackgroundColor(Color.LIGHT_GRAY))
                .addStyle(style)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(table2);

    }



    public void setFreeSpace(Document document, int numberOfLines) {
        Style style = new Style()
                .setFontSize(10f);
        String freeSpace = "                     \n";
        Paragraph paragraph = new Paragraph(freeSpace);
        paragraph.addStyle(style);
        for (int i = 0; i < numberOfLines; i++) {
            paragraph.add(freeSpace);
        }
        document.add(paragraph);
    }

    public void writeInvoice(Document document) {
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(15f)
                .setFontColor(Color.BLACK)
                .setBold();
        String text = "I N V O I C E";
        Paragraph paragraph = new Paragraph();
        paragraph.setTextAlignment(TextAlignment.CENTER);
        paragraph.add(text);
        paragraph.addStyle(style);
        document.add(paragraph);
    }
    public void addressContactPerson(Document document) {
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(10f)
                .setFontColor(Color.BLACK);
        String text = String.format("Sehr geehrte/er " +
                invoice.getClient().getContactPerson().getSalutation() + " " +
                invoice.getClient().getContactPerson().getFamilyName() + ",\n\n" +
                "vielen Dank, für Ihren Auftrag. " +
                "Vereinbarungsgemäß berechnen wir Ihnen hiermit folgende Leistungen:");

        Paragraph paragraph = new Paragraph();
        paragraph.setTextAlignment(TextAlignment.LEFT);
        paragraph.add(text);
        paragraph.addStyle(style);
        document.add(paragraph);
    }

    public void writeTextUnderTable(Document document) {
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(10f)
                .setFontColor(Color.BLACK);
        String textUnderTable = String.format("Bitte überweisen Sie den Rechnungsbetrag innerhalb von " +
                invoice.getPaymentTerm() +
                " Tagen auf unseren unten genanntes Konto.\n " +
                "Für weitere Fragen stehen wir Ihnen sehr gerne zur Verfügung.\n\n" +
                "Mit freundlichen Grüßen\n" + invoice.getEnterprise().getContactPerson().getName() +
                " " + invoice.getEnterprise().getContactPerson().getFamilyName());
        Paragraph paragraph = new Paragraph();
        paragraph.setTextAlignment(TextAlignment.LEFT);
        paragraph.add(textUnderTable);
        paragraph.addStyle(style);
        document.add(paragraph);
    }

    public void formHeaderEnterprise(Document document) {
        float columnWidth[] = {510f};
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(10f)
                .setFontColor(Color.BLUE)
                .setItalic();
        Table table = new Table(columnWidth);
        table.addStyle(style);
        table.addCell(new Cell().add(invoice.getEnterprise().getName())
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));
        String streetAndHouseNr = String.format(invoice.getEnterprise().getAddress().getStreet() +
                ", " + invoice.getEnterprise().getAddress().getHouseNr() +
                ", " + invoice.getEnterprise().getAddress().getPremises());
        table.addCell(new Cell().add(streetAndHouseNr)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));
        String postcodeAndCity = String.format(invoice.getEnterprise().getAddress().getPostcode() +
                ", " + invoice.getEnterprise().getAddress().getPlace());
        table.addCell(new Cell().add(postcodeAndCity)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));
        document.add(table);
    }

    public void setDateAndNumber(Document document) {
        float columnWidth[] = {510f};
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(8f)
                .setBold()
                .setItalic();
        Table table = new Table(columnWidth);
        table.addStyle(style);
        String date = String.format("Date: " + String.valueOf(new Date()));
        table.addCell(new Cell().add(" ")
                .setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(date)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));
        String invoiceNr = String.format("Invoice number: " + invoice.getInvoiceNr());
        table.addCell(new Cell().add(invoiceNr)
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT));
        document.add(table);
    }


    public void formFooter(Document document) {
        float columnWidth[] = {168f, 168f, 168f};
        Style style = new Style()
                .setFontColor(Color.GRAY)
                .setFontSize(10f)
                .setBold();

        Table table = new Table(columnWidth);
        table.addStyle(style);
        String enterprise = String.format(invoice.getEnterprise().getName() + "\n" +
                invoice.getEnterprise().getAddress().getStreet() + ", " +
                invoice.getEnterprise().getAddress().getHouseNr() + ", " +
                invoice.getEnterprise().getAddress().getPremises() + "\n" +
                invoice.getEnterprise().getAddress().getPostcode() + ", " +
                invoice.getEnterprise().getAddress().getPlace() + "\n" +
                "Tel: " + invoice.getEnterprise().getPhoneNr() + "\n" +
                "Email: " + invoice.getEnterprise().getEmail());
        table.addCell(new Cell().add(enterprise).setBorder(Border.NO_BORDER));

        String bank = String.format(invoice.getEnterprise().getBankDetails().getBankName() + "\n" +
                "IBAN: " + invoice.getEnterprise().getBankDetails().getIban() + "\n " +
                "BIC: " + invoice.getEnterprise().getBankDetails().getBic());
        table.addCell(new Cell().add(bank).setBorder(Border.NO_BORDER));

        String official = String.format("Reg. Nr.: " + invoice.getEnterprise().getRegisterNr()) + "\n " +
                "USt-ID: " + invoice.getEnterprise().getUstId() + "\n " +
                "Reg. place: " + invoice.getEnterprise().getRefisterPlace()+ "\n " +
                invoice.getEnterprise().getHeadOfEnterprise() + ": " +
                invoice.getEnterprise().getContactPerson().getName() + " " +
                invoice.getEnterprise().getContactPerson().getFamilyName() + "\n" +
                "Website: " + invoice.getEnterprise().getWebsite();
        table.addCell(new Cell().add(official).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

        document.add(table);
    }


    public void formHeaderAddressToClient(Client client, Document document) {
        float columnWidth[] = {300f};
        Style style = new Style()
                .setFontColor(Color.BLACK)
                .setFontSize(10f)
                .setBold()
                .setItalic();

        Table table = new Table(columnWidth);
        table.addStyle(style);
        table.addCell(new Cell().add(client.getName()).setBorder(Border.NO_BORDER));
        String streetAndHouseNr = String.format(client.getAddress().getStreet() +
                ", " + client.getAddress().getHouseNr() +
                ", " + client.getAddress().getPremises());
        table.addCell(new Cell().add(streetAndHouseNr).setBorder(Border.NO_BORDER));
        String postcodeAndCity = String.format(client.getAddress().getPostcode() +
                ", " + client.getAddress().getPlace());
        table.addCell(new Cell().add(postcodeAndCity).setBorder(Border.NO_BORDER));

        document.add(table);
    }



}
