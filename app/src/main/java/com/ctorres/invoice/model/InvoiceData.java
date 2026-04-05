package com.ctorres.invoice.model;

public class InvoiceData {

    // Dynamic values:
    private final String invoiceDate;
    private final String ncf;
    private final String description;
    private final String totalAmount;

    // Static values:
    private final String issuerName = "SR.CHARLES TOWER";
    private final String issuerRnc = "223-6104948-3";
    private final String issuerAddress = "Calle 60, No. 242, La Villa, S.D. Norte.";
    private final String issuerCityCountry = "Santo Domingo";
    private final String issuerPhone = "829-600-2837";

    private final String dueDate = "31/12/2026";

    private final String clientRnc = "430-125442";
    private final String clientName = "Centro de Salud SANTO MARCO";
    private final String clientAddress = "CALLE MIGUEL DIAZ, Edif #3 - EL ALMIRANTE, Santo Domingo Este, R.D.";
    private final String clientPhone = "809-414-7556";

    public InvoiceData(
            String invoiceDate,
            String ncf,
            String description,
            String totalAmount
    ) {
        this.invoiceDate = invoiceDate;
        this.ncf = ncf;
        this.description = description;
        this.totalAmount = totalAmount;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public String getIssuerRnc() {
        return issuerRnc;
    }

    public String getIssuerAddress() {
        return issuerAddress;
    }

    public String getIssuerCityCountry() {
        return issuerCityCountry;
    }

    public String getIssuerPhone() {
        return issuerPhone;
    }

    public String getNcf() {
        return ncf;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getClientRnc() {
        return clientRnc;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getDescription() {
        return description;
    }

    public String getTotalAmount() {
        return totalAmount;
    }
}