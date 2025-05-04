package com.infa.axon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;




public class CsvMerge {

	public static void main(String[] args) throws IOException {
		
//		File csv1 = new File("C:/Users/trinadhs/eclipse/JarDataGen/Bulkuploads/Axon_SourcingTemplate_org-unit.csv");
//		File csv2 = new File("C:/Users/trinadhs/eclipse/JarDataGen/Bulkuploads/Seg5/Axon_SourcingTemplate_org-unit.csv");
		String filename= "Axon_SourcingTemplate_data-quality-rule.csv";
		System.out.print("File Merging ...."+filename+ "  ");
		
		for (int i=2;i<=100;i++) {
			
		File csv1 = new File("C:/Users/trinadhs/eclipse/JarDataGen/Bulkuploads/Seg1/"+filename);
	
		File csv2 = new File("C:/Users/trinadhs/eclipse/JarDataGen/Bulkuploads/Seg"+i+"/"+filename);

		
		List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);
		// csv1Headers.forEach(h -> System.out.print(h + " "));
		// System.out.println();
		List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv2);
		// csv2Headers.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		List<String> allCsvHeaders = new ArrayList<>();
		allCsvHeaders.addAll(csv1Headers);
		allCsvHeaders.addAll(csv2Headers);
		// allCsvHeaders.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);
		// uniqueHeaders.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(csv1, csv1Headers);
		List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);

		List<CsvVo> allCsvRecords = new ArrayList<>();
		allCsvRecords.addAll(csv1Records);
		allCsvRecords.addAll(csv2Records);

		CsvParser.writeToCsv(new File("C:/Users/trinadhs/eclipse/JarDataGen/Bulkuploads/Seg1/"+filename), uniqueHeaders, allCsvRecords);
		Sleep(3000);
		}
		System.out.print("Completed");
		
		}

	private static void Sleep(int i) {
		// TODO Auto-generated method stub
		
	}


}

class CsvParser {

	public static List<CsvVo> getRecodrsFromACsv(File file, List<String> keys) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<CsvVo> records = new ArrayList<>();
		boolean isHeader = true;

		String line = null;
		while ((line = br.readLine()) != null) {
			if (isHeader) {// first line is header
				isHeader = false;
				continue;
			}
			CsvVo record = new CsvVo(file.getName());
			String[] lineSplit = line.split(",");
			for (int i = 0; i < lineSplit.length; i++) {
				record.put(keys.get(i), lineSplit[i]);
			}
			records.add(record);
		}

		br.close();

		return records;
	}

	public static List<String> getHeadersFromACsv(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> headers = null;

		String line = null;
		while ((line = br.readLine()) != null) {
			String[] lineSplit = line.split(",");
			headers = new ArrayList<>(Arrays.asList(lineSplit));
			break;
		}

		br.close();

		return headers;
	}

	public static void writeToCsv(final File file, final Set<String> headers, final List<CsvVo> records)
			throws IOException {
		FileWriter csvWriter = new FileWriter(file);

		// write headers
		String sep = "";
		String[] headersArr = headers.toArray(new String[headers.size()]);
		for (String header : headersArr) {
			csvWriter.append(sep);
			csvWriter.append(header);
			sep = ",";
		}

		csvWriter.append("\n");

		// write records at each line
		for (CsvVo record : records) {
			sep = "";
			for (int i = 0; i < headersArr.length; i++) {
				csvWriter.append(sep);
				csvWriter.append(record.get(headersArr[i]));
				sep = ",";
			}
			csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();
	}
}

class CsvVo {

	private Map<String, String> keyVal;

	public CsvVo(String id) {
		keyVal = new LinkedHashMap<>();// you may also use HashMap if you don't need to keep order
	}

	public Map<String, String> getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(Map<String, String> keyVal) {
		this.keyVal = keyVal;
	}

	public void put(String key, String val) {
		keyVal.put(key, val);
	}

	public String get(String key) {
		return keyVal.get(key);
	}

}


