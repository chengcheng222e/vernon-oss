/**
 * 
 */
package com.vernon.oss.common.util;

/**
 * 编码工具
 * 
 * @author Vernon.Chen
 *
 */
public class CodeUtil {

	/**
	 * 判断是否是数字型字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		if (s == null || s.equals("")) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > '9' || s.charAt(i) < '0') {
				return false;
			}
		}
		return true;
	}

	/**
	 * unicode string to utf-8 string
	 * 
	 * @param source
	 * @return
	 */
	public static String unicodeToUTF8(String source) {
		String retStr = "";
		int length = source.length();
		for (int i = 0; i < length; i++) {
			char c = source.charAt(i);
			int intAsc = (int) c;
			if (intAsc > 128) {
				String strHex = Integer.toHexString(intAsc);
				retStr = retStr + "&#x" + strHex + ";";
			} else {
				retStr = retStr + c;
			}
		}

		return retStr;
	}

	/**
	 * utf-8 string to unicode string
	 * 
	 * @param source
	 * @return
	 */
	public static String utf8ToUnicode(String source) {
		String retstr = "";
		int length = source.length();
		for (int i = 0; i < length; i++) {
			char chr = source.charAt(i);
			if (String.valueOf(chr).equalsIgnoreCase("&")) {
				if (i + 3 > length) {
					retstr += chr;
					continue;
				}
				String temp = CodeUtil.subString(source, i, i + 3).toLowerCase();
				if (temp.startsWith("&#") && temp.charAt(2) == 'x') {
					if (i + 8 > length) {
						retstr += chr;
						continue;
					}
					temp = CodeUtil.subString(source, i, i + 8).toLowerCase();
					String code = temp.substring(3, 7);
					int code_int = CodeUtil.stringToInt(code, 16);
					if (code_int > 128) {
						char strc = (char) (code_int);
						retstr += strc;
					} else {
						retstr += temp;
					}
					i = i + 7;
				} else {
					temp = CodeUtil.subString(source, i).toLowerCase();
					int idx = temp.indexOf(";");
					if (idx < 0) {
						retstr += chr;
						continue;
					}
					temp = CodeUtil.subString(temp, 0, idx + 1).toLowerCase();
					String code = temp.substring(2, temp.length() - 1);
					int code_int = CodeUtil.stringToInt(code, 10);
					if (code_int > 128) {
						char strc = (char) (code_int);
						retstr += strc;
					} else {
						retstr += temp;
					}
					i = i + idx;
				}

			} else {
				retstr += chr;
			}
		}
		return retstr;
	}

	/**
	 * iso-8859-1 string to 'code' string
	 * 
	 * @param source
	 * @param code
	 * @return
	 */
	public static String iso8859ToCode(String source, String code) {
		String retStr = "";
		if (code == null || code.length() == 0) {
			code = "gb2312";
		}
		try {
			retStr = new String(source.getBytes("ISO-8859-1"), code);
		} catch (Exception Err) {
		}
		return retStr;
	}

	/**
	 * iso-8859-1 string to unicode string
	 * 
	 * @param source
	 * @param code
	 * @return
	 */
	public static String iso8859ToUnicode(String source) {
		return CodeUtil.iso8859ToCode(source, "");
	}

	/**
	 * byte array to byte array
	 * 
	 * @param descbytes
	 * @param srcbytes
	 */
	public static void bytesToBytes(byte[] descbytes, byte[] srcbytes) {
		if (descbytes == null || srcbytes == null)
			return;

		int length = descbytes.length < srcbytes.length ? descbytes.length : srcbytes.length;

		for (int i = 0; i < length; i++) {
			descbytes[i] = srcbytes[i];
		}

		while (length < descbytes.length) {
			descbytes[length++] = 0;
		}

	}

	/**
	 * byte array to char array ,chars is return
	 * 
	 * @param chars
	 * @param bytes
	 */
	public static void bytesToChars(char[] chars, byte[] bytes) {
		if (chars == null || bytes == null)
			return;
		CodeUtil.stringToChars(chars, new String(bytes));
	}

	/**
	 * byte array to char array
	 * 
	 * @param bytes
	 * @return
	 */
	public static char[] bytesToChars(byte[] bytes) {
		char[] chars = new char[0];

		if (bytes == null)
			return chars;

		chars = new char[new String(bytes).length()];

		CodeUtil.stringToChars(chars, new String(bytes));

		return chars;
	}

	/**
	 * byte array to double
	 * 
	 * @param bytes
	 * @return
	 */
	public static double bytesToDouble(byte[] bytes) {
		return Double.longBitsToDouble(bytesToLong(bytes));
	}

	/**
	 * byte array to int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int bytesToInt(byte[] bytes) {
		int ret = 0;
		if (bytes == null)
			return ret;
		for (int i = 0; i < bytes.length; i++) {
			ret = (ret << 8) + (0xff & (int) (bytes[i]));
		}
		return ret;
	}

	/**
	 * byte array to long
	 * 
	 * @param bytes
	 * @return
	 */
	public static long bytesToLong(byte[] bytes) {
		long ret = 0;
		if (bytes == null)
			return ret;
		for (int i = 0; i < bytes.length; i++) {
			ret = (ret << 8) + (0xff & (int) (bytes[i]));
		}
		return ret;
	}

	/**
	 * byte array to float
	 * 
	 * @param bytes
	 * @return
	 */
	public static float bytesToFloat(byte[] bytes) {
		return Float.intBitsToFloat(bytesToInt(bytes));
	}

	/**
	 * byte array to string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToString(byte[] bytes) {
		String ret = "";
		if (bytes == null)
			return ret;

		int count = 0;
		while ((count < bytes.length) && (bytes[count] != 0)) {
			count++;
		}
		ret = new String(bytes, 0, count);

		return ret;
	}

	/**
	 * char array to string
	 * 
	 * @param chars
	 * @return
	 */
	public static String charsToString(char[] chars) {
		String ret = "";
		if (chars == null)
			return ret;
		ret = String.valueOf(chars);
		return ret;
	}

	/**
	 * char array to byte array
	 * 
	 * @param chars
	 * @return
	 */
	public static byte[] charsToBytes(char[] chars) {
		byte[] ret = new byte[0];
		if (chars == null)
			return ret;
		ret = stringToBytes(String.valueOf(chars));
		return ret;
	}

	/**
	 * char array to byte array, bytes is return;
	 * 
	 * @param bytes
	 * @param chars
	 */
	public static void charsToBytes(byte[] bytes, char[] chars) {
		if (bytes == null || chars == null)
			return;
		byte[] srcBytes = CodeUtil.stringToBytes(String.valueOf(chars));
		bytesToBytes(bytes, srcBytes);
	}

	/**
	 * string to byte array,bytes is return
	 * 
	 * @param bytes
	 * @param instr
	 */
	public static void stringToBytes(byte[] bytes, String instr) {
		byte[] destBytes = stringToBytes(instr);
		bytesToBytes(bytes, destBytes);
	}

	/**
	 * string to byte array
	 * 
	 * @param instr
	 * @return
	 */
	public static byte[] stringToBytes(String instr) {
		byte[] ret = new byte[0];
		if (instr == null)
			return ret;
		ret = instr.getBytes();
		return ret;
	}

	/**
	 * string to char array ,chars is return
	 * 
	 * @param chars
	 * @param instr
	 */
	public static void stringToChars(char[] chars, String instr) {
		if (chars == null || instr == null)
			return;
		char[] charsDest = stringToChars(instr);
		int length = chars.length < charsDest.length ? chars.length : charsDest.length;
		for (int i = 0; i < length; i++) {
			chars[i] = charsDest[i];
		}
		while (length < chars.length) {
			chars[length++] = 0;
		}
	}

	/**
	 * string to char array
	 * 
	 * @param instr
	 * @return
	 */
	public static char[] stringToChars(String instr) {
		char[] ret = new char[0];
		if (instr == null)
			return ret;
		ret = instr.toCharArray();
		return ret;
	}

	/**
	 * double to byte array,bytes is return
	 * 
	 * @param bytes
	 * @param in
	 */
	public static void doubleToBytes(byte[] bytes, double in) {
		if (bytes == null)
			return;
		int length = bytes.length;
		long l = Double.doubleToLongBits(in);

		while (length > 0) {
			bytes[--length] = (byte) ((l << 56) >>> 56);
			l >>>= 8;
		}
		while (length > 0) {
			bytes[--length] = (byte) 0;
		}
	}

	/**
	 * double to byte array
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] doubleToBytes(double in) {
		byte[] ret = new byte[8];
		CodeUtil.doubleToBytes(ret, in);
		return ret;
	}

	/**
	 * float to byte array , bytes is return
	 * 
	 * @param bytes
	 * @param in
	 */
	public static void floatToBytes(byte[] bytes, float in) {
		if (bytes == null)
			return;
		int length = bytes.length;
		int i = Float.floatToIntBits(in);
		while (length > 0) {
			bytes[--length] = (byte) ((i << 24) >>> 24);
			i >>>= 8;
		}
		while (length > 0) {
			bytes[--length] = (byte) 0;
		}
	}

	/**
	 * float to byte array
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] floatToBytes(float in) {
		byte[] ret = new byte[4];
		CodeUtil.floatToBytes(ret, in);
		return ret;
	}

	/**
	 * int to byte array ,bytes is return
	 * 
	 * @param bytes
	 * @param in
	 */
	public static void intToBytes(byte[] bytes, int in) {
		if (bytes == null)
			return;
		int length = bytes.length;
		while (length > 0) {
			bytes[--length] = (byte) ((in << 24) >>> 24);
			in >>>= 8;
		}
		while (length > 0) {
			bytes[--length] = (byte) 0;
		}
	}

	/**
	 * int to byte array
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] intToBytes(int in) {
		byte[] ret = new byte[4];
		CodeUtil.intToBytes(ret, in);
		return ret;
	}

	/**
	 * long to byte array ,bytes is return
	 * 
	 * @param bytes
	 * @param in
	 */
	public static void longToBytes(byte[] bytes, long in) {
		if (bytes == null)
			return;
		int length = bytes.length;

		while (length > 0) {
			bytes[--length] = (byte) ((in << 56) >>> 56);
			in >>>= 8;
		}
		while (length > 0) {
			bytes[--length] = (byte) 0;
		}
	}

	/**
	 * long to byte array
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] longToBytes(long in) {
		byte[] ret = new byte[8];
		CodeUtil.longToBytes(ret, in);
		return ret;
	}

	/**
	 * int to string
	 * 
	 * @param in
	 * @return
	 */
	public static String intToString(int in) {
		return Integer.toString(in);
	}

	/**
	 * int to string
	 * 
	 * @param in
	 * @param radix
	 * @return
	 */
	public static String intToString(int in, int radix) {
		return Integer.toString(in, radix);
	}

	/**
	 * long to string
	 * 
	 * @param in
	 * @param radix
	 * @return
	 */
	public static String longToString(long in, int radix) {
		return Long.toString(in, radix);
	}

	/**
	 * long to string
	 * 
	 * @param in
	 * @return
	 */
	public static String longToString(long in) {
		return Long.toString(in);
	}

	/**
	 * float to string
	 * 
	 * @param in
	 * @return
	 */
	public static String floatToString(float in) {
		return Float.toString(in);
	}

	/**
	 * float to string
	 * 
	 * @param in
	 * @return
	 */
	public static String doubleToString(double in) {
		return Double.toString(in);
	}

	/**
	 * string to int
	 * 
	 * @param instr
	 * @return
	 */
	public static int stringToInt(String instr, int defaultValue) {
		int ret = defaultValue;
		try {
			if (instr != null) {
				ret = Integer.parseInt(instr);
			}
		} catch (NumberFormatException e) {
		}
		return ret;
	}

	/**
	 * string to int
	 * 
	 * @param instr
	 * @param radix
	 * @return
	 */
	public static int stringToInt(String instr, int radix, int defaultValue) {
		int ret = -1;
		try {
			ret = Integer.parseInt(instr, radix);
		} catch (NumberFormatException e) {
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * string to long
	 * 
	 * @param instr
	 * @return
	 */
	public static long stringToLong(String instr, long defaultValue) {
		long ret = -1;
		try {
			ret = Long.parseLong(instr);
		} catch (NumberFormatException e) {
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * string to long
	 * 
	 * @param instr
	 * @param radix
	 * @return
	 */
	public static long stringToLong(String instr, int radix, long defaultValue) {
		long ret = -1;
		try {
			ret = Long.parseLong(instr, radix);
		} catch (NumberFormatException e) {
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * string to double
	 * 
	 * @param instr
	 * @return
	 */
	public static double stringToDouble(String instr, double defaultValue) {
		double ret = -1;
		try {
			ret = Double.parseDouble(instr);
		} catch (NumberFormatException e) {
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * string to float
	 * 
	 * @param instr
	 * @return
	 */
	public static float stringToFloat(String instr, float defaultValue) {
		float ret = -1;
		try {
			ret = Float.parseFloat(instr);
		} catch (NumberFormatException e) {
			ret = defaultValue;
		}
		return ret;
	}

	/**
	 * hex to byte array
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexToBytes(String hex) {
		int len = hex.length() / 2;
		if ((hex.length() % 2) != 0) {
			len++;
		}
		byte[] ret = new byte[len];
		for (int i = 0; i < len; i++) {
			String s = hex.substring(i * 2, i * 2 + 2);
			ret[i] = (byte) Integer.parseInt(s, 16);
		}
		return ret;
	}

	/**
	 * byte array to hex
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i]);
			if (hex.length() < 2)
				sbf.append("0" + hex);
			else
				sbf.append(hex);
		}
		return sbf.toString().toUpperCase();
	}

	/**
	 * get byte array in bytes
	 * 
	 * @param bytes
	 * @param startidx
	 * @param endidx
	 * @return
	 */
	public static byte[] getBytes(byte[] bytes, int startidx, int endidx) {
		byte[] ret = new byte[0];
		if (bytes == null || bytes.length == 0)
			return ret;
		if (endidx >= bytes.length) {
			endidx = bytes.length - 1;
		}
		int length = endidx - startidx + 1;
		if (length <= 0) {
			return ret;
		}
		ret = new byte[length];
		for (int i = 0; i < length; i++) {
			ret[i] = bytes[i + startidx];
		}
		return ret;
	}

	/**
	 * substring
	 * 
	 * @param in
	 * @param startidx
	 * @param endidx
	 * @return
	 */
	public static String subString(String in, int startidx, int endidx) {
		String ret = "";
		if (in == null || in.trim().length() == 0) {
			return ret;
		}
		int length = in.length();
		if (startidx < 0 || startidx > length) {
			return ret;
		}
		if (endidx > length) {
			endidx = length;
		}
		ret = in.substring(startidx, endidx);
		return ret;
	}

	/**
	 * substring
	 * 
	 * @param in
	 * @param startidx
	 * @return
	 */
	public static String subString(String in, int startidx) {
		String ret = "";
		if (in == null || in.trim().length() == 0) {
			return ret;
		}
		int length = in.length();
		if (startidx < 0 || startidx > length) {
			return ret;
		}
		ret = in.substring(startidx, length);
		return ret;
	}

	/**
	 * byte equals
	 * 
	 * @param bytes1
	 * @param pos1
	 * @param bytes2
	 * @param pos2
	 * @param length
	 * @return
	 */
	public static boolean bytesEquals(byte[] bytes1, int pos1, byte[] bytes2, int pos2, int length) {
		if (bytes1 == null || bytes2 == null) {
			return false;
		}
		if (pos1 < 0) {
			pos1 = 0;
		}
		if (pos2 < 0) {
			pos2 = 0;
		}
		if (length <= 0) {
			if (bytes1.length == bytes2.length) {
				length = bytes1.length;
			} else {
				return false;
			}
		}
		int len1 = bytes1.length - pos1;
		int len2 = bytes2.length - pos2;
		if (len1 < length || len2 < length) {
			return false;
		}
		for (int i = 0; i < len1; i++) {
			if (bytes1[i] != bytes2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * byte equals
	 * 
	 * @param bytes1
	 * @param bytes2
	 * @return
	 */
	public static boolean bytesEquals(byte[] bytes1, byte[] bytes2) {
		if (bytes1 == null || bytes2 == null) {
			return false;
		}
		if (bytes1.length == bytes2.length) {
			for (int i = 0; i < bytes1.length; i++) {
				if (bytes1[i] != bytes2[i]) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * byte copy
	 * 
	 * @param srcbytes
	 * @param srcpos
	 * @param destbytes
	 * @param destpos
	 * @param length
	 * @return
	 */
	public static boolean bytesCopy(byte[] srcbytes, int srcpos, byte[] destbytes, int destpos, int length) {
		if (srcbytes == null || destbytes == null) {
			return false;
		}
		if (srcbytes.length - srcpos < length) {
			length = srcbytes.length - srcpos;
		}
		if (destbytes.length - destpos < length) {
			length = destbytes.length - destpos;
		}
		System.arraycopy(srcbytes, srcpos, destbytes, destpos, length);
		return true;
	}

	/**
	 * string equals
	 * 
	 * @param str1
	 * @param pos1
	 * @param str2
	 * @param pos2
	 * @param length
	 * @return
	 */
	public static boolean stringEquals(String str1, int pos1, String str2, int pos2, int length) {
		if (str1 == null || str2 == null) {
			return false;
		}
		if (pos1 < 0) {
			pos1 = 0;
		}
		if (pos2 < 0) {
			pos2 = 0;
		}
		if (length <= 0) {
			if (str1.length() == str2.length()) {
				length = str1.length();
			} else {
				return false;
			}
		}
		int len1 = str1.length() - pos1;
		int len2 = str2.length() - pos2;
		if (len1 < length || len2 < length) {
			return false;
		}
		for (int i = 0; i < len1; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
