# Invoice Generator (Android)

Android application built with Java that generates invoice PDFs based on a predefined layout and allows sharing them directly via apps like WhatsApp.

---

## 🚀 Features

- Generate invoice PDFs using a fixed professional layout
- Input key invoice data:
    - Invoice date
    - Invoice number (NCF)
    - Description
    - Total amount
- Export PDF to device storage
- Share generated invoices via external apps (WhatsApp, etc.)
- Custom font rendering (Times New Roman)

---

## 🛠 Tech Stack

- Java
- Android SDK (API 24+)
- PdfDocument (Canvas-based rendering)
- FileProvider (secure file sharing)
- XML layouts

---

## 📂 Project Structure

com.ctorres.invoice
├── MainActivity
└── model
└── InvoiceData

---

## ⚙️ How It Works

1. User fills the form
2. Application creates an InvoiceData object
3. PDF is generated using Canvas drawing
4. File is saved locally
5. Share intent is triggered

---

## 📄 PDF Rendering

The document is built manually using Android Canvas:

- Fixed coordinates for layout precision
- Structured sections:
    - Header
    - Issuer information
    - Client details
    - Description
    - Total
    - Signature
- Consistent typography using embedded fonts

---

## 📦 Build & Run

### Generate APK

Build → Build APK(s)

### Install

- Transfer APK to device and install  
  or
- Run directly via Android Studio with USB debugging

---

## 📌 Notes

This project focuses on building a practical and usable solution with full control over PDF generation and layout.