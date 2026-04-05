package com.ctorres.invoice.model;

public class InvoiceData {
    private final String issuerName;
    private final String issuerRnc;
    private final String issuerAddress;
    private final String issuerCityCountry;
    private final String issuerPhone;

    private final String ncf;
    private final String dueDate;
    private final String invoiceDate;
    private final String rstNote;

    private final String clientRnc;
    private final String clientName;
    private final String clientAddress;
    private final String clientPhone;

    private final String description;
    private final String totalAmount;

    public InvoiceData(
            String issuerName,
            String issuerRnc,
            String issuerAddress,
            String issuerCityCountry,
            String issuerPhone,
            String ncf,
            String dueDate,
            String invoiceDate,
            String rstNote,
            String clientRnc,
            String clientName,
            String clientAddress,
            String clientPhone,
            String description,
            String totalAmount
    ) {
        this.issuerName = issuerName;
        this.issuerRnc = issuerRnc;
        this.issuerAddress = issuerAddress;
        this.issuerCityCountry = issuerCityCountry;
        this.issuerPhone = issuerPhone;
        this.ncf = ncf;
        this.dueDate = dueDate;
        this.invoiceDate = invoiceDate;
        this.rstNote = rstNote;
        this.clientRnc = clientRnc;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
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

    public String getRstNote() {
        return rstNote;
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