package com.vernon.oss.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 该类实现了将英文单词单复数互转
 * 
 * @modified Winter Lau (http://www.oschina.net)
 * @author Vernon.Chen
 * @date 2013-2-4
 */
public class InflectorUtil {

	private static List<RuleAndReplacement> plurals = new ArrayList<RuleAndReplacement>(); // 复数

	private static List<RuleAndReplacement> singulars = new ArrayList<RuleAndReplacement>();// 单数

	private static List<String> uncountables = new ArrayList<String>();

	private static InflectorUtil instance; 

	private InflectorUtil() {
		initialize();
	}

	private void initialize() {
		// 单数转复数情况
		plural("$", "s");
		plural("s$", "s");
		plural("(ax|test)is$", "$1es");
		plural("(octop|vir)us$", "$1i");
		plural("(alias|status)$", "$1es");
		plural("(bu)s$", "$1es");
		plural("(buffal|tomat)o$", "$1oes");
		plural("([ti])um$", "$1a");
		plural("sis$", "ses");
		plural("(?:([^f])fe|([lr])f)$", "$1$2ves");
		plural("(hive)$", "$1s");
		plural("([^aeiouy]|qu)y$", "$1ies");
		plural("([^aeiouy]|qu)ies$", "$1y");
		plural("(x|ch|ss|sh)$", "$1es");
		plural("(matr|vert|ind)ix|ex$", "$1ices");
		plural("([m|l])ouse$", "$1ice");
		plural("(ox)$", "$1en");
		plural("(quiz)$", "$1zes");
		// 复数转单数情况
		singular("s$", "");
		singular("(n)ews$", "$1ews");
		singular("([ti])a$", "$1um");
		singular("((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$", "$1$2sis");
		singular("(^analy)ses$", "$1sis");
		singular("([^f])ves$", "$1fe");
		singular("(hive)s$", "$1");
		singular("(tive)s$", "$1");
		singular("([lr])ves$", "$1f");
		singular("([^aeiouy]|qu)ies$", "$1y");
		singular("(s)eries$", "$1eries");
		singular("(m)ovies$", "$1ovie");
		singular("(x|ch|ss|sh)es$", "$1");
		singular("([m|l])ice$", "$1ouse");
		singular("(bus)es$", "$1");
		singular("(o)es$", "$1");
		singular("(shoe)s$", "$1");
		singular("(cris|ax|test)es$", "$1is");
		singular("([octop|vir])i$", "$1us");
		singular("(alias|status)es$", "$1");
		singular("^(ox)en", "$1");
		singular("(vert|ind)ices$", "$1ex");
		singular("(matr)ices$", "$1ix");
		singular("(quiz)zes$", "$1");
		// 不规则情况
		irregular("person", "people");
		irregular("man", "men");
		irregular("child", "children");
		irregular("sex", "sexes");
		irregular("move", "moves");
		// 没有单复数情况
		uncountable(new String[] { "equipment", "information", "rice", "money", "species", "series", "fish", "sheep" });
	}

	/**
	 * 单例模式
	 * 
	 * @return
	 */
	public static InflectorUtil getInstance() {
		if (instance == null) {
			instance = new InflectorUtil();
		}
		return instance;
	}

	/**
	 * 单数转换成复数
	 * 
	 * @param word 单词
	 * @return
	 */
	public String pluralize(String word) {
		if (uncountables.contains(word.toLowerCase())) {//  没有单复数形式
			return word;
		}
		return replaceWithFirstRule(word, plurals);
	}

	/**
	 * 复数转换成单数
	 * 
	 * @param word 单词
	 * @return 
	 */
	public String singularize(String word) {
		if (uncountables.contains(word.toLowerCase())) {//  没有单复数形式
			return word;
		}
		return replaceWithFirstRule(word, singulars);
	}

	/**
	 * 替换
	 * 
	 * @param word
	 * @param ruleAndReplacements
	 * @return
	 */
	private String replaceWithFirstRule(String word, List<RuleAndReplacement> ruleAndReplacements) {
		for (RuleAndReplacement rar : ruleAndReplacements) {
			String rule = rar.getRule();
			String replacement = rar.getReplacement();

			// Return if we find a match.
			Matcher matcher = Pattern.compile(rule, Pattern.CASE_INSENSITIVE).matcher(word);// 不分大小的匹配
			if (matcher.find()) {
				return matcher.replaceAll(replacement);
			}
		}
		return word;
	}

	/**
	 * 负数
	 * 
	 * @param rule
	 * @param replacement
	 */
	public static void plural(String rule, String replacement) {
		plurals.add(0, new RuleAndReplacement(rule, replacement));
	}

	/**
	 * 单数
	 * 
	 * @param rule
	 * @param replacement
	 */
	public static void singular(String rule, String replacement) {
		singulars.add(0, new RuleAndReplacement(rule, replacement));
	}

	/**
	 * 不规则
	 * 
	 * @param singular
	 * @param plural
	 */
	public static void irregular(String singular, String plural) {
		plural(singular, plural);
		singular(plural, singular);
	}

	/**
	 * 没有单复数
	 * 
	 * @param words
	 */
	public static void uncountable(String... words) {
		for (String word : words) {
			uncountables.add(word);
		}
	}

	public static void main(String[] args) {
		System.out.println(InflectorUtil.getInstance().pluralize("car"));
		System.out.println(InflectorUtil.getInstance().pluralize("child"));
		System.out.println("--------------------------------------------");
		System.out.println(InflectorUtil.getInstance().singularize("cars"));
		System.out.println(InflectorUtil.getInstance().singularize("children"));
	}
}

/**
 * 字符串替换规则对应
 * 
 * @author Vernon.Chen
 * @date 2013-2-4
 */
class RuleAndReplacement {
	private String rule;
	private String replacement;

	public RuleAndReplacement(String rule, String replacement) {
		this.rule = rule;
		this.replacement = replacement;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
}
