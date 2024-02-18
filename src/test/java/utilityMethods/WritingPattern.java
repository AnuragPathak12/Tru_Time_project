package utilityMethods;

import java.io.IOException;

	public class WritingPattern {
		
		public static String path = System.getProperty("user.dir") + ".\\ExcelFile\\OutputData.xlsx";

		public static void writingLegends(String[] legends) {

			for (int i = 3; i <18; i++) {
				try {
					ExcelUtilityFile.setCellData(path, "Sheet1", 3, i-3, legends[i - 3]);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			System.out.println("Writing of Legends Done");
		}
		
		public static void writingTruTimeDates(String[] trutimeDate) {

			for (int i = 4; i <11; i++) {
				try {
					ExcelUtilityFile.setCellData(path, "Sheet1", i, 0, trutimeDate[i - 4]);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			System.out.println("Writing of TruTime Dates Done");
		}
	}
