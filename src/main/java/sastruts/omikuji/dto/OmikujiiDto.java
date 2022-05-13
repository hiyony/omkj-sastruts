package sastruts.omikuji.dto;

public class OmikujiiDto {
	public static String getOmikujiID() {
		return omikujiID;
	}
	public static void setOmikujiID(String omikujiID) {
		OmikujiiDto.omikujiID = omikujiID;
	}
	public static String getBirthday() {
		return birthday;
	}
	public static void setBirthday(String birthday) {
		OmikujiiDto.birthday = birthday;
	}
	public static String getTodayString() {
		return todayString;
	}
	public static void setTodayString(String todayString) {
		OmikujiiDto.todayString = todayString;
	}
	public static String omikujiID;
	public static String birthday;
	public static String todayString;
}
