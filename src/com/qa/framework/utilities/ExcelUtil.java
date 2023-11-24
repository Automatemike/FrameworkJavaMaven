package com.qa.framework.utilities;

//10_11 Leaving this until later as requires more knowledge of the copied code.
public class ExcelUtil
{
    //Open Excel Sheet
    //Read Cell Data
    //Store in-memory collection
    //Get Cell method

    /*public void Open(String filename) --as per course copied from https://blog.executeautomation.com/data-driven-testing-in-selenium-using-jxl-part-2/
    {
        Sheet wrksheet;  //Static not allowed in here so removed for these lines
        Workbook wrkbook =null;
        Hashtable dict= new Hashtable();
        //Create a Constructor
	    public ExcelUtil(String ExcelSheetPath) throws BiffException, IOException
        {
            //Initialize
            wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
            //For Demo purpose the excel sheet path is hardcoded, but not recommended :)
            wrksheet = wrkbook.getSheet("Sheet1");
        }

        //Returns the Number of Rows
        public static int RowCount()
        {
            return wrksheet.getRows();
        }

        //Returns the Cell value by taking row and Column values as argument
        public static String ReadCell(int column,int row)
        {
            return wrksheet.getCell(column,row).getContents();
        }

        //Create Column Dictionary to hold all the Column Names
        public static void ColumnDictionary()
        {
            //Iterate through all the columns in the Excel sheet and store the value in Hashtable
            for(int col=0;col < wrksheet.getColumns();col++)
            {
                dict.put(ReadCell(col,0), col);
            }
        }

        //Read Column Names
        public static int GetCell(String colName)
        {
            try {
                int value;
                value = ((Integer) dict.get(colName)).intValue();
                return value;
            } catch (NullPointerException e) {
                return (0);

            }
        }*/
}
