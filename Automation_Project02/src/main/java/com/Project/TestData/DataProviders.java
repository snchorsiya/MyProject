package com.Project.TestData;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.Project.Util.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][]getCredentials(){
		int rows = obj.getRowCount("Credentials");
		int column = obj.getColumnCount("Credentials");
		int actRows = rows-1;
		
		Object[][] data = new Object[actRows][column];
		
		for (int i=0; i<actRows; i++) {
			for (int j=0; j<column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		
		return data;
	}
	
	//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		@DataProvider(name = "getProduct")
		public Object[][] getProduct() {
			// Totals rows count
			int rows = obj.getRowCount("ProductDetails");
			// Total Columns
			int column = obj.getColumnCount("ProductDetails");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
				}
			}
			return data;
		}

		// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("SearchProduct");
			// Total Columns
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("AccountCreationData");
			// Total Columns
			int column = obj.getColumnCount("AccountCreationData");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("AccountCreationData", j, 1),
							obj.getCellData("AccountCreationData", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}

}
