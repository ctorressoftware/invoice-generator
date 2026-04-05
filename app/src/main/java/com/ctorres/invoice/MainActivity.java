package com.ctorres.invoice;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.pdf.PdfDocument;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        generateBtn = findViewById(R.id.generate_button);
        generateBtn.setOnClickListener(v -> generatePdf());
    }

    private void generatePdf() {
        PdfDocument document = new PdfDocument();

        PdfDocument.PageInfo pageInfo =
                new PdfDocument.PageInfo.Builder(595, 842, 1).create();

        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Typeface timesFont = Typeface.createFromAsset(getAssets(), "fonts/times-new-roman.ttf");
        Typeface timesBoldFont = Typeface.createFromAsset(getAssets(), "fonts/times-new-roman-bold.otf");

        Paint titlePaint = new Paint();
        titlePaint.setColor(Color.BLACK);
        titlePaint.setTextSize(26);
        titlePaint.setFakeBoldText(true);
        titlePaint.setTypeface(timesBoldFont);

        Paint boldPaint = new Paint();
        boldPaint.setColor(Color.BLACK);
        boldPaint.setTextSize(10);
        boldPaint.setFakeBoldText(true);
        boldPaint.setTypeface(timesBoldFont);

        Paint normalPaint = new Paint();
        normalPaint.setColor(Color.BLACK);
        normalPaint.setTextSize(10);
        normalPaint.setTypeface(timesFont);

        Paint smallPaint = new Paint();
        smallPaint.setColor(Color.BLACK);
        smallPaint.setTextSize(8);
        smallPaint.setTypeface(timesFont);

        Paint linePaint = new Paint();
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(1);

        Paint headerFillPaint = new Paint();
        headerFillPaint.setColor(Color.rgb(204, 204, 255));

        Paint softYellowPaint = new Paint();
        softYellowPaint.setColor(Color.rgb(245, 245, 204));

        Paint softBluePaint = new Paint();
        softBluePaint.setColor(Color.rgb(204, 240, 245));

        Paint softGrayPaint = new Paint();
        softGrayPaint.setColor(Color.rgb(230, 230, 230));

        int left = 22;
        int right = 573;

        // Título
        String title = "FACTURA";
        float titleWidth = titlePaint.measureText(title);
        canvas.drawText(title, (pageInfo.getPageWidth() - titleWidth) / 2, 55, titlePaint);

        // Bloque emisor
        canvas.drawText("Nombre:", 40, 95, boldPaint);
        canvas.drawText("SR.CHARLES TOWER", 88, 95, normalPaint);

        canvas.drawText("RNC:", 40, 112, boldPaint);
        canvas.drawText("223-6104948-3", 68, 112, normalPaint);

        // Línea horizontal
        canvas.drawLine(left, 130, right, 130, linePaint);

        canvas.drawText("Dirección:", 40, 145, boldPaint);
        canvas.drawText("Calle 60, No. 242, La Villa, S.D. Norte.", 88, 145, smallPaint);

        canvas.drawText("Ciudad / País:", 40, 160, boldPaint);
        canvas.drawText("Santo Domingo", 108, 160, smallPaint);

        canvas.drawText("NCF:", 410, 160, boldPaint);
        canvas.drawText("B0100000053", 438, 160, boldPaint);

        canvas.drawLine(left, 170, right, 170, linePaint);

        canvas.drawText("Teléfono:", 40, 185, boldPaint);
        canvas.drawText("829-600-2837", 83, 185, smallPaint);

        canvas.drawText("VENCE", 410, 185, boldPaint);
        canvas.drawText("31/12/2026", 448, 185, boldPaint);

        canvas.drawText("FECHA:", 40, 200, normalPaint);
        canvas.drawText("28/02/2026", 83, 200, smallPaint);

        String rst = "ACOGIDO AL RST.";
        float rstWidth = smallPaint.measureText(rst);
        canvas.drawText(rst, (pageInfo.getPageWidth() - rstWidth) / 2, 200, smallPaint);

        canvas.drawLine(left, 215, right, 215, linePaint);

        // Cliente
        canvas.drawText("RNC:", 40, 230, boldPaint);
        canvas.drawText("430-125442", 68, 230, boldPaint);

        canvas.drawText("CLIENTE:", 40, 246, boldPaint);

        String clientName = "Centro de Salud SANTO MARCO";
        float clientWidth = boldPaint.measureText(clientName);
        canvas.drawText(clientName, (pageInfo.getPageWidth() - clientWidth) / 2, 246, boldPaint);

        canvas.drawLine(left, 255, right, 255, linePaint);

        canvas.drawText("Dirección:", 40, 272, boldPaint);
        canvas.drawText("CALLE MIGUEL DIAZ, Edif #3 - EL ALMIRANTE, Santo Domingo Este, R.D.", 88, 272, smallPaint);

        canvas.drawText("Teléfono:", 40, 287, boldPaint);
        canvas.drawText("809-414-7556", 83, 287, smallPaint);

        // Cabecera tabla
        canvas.drawRect(38, 320, 538, 332, headerFillPaint);
        canvas.drawRect(538, 320, 560, 332, headerFillPaint);

        canvas.drawRect(38, 320, 560, 332, linePaint);

        canvas.drawText("DESCRIPCION", 255, 329, boldPaint);
        canvas.drawText("TOTAL", 510, 329, boldPaint);

        // Primera fila
        canvas.drawRect(38, 332, 560, 358, softYellowPaint);

        canvas.drawText("HONORARIOS MEDICOS CORRESPONDIENTE AL MES DE FEBRERO 2026.", 40, 348, smallPaint);
        canvas.drawText("$", 482, 348, boldPaint);
        canvas.drawText("50,000.00", 515, 348, smallPaint);

        // Áreas vacías
        canvas.drawRect(38, 380, 560, 438, softYellowPaint);
        canvas.drawRect(38, 478, 560, 496, softYellowPaint);
        canvas.drawRect(38, 516, 560, 548, softYellowPaint);

        // Total final
        canvas.drawRect(38, 575, 560, 612, softGrayPaint);

        canvas.drawText("TOTAL", 450, 592, boldPaint);

        canvas.drawRect(478, 582, 505, 597, softBluePaint);
        canvas.drawRect(505, 582, 560, 597, softBluePaint);

        canvas.drawText("$", 488, 593, boldPaint);
        canvas.drawText("50,000.00", 518, 593, smallPaint);

        // Firma
        canvas.drawText("Firma y sello representante:", 40, 665, smallPaint);
        canvas.drawLine(40, 700, 118, 700, linePaint);

        document.finishPage(page);

        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(downloadsDir, "invoice_test.pdf");

        try {
            document.writeTo(new FileOutputStream(file));
            Toast.makeText(this, "PDF generado: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al generar PDF", Toast.LENGTH_SHORT).show();
        }

        document.close();
    }
}