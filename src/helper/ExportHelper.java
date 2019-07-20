/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Desi Enjelina Lubis;
 */
public class ExportHelper {
    public static void exportJadwal(List<Double> score) throws FileNotFoundException, SQLException, IOException {
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Score");

        XSSFRow row = spreadsheet.createRow(1);
        XSSFCell cell;
        cell = row.createCell(1);
        cell.setCellValue("Score");
//        cell = row.createCell(2);
//        cell.setCellValue("Sesi");
//        cell = row.createCell(3);
//        cell.setCellValue("Mata Kuliah");
//        cell = row.createCell(4);
//        cell.setCellValue("Dosen");
//        cell = row.createCell(5);
//        cell.setCellValue("Kelas");
//        cell = row.createCell(6);
//        cell.setCellValue("Ruangan");

//        int i = 2;
        
        for(int i=0; i<score.size(); i++){
            row = spreadsheet.createRow(i);
            cell = row.createCell(1);
            cell.setCellValue(score.get(i));
        }
//
//        while(resultSet.next()) {
//            row = spreadsheet.createRow(i);
//            cell = row.createCell(1);
//            cell.setCellValue(resultSet.getString("hari"));
//            cell = row.createCell(2);
//            cell.setCellValue(resultSet.getString("sesi"));
//            cell = row.createCell(3);
//            cell.setCellValue(resultSet.getString("matkul"));
//            cell = row.createCell(4);
//            cell.setCellValue(resultSet.getString("dosen"));
//            cell = row.createCell(5);
//            cell.setCellValue(resultSet.getString("kelas"));
//            cell = row.createCell(6);
//            cell.setCellValue(resultSet.getString("ruangan"));
//            i++;
//        }

        FileOutputStream out = new FileOutputStream(new File("output.xlsx"));
        workbook.write(out);
        out.close();
    }

    public static void openJadwal() throws IOException, SQLException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File("output.xlsx"));
        }
    }
//
//    private static String getTime(){
//        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//    }
//
//    private static String getUrl() throws SQLException {
//        Connection connection = SQLHelper.getConnection();
//        DatabaseMetaData databaseMetaData = connection.getMetaData();
//        url = databaseMetaData.getURL();
//
//        String[] id = (url.split("/"));
//        int length = id.length;
//
//        url = id[length-1];
//
//        if (url.equalsIgnoreCase("penjadwalan_ftb")) return "FTB";
//        else if (url.equalsIgnoreCase("penjadwalan_diploma")) return "DIPLOMA";
//        else if (url.equalsIgnoreCase("penjadwalan_sarjana")) return "SARJANA";
//        else if (url.equalsIgnoreCase("penjadwalan_fti")) return "FTI";
//        else if (url.equalsIgnoreCase("penjadwalan_d3tk")) return "D3TK";
//        else return "";
//    }
}
