import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 */
public class DateUtil {
	
	public static String myDate = getMyTime();

	/**
	 * * 获取当前时间. * @return 时间格式为yyyy-MM-dd HH:mm:ss
	 * */
	private static String getMyTime() {
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(cal.getTime());
	}

	public static String sysdate = createDate();

	/**
	 * * 获取当前时间. * @return
	 * */
	private static String createDate() {
		Calendar cal = new GregorianCalendar();
		String year, month, day;
		year = Integer.toString(cal.get(Calendar.YEAR));
		month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		day = Integer.toString(cal.get(Calendar.DATE));
		return year + "-" + month + "-" + day;
	}

	/**
	 * * 时间对比 *
	 * 
	 * @param userdate
	 *            * @return 参数格式为yyyy-MM-dd HH:mm:ss
	 * */
	public static int dateCompare(String userdate) {
		int ud = getmyint(userdate);
		int nowd = getmyint(myDate);
		return nowd - ud;
	}

	private static int getmyint(String userdate) {
		Date date1 = Timestamp.valueOf(userdate);
		DateFormat df1 = new SimpleDateFormat("HH");
		DateFormat df2 = new SimpleDateFormat("mm");
		String h = df1.format(date1);
		String m = df2.format(date1);
		int ud = (Integer.valueOf(h).intValue()) * 60
				+ Integer.valueOf(m).intValue();
		return ud;
	}

	/**
	 * * 获取当前时间.
	 * 
	 * @return 格式为:yyyy-mm-dd hh:mm:ss格式的时间字符串
	 */
	public static String getDateTime() {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateformat.format(calendar.getTime());
	}

	/** * 获取当前时间. * @return 格式为:yyyy-mm-dd格式的时间字符串 */
	public static String getDate() {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(calendar.getTime());
	}

	/** * 格式化时间字符串. * @param str * @return */
	public static String formatString(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tmp = null;
		try {
			tmp = dateformat.parse(str);
		} catch (ParseException e) {
			tmp = new Date();
		}
		return dateformat.format(tmp);
	}

	/** * 时间转字符串. * @param date * @return */
	public static String dateTimeToStr(Date date) {
		if (date == null) {
			return "";
		}
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(date);
	}

	public static String dateTimesToStr(Date date) {
		if (date == null) {
			return "";
		}
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateformat.format(date);
	}

	/** * 字符串转为时间类型. * @param str * @return */
	public static Date strToDate(String str) {
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		Date tmp = null;
		try {
			tmp = dateformat.parse(str);
		} catch (ParseException e) {
			dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				tmp = dateformat.parse(str);
			} catch (ParseException e1) {
				dateformat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					tmp = dateformat.parse(str);
				} catch (ParseException e2) {
					// TODO 自动生成 catch 块
					tmp = new Date();
				}
			}
		}
		return tmp;
	}

	/** * 时间转字符串. * @param date * @return */
	public static String dateToStr(Date date) {
		if (date == null) {
			return "";
		}
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateformat.format(date);
	}

	/** * 时间比较. * @param start * @param end * @return */
	public static long compdate(String start, String end) {
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long result = 0;
		try {
			Date dstart = dateformat.parse(start);
			Date dend = dateformat.parse(end);
			long lstart = dstart.getDate();
			long lend = dend.getDate();
			result = (lend - lstart) / 1000 / 1800;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	/** * 时间比较. * @param start * @param end * @return返回相差天数 */
	public static int compday(String start, String end) {
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int result = 0;
		try {
			Date dstart = dateformat.parse(start);
			Date dend = dateformat.parse(end);
			int lstart = (int) dstart.getTime();
			int lend = (int) dend.getTime();
			result = (lend - lstart) / 86400000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	/** * 取得当月天数 * */
	public static int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/** * 得到指定月的天数 * */
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static void dateDiff(String startTime, String endTime, String format) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long diff;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			long day = diff / nd;// 计算差多少天
			long hour = diff % nd / nh;// 计算差多少小时
			long min = diff % nd % nh / nm;// 计算差多少分钟
			long sec = diff % nd % nh % nm / ns;// 计算差多少秒
			// 输出结果
			System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟"
					+ sec + "秒。");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/** * 计算月份相差 */
	public static int getMonthDiff(String start, String end, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return getMonthDiff(sdf.parse(start), sdf.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getMonthDiff(Date start, Date end) {
		return 12 * (end.getYear() - start.getYear()) + end.getMonth()
				- start.getMonth();
	}

	public static void main(String[] args) {
		String format = "yyyy-MM-dd hh:mm:ss";
		dateDiff("2010-10-23 9:23:10",
				new SimpleDateFormat(format).format(new Date()), format);
		System.out.println(getMonthLastDay(2011, 11));
		System.out.println(getMonthDiff("2005-9", "2011-11", "yyyy-MM"));
	}
}
