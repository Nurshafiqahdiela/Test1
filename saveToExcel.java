/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author Asus
 */
class saveToExcel {
    
    public static void main(){
        
    }

    public void saveData() {
        
        try{
            
            HSSFWorkbook workbooks = new HSSFWorkbook();
            HSSFSheet sheets = workbooks.createSheet("GitHub");
            
            Row heading = sheets.createRow(0);
            heading.createCell(0).setCellValue("Name");
            heading.createCell(1).setCellValue("Total Repo");
            heading.createCell(2).setCellValue("Total Follower");
            

            //1st Row Font Size
            for (int i = 0; i <= 2; i++) {
                CellStyle style = workbooks.createCellStyle();
                Font font = workbooks.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short) 12);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                heading.getCell(i).setCellStyle(style);
            }


            int s = 1;
            for (data2 data : GitHub.findAll()) {
                //Create row
                Row row = sheets.createRow(s);
                //Column 1: follower
                Cell cellId = row.createCell(0);
                cellId.setCellValue(data.getLogin());
                //Column 2 : totalRepo
                Cell cellLogin = row.createCell(1);
                cellLogin.setCellValue(data.getRepo());
                //Column 3 : total
                Cell cellRepo = row.createCell(2);
                cellRepo.setCellValue(data.getFollowers());
                //Column 4 : trying
                Cell cellFollowers = row.createCell(3);
               
                s++;
            }
            //Auto Adjust Width
            for (int i = 0; i < 6; i++)
                sheets.autoSizeColumn(i);

            //Save to Excel FILE
            FileOutputStream out = new FileOutputStream(new File("Assignment 2.xls"));
            workbooks.write(out);
            out.close();
            workbooks.close();

        } catch (
                Exception e) {
            System.out.print(e.getStackTrace());
        }
    }
        }
    
    

