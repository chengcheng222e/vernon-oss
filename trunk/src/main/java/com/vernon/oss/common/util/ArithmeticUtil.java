package com.vernon.oss.common.util;

import java.math.BigDecimal;

/**
 * 算术运算工具类
 * 
 * @date 2013-1-26
 * @author Vernon.Chen
 */
public class ArithmeticUtil {

	private static final int DEFAULT_DIV_SACLE = 10; // 默认除法运算精度,后10位

	/**
	 * 加法
	 * 
	 * @param summandValue 被加数
	 * @param addendValue 加数
	 * @return
	 */
	public static double add(double summandValue, double addendValue) {
		BigDecimal summand = new BigDecimal(Double.toString(summandValue));
		BigDecimal addend = new BigDecimal(Double.toString(addendValue));
		return summand.add(addend).doubleValue();
	}

	/**
	 * 减法
	 * 
	 * @param minuendValue 被减数
	 * @param subtrahendValue 减数
	 * @return
	 */
	public static double sub(double minuendValue, double subtrahendValue) {
		BigDecimal minuend = new BigDecimal(Double.toString(minuendValue));
		BigDecimal subtrahend = new BigDecimal(Double.toString(subtrahendValue));
		return minuend.subtract(subtrahend).doubleValue();
	}

	/**
	 * 乘法
	 * 
	 * @param multiplicandValue 被乘数
	 * @param multiplierValue 乘数
	 * @return
	 */
	public static double mul(double multiplicandValue, double multiplierValue) {
		BigDecimal multiplicand = new BigDecimal(Double.toString(multiplicandValue));
		BigDecimal multiplier = new BigDecimal(Double.toString(multiplierValue));
		return multiplicand.multiply(multiplier).doubleValue();
	}

	/**
	 * 除法运算
	 * 
	 * @param dividendValue 被除数
	 * @param divisorValue 除数
	 * @param SCALE 精度
	 * @return
	 */
	public static double div(double dividendValue, double divisorValue, int SCALE) {
		if (SCALE < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal dividend = new BigDecimal(Double.toString(dividendValue));
		BigDecimal divisor = new BigDecimal(Double.toString(divisorValue));
		return dividend.divide(divisor, SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 除法运算
	 * 
	 * @param dividendValue 被除数
	 * @param divisorValue 除数
	 * @return
	 */
	public static double div(double dividendValue, double divisorValue) {
		return div(dividendValue, divisorValue, DEFAULT_DIV_SACLE);
	}

	/**
	 * 四舍五入
	 * 
	 * @param targetValue
	 * @param SCALE
	 * @return
	 */
	public static double round(double targetValue, int SCALE) {
		if (SCALE < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal target = new BigDecimal(Double.toString(targetValue));
		BigDecimal DEFAULT = new BigDecimal("1");
		return target.divide(DEFAULT, SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public static void main(String[] args) {
		double firstValue = 10;
		double secondValue = 6;
		// 加法
		double result = add(firstValue, secondValue);
		System.out.println("add() result: " + result);

		// 减法
		result = sub(firstValue, secondValue);
		System.out.println("sub() result: " + result);

		// 乘法
		result = mul(firstValue, secondValue);
		System.out.println("mul() result: " + result);

		// 除法(默认)
		result = div(firstValue, secondValue);
		System.out.println("div() result: " + result);

		// 除法
		result = div(firstValue, secondValue, 3);
		System.out.println("div() result: " + result);

		// 四舍五入
		double targetValue = 12.12235324;
		result = round(targetValue, 4);
		System.out.println("round() result: " + result);

	}
}
