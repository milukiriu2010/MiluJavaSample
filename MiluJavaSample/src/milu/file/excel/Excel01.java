package milu.file.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;

// �ȉ��̃G���[���łăR���p�C���ł��Ȃ�
// Description Resource Path Location Type The package org.apache.poi.ss.usermodel is accessible from more than one module: poi, poi.ooxml
public class Excel01 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String outputFilePath = "out.xlsx";
        //Workbook book = null;
        FileOutputStream fout = null;
        /*
        try {
            book = new SXSSFWorkbook();

            Font font = book.createFont();
            font.setFontName("�l�r �S�V�b�N");
            font.setFontHeightInPoints((short) 9);

            DataFormat format = book.createDataFormat();

            //�w�b�_������p�̃X�^�C��
            CellStyle style_header = book.createCellStyle();
            style_header.setBorderBottom(BorderStyle.THIN);
            XLSXWriteTest.setBorder(style_header, BorderStyle.THIN);
            style_header.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE.getIndex());
            style_header.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style_header.setVerticalAlignment(VerticalAlignment.TOP);
            style_header.setFont(font);

            //������p�̃X�^�C��
            CellStyle style_string = book.createCellStyle();
            XLSXWriteTest.setBorder(style_string, BorderStyle.THIN);
            style_string.setVerticalAlignment(VerticalAlignment.TOP);
            style_string.setFont(font);

            //���s��������������p�̃X�^�C��
            CellStyle style_string_wrap = book.createCellStyle();
            XLSXWriteTest.setBorder(style_string_wrap, BorderStyle.THIN);
            style_string_wrap.setVerticalAlignment(VerticalAlignment.TOP);
            style_string_wrap.setWrapText(true);
            style_string_wrap.setFont(font);

            //�����p�̃X�^�C��
            CellStyle style_int = book.createCellStyle();
            XLSXWriteTest.setBorder(style_int, BorderStyle.THIN);
            style_int.setDataFormat(format.getFormat("#,##0;-#,##0"));
            style_int.setVerticalAlignment(VerticalAlignment.TOP);
            style_int.setFont(font);

            //�����p�̃X�^�C��
            CellStyle style_double = book.createCellStyle();
            XLSXWriteTest.setBorder(style_double, BorderStyle.THIN);
            style_double.setDataFormat(format.getFormat("#,##0.0;-#,##0.0"));
            style_double.setVerticalAlignment(VerticalAlignment.TOP);
            style_double.setFont(font);

            //�~�\���p�̃X�^�C��
            CellStyle style_yen = book.createCellStyle();
            XLSXWriteTest.setBorder(style_yen, BorderStyle.THIN);
            style_yen.setDataFormat(format.getFormat("\"\\\"#,##0;\"\\\"-#,##0"));
            style_yen.setVerticalAlignment(VerticalAlignment.TOP);
            style_yen.setFont(font);

            //�p�[�Z���g�\���p�̃X�^�C��
            CellStyle style_percent = book.createCellStyle();
            XLSXWriteTest.setBorder(style_percent, BorderStyle.THIN);
            style_percent.setDataFormat(format.getFormat("0.0%"));
            style_percent.setVerticalAlignment(VerticalAlignment.TOP);
            style_percent.setFont(font);

            //�����\���p�̃X�^�C��
            CellStyle style_datetime = book.createCellStyle();
            XLSXWriteTest.setBorder(style_datetime, BorderStyle.THIN);
            style_datetime.setDataFormat(format.getFormat("yyyy/mm/dd hh:mm:ss"));
            style_datetime.setVerticalAlignment(VerticalAlignment.TOP);
            style_datetime.setFont(font);

            Row row;
            int rowNumber;
            Cell cell;
            int colNumber;

            //�V�[�g�̍쐬(3�V�[�g����Ă݂�)
            Sheet sheet;

            for (int i = 0; i < 3; i++) {
                sheet = book.createSheet();
                if (sheet instanceof SXSSFSheet) {
                    ((SXSSFSheet) sheet).trackAllColumnsForAutoSizing();
                }

                //�V�[�g���̂̐ݒ�
                book.setSheetName(i, "�V�[�g" + (i + 1));

                //�w�b�_�s�̍쐬
                rowNumber = 0;
                colNumber = 0;
                row = sheet.createRow(rowNumber);
                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("No.");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("������");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("���s�̓�����������");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("����");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("����");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("�~");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("�p�[�Z���g");

                cell = row.createCell(colNumber++);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("����");

                cell = row.createCell(colNumber);
                cell.setCellStyle(style_header);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("�~(8%�̐ō�)");

                //�E�B���h�E�g�̌Œ�
                sheet.createFreezePane(1, 1);

                //�w�b�_�s�ɃI�[�g�t�B���^�̐ݒ�
                sheet.setAutoFilter(new CellRangeAddress(0, 0, 0, colNumber));

                //�񕝂̎�������
                for (int j = 0; j <= colNumber; j++) {
                    sheet.autoSizeColumn(j, true);
                }

                //�f�[�^�s�̐���(10�s����Ă݂�)
                for (int j = 0; j < 10; j++) {
                    rowNumber++;
                    colNumber = 0;
                    row = sheet.createRow(rowNumber);
                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_int);
                    cell.setCellType(CellType.NUMERIC);
                    cell.setCellValue(j + 1);

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_string);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue("�����" + (j + 1) + "�s�ڂ̃f�[�^�ł��B");

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_string_wrap);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue("�����\n" + (j + 1) + "�s�ڂ�\n�f�[�^�ł��B");

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_int);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue((j + 1) * 1000);

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_double);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue((double) (j + 1) * 1000);

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_yen);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue((j + 1) * 1000);

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_percent);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue((double) (j + 1));

                    cell = row.createCell(colNumber++);
                    cell.setCellStyle(style_datetime);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(new Date());

                    cell = row.createCell(colNumber);
                    cell.setCellStyle(style_yen);
                    cell.setCellType(CellType.FORMULA);
                    cell.setCellFormula("ROUND(" + XLSXWriteTest.getExcelColumnString(colNumber - 3) + (rowNumber + 1) + "*1.08, 0)");

                    //�񕝂̎�������
                    for (int k = 0; k <= colNumber; k++) {
                        sheet.autoSizeColumn(k, true);
                    }
                }
            }

            //�V�[�g3�������Ă݂�
            book.removeSheetAt(2);

            //�t�@�C���o��
            fout = new FileOutputStream(outputFilePath);
            book.write(fout);
        }
        finally {
            if (fout != null) {
                try {
                    fout.close();
                }
                catch (IOException e) {
                }
            }
            if (book != null) {
                try {
                    // SXSSFWorkbook�̓�������Ԃ�ߖ񂷂����Ƀe���|�����t�@�C�����ʂɐ������邽�߁A
                    // �s�v�ɂȂ����i�K��dispose���ăe���|�����t�@�C�����폜����K�v������
                    //
                    ((SXSSFWorkbook) book).dispose();
                    book.close();
                }
                catch (Exception e) {
                }
            }
        }
        */
    }

    /*
    private static void setBorder(CellStyle style, BorderStyle border) {
        style.setBorderBottom(border);
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
    }
    */

    private final static String[] LIST_ALPHA = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /*
    private static String getExcelColumnString(int column) {
        String result = "";

        if (column >= 0) {
            if (column / LIST_ALPHA.length > 0) {
                result += getExcelColumnString(column / LIST_ALPHA.length - 1);
            }
            result += LIST_ALPHA[column % LIST_ALPHA.length];
        }

        return result;
    }
    */
}
