package org.example.Xls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {

    }

    public static void statisticsWriter(List<Statistics> statisticsList, String filePath) throws IOException {

        Workbook workbook = new XSSFWorkbook(); // создание книги
        Sheet sheet = workbook.createSheet("Statistics"); //Создание страницы с определенным наименованием
        Font font = workbook.createFont(); //Создание шрифта
        font.setBold(true); // установка жирного шрифта
        font.setFontHeightInPoints((short) 12); // установка высоты шрифта
        CellStyle cellStyle = workbook.createCellStyle(); // создание стиля ячеек
        cellStyle.setFont(font); //установка шрифта

        int rowNumber = 0;
        Row row = sheet.createRow(rowNumber++); // Создание строки row (отсчет от 0)

        Cell profileCellHeader = row.createCell(0); //Создание ячейки в строке (отсчет от 0)
        profileCellHeader.setCellValue("Профиль обучения"); // задание значения ячейки
        profileCellHeader.setCellStyle(cellStyle); // установка стиля ячейки

        Cell avgExamScoreCellHeader = row.createCell(1);
        avgExamScoreCellHeader.setCellValue("Средний балл за экзамен");
        avgExamScoreCellHeader.setCellStyle(cellStyle);

        Cell numberOfStudentsCellHeader = row.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHeader.setCellStyle(cellStyle);

        Cell numberOfUniversityCellHeader = row.createCell(3);
        numberOfUniversityCellHeader.setCellValue("Количество университетов по профилю");
        numberOfUniversityCellHeader.setCellStyle(cellStyle);

        Cell nameOfUniversityCellHeader = row.createCell(4);
        nameOfUniversityCellHeader.setCellValue("Названия университетов");
        nameOfUniversityCellHeader.setCellStyle(cellStyle);

        for(Statistics statistics : statisticsList) {
            Row statisticsRow = sheet.createRow(rowNumber++);

            Cell profileStatisticsRow = statisticsRow.createCell(0); //Создание ячейки в строке (отсчет от 0)
            profileStatisticsRow.setCellValue(statistics.getProfile().getProfileName()); // задание значения ячейки

            Cell avgExamScoreStatisticsRow = statisticsRow.createCell(1);
            avgExamScoreStatisticsRow.setCellValue(statistics.getAvgExamScore());

            Cell numberOfStudentsStatisticsRow = statisticsRow.createCell(2);
            numberOfStudentsStatisticsRow.setCellValue(statistics.getProfile().getProfileName());

            Cell numberOfUniversityStatisticsRow = statisticsRow.createCell(3);
            numberOfUniversityStatisticsRow.setCellValue(statistics.getProfile().getProfileName());

            Cell nameOfUniversityStatisticsRow = statisticsRow.createCell(4);
            nameOfUniversityStatisticsRow.setCellValue(statistics.getProfile().getProfileName());
        }

        try(FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}
