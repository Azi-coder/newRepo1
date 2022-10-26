package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.function.Predicate.not;


public class Choosehotel extends BaseTest{

    @Test
    public void rejectWarning() throws InterruptedException {

    mainPage.clickText();
    mainPage.clickCity();
    Thread.sleep(1000);
    mainPage.clickDate();
    mainPage.clickSecondDate();
    mainPage.clickType();
    mainPage.clickSearch();
        Thread.sleep(4000);
        Assert.assertEquals(resultPage.getText(),"Best match");
        resultPage.clickFilter();
        //Thread.sleep(3000);
        //resultPage.scroll();
        Thread.sleep(5000);
        for(int i = 0 ; i < resultPage.size(); i++){
            System.out.println(resultPage.getHotelNames(i));
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("List Of Hotel Names");
        Map<Integer,Object[]> data = new TreeMap<Integer,Object[]>();
        data.put(1, new Object[] {"nth", "HotelName"});
        for(int i=0;i< resultPage.size();i++){
            data.put(i+2, new Object[] {i+1, resultPage.getHotelNames(i)});
        }
        Set<Integer> keyset = data.keySet();
        int rownum = 0;
        for (Integer key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {

            FileOutputStream out = new FileOutputStream(new File("excel.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel'e yazma basarili.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
