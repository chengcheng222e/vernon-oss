package com.vernon.oss.common.util;

/**
 * 计算拼音和中文对应的工具类
 * 
 * @author Vernon.Chen
 * @date 2013-2-5
 */
public class SpellUtil {

	private static String[][] strs;
	static {
		strs = new String[][] { init129(), init130(), init131(), init132(), init133(), init134(), init135(), init136(),
				init137(), init138(), init139(), init140(), init141(), init142(), init143(), init144(), init145(),
				init146(), init147(), init148(), init149(), init150(), init151(), init152(), init153(), init154(),
				init155(), init156(), init157(), init158(), init159(), init160(), init170(), init171(), init172(),
				init173(), init174(), init175(), init176(), init177(), init178(), init179(), init180(), init181(),
				init182(), init183(), init184(), init185(), init186(), init187(), init188(), init189(), init190(),
				init191(), init192(), init193(), init194(), init195(), init196(), init197(), init198(), init199(),
				init200(), init201(), init202(), init203(), init204(), init205(), init206(), init207(), init208(),
				init209(), init210(), init211(), init212(), init213(), init214(), init215(), init216(), init217(),
				init218(), init219(), init220(), init221(), init222(), init223(), init224(), init225(), init226(),
				init227(), init228(), init229(), init230(), init231(), init232(), init233(), init234(), init235(),
				init236(), init237(), init238(), init239(), init240(), init241(), init242(), init243(), init244(),
				init245(), init246(), init247(), init248(), init249(), init250(), init251(), init252(), init253() };

	}

	public static String getSpellByAscii(String ascii) {
		String retStr = "";
		int upperascii = Integer.parseInt(ascii.substring(0, ascii.indexOf("-")));
		int lowascii = Integer.parseInt(ascii.substring(ascii.indexOf("-") + 1, ascii.length()));
		lowascii = lowascii > 127 ? lowascii - 1 : lowascii;
		if (upperascii < 160) {
			retStr = strs[upperascii - 129][lowascii - 64];
		} else {
			retStr = strs[upperascii - 138][lowascii - 64];
		}
		return retStr;
	}

	private static String[] init129() {
		return new String[] { "kao,qiao,yu", "shang", "xia", "mo ye o ne", "mian", "chou", "shi", "diu", "qiu",
				"liang", "you", "bing", "jiu", "ji", "jie", "guan,kuang", "chan", "zhuo", "ba", "jing", "fu", "yi,ji",
				"yi", "shi me", "jiu", "ho", "yin", "hu", "cheng,sheng", "hao,yi", "wan", "gai", "jiu", "ha ri",
				"ho lo", "dou", "shi", "nang", "ga ri", "ge ri", "dao ri", "mo ri", "o lo", "ca lo", "xue", "yan",
				"po ri", "sa lo", "na", "qian", "sao ri", "er", "zu ri", "za ri", "zhi,luan", "gui", "qian", "luan",
				"lin", "yi", "jue", "ma", "shi", "yu", "si", "sui", "gen", "ya", "qi,zhai", "ya", "da", "ye", "xiang",
				"jing", "ye", "you", "dan", "lian", "duo", "wei,men", "ji", "ji", "wang", "ba", "bing", "fo",
				"jin,san", "e o", "xian", "tuo,cha,duo", "hong", "gan,han", "bo", "chao", "chang,zhang", "chang",
				"ren", "fan", "chao,miao", "qian", "wo", "yao,fo", "feng", "cang", "wang", "di", "zhong", "pei", "yu",
				"diao", "dun", "wen", "yi", "xin", "ji", "ai", "jin", "pi", "dan", "fu", "tang", "cui", "yun",
				"che,ju", "qian", "xun", "xin", "chi", "xian,xuan", "nu", "ni", "xie", "xu", "zhou", "qu", "peng",
				"pi", "zhi", "si", "yi,chi", "zheng", "han,gan", "mai", "zhu", "bu", "qu", "bi", "zhao,shao", "ci",
				"yang", "zhan,dian", "bi", "xian", "qu", "shi", "bao", "hui,huai", "ge", "xiang", "ge", "fa", "ming",
				"bing", "hen", "huo", "gui", "quan", "ci", "xing", "shen", "tuo", "gai", "lai", "yi", "gong", "yin",
				"mi", "xu", "an", "lu", "er", "lun", "cha", "chi", "xun", "zhou", "ru", "cun", "si", "dai", };
	}

	public static String[] init130() {
		return new String[] { "ta", "ning", "jin", "jiong", "cheng,ting", "zhen", "zuo", "hao", "lv", "jv", "shu,dou",
				"ting", "shen", "tuo,tui", "bo", "nan", "xiao", "tui", "yu", "xi", "xu", "guang", "ku", "wu", "yi",
				"fu", "liang", "hun", "jing", "qian", "san", "pei", "xi", "fu", "xia", "xiu", "di", "che,ju", "zhi",
				"lai", "si", "huo", "xiao", "jian", "biao", "chu,ti", "fei", "ya", "bei", "yu", "xin", "hu,chi",
				"chang", "zhi", "bing", "jiu", "yao", "cui,zu", "liang,lia", "wan", "lai", "cang", "zong", "ge",
				"tian", "shu", "men", "tan", "chui", "xing", "peng", "qi", "gan", "liang,jing", "sui", "jie", "fang",
				"zhi", "zong", "lun", "song", "leng", "hun", "dong", "zi", "ben", "wu", "ju", "nai", "cai", "jian",
				"ye", "sha", "ning", "ying", "cheng,chen", "qian", "ruan", "zhong,tong", "chun", "wei", "yu", "bing",
				"ti", "yan", "feng", "tang,dang", "wo", "e", "che", "sheng", "kan", "di", "cha", "bei", "xie", "huang",
				"yao", "zhan", "chou,qiao", "an", "you", "xu", "zha", "ci", "fu", "bi", "zhi", "mian", "ji", "yi",
				"xie", "xun", "cai,si", "duan", "ce,ze,zhai", "zhen", "tou", "bei", "zan,za,zan", "jie", "wei", "sou",
				"zhi,si", "su", "xia", "yuan", "rong", "nu", "yun", "jiang,gou", "ma", "dian", "tang", "hao", "jie",
				"xi", "shan", "qian,jian", "que,jue", "cang,chen", "chu", "san", "bei", "xiao", "rong", "yao",
				"ta,tan", "suo", "yang", "fa", "bing", "jia", "zai", "gu", "can", "lei", "yong", "zao,cao", "zong",
				"peng", "song", "chuan,zhuan", "yu", "zhai", "qi,cou", "shang", "chuang", "jing", "han", };
	}

	private static String[] init131() {
		return new String[] { "zhang", "qing", "yan", "di", "xie", "lv,lou", "bei", "piao,biao", "jin", "lian", "lu",
				"man", "qian", "xian", "tan", "ying", "dong", "zhuan", "shan", "qiao", "jiong", "tui", "zun", "pu",
				"lao", "chang", "guang", "qi", "cheng,deng", "zhan,zhuan,chan", "wei", "ji", "bo", "hui", "chuan",
				"tie,jian", "dan", "jiao,yao", "fen", "xian", "yu,ju", "e,wu", "lin", "bo", "gu", "xian", "xian",
				"min", "ye", "jin", "jia,jie", "qiao", "feng", "zhou", "ai", "sai", "yi", "jun", "nong",
				"chan,tan,shan", "yi", "dang", "kuai", "jian", "chu", "jiao", "sha", "zai", "can", "bin", "an", "tai",
				"chou", "chai", "lan", "ni,yi", "jin", "qian", "meng", "wu", "ning", "qiong", "ni", "chang", "lie",
				"lv", "kuang", "bao", "yu", "biao", "zan", "zhi", "si", "you", "hao", "qing", "chen", "li", "teng",
				"wei", "long", "chu", "chan", "rang,xiang", "shu", "hui,xie", "li", "luo", "zan", "nuo", "tang", "yan",
				"lei", "nang", "zan", "xiong", "dui,rui,yue", "dui,rui,yue", "tu", "chang,zhang", "er", "er", "jin",
				"yan", "shi", "shi,ke", "qian,ke", "gong,fen", "hao,ke", "shen", "dou", "bai,ke", "gongli", "huang",
				"wang", "nei", "liang", "yu,shu", "han", "tian", "bun", "ji", "yi", "mao", "ran", "yuan", "mao", "ce",
				"jiong", "gua", "jiong", "mao", "zhou", "gou", "xu", "yin,you", "kan", "yi", "shen", "shi", "meng",
				"zui", "kou", "lin", "fu", "xie", "mi", "tai", "gang", "ya", "pan", "fa", "min", "qia", "jian", "sou",
				"mei", "tu", "gu", "jing,cheng", "qing", "dong", "gan", "yin", "ai", "li", "cang", "ming", "zhun",
				"cui", };
	}

	private static String[] init132() {
		return new String[] { "si", "duo", "jin", "lin", "xi", "du", "fan", "fan", "ju", "chu",
				"yi ka,yi ka no bo li,ta ko", "feng", "ko ga la xi", "na gi", "feng", "feng", "kai", "gan", "ping",
				"kuai", "han", "ren", "chuang", "ji", "qian", "cun", "ji", "dan", "wan", "jue", "li", "fu", "qu",
				"diao", "min", "ling", "zhong", "bie", "jie", "jie", "shan", "chan", "geng", "chuang", "kui", "duo",
				"er", "jie", "ci", "jing", "dou", "luo", "ze", "yuan", "cuo", "kei,ke", "cha,sha", "chuang", "cuo",
				"li", "fei", "chan", "qi", "chuang", "zi", "gang", "bao,bo", "duo", "qing", "du,zhuo", "jian", "ji",
				"yan", "huo", "duo", "zhi,duan", "wu", "gua", "sheng", "jian", "da,zha", "kai", "chuang", "chuan",
				"chan", "tuan,zhuan", "lu,jiu", "li", "peng", "shan", "kou", "gua", "hua", "zha", "zhuo", "lian", "ju",
				"liu", "gui", "jiao,chao", "gui", "jian", "jian", "tang", "ji", "jian", "jian", "zhi", "chan", "zuan",
				"mo", "li", "zhu", "ya", "jin,jing", "keng", "xie,lie", "zhi", "yi", "zhu", "miao", "lao", "juan",
				"kou", "yang", "wa", "xiao", "mou", "kuang", "jie", "lie", "ke", "jin,jing", "gao", "min", "chi",
				"lang", "yong", "ke", "juan", "qing", "lu", "bu", "chi", "kai", "mian", "dong", "xu", "wu", "yi",
				"xun", "weng,yang", "sheng", "lao", "lu", "piao", "shi", "ji", "jiang", "jiao,chao", "quan", "xiang",
				"yi", "qiao", "fan", "juan", "tong,dong", "ju", "dan", "mai", "xun", "xun", "lv", "li", "che",
				"rang,xiang", "quan", "yun", "jiu", "bao", "mo ne me", "xiong", "gai", "gai", "yi", "peng", "ju",
				"tao,yao", "ge", "e", };
	}

	private static String[] init133() {
		return new String[] { "gong", "da", "jiu", "gong", "nao", "jiu", "yi", "jiang", "kang", "hu", "qu", "fan",
				"qie", "zang,cang", "kuang", "hu", "yu", "gui", "hui", "dan", "kui,gui", "lian", "lian", "suan", "du",
				"jiu", "jue", "xi", "ke,qia", "yan", "qu,ou", "xun", "nian", "zu", "shi", "xi", "wan", "wan", "xie",
				"dan", "ji", "shuai,lv", "guan,kuang", "xi", "xie", "jie", "yang,ang", "qiong", "shao", "chi", "xu",
				"que", "wu", "ji", "e", "xi", "san", "wei", "zhe,zhai", "han,an", "ya", "di", "zha,zhai", "pang",
				"a e si", "qie", "ya", "zhi,shi", "mang", "ti", "she", "ting", "zui", "fei", "ce", "yuan", "li",
				"dian", "jin", "ao", "gui", "yan", "li", "chang", "qian,lan", "li", "yan", "yan", "yuan", "gong,hong",
				"lin,miao", "rou,qiu", "qu", "ke wu mu", "lei", "du", "zhuan", "can,shen,cen,san", "can,shen,cen,san",
				"can,shen,cen,san", "ai,yi", "dai", "shou", "guai", "ba", "ruo", "li", "zhuo,yi,li,jue", "jia", "sou",
				"ji", "wei,yu", "rui", "cong", "gua", "qiu", "chi", "du ge", "hong", "mie", "mang", "xuan,song", "zi",
				"dou,cun", "ye", "ou", "huo", "yi", "chou", "qin", "jie,ge", "bu", "e,hua", "hong", "wu", "na,ne",
				"xue,chuo,jue", "dou,ru", "hou,hong,ou", "gao", "jun", "lv", "ge", "wen", "qi", "wu", "jiao", "hong",
				"chi", "sheng", "tun,tian", "hua,qi", "e", "shi", "juan", "pen", "wen,min", "mou,m", "ran", "di",
				"shi", "zhou", "tie,che", "xi", "yi", "qi,zhi", "ping", "zi,ci", "xu,hou,gou", "yi", "xiao,hao",
				"da,dan", "qu", "xian,gan", "tuo", "pou", "bi", "fu", "yang", "he", "hai", "da", "wa", "zuo", "bu",
				"tuo", "xian", "huo", "qi", "er", };
	}

	private static String[] init134() {
		return new String[] { "e", "die,xi", "zhou", "shu,xun", "xiao", "kua", "huai,shi", "tao", "e,an", "xuan",
				"wai,he,wo,wa,gua,guo", "lao", "tong", "xiong", "you", "die,di", "nian", "xing", "po pu ni", "hao",
				"yuan,yun", "long", "pou", "mang", "zu", "he", "xian", "lao", "po,ba,bo", "liang,lang", "ba", "mie",
				"lie,lv", "sui", "fu", "han", "chuo,yue", "you", "gu", "gu", "bei,bai", "han", "yi", "jia,qian", "tu",
				"dan,xian,yan", "wan", "li", "qiu", "che", "zao", "ya", "dou", "qi", "di", "qin", "ma si", "gong,hong",
				"dou", "ge xi", "liang", "leng", "sha,sha", "zu", "wo,wei", "jin,yin", "qi", "er,wa", "qiang", "an",
				"jie,ze,zuo", "nian", "yu", "tian", "lai", "xi", "ai", "gou", "zhuo,zhao", "di", "heng", "cai",
				"qiang", "zhun,tun,xiang,dui", "wu", "wen", "sha,jie,die,ti", "gu", "qi", "qi", "dan", "yue,wa",
				"zi,ci", "bi,tu", "cui", "he", "ya", "qi", "zhe", "liang", "xian", "qing,ying", "gua", "ze,shi", "guo",
				"luo", "yan", "di", "quan", "tan,chan,tuo", "ju", "tang", "an", "dan", "yu", "zhe", "zhou", "chai",
				"wai", "huo,guo,xu", "zan,za,zan", "yao", "mian", "hu", "yun", "huan", "huan,yuan,xuan,he", "ji",
				"zhong,chuang", "wei", "sha", "xu", "huang", "duo,zha", "yan", "liang", "yu", "sang", "chi",
				"qiao,jiao", "yan", "dan,shan,chan", "pen,ben", "can,sun,qi", "yo", "wei", "ying", "pao xi", "xi",
				"jie", "zao,qiao", "hu", "ti", "yao", "he,xiao,hu", "qiang", "se", "yong", "gong,hong", "xie", "ma,ma",
				"cha", "hai", "ru", "wa,gu", "ji", "beng,pang", "wu", "xian,qian,qie", "zi", "lao", "wa", "jia lun",
				"suo", "zi", "sai", "ge", "na", "qiang", "bi", "ao", "lian", "zui,sui", "zhe,zhu", "mo", "tan", "jiao",
				"chong", "jiao,dao", "kai,ge", };
	}

	private static String[] init135() {
		return new String[] { "tan", "shan,can", "ai", "xiao", "lou", "xiao,jiao", "hu", "hui", "guo", "ou", "xian",
				"ze", "chang", "po", "de,dei", "ma", "hu", "ga", "tang", "ye", "sai", "jiao", "xiao", "hua", "mai",
				"ran", "lao", "xiao", "ji", "kui", "xiao", "hao", "fu,?", "qiao", "chu,xu,shou", "tan,chan", "dan,tan",
				"xun", "e", "zun", "fan,bo", "chi", "hui", "zan", "chuang", "cu,za,he", "dan", "jue", "tun,kuo", "xi",
				"qi", "hao", "lian", "xu,shi", "hui", "yin", "xun", "nie", "si", "yan", "ying", "da", "zhan",
				"zhou,zhuo", "nong", "yue,hui", "xie", "jiao,qiao,chi", "yuan", "ai", "yong", "kuai", "yu", "pen",
				"dao", "xin,hen", "dun", "dang", "ha na xi", "pi", "yin", "zui", "ning", "di", "lan", "ta", "huo,o",
				"he,xia", "yan", "duo", "xiu,pi", "zhou,chou", "ji,jie,zhai", "jin", "chang", "xun", "me", "ti", "lu",
				"hui", "bo,pao,bao", "you", "nie", "yin", "hu", "mei,me,mo", "hong", "zhe", "li", "liu", "xie,hai",
				"nang", "mo", "yan", "li", "lu", "long", "po", "dan", "chen", "pin", "pi", "xiang", "me", "xi", "duo",
				"ku", "yan", "chan", "ying", "di mi", "la", "ta", "xiao", "chuo", "huan", "huo", "zhuan", "nie",
				"xiao", "za,ca", "li", "chan", "chai", "li", "yi", "luo", "za,zan,can", "su", "xi", "zeng", "jian",
				"yan,za,nie", "zhu", "lan", "nie", "ra mo", "luo", "hui", "yin", "nin", "tuan", "kang", "yuan",
				"jiong", "pian", "yun", "cong", "hui", "e", "guo", "wei,tong", "tu", "guo", "qun", "ri", "guo", "tai",
				"guo", "yin", "hun", "han", "lun", "guo", "chuan,chui", "wei", "yuan", "quan,juan", "ku", "pu", };
	}

	private static String[] init136() {
		return new String[] { "yuan", "yuan", "ya", "tuan", "tu", "tu", "tuan", "l<e", "hui", "yi", "luan", "luan",
				"ya", "tu", "ting", "pu", "lu", "kuai", "ya", "yu,zhun", "qian,su", "qian", "zhuo", "dang", "qia",
				"xia", "shan", "nie", "mo", "jia", "zhi", "xun", "yi", "qin", "mei,fen", "rong,keng", "tun,dun",
				"ben,fen", "bi", "jing", "di,lan", "jing", "ji", "di", "jing", "pan,ban", "tang", "qu", "zhi", "gua",
				"tai", "jiong", "yang", "fo", "lu", "qiu", "gou", "xue", "fa", "ling", "zhu", "fu", "hu", "zhi", "ao",
				"dai", "pao", "min", "ji", "he", "lv", "ci", "chi", "yin", "hou", "dui", "zhao", "fu", "guang", "yao",
				"duo", "gui", "cha", "yang", "xie", "shou", "bing", "hong", "da", "ka", "dang", "hang", "an", "xing",
				"xian", "bang", "pou,fu", "ba", "yi", "yin", "han", "xu", "chui", "cen", "beng,feng", "di,fang",
				"que,jue", "yong", "jun", "xia,jia", "di", "lang", "juan", "qin,jin", "zhe", "lie", "hua", "bu",
				"jiong", "ye", "di", "ya", "quan", "sui,su", "qing,zheng", "wan", "ju", "lun", "zheng,cheng", "kong",
				"chong,shang", "dong", "tan", "cai", "chu,tou", "beng", "xian,kan", "duo", "yi,shi", "zhi", "zhun",
				"qi", "ju", "ni", "ke", "kun", "ni", "jian", "gang", "yu", "e", "gu", "leng", "fang", "ya", "kun",
				"an", "shen", "nao", "tu", "cheng", "huan", "bi", "lian", "guo", "zhuan", "bao", "yu", "mao,mou,wu",
				"jie", "ruan", "e,ai,ye", "geng", "zong", "yu", "huang", "e", "yao", "bao", "ji", "mei", "chang",
				"tuo", "yin", "feng", "zhong", "jie", "jin", "feng", "gang", };
	}

	private static String[] init137() {
		return new String[] { "chuan", "jian", "ping", "lei", "jiang", "huang", "duan", "wan", "xuan", "xi", "ji",
				"kuai", "ying", "yong", "kai", "su", "shi", "mi", "weng", "cheng", "tu", "que", "zhong", "li", "peng",
				"bang", "zang", "dui", "tian", "wu", "zheng", "xun", "zhen", "ai", "gong", "yan", "xian", "wen", "xie",
				"liu", "hai", "lang", "chang", "peng", "beng", "chen", "lu", "lu", "ou,qiu", "qian,zan,jian", "mei",
				"mo", "zhuan,tuan", "shuang", "lou", "biao", "qi", "zhi,di", "zhang", "kan", "dian", "chen",
				"zhi,zhuo", "xi", "guo", "qiang", "jin", "di", "cui", "yan", "ta", "zeng", "qian", "wei", "zhui",
				"qiao", "shan", "shan", "fa", "pu", "kuai,tui", "tuan,dong", "fan", "qiao,que", "dun", "zun,dun", "di",
				"sheng", "duo,hui", "duo", "tan", "deng", "wu", "fen", "huang", "tan", "da", "ye", "zhu", "jian", "ao",
				"qiang", "qiao,ao", "ken", "yi,tu", "pi", "dian", "jiang", "ye", "xue,bo,jue", "tan", "lan", "ju",
				"huai", "dang", "rang", "qian", "xun", "xian,lan", "xi", "ai", "ya", "dao", "ruan", "jin", "lei",
				"kuang", "lu", "yan", "tan", "wei", "huai", "long", "long", "rui", "li", "lin", "chan", "xun", "yan",
				"lei", "ba", "wan", "san", "zhuang", "yi", "mai", "zhu", "zhuang", "hu", "kun", "hu", "xu", "kun",
				"shou", "mang", "dun", "shou", "yi", "gu,ying", "jiang,xiang", "feng,pang", "zhai", "bian", "sui",
				"qun", "ling", "cuo", "xiong,xuan", "xie", "nao", "xia", "yuan,wan", "mao,wan", "duo", "qing", "yi xi",
				"gou", "qi", "meng", "meng", "chen", "ce", "guai", "gao", "tao,ben", "tai", "yan,tao", "bi", "hua", };
	}

	private static String[] init138() {
		return new String[] { "yun", "jia,ga,xia", "ba", "en", "di,ti", "pao", "juan", "xie", "dian", "quan,juan",
				"huan", "kai", "she,chi,zha", "ben", "huang", "fei", "diao", "xun,zhui", "beng", "ao", "weng",
				"po,ha,tai", "wu", "ao,yu", "jiang", "lian", "duo", "yun", "jiang", "shi", "fen", "huo", "bi", "luan",
				"duo,che", "ding,tian", "qian", "jiu", "nuan", "cha", "xian", "fan", "ji", "hong", "dan", "fu,you",
				"jing", "hai,jie", "wen", "zhong", "pa", "keng,hang", "zhong", "yun", "fou,pei,pi", "chi", "yue,jue",
				"zhuang", "yan", "na,nan", "xin", "fen", "feng", "wan,yuan", "du", "ba", "zhuo", "zhao", "ni,nai",
				"yuan", "tou", "xian,xuan,xu", "zhi,yi", "e", "mo", "bi", "shen", "e", "he", "xu", "fa", "zheng",
				"min", "ban", "fu", "ling", "zi", "ran", "shan", "yang", "gan", "zi", "ju", "ren", "dong", "ji", "gai",
				"xiang", "hua,huo", "juan", "gou,du", "jian", "jian", "nian", "zhi", "zhen", "xian", "heng", "guang",
				"jun,xun", "kua,hu", "yan", "ming", "lie", "pei", "e,ya", "you", "yan", "shen,xian", "shi", "gui",
				"quan", "song", "hong", "xian", "shao", "cheng,sheng", "xie", "mang", "fu", "wu,mu", "ke", "chuo,lai",
				"chuo", "ting", "xing", "nan", "yu", "pou,bi", "nei,sui", "zhi", "han", "zhuang", "pin", "tui", "man",
				"wu,yu", "yan", "wu", "xi,ai", "yan", "yu", "si", "li", "ju", "zhui,shui", "qi", "xian", "zhuo",
				"dong", "lu", "ai,e", "e", "lou", "mian", "cong", "pou,pei,bu", "ju", "cai", "ling", "xiao", "shu",
				"qi", "hui", "fu,fan", "wo", "wo", "tan", "fei", "fei", "tian", "ni", "quan,juan", "jing", "jing",
				"qian,jin", "dian", "xing", "hu", "wan,wa", };
	}

	private static String[] init139() {
		return new String[] { "lai", "yin", "zhou,chou", "chuo,nao", "fu", "lun", "an,n<e", "hun,kun", "yin", "ya",
				"ju", "li", "dian", "xian", "hua,da tai", "hua", "dang,yang", "yao", "nan", "ruo,chuo", "jia",
				"tou,yu", "yu", "wei", "di,ti", "rou", "mei", "dan", "ruan,nen", "qin", "hui", "wo", "qian", "chun",
				"miao", "fu", "jie", "duan", "yi,pei", "zhong", "huang", "mian", "an", "ying", "xuan", "jie", "wei",
				"zheng", "qiu", "ti", "xie", "tuo,duo", "lian", "mao", "ran", "si", "pian", "wei", "wa", "cu", "hu",
				"jie", "bao", "xu", "tou,yu", "gui", "chu,zou", "yao", "yuan", "rong", "ru", "liu", "mei", "pan",
				"ao,yun,wo", "ma", "kui", "qin,shen", "zhen", "yuan", "jie,suo", "rong", "ming", "ying", "su", "niao",
				"tao", "pang", "lang", "nao", "biao", "pi", "yi", "yu", "xuan", "man", "yi", "kang", "yong", "ni",
				"gui", "jin", "zhuan", "ze", "han,nan", "lao", "zhe", "hu", "hu", "ao", "nen", "ma", "pie", "gu", "wu",
				"qiao", "tuo", "zhan", "miao", "xian", "xian", "mo", "liao", "lian", "hua", "gui", "deng", "zhi", "xu",
				"yi", "hua", "xi", "kui", "rao", "yan", "chan", "jiao", "mei", "fan", "fan", "xian,yan,jin", "yi",
				"hui", "jiao", "fu", "shi", "sui", "qiang", "lian", "huan,xuan,qiong", "xin", "niao", "dong", "yi",
				"can", "ai", "niang", "ning", "mo", "tiao", "chou", "jin", "ci", "yu", "pin", "rong", "ru", "nai",
				"yan", "tai", "ying", "qian", "yue", "mian", "ka ka a", "shen", "xing", "ni", "du", "liu", "yuan",
				"lan", "yan", "ling", "jiao", "niang", "lan", "xian,qian", "ying", "shuang", };
	}

	private static String[] init140() {
		return new String[] { "xie,hui", "huan,quan", "mi", "li", "luan", "yan", "zhu,chuo", "lan", "jue", "zi,ma",
				"xin", "si", "tai", "you", "zhuan", "sun,xun", "mie", "cong", "qian", "ya", "ni", "zi", "li", "xue",
				"bo", "nai", "nie", "ying", "luan", "rong", "qiong", "tu,jia", "rou", "yao", "yi", "jing", "zhun",
				"zhu", "hong", "shi", "yi", "tiao", "shi", "cheng", "qun", "gong", "xiao", "zha", "bao,shi", "cai",
				"huang", "mi", "kou", "cai", "zan", "yuan", "qing", "he", "zhen", "jian", "ning", "bing", "huan",
				"qin", "shi", "ning", "jin,qin", "ning", "zhi", "yu", "bao", "kuan", "ning", "ju,lou", "qin", "hu",
				"shi", "ning", "shen", "wei", "xie", "kuan", "hui", "jun", "yi", "yi", "bao", "qin", "chong", "bao",
				"feng", "l<e,luo", "dui", "po", "zhuan", "fu", "kei,ke", "jiang", "zhuan", "xun", "shu,zhu", "dui",
				"dao", "jie,ji", "er", "er", "shu", "shang", "mo", "liao", "xian", "xian", "hun", "wang", "liao",
				"long,mang,meng,pang", "wang", "wang", "wang", "yao", "duo", "kui", "zhong", "gan", "gu", "tui", "gan",
				"gan", "xi", "bi", "jie", "tian", "diao", "shi", "zhen", "xi", "ni", "xi", "uu", "man", "lou",
				"ping,bing", "ti", "fei", "xie,ti", "lv", "ceng", "xie", "ju", "jue", "liao", "jue", "shu,zhu", "xi",
				"ni,ji", "wa", "xian", "li", "an", "hui", "hui", "hong,long", "ren", "wu", "han,an", "shen", "chu",
				"yin", "yue", "ban", "yao", "ang", "wu", "jie", "e", "fen", "wan", "qian", "qi", "jie", "zuo", "zuo",
				"yang", "ju", "gang", "xue", "po", "li", "tiao", "ju", };
	}

	private static String[] init141() {
		return new String[] { "fu", "tuo", "pi", "ao", "kuang", "qu", "po", "tiao", "ling", "di", "ping", "zai,ze mo",
				"xiu", "tong", "xue", "biBn", "he", "ke,ba", "luo", "e", "fu,nie", "die", "lu", "en", "er", "gai",
				"quan", "yi", "mu", "shi", "an", "wei", "huan", "mi", "li", "fa", "tong", "wei", "you", "qia", "li",
				"yao", "jiao", "e", "xie,ye", "bu", "qun", "feng", "nao", "li", "you", "xian", "rong", "dao", "shen",
				"cheng", "tu", "geng", "gao", "xia", "yin", "wu", "lang", "kan", "xian", "que", "chong", "ta", "lin",
				"hua", "ju", "lai", "min", "kun", "kun", "zu,cui", "gu", "ya", "gang", "lun", "lun", "ling", "duo",
				"zheng", "yin", "dong", "han", "zheng", "wei", "pi,bi", "jie", "zu", "jue", "dong", "yin", "zi", "ze",
				"huang", "yu", "yang,dang", "feng", "qiu", "yang", "ti", "yi", "zhi,shi", "shi,die", "e", "zhu",
				"kan,zhan", "lv", "yan", "mei", "han", "ji", "huan", "ting", "wu,mao", "yu", "zong", "lan", "ke,jie",
				"yan", "yan", "wei", "zong", "cha", "sui", "ke", "qin", "qi", "tu", "cui", "xi", "weng", "cang",
				"dang,tang", "rong,ying", "jie", "kai,ai", "liu", "wu", "kao,qiao", "beng", "dian", "qin,qian", "yong",
				"nie", "cuo", "shi", "ruo", "song", "zong", "jiang", "liao", "kang", "yan", "die,di", "cen", "ding",
				"tu", "lou", "zhan,chan", "zhan,chan", "ao", "cao", "qu", "qiang", "wei", "zui", "dao", "dao", "xi",
				"yu", "pi,pei", "long", "xiang", "ceng", "bo", "qin", "jiao", "yan", "lao", "zhan", "liao", "liao",
				"qin", "tuo", "zun", "jiao,qiao", };
	}

	private static String[] init142() {
		return new String[] { "jue,gui", "yao", "jiao", "yao", "jue", "zhan,shan", "yi", "xue", "nao", "ye", "ye",
				"yi", "nie", "xian", "ji", "xie,jie", "ke,jie", "gui,xi,juan", "di", "ao", "zui", "wei", "rong", "dao",
				"ling", "jie", "yu", "yue", "yin", "ru", "jie", "li,lie", "gui,xi,juan", "long", "long", "ying,hong",
				"xi", "ju", "chan", "ying", "kui", "yan", "nao", "quan", "chao", "cuan", "luan", "dian", "dian", "nie",
				"yan", "yan", "yan", "kui", "yan", "kuai", "huang", "jing,xing", "chao", "lie", "ge xi", "pu", "bu",
				"qiu", "zhi", "zhao", "yi", "jin", "xun", "juan", "pa, xi", "fu", "za", "ding", "nie", "fen", "pa",
				"zhi", "hu", "dan", "dai", "mo,wa", "fu", "mo", "yi", "yi", "ping", "qia", "juan", "ru", "shuai",
				"shui", "qiao", "zhen", "shi", "qun", "dai", "gui", "ping", "zhang", "jian,san", "wan", "dai",
				"sha,qie", "qi,ji", "zhu", "hou", "zhen", "zheng", "wei", "yi", "bang", "ping", "die", "gong", "pan",
				"tao", "mi", "jia", "teng", "hui", "zhong", "shan,qiao,shen", "biao", "guo", "ze", "mu", "bang",
				"jing", "chan", "zhi", "hu", "bi", "bi", "zhang", "mi", "qiao", "chan", "fen", "meng", "bang",
				"chou,dao", "mie", "chu", "jie", "xian", "lan", "jian", "bing", "gan", "ji", "ting", "ze", "guang",
				"me,mo", "qin", "dun,tun", "ya", "bai,ting", "jie", "zhuang", "ya", "ci", "tong", "yi", "zhi", "tiao",
				"zhi", "xiao", "tu", "gui", "ku", "mang,meng,pang", "you", "bu", "bing,ping", "cheng", "lai", "ji,cuo",
				"song", "shu", "qing", "yu", "miao", "sou", "ce", "xiang", "fei", "jiu", "e", };
	}

	private static String[] init143() {
		return new String[] { "gui,wei,hui", "liu", "sha,xia", "sou", "zhi", "bu", "qing", "jiu", "jiu", "lou", "yin",
				"dai", "lu", "yi", "chu", "tu", "si", "xin", "miao", "chang", "wu", "fei", "guang", "kao x", "kuai",
				"bi", "qiang,se", "lin", "liao", "lu", "ji", "ying", "xian", "ting", "yong", "li", "ting", "xun", "di",
				"po,pai", "hui", "nai", "hui", "fen", "ju", "yan", "zang", "yi", "er", "san", "er", "shi", "diao",
				"hu", "wu", "tui", "jiang", "ba", "shen", "jue,zhang", "tao", "fu", "di", "chao", "zhen", "yi",
				"juan,quan", "shao", "xuan,yuan", "jing", "diao", "zhang", "jiang", "qiang,jiang", "peng", "bi", "she",
				"dan,tan", "jian", "ge", "fa", "bi", "kou", "jian", "bie", "xiao", "dan,tan", "guo", "qiang,jiang",
				"hong", "mi", "guo", "wan", "jue", "ji", "lu", "hui", "hui", "yi", "yi", "yi", "huo", "huo", "wen",
				"yan", "yu", "chi", "diao", "yong", "piao", "chi", "zhuo,bo", "tuo,yi", "ji", "zhong", "wang", "di",
				"ling", "fu", "wang", "xi", "wang,jia,wa", "cheng,zheng", "zhi", "jing", "cong", "cong", "cong", "uu",
				"ji", "zhi", "cong,zong", "zhou", "lai", "xie", "jie", "jian", "shi,ti", "jia,xia", "bian", "fu",
				"wei", "pang", "xi", "zheng", "piao", "ti,chi", "de", "zhi,zheng", "bie", "zhong,chong", "che",
				"jiao,yao", "hui", "mei", "long", "xiang", "bao", "qu,ju", "le", "ren", "ding,ting", "gai", "ren",
				"gan,han", "yi,qi", "shi,tai", "xi,lie", "fan", "ying", "min,wen", "min,wen", "wu", "ji", "xi", "jia",
				"wan", "cong", "yu,shu", "qi,shi", "cui", "tai", "tun,zhun,dun", "qian,qin", "hun", "xiong",
				"kuang,wang", "xian", "kang,hang", "ju", };
	}

	private static String[] init144() {
		return new String[] { "yi", "bao", "min,men", "pei", "kou,ju", "ban", "nao,niu", "tie,zhan", "hu,gu",
				"cu,ju,zu", "you,chou", "di", "tu,die", "you", "fu", "xi", "bi", "you,yao", "xuan", "cong", "bing",
				"huang", "xu,xue", "bi,pi", "shu", "xi,shu", "tan", "yong", "mi", "gi", "shi", "xi", "lao", "heng",
				"kuang", "mou", "zhi", "xie", "tiao,yao", "die", "hao", "gui", "xi,qi,xu", "xiao,jiao", "si", "hu,kua",
				"qiu", "hui", "chi", "yi", "xiong", "guai", "lin", "chi", "shang", "quan,zhuan", "yue", "peng", "de",
				"hui", "qiu", "mang", "yong", "yuan,juan", "pi", "yue", "yu,shu", "tu", "jie,ke", "zhe", "lin",
				"hao,jiao", "qie", "ti", "bu", "qian", "xi", "man,men", "yi", "heng", "cheng", "wu", "li", "liang",
				"cong", "yi,nian", "li", "nao", "e", "wu", "cong", "de", "chang", "men", "li", "guan", "guan", "qi",
				"kong", "tian", "lun", "xi", "kan", "gun", "ni", "dun", "guo", "zhan", "yuan,wan", "jin", "ji",
				"lan,lin", "yu,xu", "he", "juan,quan", "tan,dan", "ti", "nian", "chuo,chui", "hun,men", "xin", "e,wu",
				"suo,rui", "zong", "jian", "yong", "de", "nao", "yun", "die", "chun", "qiong", "ce", "bian", "min",
				"zong", "ti,shi", "bei", "xuan", "wei", "ge", "wei", "bi", "xuan", "huan", "mian", "yong", "qi,kai",
				"dang,shang,tang,yang", "yin", "chen,xin,dan", "mao", "ke,qia", "ke", "ai", "qie", "yan", "nuo",
				"cong,song", "sai,si", "ying", "que", "gong,hong", "yun", "su,shuo", "qi", "yao", "song", "huang",
				"ji", "gu", "ju", "chuang", "ni", "xie", "kai", "zheng", "yong", "cao", "xun", "shen", "bo", "kai,xi",
				"xi,xie", "hun", "yong", "yang", "li", "cao,sao", "tao", };
	}

	private static String[] init145() {
		return new String[] { "yin", "xu,chu", "tai", "yun", "ming", "gong,hong", "cao,cong", "piao", "mu", "guo",
				"chi", "can", "can", "can", "cui", "min", "zhang", "tong", "ao", "shuang", "guan", "que", "zao", "jiu",
				"lian", "ou", "song", "qin,jin", "yin", "lv", "shang", "tuan", "man", "qian", "she", "qing", "di,chi",
				"zhi,zhe", "lou,lv", "juan", "qi", "qi", "yu", "ping", "liao", "cong", "you", "chong", "zhi", "tong",
				"cheng", "qi", "qu", "peng", "bei", "qiong", "jiao", "chi", "lian", "ping", "kui", "hui",
				"cheng,deng,zheng", "yin", "yin", "xi", "xi", "dan,da", "tan", "duo", "dui,dun,tun", "su", "jue", "ce",
				"xiao,jiao", "fan", "fen", "lao", "lao", "xian", "min", "liao", "wu", "can", "jue", "cu", "xian",
				"tan", "sheng", "pi", "yi", "xian", "nao,nang", "dan", "tan", "jing", "song", "jiao,ji", "wei",
				"xuan,huan", "qin", "qin", "ju", "cao,sao", "ken", "ying", "yi", "lin", "se", "jun", "huai", "ai",
				"yan", "guo", "xia", "chi", "yu", "yin", "dai", "meng", "ai,yi,ni", "meng", "dui", "qi,ji", "mo",
				"lan,xian", "men", "chou", "zhi", "nuo", "yan", "yang", "bo", "zhi", "kuang", "kuang", "you", "fu",
				"liu", "mie", "cheng", "hui", "chan", "lan", "huai", "xuan", "rang", "chan", "ji", "ju", "huan", "she",
				"lian", "nan", "mi,mo", "tang", "jue", "gang,zhuang", "gang,zhuang", "yue", "ge", "jian", "dong",
				"die", "zei", "jia", "zhi", "kui", "zhan", "qiang", "ge", "jian", "yu", "yan", "xi,hu", "zhan",
				"xi,hu", "xi,hu", "qu", "hu", "hu", "e", "shi", "ti", "mao", "dian", "shang,jiong", "yi", "yi", "yan", };
	}

	private static String[] init146() {
		return new String[] { "qiu", "le,li,cai", "fan,fu", "ha me ru", "zai", "zhang", "diao,di,yue,li", "yu,wu",
				"yu,wu,ku", "han", "shen", "cha", "tuo,chi,yi", "gu,xi,ge,jie", "wu", "den", "sa te", "xi,cha,qi",
				"qian,qin", "jia", "yu", "ba,ao", "xi,zhe", "zhi", "zhi,sun,kan", "den", "yan", "kuang,wang,zai",
				"bian", "ju", "wen", "hu,gu", "yue", "qin", "dan,shen", "zheng", "yun", "wan", "ne,ni,rui,na", "pou",
				"pou,fu", "ba", "ao,niu", "ze,zhai", "yun", "bing", "zhi,zhai", "nan", "bu,pu", "yao,tao", "zhen",
				"zha", "yang", "he,qia", "ni", "ye", "chi", "pi,pei", "jia", "mei", "qu", "zhu", "jia,ya", "zha",
				"pao", "na", "qian", "tuo", "bai", "di", "ju", "kuo", "qia", "qian", "hen", "nin", "gong", "cun,zun",
				"yi,chi,hai", "xie", "ce,se,chuo", "hui", "bai", "zhi", "kuo,guang", "duo", "duo", "nong", "zhen",
				"ge", "jiao", "dong", "ru,na", "lie", "zha", "lv", "die,she", "jue", "lie ri", "ju", "ya", "xian",
				"yu", "tuo,shui", "bo", "geng", "ti", "cheng", "suo,sa,sha", "keng,qian", "mei", "nong", "ju",
				"bang,peng", "jian", "shan", "nuo", "xie,jia", "cha", "peng", "jiao,ku", "jiu", "huo,chi",
				"tu,shu,cha", "pou,fu", "ze", "shu,song,sou", "ye,yu", "jue,zhuo", "wan", "bu,pu,zhi", "zun", "ye",
				"zhai", "lv", "sou", "tuo,shui", "bang", "wei", "wan,yu", "qin", "she", "min", "men", "fu,bu", "dao",
				"wo,luo", "juan,quan", "yue", "zong", "chen", "tu", "ben", "ruo,wei,re", "zuo", "wo,xia", "qi",
				"cheng", "sao", "lun", "qing,qian", "gang", "di", "hun", "qi", "shu", "qian,wan", "ling", "ya",
				"zheng", "liang", "gua", "ni,nie,yi", "huo,xu", "shan,yan", "zheng,ding", "cai", "bing", "ti",
				"zou,zhou,chou", "ken", "pa", "jie", "ming", "jie", "meng", "sao", "peng", "nuo", "jian", };
	}

	private static String[] init147() {
		return new String[] { "zheng,keng", "jiu,you", "jian", "yan", "nan", "hong", "pi,che", "wei", "sai,zong,cai",
				"nie", "shi", "zong,song", "zhen", "xun", "huang,yong", "bian", "yang", "huan", "yan", "zan,zuan",
				"xu,ju", "ke,qia", "ji", "ti,di", "la", "la", "cheng", "jiu", "tu", "hui", "gen", "chong,dong", "xiao",
				"xie", "qian,jian", "cha", "bei", "yao", "wei", "beng", "wen", "zong", "gen", "gou", "qin", "rong",
				"que", "chou,zou", "sun", "sun", "rong,nang", "bang,peng", "ke,e", "yao", "dao", "zhi", "nu,nuo,nou",
				"la,xie,xian", "qiu", "xian", "jin", "mie", "e", "chui", "shan", "ta", "jie,zhe", "pan,ban,po", "li",
				"tao", "hu,ku", "zhi,nai", "wa", "hua", "wen", "qiang,cheng", "tian,shen", "zhen", "e", "na,nuo",
				"quan", "zha", "wu", "she", "gang", "sou", "sa,sha,shai", "chan,sun", "suo", "jiu,liu,liao,jiao,nao",
				"chong", "chuang", "guai", "feng,peng", "di,tu,zhi", "qi,ji,cha", "sou,song", "lian", "cheng", "chi",
				"guan", "lu", "lou", "zong", "gai,xi", "hu,chu", "zha", "qiang", "tang", "hua", "zhi,nai",
				"jiang,qiang", "gui", "ying", "ao,qiao", "zhi", "nie,che", "man", "chan,can", "kou", "chu", "se,mi,su",
				"tuan", "jiao,chao", "chan,xian,can,shan", "keng,qian", "biao", "jiang", "yao", "gou", "qian", "ji",
				"pie", "lao", "dun", "xian", "ruan", "gui", "zan,zen,qian", "yi", "xian", "cheng", "nao", "hong",
				"heng,guang", "da", "nian", "lin", "zheng,cheng", "hui,wei", "jiao", "ji", "cao", "dan", "dan,shan",
				"bo", "che", "jue", "xiao,sou", "ben", "fu", "zhuo", "wei,tuo", "pu", "qin", "dun", "hua", "jiao",
				"ta", "qiao,yao,ji", "zhua,wo", "jian", "yong", "nang", "lu", "zhuo", "ze,zhai", "pu", "chuo", "ji",
				"dang", "se", "qing,jing", "jie", "kuai", "dan", "xie", "qia,jia,ye", "ao", "ju", };
	}

	private static String[] init148() {
		return new String[] { "ye", "e", "meng", "mi", "ji", "tai", "dao", "lan", "ju", "ye", "ru", "ye", "ye", "ni",
				"huo", "jie", "bin", "ning", "ge", "zhi", "zhi,jie", "kuo", "mo", "jian", "xie", "lie,la", "tan",
				"bai", "sou", "lu", "li,luo,yue", "rao", "ti,zhi,zhai", "yang", "lei", "ca,sa", "shu", "zan", "nian",
				"xian", "jun,pei", "li,luo", "la,lai", "huan", "ying", "lu,luo", "long", "qian", "qian", "qian", "lan",
				"xian,jian", "ying", "mei", "chan", "weng", "cuan", "xie", "she,nie", "luo", "jun", "mi,mo", "chi",
				"zan,cuan", "luan", "tan", "li,shai", "dian", "wa", "dang", "jiao", "lan", "li,luo", "gui", "gui",
				"qi,yi,ji", "xun", "kao", "yi", "gan,han", "ban", "po", "dian", "kou", "min", "wu,mou", "he", "ce",
				"chu,shou", "ge,guo,e", "xu", "jiao", "chen", "shen", "duo,dui", "yu", "bai", "xu", "duo,dui", "nie",
				"dian", "duo,que", "yi", "ke", "yan", "qi,yi,ji", "tou", "xiao,xue", "duo,que", "yang", "xia", "min",
				"ai,zhu", "ai,zhu", "di", "chen", "shu,shuo", "liao", "qu", "xiong,xuan", "yi", "jiao", "shan", "jiao",
				"zhuo,zhu", "yi,du", "lian", "bi", "li,tai", "xiao", "xiao", "xue", "qi", "qi", "jue,jiao", "zhai",
				"lang", "ban", "yu,zhong", "lan", "wei,men", "sheng", "jia", "jia", "yu", "jiao", "tou,tiao", "dou",
				"yin,zhi", "qiang", "qu", "zhan", "zhuo", "zhuo", "zhuo", "qin", "lin", "zhuo", "chu", "duan", "zhu",
				"chan,jie", "hang", "pei", "liu,you", "mie", "qi", "pi,bi", "liu", "fu", "fang", "jing", "zhao", "yi",
				"shao", "jian", "e o si", "zhi", "fan", "piao", "fan", "zhan", "kuai", "sui", "yu", "ji", "ji", "huo",
				"xie", "tiao", };
	}

	private static String[] init149() {
		return new String[] { "tai,ying", "di,de", "xu", "chan", "yang", "shi", "min", "min", "tun,zhun", "chun", "wu",
				"bei", "ban", "jie", "sheng", "hu", "fang", "gui", "xuan", "fen", "qin", "hu", "yan", "ze", "fang",
				"shen", "ju", "yang", "bing", "xuan", "po", "zhen", "ling", "hao", "mo", "bian", "xu", "hun", "zong",
				"shi", "fei", "die,yi", "wen", "dong", "ai", "bing", "ang", "long", "kuang", "tiao", "shi", "huang",
				"xuan", "kui", "xu,kua", "jiao", "jin", "zhi", "tong", "hong", "gai", "xiang", "han", "jun", "xian",
				"kun", "zhou", "xi", "sheng", "zhe", "zhe", "wan", "hao", "wan", "tian", "zhuo", "zui", "zhou", "shan",
				"ni", "xi", "qi,du", "zheng", "yi", "an,yan", "wan", "lin", "cheng", "wang", "xiao", "fei", "xuan",
				"yi", "yun", "hui", "xu", "min", "ye", "ying", "shu,du", "wei", "qing", "mao", "nan", "jian,lan",
				"yang", "chun", "yao", "suo", "pu", "jiao", "kai", "hao", "weng", "chang", "qi", "hao", "yan", "li",
				"ji", "men", "zan", "xie", "hao", "mu", "cong", "ni", "zhang", "hui", "han", "xuan", "chuan", "liao",
				"tan", "jing", "pie", "lin", "xi", "yi", "ji", "huang", "dai", "ye", "ye", "li", "tan", "tong", "xiao",
				"fei", "shen", "zhao", "hao", "yi", "xiang", "xing", "shen", "jiao", "bao", "jing", "yan", "ai", "ye",
				"ru", "meng", "li", "chen", "kuang", "die", "uu", "yan", "huo", "lu", "rong", "long", "luo", "luan",
				"shai", "tang", "yan", "zhu", "yue", "ye", "hu", "shu", "cao", "sheng", "zeng,ceng", "can,qian,jian",
				"xu", "hui,kuai", };
	}

	private static String[] init150() {
		return new String[] { "yin", "qie,he", "fen", "bi,pi", "fen,ban", "ling", "fei,ku", "uu", "nv,ga", "tiao",
				"lang", "juan,zui", "ming", "huang,mang,wang", "tun", "ji", "ying", "zong", "wang", "tong,chuang",
				"lang", "lao", "long", "pin", "shu,zhu", "te wu le", "ren", "ba", "duo", "dao,tiao,mu", "li",
				"qiu,gui", "jiu", "bi", "cheng", "ci", "ru", "qian", "yu,wu", "wu", "xun", "fan", "zi", "ren,er",
				"tuo,zhe", "di,duo", "mang", "chi", "yi", "gu,gai", "gong", "yi,li,duo,tuo", "jie", "mian", "wan",
				"jiu", "mang", "si,zhi,xi", "yuan,wan", "fei,bei", "dong", "xian", "chun", "shu,dui", "hua", "xin",
				"niu,chou", "chou", "song", "wo,yue", "jin", "ji", "mao", "pi,mi", "ang", "fen", "yi", "fu", "nan",
				"hu,di", "ya", "dou", "xin", "yao", "e", "zhao", "yun", "hua", "sheng", "di,duo", "lu",
				"song,ma ti su", "zhan", "xian,zhen", "si,tai", "xi", "guai", "bao,fu", "mo", "yi,xie", "ye", "ye",
				"shi", "nie", "bi", "yi,duo,li", "ni,chi", "la", "he", "pan,ban", "fan", "zhong", "dai", "ci",
				"yang,ying", "fu", "mao", "shao", "song", "shen", "nan", "yong", "zhi,die", "zha,zu", "dan", "gu",
				"bu,pu", "ao", "fu", "ba,fu,pei,bo,bie", "duo,zuo,wu", "bi,bie", "shan", "si", "zhu", "bei,pei",
				"shi,fei", "guai", "cha,zha", "yao", "jiu", "liu", "mei", "li", "rong", "zao", "sa ying", "yong",
				"xun", "qi,qie", "chen", "yi", "xiang", "zhen", "li", "se", "kan", "ben,bing", "ren", "bai", "ren",
				"bing", "zi", "chou", "yi,xie", "ci", "jian,zun", "zui", "er", "er", "you,yu", "fa", "gong", "zhan",
				"lie", "yin", "zhi,yi", "shi", "fu", "ru", "yi,ti", "ku", "qiong", "sang", "xue", "duo", "chui",
				"yu,mou", "za,zan", "ka sei", };
	}

	private static String[] init151() {
		return new String[] { "ying", "jie", "liu", "zhan", "xun", "sha", "chen,zhen", "bei", "ting,ying", "gua",
				"jing", "bo", "ben,fan", "rui", "xi", "lang", "liu", "feng", "qi", "wen", "jun", "gan", "su,yin",
				"qiu", "you", "long", "peng", "zhuang", "di", "xuan,juan,xie", "tu,cha", "zao", "ao,you", "bi", "di",
				"han", "zhi", "ren,er", "bei", "jian", "huan", "wan", "nuo", "jia", "tiao", "ji", "xiao", "lv", "kuan",
				"chen", "fen", "song", "si,qi", "dou", "qin", "ying", "ju", "kun", "zhuo", "chan,yan", "wei", "jing",
				"li", "bin,bing", "xia", "xi ki mi", "chou,tao,dao", "zhi", "lai", "lian", "zhuo", "li", "qi", "bing",
				"lun", "cong,song", "qian", "qi", "cai", "chan", "de,zhe", "fei", "pai,bei,pei", "bang,pou,bei", "hun",
				"cheng", "zao", "li,lie", "yu", "yu", "gu", "jun", "dong", "gang", "wang", "que", "fan", "cheng",
				"zhan", "qi", "yuan", "yan", "yu", "quan,juan", "yi", "ren,shen", "qi", "zhuo", "fu,su", "lai",
				"zou,sou", "zou", "fen", "chen", "qing", "ni", "wan", "lu", "hao", "jie,qie", "chou,zhou,diao", "ju",
				"ju", "cheng,sheng", "zu,cui", "qiang,kong", "ya", "bei", "zhuo", "zi", "bin", "peng", "ding", "chu",
				"chang", "men", "hua", "jian", "gui", "xi", "dao", "gui", "dian", "zhi", "quan,juan", "mi eng", "fu",
				"geng", "peng", "shan", "yi", "sen", "duo,chuan", "fu", "wei,hui", "wei", "jia", "zong", "jian,han",
				"yi", "xi", "yan,ya", "yan", "jian", "yu", "he", "wo", "pian", "bi", "yao", "guo,kua", "xu", "ruo",
				"yang", "la", "yan", "ben", "hui", "kui", "jie", "kui", "si", "feng", "tuo", "ji,zhi", "mu", "mao",
				"ku,hu", "hu", "ting", };
	}

	private static String[] init152() {
		return new String[] { "yu", "you", "song,cong", "xuan,yuan", "yang,ying", "zhen", "pian", "die,ye", "jie",
				"ye", "shun,dun", "yu", "wei", "mei", "di,shi", "ji", "jie", "rou", "huang", "le,yue", "ha ni za wu",
				"ka tui la", "mu le", "tan", "wen,yun", "shen", "chu", "bi,pi", "jia", "yi", "zhan,nian,zhen", "fu,bo",
				"nuo", "mi", "gu", "jian,jin", "ta", "yao", "sha,xie", "yuan", "zi", "ming", "su", "jia", "yao", "jie",
				"huang", "gan", "qian", "ma", "yuan", "rong", "shi", "zhi", "wen", "ting", "rong", "tang", "zhai",
				"si", "sheng", "ke", "xi", "gu", "qi", "gao", "sun", "pan", "tao", "ge", "chun", "dian", "nou", "ji",
				"gou", "qiang", "qian,lian,xian", "mei", "xu", "gang", "zhuo", "tuo", "qiao", "yang", "dian,zhen",
				"jia", "zui", "dao", "long", "sang", "xi,die", "ji,gui", "lian", "hui", "rong,yong", "qian", "guo",
				"gai", "gai", "tuan,shuan,quan", "hua", "sen", "cui,zhi", "peng", "you,chao", "jiang", "hu", "huan",
				"gui", "nie", "yi", "gao", "kang", "gui", "gui", "man,wan", "di", "zhuang", "le,yue", "lang", "chen",
				"cong,zong", "li,chi", "xiu", "qing", "shang", "tong", "guan", "ze", "su", "lei", "lu", "liang", "mi",
				"lou", "chao,jiao", "su", "ke", "biao", "lu", "jiu,liao", "zhe", "zha", "shu", "man", "niao,mu",
				"yang", "tiao", "peng", "zhu", "sha,xie", "quan", "jian", "cong", "ji", "yan", "xue", "er", "xun",
				"zhi", "zui", "cong", "pu", "shu", "hua", "gui", "zhen", "shan", "xi", "chun", "dian", "fa,fei", "mo",
				"wu", "rao,nao", "lin", "liu", "qiao", "xian", "run", "fan", "zhan,jian", "liao", "yun", "shun",
				"tui,dun", "cheng", "tang,cheng", "meng", "su,qiu", };
	}

	private static String[] init153() {
		return new String[] { "jue", "tan,dian", "hui", "ji", "nuo", "tuo", "ning", "rui", "tong,chuang", "zeng,ceng",
				"fen,fei", "qiong", "ran,yan", "heng", "qian", "gu", "liu", "lao", "gao", "xi", "sheng", "za", "zan",
				"ji", "dou", "jing", "xian", "cu,chu", "ta", "shu,qiao", "jiang", "lin", "nong", "yin", "hui", "shan",
				"zui", "xuan", "cheng", "gan", "ju", "zui", "yi", "pu", "feng", "hui", "dang", "ji", "sui", "ping,bo",
				"cheng", "chu", "zhua", "gui,hui", "ji", "jie", "jia", "zhai,shi,tu", "jian", "qiang", "dao", "yi",
				"biao", "song", "she", "li", "yin", "chou,tao,dao", "tai", "mian", "qi", "tuan", "bin,bing", "huo",
				"ji", "qian,lian", "ni,mi", "ning", "yi", "gao", "jian,kan", "yin", "nou,ruan,ru", "qing", "yan", "qi",
				"mi", "zhao", "gui", "chun", "ji", "kui", "po", "deng", "chu", "ge", "mian", "you", "zhi",
				"huang,guo,gu", "qian", "lei", "lei", "sa", "lu", "li", "cuan", "lv,chu", "mie,mei", "hui", "ou", "lv",
				"zhi", "gao", "du", "yuan", "li,yue", "fei", "zhuo,zhu", "sou", "lian", "jiang", "chu", "qing", "zhu",
				"lu", "yan", "li", "zhu", "chen", "jue,ji", "e", "su", "huai,gui", "nie", "yu", "long", "la,lai",
				"qiao", "xian", "gui", "ju", "xiao", "ling", "ying", "jian", "yin", "you", "ying", "xiang", "nong",
				"bo", "chan,zhan", "lan", "ju", "shuang", "she", "wei,zui", "cong", "quan", "qu", "zang", "jiu", "yu",
				"luo", "li", "cuan", "luan", "dang", "qu", "e mi", "lan", "lan", "zhu", "lei", "li", "ba", "nang",
				"yu", "ling", "guan", "yu,yi", "qian,xian", "xu", "chao", "chu,qu,xi", "qi", "ke,ai", "yi,yin", "jue", };
	}

	private static String[] init154() {
		return new String[] { "xi,kai", "xu", "he", "kuai", "lang", "kuan", "shuo,sou", "ei,ai", "xu,chua",
				"chi,chuai", "qin", "kan,qian", "kuan", "kan,ke", "chuan", "gua", "yan,yin", "yu", "xiao", "ye", "wu",
				"tan", "jin,qun", "ou", "hu", "ti", "huan", "xu", "pen", "xi", "xiao", "xu", "shan", "lian,han", "chu",
				"yi", "e", "yu", "chuo", "huan", "bu", "bu", "ju", "qian", "zhi,chi", "se", "chi", "se,sha", "zhong",
				"sui", "sui", "li", "ze", "yu", "li", "gui", "dai", "zhe", "mo,wen", "mo", "yao", "sheng", "xu",
				"jing", "qia", "qiu", "su", "qing,jing", "yi", "fou,bo", "ye,yan", "can", "hun,mei", "die", "zhen",
				"yun", "wen", "chou", "ti", "jin", "shang", "yin", "chi", "jiu", "kui,hui", "cuan", "dan", "du",
				"jiang", "lian", "bin", "du", "jian", "jian", "zhu", "qing,keng,sheng", "yi", "sha", "ke,qiao",
				"ke,qiao", "xiao,yao", "xun", "hui", "qiao", "ji", "ou", "hui", "duan", "yi", "xiao", "guan,wan",
				"mei", "ai", "jie", "pi", "chan", "uu", "uu", "bi", "mao", "jia", "sai", "mu", "tuo", "xun", "er",
				"rong", "xian", "ju", "qiu", "dou,nuo", "uu", "pei", "ju", "duo", "bi", "san", "mao", "sai,sui", "shu",
				"tuo", "he", "ta", "san", "lv", "mu", "mao", "tong", "rong", "zhan", "sao", "zhan", "meng", "lu",
				"die", "jue", "qi", "yang,ri", "nei", "nei", "shen", "qi", "xi", "qing", "ya", "dong", "yang", "yun",
				"zheng,cheng", "bing", "dang", "shui", "le", "ni", "fan", "gui,jiu", "bin,pa", "ze", "mian", "diao",
				"zhuo,que", "chuan", "wan", "fan", "tai", "tuo", "mang", "qiu", "pin", "qian", };
	}

	private static String[] init155() {
		return new String[] { "wu", "wu", "tu", "jiu", "zhi,ji", "zhi", "qian", "jing", "jing", "rui", "jun", "hong",
				"tai", "bian", "gan,han,cen", "zhong", "fang,pang", "jue", "hu,huang", "niu,you", "xu", "xu", "yun",
				"yan", "dan", "you", "hu", "huo", "nv,niu", "mei,mo", "mi,wu", "chong", "hong,pang", "bi", "zhi",
				"pan", "zhui,zi", "za", "pai", "ze", "feng", "mei", "za", "tuo,duo", "li", "mi,li", "yi,chi", "fa",
				"tian", "si", "kuang", "jiong", "ju", "yi,die", "jia", "zhong", "hui", "ben", "ze", "chu,she",
				"you,ao", "gu", "hu", "peng,ping", "ci", "zhi", "su", "cheng", "si", "ju", "yue,sa", "sheng",
				"jue,xue", "fu", "ji", "guan", "dan", "yin", "pan", "yie", "hui", "zai", "cheng", "wei", "hou", "jian",
				"si", "er", "xing", "fu", "se,qi,zi", "zhi", "yin", "wu", "kao", "luo", "an,yan,e", "yi", "si", "lei",
				"yi", "mi", "quan", "po", "xiao", "xie", "su,shuo", "kuang", "qie,jie", "ju", "ping", "xiong", "zhi",
				"guang", "ming", "wu", "qu", "yi", "jing", "shi", "pe o le", "chan", "jin", "lie", "qiu", "wei", "han",
				"mang", "you,di", "bo", "dou", "hong", "yi", "ying,cheng", "lan", "han", "li", "geng", "li", "chun",
				"feng,hong", "yi", "tong", "lao", "jia", "chong", "jiong", "sui,nei", "cheng", "pei", "xian", "shen",
				"kun", "ping", "han", "jing", "nian", "tu", "xiao", "ting", "e", "tun,yun", "li", "shui", "si", "lei",
				"shui", "to ko", "yun", "heng", "xing", "shou,tao", "chuo", "zhang", "kong,nang", "wan,wo,yuan", "tuo",
				"dong", "wo", "ju", "she", "liang", "hun", "ta", "qie,ji", "de", "juan", "gu", "guo,guan", "yan", };
	}

	private static String[] init156() {
		return new String[] { "zhou", "peng", "hao", "chang", "qi", "fang", "zhi", "lu", "ju", "lei", "zhe",
				"ping,peng", "tian", "yu,xu", "ni", "lu", "mi", "jing,cheng", "ling", "lun", "qu", "yu", "nian,shen",
				"biao,hu", "hu", "yuan", "lai", "qing", "qian", "zhi", "yin", "bo", "ben", "yuan", "wen,min",
				"ruo,re,luo", "fei", "yuan", "ke", "ji", "she", "se", "yi", "pai", "xi", "yuan", "rou", "huan", "jian",
				"nuan", "qiu,wu", "ting", "feng", "wo,guo", "ti,di", "wei", "ru", "ce", "he", "yan", "hong", "mi",
				"mao", "ying", "yan", "hong,qing", "sheng", "mei", "zai", "hun", "nai", "gui", "chi", "e", "lian",
				"qi", "qi", "mei", "tian", "cou", "wei", "can", "hui,min,xu", "po", "xu", "ji", "jian", "feng", "yi",
				"yin", "shi", "jie", "zhen", "tan", "yu", "bi", "min,hun", "shi", "tu", "sheng", "yong", "ju", "dong",
				"tuan,nuan", "qiu,jiao", "qiu", "tang,shang", "long", "huo", "yuan", "nan", "ban,pan", "you", "quan",
				"zhuang,hun", "liang", "chan", "xian", "chun", "nie", "zi", "man", "ying", "la", "feng,hong", "lou",
				"wei", "bo", "ying", "ha tu", "jin", "yan,gui", "suo", "yuan", "lian,nian,xian", "yao", "meng", "zhun",
				"cheng", "tai", "da,ta", "wa", "gou", "sao", "zha", "shi", "lun", "ma", "wei", "zai", "wu", "wen",
				"qiang", "ze", "shi", "ai", "yun", "yin", "su", "suo", "shi", "ai", "pan", "chu,xu", "weng", "cang",
				"mie", "ge", "hao,xue", "huang", "qi,xi,xie", "di", "zhi", "xing,ying", "jie", "ge", "sui", "jiao",
				"hui", "yin", "ze,hao", "long", "chun", "yao", "yu", "xiu", "hu", "bi", "biao", "zhi", };
	}

	private static String[] init157() {
		return new String[] { "jiang", "kou", "shen", "shang", "mi", "ao", "lu", "hu,xu", "you", "chan", "fan", "yong",
				"gun", "man", "qing", "yu", "ji", "ya", "chao", "xi", "ji", "lou", "long", "jin", "guo", "cong,song",
				"zhi", "gai", "qiang", "jiao", "cong", "chun", "tuan,zhuan", "ou", "teng", "ye", "xi", "mi", "tang",
				"shang", "han", "lian", "wa", "chi", "gan", "feng,peng", "zi", "kang", "ben,peng", "zhang",
				"chong,zhuang", "xu", "huo,kuo", "jian", "yan", "shuang", "liao,liu", "cui", "ti", "jiang",
				"cong,zong", "ying", "hong", "xiu", "shu", "guan", "cong,zong", "kun", "xu", "zhi", "pi,pie", "yu",
				"jiao,qiao", "po", "dang,xiang", "hui", "jie", "wu", "pa", "ji", "wei", "su", "qian", "xi,ya", "xi",
				"xun", "dun", "min", "run", "su", "zhen", "cong,zong", "yi", "zhi", "wan", "tan,shan", "xun",
				"kui,hui", "ye", "tu,zha", "san,sa", "hei", "bi", "chan", "shu", "pu", "lin", "wei", "se", "se",
				"cheng", "jiong", "hua", "jiao", "lao", "cun", "jing", "han", "yun", "liu", "hong,gong", "fu", "hao",
				"he", "xian", "jian", "shan", "xi", "ao", "lu", "ning", "yu", "lin", "mian,sheng", "dang", "huan",
				"ze,shi", "xie", "yu", "shi", "xue", "ling", "wan,man", "zi", "yong", "kuai,hui", "can", "lian",
				"dian", "ye", "huan", "zhen", "man", "gan", "yi", "sui", "pi", "ju", "ta", "qin", "zhuo", "nong",
				"guo,wo", "jin", "fen,pen", "se", "ji,sha", "hui,huo", "chu", "ta", "song", "ding,ting", "se", "zhu",
				"lian", "mi,ni", "shi", "shu", "mi", "ning", "ying", "ying", "meng", "jin", "qi", "ji", "cui,zui",
				"wo", "tao", "yin", };
	}

	private static String[] init158() {
		return new String[] { "yin", "dui", "ci", "huo,hu", "qing", "lan", "jun,xun", "ai,kai,ke", "wei", "bin", "gu",
				"qian", "ying", "bin", "kuo", "fei", "cang", "bo ku", "jian", "wei,dui", "luo,po", "zan,cuan", "lv",
				"li", "you", "yang", "lu", "si", "zhi", "ying", "du,dou", "wang", "hui", "xie", "pan", "shen", "biao",
				"chan", "mie,mo", "liu", "jian", "se", "cheng,deng", "gu", "bin", "huo", "xian", "lu", "qin", "rong",
				"li", "jing", "xiao", "ying", "sui", "wei,dui", "huai,wai", "xue", "zhu", "long,shuang", "lai", "dui",
				"fan", "hu", "lai", "shu", "lian", "ying", "mi", "ji", "lian", "jian,zun", "ying", "lin", "yi", "jian",
				"chan", "dai", "rang,nang", "jian", "lan", "fan", "shuang", "yuan", "zhuo,jiao,ze", "feng", "she",
				"lei", "lan", "cong", "qu", "yong", "qian", "fa", "jue", "yan", "ying", "sa", "zan,cuan", "luan",
				"yan", "li", "mi", "shan", "tan", "dang,tang", "jiao", "chan", "ying", "hao", "zhu", "lan", "lan",
				"nang", "wan", "luan", "xun,quan", "xian", "yan", "gan", "yan", "yu", "guang", "xiao", "xiao", "hui",
				"hong", "zhuan", "zha,yu", "xie", "chi", "zai", "qi", "zhong", "fen,ben", "niu", "wen", "pu", "yi",
				"pi", "kai", "pan", "yan", "pang,feng", "mu", "liao", "guang", "xin", "guang", "guang", "bian", "da",
				"xia", "zheng", "zhu", "ke", "zhao", "fu", "ba", "xie", "xie", "ling", "zhuo,chu", "pao,fou", "tai",
				"yang", "tong", "shan,qian", "wei", "huang", "zhou", "jiao,yao", "xu", "heng", "quan", "huan", "xiao",
				"xiu", "xian", "yin", "wu", "zhou", "yao", "shi", "wei", "tong,dong", "mie", "zai", "kai", "xia", };
	}

	private static String[] init159() {
		return new String[] { "xuan", "zheng", "po", "hui", "guang", "che", "hui", "chen", "uu", "lie", "fu,pao",
				"jiong", "xie,che", "pu", "ting", "zhuo", "ting", "hai", "lang", "yan", "xu", "chi", "rong", "hu",
				"xi", "shu", "he", "xun,hun", "ku", "juan,ye", "xiao", "xi", "zhuang", "qu,jun", "di", "xie,che",
				"ji,qi", "uu", "l<", "yan", "ju", "lin", "kun", "hun", "tun", "xi", "cui", "wu", "hong", "chao,ju",
				"fu", "wo,ai", "zong,cong", "feng", "ping", "qiong", "ruo", "xi,yi", "qiong", "xin", "yi", "jue", "yu",
				"gang", "pi", "xiong,ying", "gang", "sheng", "chang", "shao", "xiong,ying", "ne mu", "geng", "qu",
				"chen", "he", "kui", "zhong", "xia", "hui,yun,xun", "feng", "lian", "xing", "jiao", "bi", "ying",
				"zhu", "wei", "tuan", "shan,qian", "xi,yi", "nuan", "nuan", "chan", "yan", "jiong", "jiong", "mei",
				"wei", "ye,zha", "jin", "qiong", "rou", "huan", "fan", "qiu", "sui", "yang", "lie", "jie", "zao",
				"gua", "yun", "nan", "shi", "huo", "gou", "tang", "chao", "en,yun", "bo", "huang", "xie", "xi", "wu",
				"yun", "he", "he,xiao", "xi", "yun", "xiong", "shan", "qiong", "yao", "mi", "lian", "ying", "wu",
				"gong", "yan", "qiang", "bi", "biao", "cong,zong", "lu,ao", "jian", "lou", "peng,feng", "sui,cui",
				"yi", "teng", "jue", "zong", "hu", "yi", "zhi", "wei", "liu", "han,ran", "ou", "re", "jiong", "kun",
				"cuan", "zeng", "jian", "xi", "xi", "yi", "xiao", "chi", "huang", "chan,dan", "ye", "tan", "yan",
				"xun", "qiao", "jun", "deng", "dun", "shen", "jiao,qiao,jue,zhuo", "fen", "si", "yu", "lin",
				"tong,dong", "shao", "fen", };
	}

	private static String[] init160() {
		return new String[] { "xun", "lan", "mei", "tang", "yi", "jiong", "men", "zhu", "uu", "ying", "yi", "xue",
				"lan", "tai,lie", "can", "xi", "que", "zong", "lian", "hui", "zhu", "ling", "wei", "yi", "xie", "zhao",
				"hui", "ta tui", "nong", "lan", "xu", "he", "xun", "jin", "chou", "dao", "yao", "he", "lan", "biao",
				"rong,ying", "li,lie", "mo", "ruo", "lv", "la,lie", "ao", "xun", "kuang,huang", "shuo", "liao", "li",
				"lu", "jue", "liao", "yan,xun", "xi", "xie", "long", "ye", "can", "rang", "yue", "lan", "cong",
				"chong", "guan", "qu", "che", "mi", "tang", "lan", "zhu", "lan", "ling", "yu", "zhao,zhua", "zheng",
				"pao", "cheng,chen", "wei", "han", "jue", "ye", "zu", "er", "chuang", "ke", "zang", "die", "qiang",
				"yong", "qiang", "pan", "chao", "jian", "chuang", "yu", "zha", "bian,mian", "bang", "bo", "chuang",
				"you,yong", "du", "cheng", "niu", "jiu,le", "ta", "ren", "mang", "fang", "gang", "yan", "ge,qiu",
				"bei", "si", "you,chou", "ke", "mu", "di", "quan", "quan", "zi", "mang", "keng", "qian", "li", "pou",
				"gang", "zhi,te", "ben", "quan", "chun", "jia", "feng", "ke", "ju", "chu", "xi", "bei", "luo", "jie",
				"ma", "san", "wei", "mao,li", "dun", "tong", "qiao", "xi", "li", "du", "lie", "bai", "piao", "bao",
				"xi", "chou", "wei", "kui", "chou", "quan,ba", "ji", "chai", "zhuo,bao", "ge", "kang,gang", "pei,fei",
				"hou", "ya", "yin", "huan,fan", "zhuang", "kuang", "zhong", "mu", "pi", "ju", "yi,quan,chi",
				"sheng,xing", "tuo,yi", "ling", "pi", "ni", "yao", "you", "xue", "dan", "bo", };
	}

	private static String[] init170() {
		return new String[] { "ku", "xian", "huan", "he,mo", "zhao", "jie", "xun", "shan", "ta,shi", "tong,dong",
				"lao", "mang,dou", "xi,shi", "xia", "bei", "zhi", "yan", "sha", "han", "jing", "pai", "fei", "xiao",
				"bai,pi", "qi", "biao", "yin", "lai", "jian,yan", "qiang", "kun", "yan", "zong", "zhi", "zheng",
				"ya,wei", "lie", "ce o n", "zong", "gui", "feng", "wo", "yuan", "chuan", "tuan", "ya,jia,qie",
				"xie,he,ge,hai", "jia", "bian,pian", "you", "yao", "sun", "bo,po", "ming", "sou", "ma", "huan", "dai",
				"yu", "shi", "hao", "qiang", "yi", "zhen", "cang", "hao,gao", "man", "jiang", "mo", "chan", "ao",
				"hao", "suo", "fen", "bi", "bi", "huang", "pu", "lin", "xu", "tong", "yao,xiao", "shuo,xi", "xiao",
				"shou", "du n", "jiao", "ge,lie,xie", "juan", "du", "hui", "kuai", "xian", "xian", "ning", "bian,pian", };
	}

	private static String[] init171() {
		return new String[] { "huo", "nou,ru", "meng", "lie", "nao,you", "guang", "shou", "lu", "ta", "xian", "mi",
				"rang", "nao,you", "luo", "xian", "qi", "jue", "miao", "zi", "lu", "su", "qiu", "ga", "le", "ba",
				"hong", "di", "chuan", "gan", "yu", "qi", "yu", "chang,yang", "hong", "wu", "fu", "jie", "ya", "bian",
				"bang", "yue", "jue", "men,yun", "jue", "jian,qian", "dan", "pin", "qiang,cang", "yi", "an,gan",
				"ping", "fu", "xuan,xian", "ci", "gou", "jia", "shao", "ci", "ran", "sheng", "shen", "yi,tai", "zu,ju",
				"liu", "bi", "zhen", "jin", "jiao", "jian", "li", "guang", "xian", "zhou", "yan", "xiu", "yang", "xu",
				"su", "qin", "yin,ken", "xun", "bao", "xiang", "xia", "gui", "chong", "xu", "pei", "lao", "dang",
				"ying", "wen", "e", "cheng", "di,ti", "wu", };
	}

	private static String[] init173() {
		return new String[] { "kun", "zhuan", "cong", "yi", "qi", "jing", "zao,suo", "qiu", "ao", "lian", "men", "yin",
				"ye", "zhi", "wu", "deng", "xiu", "zeng", "xun", "qu", "dang", "lin", "liao", "qiong,jue", "su", "gui",
				"jing", "fan", "jin", "liu", "ji", "hui", "jing", "ai", "zao", "dang", "jiao", "guan", "tan",
				"hui,kuai", "huan", "se", "sui", "tian", "chu", "yu", "jin", "lu,fu", "bin,pian", "shu", "zui", "lan",
				"xi", "ji,zi", "xuan", "ruan", "wo", "gai", "lei", "du", "li", "zhi", "rou", "li", "zan", "qiong",
				"ti", "gui", "sui", "la", "long", "lu", "li", "lan", "ying", "mi,xi", "xiang", "qiong,wei", "guan",
				"dao", "zan", "huan,ye,ya", "bo", "bo,pao", "zhi,hu", "li", "shiwa", "xiang,hong", "qianwa", "ban",
				"pen", "fang", "dan", "fenwa", "maowa", "ki ro ton,mao wa", };
	}

	private static String[] init172() {
		return new String[] { "wu", "cheng", "jun", "mei", "bei", "ting", "xian", "chu", "han", "xuan,qiong", "yan",
				"xuan", "xiu", "fu", "xi", "ling", "li", "jin", "suo", "feng", "wan", "dian", "pin,bing", "zhan",
				"cui,se", "min", "yu", "lai", "min", "sheng", "wei,yu", "tian", "shu", "beng,pei", "cheng", "e",
				"chang", "beng", "lu", "guan", "diao", "bei", "que", "zhuo", "qin", "fa", "jin", "du", "jie",
				"hun,hui", "yu", "mei", "chun", "xuan", "ti", "xing", "dai", "rou", "min", "jian", "wei", "ruan",
				"huan", "xie,jie", "chuan", "jian", "zhuan", "chang,yang", "lian", "quan", "duan", "ye", "huang",
				"liu", "shi", "rong", "suo", "yao", "wen", "wu", "zhen", "jin", "ying", "ma", "tao", "liu", "li",
				"lang", "tian,zhen", "qiang,cang", "cuo", "jue", "zhao", "bin,pian", "tu,shu", "chang", };
	}

	private static String[] init174() {
		return new String[] { "hu", "yi", "bai wa", "juan", "chang", "chi", "liwa", "dang", "wa", "zhui", "ping",
				"bian", "zhou", "li wa", "ci", "ying", "qi", "xian", "lou", "di", "ou", "zhuan", "lin", "wu", "dan",
				"weng", "ying", "yan", "tian", "han", "chang", "qing", "shen", "chan", "chan", "rui", "su", "shen",
				"lu", "beng", "you", "fu", "ping", "ting,ding", "zhen", "meng", "bi,qi", "mu", "xun", "liu", "mu",
				"yun", "fu", "geng", "jie", "fu,bi", "tian", "mu", "da bo", "jiang", "wa", "da,fu", "nan", "mu", "mu",
				"ce,ji", "zai,zi", "gai", "bi", "da", "zhi,chou,shi", "l<e", "fan,pan", "yi", "hua", "she,yu", "she",
				"mu", "jun", "yi", "liu", "die", "hua", "dang", "zhui", "jiang", "cheng", "chang", "tuan", "lei",
				"cha", "liu", "die", "lin", "jiang", "chou", };
	}

	private static String[] init175() {
		return new String[] { "pi", "die", "die", "jie,qie", "dan", "shu", "zhi,di", "nai", "bi", "gang", "zhou",
				"xia", "xu", "chen", "jue,xue", "qi", "ya,xia", "cui", "bi", "zong", "xue", "zhi", "fa,bian", "zhi",
				"fei", "gou", "shan,dian", "nie", "teng,chong", "tong", "jie", "wei,you,yu", "hui", "tan,shi", "zhi",
				"mei", "jing", "xiao", "tu", "mang", "xiao", "suan", "pu", "duo", "shou", "yi", "beng,peng", "zhang",
				"guan", "ma", "ma,lin", "ji", "tian,dian", "an,ye,e", "chi", "bi", "min", "dui", "ke,e", "ya", "cu",
				"shen", "zhong", "zhi,chi", "yu", "feng", "yang", "chen", "tu", "guo", "wen", "huan", "ku", "yin",
				"jue", "xi", "guan", "yi", "chuang", "hui,lei", "n<e,yao", "dian,chen", "zhang", "shen", "cu", "yi",
				"zong", "sou", "se", "diao", "lou", "lou", "qin", "fu", "liao", "qiao,jiao", };
	}

	private static String[] init176() {
		return new String[] { "liu", "lao", "xian", "fei", "dan", "yin", "he", "xian", "guan", "gui,wei", "nong", "yu",
				"wei", "yong", "lei", "li,lai", "shu", "dan", "lin", "lin", "bie", "ji", "chi", "yang", "jie", "zheng",
				"mo", "li", "huo", "lai", "ji", "xuan", "ying", "yin", "yong", "tan", "dian", "luo", "luan", "luan",
				"bo", "uu", "ba", "fa", "fa", "qie", "ji,bi", "zao", "mao", "pa,ba", "ci", "ling", "mo", "ji", "peng",
				"gao,yao", "e", "han", "bi", "chou", "qian", "ai", "xiao", "hao", "huang", "hao", "ze", "cui", "hao",
				"xiao", "ye", "hao", "jiao", "ai", "xing", "huang", "li,luo,bo", "piao", "he", "jiao", "gan", "pao",
				"qiu", "que", "zha", "gu", "jun", "jun", "zhou", "zha,cu", "gu", "zhao,zhan,dan", "du", "qi", "ying",
				"bei", "a,a", "a", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "ai", "an",
				"an", "an", "an", "an", "an", "an", "an", "an", "ang", "ang", "ang", "ao,wa", "ao", "ao", "ao", "ao",
				"ao", "ao,yu", "ao", "ao", "ba", "ba", "ba,pa", "ba", "ba,ba", "ba", "ba", "ba", "ba", "ba", "ba",
				"ba", "ba", "ba,pa", "ba", "ba", "ba,ba,pi", "ba", "bai", "bai,bo", "bai", "bai", "bai", "bai", "bai",
				"bai", "ban", "ban", "ban", "ban", "ban", "ban", "ban", "ban", "ban", "ban,pan", "ban", "ban", "ban",
				"ban", "ban", "bang", "bang", "bang", "bang", "bang", "bang", "bang", "bang,pang", "bang,beng", "bang",
				"bang", "bang", "bao", "bao", "bao", "bao", "bao,bo", };
	}

	private static String[] init177() {
		return new String[] { "diao", "he", "he", "bo", "wan", "yu", "fan", "fu", "qiu", "dao", "lu", "zhan", "li",
				"jin", "xu", "jian", "pan", "an", "lu", "xu", "zhou,chou", "dang", "an", "gu", "li", "gan",
				"mang,wang", "qi", "yuan", "xian,tian", "xin", "xi,pan", "feng", "min", "ming", "shi", "yun,hun",
				"pan", "fang", "mao", "xian", "shi", "yang,ying", "zheng", "yao,ao", "shen", "huo", "da", "zhen",
				"kuang", "ju,xu,kou", "shen", "mei", "mo,mie", "zhu", "zhen", "shi", "die,ti", "ni", "zi", "chao",
				"bing,fang", "pang,pan", "long", "tong", "die,zhi", "di", "ne", "ming", "xuan,shun,xun", "zhen",
				"yang", "mo", "zhong", "mo", "mei", "qiao,shao,xiao", "han", "huan", "cheng", "cuo,zhuai", "juan", "e",
				"mian", "xian", "xi", "kun", "shan", "tian", "gun", "wan", "leng", "shi", "qiong", "li", "zheng",
				"bao,bo", "bao", "bao", "bao,bu,pu", "bao", "bao", "bao", "bao", "bao,pu", "bao", "bao", "bao", "bei",
				"bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei", "bei,pi",
				"ben", "ben", "ben", "ben", "beng", "beng", "beng", "beng", "beng", "beng", "bi", "bi", "bi", "bi",
				"bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi", "bi,pi",
				"bi", "bi,bei", "bi", "bi", "bian", "bian", "bian", "bian", "bian,pian", "bian,pian", "bian", "bian",
				"bian", "bian", "bian", "bian", "biao", "biao", "biao", "biao", "bie", "bie", "bie", "bie", "bin",
				"bin", "bin", "bin", "bin", "bin", "bing", "bing", "bing", "bing", "bing", "bing", "bing", };
	}

	private static String[] init178() {
		return new String[] { "li", "lai", "sui,zui", "juan", "bi", "hun", "lu", "yi,ze,gao", "zhou", "yu", "hun",
				"ma", "xia", "xing", "hui", "hun", "zai", "chun", "jian", "mei", "hou", "xuan", "ti", "xu", "fa", "wo",
				"gui,wei,kui", "mi", "weng", "kou,ji", "dang", "chen", "qiong,huan", "mo", "fen", "ze", "zhang", "yi",
				"diao,dou", "kou", "mo", "shun", "cong", "lou,lv", "chi", "man,men", "gui", "wan", "run,shun", "xi",
				"pu", "shen", "liao", "che", "xian,jian", "ye", "xue", "wu,mi", "gui,kui", "jian", "ye", "ai", "hui",
				"jian", "zhao", "wei", "chou", "sao", "ning,cheng", "xun", "yao", "huo,yue", "meng", "mian", "pin",
				"mian", "lei", "kuang,guo", "xuan", "mian", "huo", "lu", "meng", "long", "guan,quan", "man", "xi",
				"tang", "kan", "zhu", "jin,qin,guan", "yu,xu,jue", "shuo", "ze", "jue", "shen", "bing", "bing", "bo",
				"bo", "bo", "bo", "bo", "bo", "bo", "bo,bei", "bo", "bo", "bo", "bo,bai,ba", "bo", "bo", "bo", "bo",
				"bo", "bo,po", "bo", "bu", "bu,bo", "bu", "bu", "bu", "bu,fou", "bu", "bu", "bu,bo", "bu", "bu", "ca",
				"cai", "cai", "cai", "cai", "cai", "cai", "cai", "cai", "cai", "cai", "cai", "can", "can,shen,cen,san",
				"can", "can", "can", "can", "can", "cang", "cang", "cang", "cang", "cang,zang", "cao", "cao", "cao",
				"cao", "cao", "ce", "ce", "ce,ze,zhai", "ce", "ce", "ceng", "ceng", "cha", "cha", "cha", "cha",
				"cha,zha", "cha", "cha", "cha", "cha", "cha,chai,ci", "cha", "chai,ca", "chai", "chai", "chan",
				"chan,xian,can,shan", "chan", "chan", "chan", "chan", "chan", "chan", "chan", "chan,zhan", "chang",
				"chang", };
	}

	private static String[] init179() {
		return new String[] { "hou", "ying", "zhou", "jiao", "zeng", "yue", "ba", "ding", "qi", "zi", "wu", "zhe",
				"ku", "gang,qiang,kong", "dan", "jue", "li", "fu", "min", "e", "kang", "zhi", "jie", "pin,bin,fen",
				"e", "zhe", "sui", "wa", "jin", "mo", "ju", "yu", "ke,luo", "tuo", "e", "mu", "zhu", "nu", "ping",
				"ling", "pao", "le", "bo", "po", "yong", "kuang", "keng", "quan", "zhu", "kuang,guang", "e", "qia",
				"lu", "wei,gui", "ai", "ken,xian,gun,yin", "yan", "peng,ping", "lBo", "hong", "qing", "wei,ai,gai",
				"qiao", "ce o ke", "keng", "que,ke,ku", "chan", "lang", "hong", "yu", "xiao", "xia", "mang,bang",
				"luo,long", "yong,tong", "che", "che", "yan", "sha", "kun", "yu", "ze xi", "huB", "lu", "chen", "n<e",
				"song", "zhuo", "keng", "yan", "zhui,chui,duo", "kong", "cheng", "qi", "zong,cong", "qing", "chang",
				"chang", "chang", "chang", "chang", "chang", "chang,an,han", "chang", "chang", "chang", "chang",
				"chao", "chao", "chao", "zhao,chao", "chao,zhao", "chao", "chao", "chao", "chao", "che", "che", "che",
				"che", "che", "che", "chen", "chen", "chen", "chen", "chen", "chen", "chen", "chen", "chen", "chen",
				"cheng", "cheng,chen", "cheng", "cheng", "cheng", "cheng", "cheng,sheng", "cheng", "cheng",
				"cheng,deng", "cheng", "cheng", "cheng", "cheng", "cheng", "chi", "chi", "chi", "chi,shi", "chi",
				"chi", "chi", "chi", "chi", "chi", "chi", "chi,che", "chi", "chi", "chi", "chi", "chong", "chong",
				"chong", "chong", "chong", "chou", "chou", "chou", "chou", "chou", "chou", "chou", "chou,qiu", "chou",
				"chou", "chou", "chou,xiu", "chu", "chu", "chu", "chu", "chu", "chu", "chu", "chu", "chu", "chu", };
	}

	private static String[] init180() {
		return new String[] { "lin", "jun", "bo", "min", "jian,zhan", "he", "que,xi", "leng", "yin", "wu", "qi", "lun",
				"nao,gang", "ruan", "yan", "ding", "tuo", "ying", "ke", "wei", "shuo,shi", "zhen", "duan", "xia",
				"dang", "ti,di", "nao", "tian", "qi", "dun", "feng", "que", "que,qiao", "ma", "gong", "su,xie", "e",
				"liu", "si,ti", "tang", "hua,ke,gu", "pi", "kui,wei", "tian", "xia,qia,ya", "xi", "lian,qian",
				"wei,ai,gai", "yun", "dui", "la", "zhuan", "yao", "zhuan", "chan", "qi", "ao,qiao", "peng", "liu",
				"lu", "kan", "chuang", "chen", "yin", "lei", "biao", "qi", "qi,zhu", "cui", "zong", "chuo", "lun",
				"ji", "shan", "lao,luo", "zeng", "jian", "xi", "ding", "dian", "pan,bo", "ji,she", "qiao", "di", "li",
				"jian", "xi", "zhang", "qiao", "jian", "yu", "zhui", "he,qiao", "ke,huo", "ze", "lei", "chu", "chu",
				"chu", "chu", "chu", "chu", "chuai,tuan,zhui", "chuan", "chuan", "chuan", "chuan,zhuan", "chuan",
				"chuan", "chuan", "chuang", "chuang", "chuang,zhuang", "chuang", "chuang", "chuang", "chui", "chui",
				"chui", "chui", "chui", "chun", "chun", "chun", "chun", "chun,zhun", "chun", "chun", "chuo",
				"chuo,chao", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "ci", "cong", "cong",
				"cong", "cong", "cong,zong", "cong", "cou", "cu", "cu", "cu", "cu", "cuan", "cuan", "cuan", "cui",
				"cui", "cui", "cui", "cui", "cui", "cui", "cui", "cun", "cun", "cun", "cuo", "cuo,zuo", "cuo", "cuo",
				"cuo", "cuo", "da", "da", "da", "da,dB", "da", "da,dai,tai", "dai", "dai", "dai", "dai", "dai", "dai",
				"dai", "dai", "dai", "dai", "dai", };
	}

	private static String[] init181() {
		return new String[] { "jie", "chu", "ye", "que,hu", "dang", "yi", "pi", "pi", "yu", "pin", "e,qi", "ai", "ke",
				"jian", "yu", "ruan", "pao", "ci", "bo", "yBng", "mie", "xian,xin", "kuang", "lei", "lei", "zhi", "li",
				"li", "fan", "que", "pao", "ying", "li", "long", "long", "mo", "shuang", "guan", "jian", "ca", "yan",
				"reng", "yue", "ta", "ma", "xie", "yao", "zhi,qi", "beng,fang", "dui", "zhong", "ren", "yi", "shi",
				"you", "zhi", "tiao", "fu", "mi,bi", "suan", "mei", "chai", "lv", "yu", "wu", "zhu", "gui", "xia",
				"zhi", "gao", "gao", "shui,lei", "jin", "shen", "gai", "kun", "di", "tao", "gu", "guan", "zui", "ling",
				"lu", "dao", "zhi", "bi,pi", "chu", "hui", "you,chao", "yin", "zi", "huo", "zhen", "yuan", "xu",
				"xian", "dai", "dan", "dan", "dan", "dan,shan,chan", "dan", "dan,shan", "dan", "dan", "dan", "dan",
				"dan,da", "dan", "dan", "dan,tan", "dan", "dang", "dang", "dang", "dang", "dang", "dao", "dao", "dao",
				"dao", "dao", "dao", "dao", "dao", "dao", "dao", "dao", "dao", "de", "de,dei", "di,de", "deng", "deng",
				"deng", "deng", "deng", "deng", "deng", "di", "di", "di", "di", "di", "di", "di", "di", "di,zhai",
				"di", "di", "di,de", "di,de", "di", "di", "di", "di,ti,tui", "di", "di", "dian", "dian", "dian",
				"dian", "dian", "dian", "dian", "dian", "dian", "dian,tian", "dian,tian,sheng", "dian", "dian", "dian",
				"dian", "dian", "diao", "diao", "diao", "diao", "diao", "diao", "diao", "diao", "diao", "die", "die",
				"die", "die", "die", "die", "die", };
	}

	private static String[] init182() {
		return new String[] { "shang,yang", "ti,zhi", "yi", "mei", "si", "di", "bei", "zhen", "ying", "ji", "gao",
				"tang", "si", "ma", "ta", "fu", "xuan", "qi", "yu", "ji", "si", "shan,chan", "dan", "gui", "sui", "li",
				"nong", "mi", "dao", "li", "yue", "ti", "zan", "lei", "rou", "xie", "tu", "ren", "zi", "cha,na",
				"yi,zhi", "xian", "nian", "qiu", "fen", "hao,mao", "yun", "zhi", "jing", "zhi", "yu", "ku", "ban",
				"pi", "ni", "li", "you", "pi", "bo", "ling", "nian", "zuo", "di", "ju", "huo,kuo", "tong", "shi,zhi",
				"huo,kuo", "huo", "yin", "zi", "zhi", "ren", "du", "zhu", "nong", "fu,pu", "gao", "xun,ze", "shui",
				"kun", "gan", "jing", "ti", "tu,shu", "ya", "lun", "lu", "gu", "zuo", "zhun", "bang", "ji,qi", "zhi",
				"kun", "leng,ling", "ding,zheng", "ding", "ding", "ding", "ding", "ding", "ding", "ding", "ding",
				"diu", "dong", "dong", "dong", "dong", "dong", "dong", "dong,tong", "dong", "dong", "dong", "dou",
				"dou", "dou", "dou", "dou", "dou", "dou", "du,dou", "du", "du,dai", "du", "du", "du,dou", "du", "du",
				"du", "du", "du", "du", "du,duo", "du", "du", "duan", "duan", "duan", "duan", "duan", "duan", "dui",
				"dui,rui,yue", "dui", "dui", "dun", "dun", "dun", "dun,dui", "dun", "dun,tun", "dun", "dun", "dun",
				"duo", "duo", "duo", "duo", "duo", "duo", "duo", "duo", "duo", "duo", "duo", "duo,hui", "e,yi", "e",
				"e", "e", "e", "e", "e", "e,wu", "e", "e", "e", "e", "e", "en", "er", "er", "er", "er", "er", "er",
				"er", };
	}

	private static String[] init183() {
		return new String[] { "peng", "bing", "zui,zu,su", "yu", "l<e", "uu", "yi", "xi,qie", "bian", "ji", "fu",
				"pi,bi", "nuo", "jie", "zhong", "zong", "xu", "cheng,chen", "dao", "xian,jian,lian", "zi,jiu", "yu",
				"xu", "zhi", "gao", "gu", "rong", "sui", "rong", "ji", "kang", "can,shan,cen", "men,mei", "zhi", "ji",
				"lu", "su", "ji", "ying", "wen", "qiu", "ke we o ke", "yi", "huang", "qie", "ji", "xiao,rao", "pu",
				"jiao", "zhuo,bo", "tong,zhong", "zuo", "lu", "sui", "nong", "se", "hui", "rang", "nuo", "yu", "pin",
				"ji", "tui", "wen", "cheng,chen", "huo", "kuang", "lv", "biao,pao", "se", "zhuo,jue", "li", "cuan,zan",
				"wa", "yu", "shen", "jing", "yao", "lao", "yao", "bao", "bing", "wa", "zhu,ku", "jiao,liao,liu",
				"diao", "wu", "wa,gui", "chuang", "yao", "xiao", "cheng", "kou", "dan", "zhuo", "huo", "er", "fa",
				"fa", "fa", "fa", "fa", "fa", "fa", "fa", "fan", "fan", "fan,pan", "fan", "fan", "fan", "fan",
				"fan,po", "fan", "fan", "fan", "fan", "fan", "fan", "fan", "fan", "fan", "fang", "fang", "fang",
				"fang", "fang", "fang", "fang", "fang", "fang", "fang", "fang", "fei", "fei", "fei", "fei", "fei",
				"fei", "fei", "fei", "fei", "fei", "fei", "fei", "fen", "fen", "fen", "fen", "fen", "fen", "fen",
				"fen", "fen", "fen", "fen", "fen,bin", "fen", "fen", "fen", "feng", "feng", "feng", "feng", "feng",
				"feng", "feng", "feng", "feng", "feng", "feng,ping", "feng", "feng", "feng", "feng", "fo,fu,bi,bo",
				"fou,pi", "fu", "fu", "fu", "fu", "fu", "fu,bi", "fu", "fu", "fu", "fu", "fu", "fu", "fu", };
	}

	private static String[] init184() {
		return new String[] { "su", "guan", "zhuo", "wo", "wa", "ya,ye", "qiong", "yao", "yao", "tiao", "chao",
				"tian,dian,yan", "diao", "ju", "liao", "xi", "wu", "kui", "chuang", "chao,ke", "kuan,cuan",
				"kuan,cuan", "cheng", "cui", "liao", "zao", "cuan", "qiao", "qiong", "dou", "zao", "long", "qie",
				"chu", "shi", "fu", "qiBn", "chu,qi", "hong", "qi", "hao", "sheng", "fen", "miao", "qu,kou", "zhu",
				"ling", "long", "bing", "bai", "si", "hong", "jing,zhen", "diao", "yi", "shu", "jing", "qu", "ping",
				"li", "zhuan", "ceng,zeng", "deng", "cun", "wai", "jing", "kan", "jing", "le,jin", "peng", "chi",
				"mang", "zhu", "wan", "jiao", "suan", "qin", "ya", "zhui,rui", "yuan", "hang", "cen,jin,han", "pi,bi",
				"yi", "dong", "shan", "da,xia,na", "zhu", "na", "gu", "qie", "min", "bao", "ce", "fa", "ling", "fu",
				"fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu,pi",
				"fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "fu", "ga", "ga",
				"gai", "gai", "gai", "gai", "gai,ge,he", "gai", "gan", "gan", "gan", "gan", "gan", "gan", "gan", "gan",
				"gan", "gan", "gan", "gang", "gang", "gang", "gang", "gang", "gang", "gang", "gang,jiang", "gang",
				"gao", "gao,yao", "gao", "gao", "gao", "gao", "gao", "gao", "gao", "gao", "ge", "ge", "ge", "ge", "ge",
				"ge", "ge,yi", "ge", "ge", "ge", "ge", "ge,ha", "ge", "ge", "ge", "ge", "ge", "gei,ji", "gen", "gen",
				"geng", "geng", "geng", "geng", };
	}

	private static String[] init185() {
		return new String[] { "nu", "fu,fei", "fan", "ge", "fan", "shi", "mao", "ti", "qiong", "min", "luo", "gui",
				"qu", "chi", "yin", "yao", "bi", "kuo", "jiao", "sun", "ru", "ji", "hang", "zhong", "lai", "dang",
				"ce", "fu", "tu", "li", "lang", "ju", "guan", "jian", "han", "tong", "xia", "zhi", "cheng", "suan",
				"zhu", "zuo", "ting", "ce", "gao", "gan", "kuang", "yun", "o", "xiao", "pou,bu,fu,pu", "lai", "zou",
				"pai,bei", "bi", "ge", "tai,chi", "guai,dai", "yu", "jian", "zhao,dao", "chi", "zheng", "sha", "zhou",
				"lu", "lin", "jun,qun", "fu", "zha", "gu", "quan", "jun", "chui", "ce", "zu", "po", "xuan", "bian",
				"sun", "xian", "ping", "xing", "hu", "shi,yi", "yue,yao,chuo", "chun", "lv", "wu", "dong",
				"shuo,xiao,qiao", "ji", "jie", "xing", "mei", "fan", "geng", "geng", "geng", "gong", "gong", "gong",
				"gong", "gong", "gong", "gong", "gong", "gong", "gong", "gong", "gong", "gong", "gong", "gong", "gou",
				"gou", "gou", "gou", "gou", "gou", "gou", "gou", "gou", "gu", "gu", "gu", "gu", "gu", "gu", "gu", "gu",
				"gu", "gu", "gu", "gu", "gu", "gu", "gu", "gu", "gu", "gu", "gua", "gua", "gua", "gua", "gua", "gua",
				"guai", "guai", "guai", "guan", "guan", "guan", "guan", "guan", "guan", "guan", "guan", "guan", "guan",
				"guan", "guang", "guang,an", "guang", "gui", "gui", "gui", "gui", "gui", "gui,jun,qiu", "gui", "gui",
				"gui", "gui", "gui", "gui", "gui,ju", "gui", "gui", "gui", "gun", "gun", "gun,hun", "guo", "guo",
				"guo", "guo", "guo", "guo", "ha", };
	}

	private static String[] init186() {
		return new String[] { "chuan", "feng", "zhu", "hong", "qie", "qiu", "miao", "qian", "gu", "yi", "yun", "he",
				"tang", "yue", "chou", "ruo", "zheng", "nie", "qian", "xiao", "gong,gan,long", "peng,pang", "du",
				"zhuo,huo", "chu", "shai", "zhu", "qiang,cang", "long", "jian", "bu", "hui", "bi", "zhu,di", "cong",
				"yan", "cen,zan,can", "zhuan,zuan,suan", "pi", "piao,biao", "yu", "tuan,zhuan", "ze", "shai",
				"guo,gui", "yi", "hu", "chan", "kou", "ping", "zao", "ji", "lou", "ce,ji", "nian", "suo", "cuan",
				"sa sa la", "suo", "le", "zhu", "xiao", "bo", "mi,mie", "shai,si", "dang", "liao", "dan", "fu", "jian",
				"min", "kui", "dai", "jiao", "sun,zhuan", "lao", "xiao", "lu", "shi", "zan", "qi", "pai", "qi", "pai",
				"gan", "ju", "lu", "lu", "yan", "dang", "sai", "zhua", "gou", "qian", "lian", "shi", "hai", "hai",
				"hai", "hai", "hai", "hai", "hai", "han", "han", "han", "han", "han", "han", "han", "han", "han",
				"han", "han", "han", "han", "han", "han", "han", "han", "han", "han", "hang,ben", "hang", "hang",
				"hao", "hao", "hao", "hao", "hao", "hao", "hao", "hao", "hao", "he,a,ke", "he,ye", "he", "he", "he,hu",
				"he", "he,huo,hu", "he", "he,ge", "he", "he,hao,mo", "he", "he", "he", "he", "he", "he", "he",
				"hei,mo", "hei", "hen", "hen", "hen", "hen", "heng,hng", "heng,peng", "heng", "heng", "heng", "hong",
				"hong", "hong", "hong", "hong", "hong", "hong", "hong", "hong,gong", "hou", "hou", "hou", "hou", "hou",
				"hou", "hou", "hu", "hu", "hu", "hu", "hu", "hu", "hu", "hu", "hu", "hu", "hu", };
	}

	private static String[] init187() {
		return new String[] { "lan", "kui", "yu", "yue", "hao", "zhen,jian", "tai", "ti", "nie", "chou", "yi", "qi",
				"teng", "zhuan", "zhou", "fan,pan,bian", "sou,shu", "zhou", "qian", "zhuo", "teng", "lu", "lu", "jian",
				"tuo", "ying", "yu", "lai", "long", "shen shi,sen si,qie", "lian", "lan", "qian", "yue", "zhong", "qu",
				"lian", "bian", "duan", "zuan", "li", "shai", "luo", "ying", "yue", "zhuo", "yu", "fan", "shen", "zhe",
				"shen", "nv", "he", "ni", "cun", "zhang", "qian", "zhai", "bi", "ban", "wu", "sha,chao", "kang,jing",
				"rou", "bi", "cui", "yin", "zhe", "mi", "ta", "hu", "gan", "ju", "yu", "zhou", "chi", "su", "hong",
				"tong", "ce,se", "lin", "zhuang", "bai", "lao", "er", "qu", "he", "xian", "fu", "li", "yue", "lu",
				"ju", "qi", "bai", "zhang", "hu", "hu", "hu,xia", "hu", "hu", "hu", "hu", "hua", "hua", "hua", "hua",
				"hua", "hua", "hua", "hua", "hua", "huai", "huai", "huai", "huai", "huai,pei,pi", "huan", "huan",
				"huan", "huan,hai", "huan", "huan", "huan", "huan", "huan", "huan", "huan", "huan", "huan", "huan",
				"huang", "huang", "huang", "huang", "huang", "huang", "huang", "huang", "huang", "huang", "huang",
				"huang", "huang", "huang", "hui", "hui", "hui", "hui", "hui", "hui", "hui", "hui", "hui", "hui", "hui",
				"hui", "hui", "hui", "hui", "hui,kuai", "hui", "hui", "hui", "hui", "hui", "hun", "hun", "hun", "hun",
				"hun", "hun", "huo", "huo", "huo", "huo", "huo", "huo", "huo", "huo", "huo", "huo", "ji", "ji", "ji",
				"ji", "ji", "ji,qi", "ji", "ji", };
	}

	private static String[] init188() {
		return new String[] { "guo", "hua", "shen", "tang", "bian", "mian", "zong", "jian", "li", "xie", "fu", "nuo",
				"bei", "gu,gou", "xiu", "jia", "zhuang", "tang", "san,shen", "fen", "jiang", "mo", "san,shen", "san",
				"nuo", "xi", "liang", "kuai", "bo", "huan", "shu", "zong", "xian", "tuan", "nie", "li", "zuo", "di",
				"nie", "tiao", "lan", "si", "jiu", "gong", "zheng", "jiu", "gong", "ji", "cha", "zhou", "xun",
				"yue,yao", "hong,gong", "yu", "he,ge", "wan", "ren", "wen", "qiu", "na", "zi", "tou", "niu", "fou",
				"ji,jie", "shu", "chun", "pi,bi", "zhen", "sha", "hong", "zhi", "ji", "fen", "yun", "ren", "dan",
				"jin", "fang", "cui", "jiu", "zha,za", "ha", "fu", "zhi", "qi", "chou", "hong", "zha,za", "xi", "fu",
				"xie", "shen", "bo,bi", "zhu", "qu", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji,qi", "ji",
				"ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji",
				"ji", "ji", "ji", "ji,qi", "ji,zhai", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji", "ji",
				"ji", "ji", "jia", "jia", "jia,ga,xia", "jia", "jia,jia", "jia", "jia", "jia", "jia", "jia", "jia",
				"jia", "jia", "jia,jie", "jia", "jia", "jia", "jian", "jian", "jian", "jian", "jian", "jian", "jian",
				"jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian",
				"jian", "jian", "jian", "jian", "jian,kan", "jian", "jian", "jian", "jian,xian", "jian", "jian",
				"jian", };
	}

	private static String[] init189() {
		return new String[] { "ling", "zhu", "shao", "gan", "yang", "fu", "tuo", "zhen,tian", "dai", "chu", "shi",
				"zhong", "xian", "zu", "jiong", "ban", "qu", "mo", "shu", "zui", "kuang", "jing", "ren", "hang", "xie",
				"jie", "zhu", "chou", "gua,kua", "bai,mo", "jue", "kuang", "hu", "ci", "huan,geng", "geng", "tao",
				"xie,jie", "ku", "jiao", "quan,shuan", "gai,ai", "luo,lao", "xuan", "beng,bing,peng", "xian", "fu",
				"gei,ji", "tong,dong", "rong", "tiao,diao,dao", "yin", "lei", "xie", "juan", "gai,hai", "die", "tong",
				"si", "jiang", "xiang", "hui", "jue", "jian", "juan", "chi,zhi", "mian,wen,man,wan", "zhen", "lv",
				"cheng", "qiu", "shu", "bang", "tong", "xiao", "huan,wan", "qin,xian", "geng", "xu", "ti", "xiu",
				"xie", "hong", "xi", "fu", "ting", "sui", "dui", "kun", "fu", "jing", "hu", "zhi", "yan,xian", "jiong",
				"feng", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jian", "jiang", "jiang", "jiang",
				"jiang", "jiang", "jiang,qiang", "jiang", "jiang", "jiang", "jiang", "jiang", "jiang", "jiang", "jiao",
				"jiao", "jiao", "jiao", "jiao", "jiao", "jiao", "jiao", "jiao", "jiao", "jiao,jue", "jiao", "jiao",
				"jiao", "jiao,yao", "jiao", "jiao", "jiao,jue", "jiao", "jiao,zhuo", "jiao", "jiao,chao", "jiao",
				"jiao", "jiao", "jiao", "jiao", "jiao", "jie,qi", "jie", "jie", "jie", "jie", "jie", "jie", "jie",
				"jie", "jie,ju", "jie", "jie", "jie", "jie", "jie", "jie", "jie,xie", "jie", "jie", "jie,ji",
				"jie,gai", "jie", "jie", "jie", "jie", "jie", "jie", "jin", "jin", "jin", "jin", "jin", "jin", "jin",
				"jin", "jin", "jin", "jin", "jin", "jin", "jin", "jin", "jin", "jin", "jin", };
	}

	private static String[] init190() {
		return new String[] { "ji", "xu", "ka sei", "zong,zeng", "lin,chen", "duo", "li,lie", "lv", "jing", "chou",
				"quan", "shao", "qi", "zhun", "ji,qi", "wan", "qian,qing,zheng", "xian", "shou", "wei", "tao", "wan",
				"gang", "wang", "beng", "zhui", "cai", "guo", "cui", "lun,guan", "liu", "qi", "zhan", "bi",
				"chuo,chao", "ling", "mian", "qi", "ji", "tian,tan,chan", "zong", "gun", "zou", "xi", "zi", "xing",
				"liang", "jin", "fei", "rui", "min", "yu", "zong", "fan", "lv,lu", "xu", "ying", "shang", "zi", "xu",
				"xiang", "jian", "ke", "xian", "ruan", "mian", "ji,qi", "duan", "chong,zhong", "di", "min", "miao,mao",
				"yuan", "xie,ye", "bao", "si", "qiu", "bian", "huan", "geng", "zong", "mian", "wei", "fu", "wei",
				"tou,xu,shu", "gou", "miao", "xie", "lian", "zong", "bian,pian", "gun,yun", "yin", "ti", "gua,wo",
				"jin", "jin,jing", "jing", "jing", "jing", "jing", "jing", "jing", "jing", "jing", "jing", "jing",
				"jing", "jing", "jing", "jing,ying", "jing,geng", "jing", "jing", "jing", "jing", "jing", "jing",
				"jing", "jing", "jing", "jing,cheng", "jiong", "jiong", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu",
				"jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "jiu", "ju", "ju,gou", "ju",
				"ju", "ju", "ju", "ju", "ju", "ju,zui", "ju", "ju", "ju", "ju", "ju", "ju", "ju", "ju", "ju", "ju",
				"ju", "ju", "ju,gou", "ju", "ju", "ju", "juan", "juan", "juan", "juan", "juan", "juan", "juan", "jue",
				"jue", "jue", "jue", "jue", "jue", "jue,jiao", "jue", "jue", "jue", "jun", "jun", "jun", "jun", "jun",
				"jun", };
	}

	private static String[] init191() {
		return new String[] { "zhi", "yun,wen", "cheng", "chan", "dai", "xie", "yuan", "zong", "xu", "sheng",
				"ou duo xi", "geng", "se o ne", "ying", "jin", "yi", "zhui", "ni", "bang", "gu,hu", "pan", "zhou",
				"jian", "ci,cuo,suo", "quan", "shuang", "yun,wen", "xia", "cui,sui,shuai", "xi", "rong", "tao", "fu",
				"yun", "zhen", "gao", "ru", "hu", "zai,zeng", "teng", "xian,xuan", "su", "zhen", "zong", "tao",
				"huang ho ro", "cai", "bi", "feng", "cu", "li", "suo,su", "yan,yin", "xi", "zong", "lei", "zhuan,juan",
				"qian", "man", "zhi", "lv", "mu,mo", "piao", "lian", "xuan", "zong", "ji", "shan", "sui", "lv", "beng",
				"yi", "sao", "mou,miu,miao,mu,liao", "qiang", "sheng", "xian", "ji", "zong", "xiu", "ran", "xuan",
				"sui", "qiao", "zeng", "zuo", "zhi", "shan", "san", "lin", "ju,jue", "fan", "liao", "chuo", "zun",
				"jian", "jun", "jun", "jun,xun", "jun", "jun", "ka", "ka,ga", "qia,ka", "ka,luo,lo,ge", "kai", "kai",
				"kai,jie", "kai", "kai", "kan", "kan", "kan", "kan", "kan", "kan", "kang", "kang", "kang", "kang,gang",
				"kang", "kang", "kang", "kao", "kao", "kao", "kao", "ke", "ke,he", "ke", "ke", "ke", "ke", "ke",
				"ke,qiao", "ke,hai", "ke", "ke", "ke", "ke", "ke", "ke", "ken", "ken", "ken", "ken", "keng",
				"hang,keng", "kong", "kong", "kong", "kong", "kou", "kou", "kou", "kou", "ku", "ku", "ku", "ku", "ku",
				"ku", "ku", "kua", "kua", "kua,ku", "kua", "kua", "kuai", "kuai", "kuai", "kuai", "kuan", "kuan",
				"kuang", "kuang", "kuang", "kuang", "kuang", "kuang", "kuang", "kuang", "kui", "kui", "kui", "kui",
				"kui", "kui", "kui", "kui,gui", };
	}

	private static String[] init192() {
		return new String[] { "rao", "chan", "rui", "xiu", "hui", "hua", "zuan", "xi", "qiang", "wen", "da", "sheng",
				"hui", "xi,ji", "se", "jian", "jiang", "huan", "qiao,sao", "cong", "xie", "jiao,zhuo", "bi",
				"dan,tan,chan", "yi", "nong", "sui", "yi", "sha", "ru", "ji", "bin", "qian", "lan", "pu,fu", "xun",
				"zi", "peng", "yao,li", "mo", "lei", "xie", "zuan", "kuang", "you", "xu", "lei", "xian", "chan",
				"ko o", "lu", "chan", "ying", "cai", "xiang,rang", "xian", "zui", "zuan", "luo", "li,xi,sa", "lan",
				"lei", "lian", "hong", "ren", "zhu", "zhen", "die", "xi", "ying", "tao", "yun,wen", "xian",
				"cui,sui,shuai", "xie", "fou", "fou", "que", "bo", "ping", "xiang", "zhao te yo", "gang", "ying",
				"guan", "zun", "tan", "cheng", "qi", "weng", "ying", "lei", "tan", "lu", "wang", "wang", "kui", "kui",
				"kui,hui", "kun", "kun", "kun", "kun", "kuo,gua", "kuo", "kuo", "kuo", "la", "la", "la", "la", "xi",
				"la", "la,la", "lai", "lai", "lai", "lan", "lan", "lan", "lan", "lan", "lan", "lan", "lan", "lan",
				"lan", "lan", "lan", "lan", "lan", "lan", "lang", "lang", "lang", "lang", "lang", "lang", "lang",
				"lao", "lao", "lao", "lao", "lao", "mu,lao", "lao", "lao,luo", "lao", "le,lei", "le,yue", "lei", "lei",
				"lei", "lei", "lei", "lei", "lei", "lei", "lei,le", "lei", "lei", "leng,ling", "leng", "leng", "li",
				"li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li",
				"li", "li", "li", "li", "li", "li", "li", "li", };
	}

	private static String[] init193() {
		return new String[] { "ra", "shen", "gu", "zhu", "ju", "mao", "min", "gua", "ti", "juan", "fu", "shen",
				"guai,gua", "zhuo", "yu", "an", "fa", "si", "ma", "liu", "ba,ba,pi", "fa", "chao", "wei", "bi", "ji",
				"chong", "liu", "juan", "mi", "zhao", "luo", "pi", "ji", "ji", "luan", "mi", "da", "yang,xiang",
				"ling", "you", "fen", "ba", "yang", "gu", "qiang", "zang", "mei,gao", "yi,xi", "zhu", "yi", "rong",
				"qun", "qiang", "huan", "xian", "yi", "you", "qiang,kong", "qian,xian,yan", "yu", "geng", "yuan",
				"fan", "shan", "fen", "shan", "lian", "nou", "qiang", "hong,gong", "chong", "fen", "hong", "chi",
				"cui", "fu", "xia", "ben", "la", "pi,bi,po", "liu", "zhi", "qu,yu", "xi", "xie", "xi", "ke", "hui",
				"hui", "xiao", "sha", "hong", "jiang", "dao,zhou", "sha", "li", "li", "li", "li", "li,dai", "li", "li",
				"li", "liang,lia", "lian", "lian", "lian", "lian", "lian", "lian", "lian", "lian", "lian", "lian",
				"lian", "lian", "lian", "lian", "liang", "liang", "liang", "liang", "liang", "liang", "liang", "liang",
				"liang", "liang", "liang", "liao", "liao", "liao", "liao", "liao", "liao", "liao", "lao,liao",
				"liao,le", "liao", "liao", "liao", "liao", "lie", "lie", "lie", "lie", "lie", "lin", "lin", "lin",
				"lin", "lin", "lin", "lin", "lin", "lin", "lin", "lin", "lin", "ling", "ling", "ling", "ling", "ling",
				"ling", "ling", "ling", "ling", "ling", "ling", "ling", "ling", "ling", "liu", "liu", "liu", "liu",
				"liu", "liu", "liu", "liu", "liu", "liu", "liu,lu", "long", "long", "long", "long", "long", };
	}

	private static String[] init194() {
		return new String[] { "chi", "xuan", "chi", "zong", "wan", "hui", "hou", "he", "piao", "lian", "hou,qu", "ao",
				"lin", "pen", "qiao", "ao", "hui", "xuan", "dao", "lao", "gou", "gou", "gou", "die", "ruan,nuo",
				"er,nai", "duan,zhuan", "ting", "pi", "si,chi", "qu,chu", "jia", "ju", "chu", "lun", "ji,jie",
				"zha,ze", "lou", "ji", "lao", "huo", "you", "huai", "yi", "qin", "yun,ying", "dan", "hong", "zhi",
				"uu", "zhen", "che", "zheng", "you", "wa,tui,zhuo", "tiao", "er,nv", "ya", "tie,zhe", "xu", "hao",
				"sheng", "lie", "jing", "bi", "di,zhi", "guo", "wen", "xu", "ping", "cong", "xi ka li", "ni", "ting",
				"ju", "cong", "kui", "lian", "lian", "weng", "kui", "lian", "lian", "cong", "sheng", "song", "ting",
				"kui", "nie", "zhi", "dan", "ning", "qie", "ni,jian", "ting", "ting", "long", "long", "long", "long",
				"lou", "lou", "lou", "lou", "lou", "lou", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lu",
				"lu,liu", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lu", "lv", "lv", "lv", "lv", "lv", "lv",
				"lv", "lv", "lv", "lv", "lv", "shuai,lv", "lv", "lv,lu", "luan", "luan", "luan", "luan", "luan",
				"luan", "l<e", "l<e", "lun", "lun", "lun", "lun", "lun", "lun,guan", "lun", "luo", "luo", "luo", "luo",
				"luo", "luo", "luo", "luo", "luo", "luo", "luo", "luo,lao", "ma", "ma", "ma", "ma", "ma", "ma", "ma",
				"ma", "ma,ma", "mai,man", "mai", "mai", "mai", "mai", "mai", "man,men", "man", "man", "man", "wan",
				"man", "man", "man", };
	}

	private static String[] init195() {
		return new String[] { "long", "zhao", "si", "su", "zhao", "yi", "qiu", "ken", "cao", "ge", "bo,di", "huan",
				"chi", "ren", "ru", "yuan", "chai", "qin,han", "ban", "pei", "pang,pan", "you", "ran", "wen", "qi",
				"pi,bi", "xi", "xi", "ken", "die", "fei,bi", "ba", "bo", "qu", "tian", "zi,fei", "fei,ku", "zhi", "ni",
				"ping,peng", "zi", "fu,zhou", "xian", "mu", "qu", "qia", "chi", "yang", "pang", "chi", "xiong", "er",
				"heng", "zi", "gui,kui", "zheng", "tiao", "cui", "mei", "xie", "xie", "mai", "xie", "nin", "wan",
				"wen", "xiu", "jing", "rou", "heng", "lie", "shan", "ting", "mei", "chun", "shen", "jia", "de", "juan",
				"cu", "xiu", "xin", "tuo", "cheng", "nei", "dou", "nao", "pi", "gu", "li", "zhang", "cui", "jie",
				"liang", "shui", "biao", "man", "mang", "mang", "mang", "meng,mang", "mang", "mang", "mao", "mao",
				"mao", "mao", "mao", "mao", "mao", "mao", "mao,mo", "mao", "mao", "mao", "me,yao,ma", "mei", "mei",
				"mei", "mei", "mei", "mei", "mei,mo", "mei", "mei", "mei", "mei", "mei", "mei", "mei", "mei", "mei",
				"men", "men", "men", "meng", "meng", "meng", "meng", "meng", "meng", "meng", "meng", "mi", "mi", "mi",
				"mi,mei", "mi", "mi", "mi", "mi", "mi,bi", "mi", "mi,bi", "mi", "mi", "mi", "mian", "mian", "mian",
				"mian", "mian", "mian", "mian", "mian", "mian", "miao", "miao", "miao", "miao", "miao", "miao", "miao",
				"miao", "mie", "mie", "min", "min", "min", "min", "min", "min", "ming", "ming", "ming", "ming", "ming",
				"ming", "miu", "mo", };
	}

	private static String[] init196() {
		return new String[] { "lun", "pian", "guo", "juan", "chui", "dan", "nei", "nai", "ren", "shen", "zhui", "ju",
				"dong", "pi", "guo", "wo", "mei", "ruan", "zhuan", "chi", "luo", "ou", "di", "an", "nao", "shuan",
				"yun", "zhong", "rou", "tu", "wei", "jiao", "jia", "duan", "bi", "chang", "qian", "wa", "shou", "tang",
				"su", "zhui", "yi", "liao", "ji", "pi", "xie", "lv", "ou", "chang", "lu,biao", "guo", "pang", "chuai",
				"jiang", "fu", "zhuan,chuan,chun", "lv", "jiao", "ying", "lv", "xue", "cun", "tong", "ni", "liao",
				"cui", "kui", "xiao", "teng", "fan,pan", "zhi", "jiao", "hu,wu", "cui", "run", "xiang", "sui", "fen",
				"zhua", "dan", "kuai", "nong", "jue", "chu", "juan", "la,ge", "lian", "tun", "qi", "cui", "bin", "xun",
				"nao", "wo,yue", "zang", "mo", "mo", "mo,mu", "mo", "mo", "mo,ma", "mo", "mo,ma", "mo", "mo,mu", "mo",
				"mo", "mo", "mo", "mo", "mo", "mou", "mou,mu", "mou", "mu", "mu", "mu", "mu", "mu", "mu", "mu", "mu",
				"mu", "mu", "mu", "mu", "mu", "mu", "mu", "na", "na,nei,na,ne", "na,ne", "na", "na,nei", "na,nuo",
				"na", "nai", "nai", "nai", "nai", "nai", "nan,na", "nan", "nan,nuo", "nang", "nao", "nao", "nao",
				"nao", "nao,chuo,zhuo", "ni,ne", "nei", "nei,na", "nen", "neng,nai", "ni", "ni", "ni", "ni", "ni",
				"ni", "ni", "ni", "ni", "ni", "ni,niao", "nian", "nian", "nian", "nian", "nian", "nian,nie", "nian",
				"niang", "niang", "niao", "niao,sui", "nie", "nie", "nie", "nie", "nie", "nie", "nie", "nin", "ning",
				"ning", "ning", "ning", };
	}

	private static String[] init197() {
		return new String[] { "xian", "biao", "xing", "kuan", "la", "yan", "lu", "huo", "za", "luo", "qu", "zang",
				"luan", "ni,luan", "za", "qian,xian", "wo", "guang,jiong", "lin", "guang,jiong", "jiao", "ji", "gao",
				"chou", "mian,bian", "nie", "ge", "jian", "die,zhi", "zhi,jin", "xiu", "tai", "xian", "cha", "xi",
				"yu", "xing", "ju", "jiu", "xin", "she", "jiu", "tan", "shi", "tan", "pu", "pu", "guan", "hua", "tian",
				"xia", "dao", "fan", "pa", "tai", "fan", "chuan", "lu", "ling", "xia", "qiong", "pang", "kua", "fu",
				"zao", "feng", "li", "yu", "lang", "uu", "bo", "nian", "ju", "huang", "ke", "bian", "mu", "die", "dao",
				"bang", "cha", "yi", "cang", "lou", "dai", "so ri", "yao", "deng", "dang", "qiang", "lu", "yi", "ji",
				"jian", "huo", "qi", "ning", "ning", "niu", "niu", "niu", "niu", "nong", "nong", "nong", "nong,long",
				"nu", "nu", "nu", "nv", "nuan", "nue", "nue,yao", "nuo", "nuo", "nuo", "nuo", "o,e", "ou", "ou", "ou",
				"ou", "ou", "ou", "ou", "pa", "pa", "pa", "pa", "pa", "pa", "pai", "pai", "pai", "pai", "pai", "pai",
				"pan", "pan", "pan", "pan", "pan", "pan", "pan", "pan", "pang", "pang", "pang,bang", "pang",
				"pang,pan", "pao", "pao", "pao,bao", "pao,bao", "pao", "pao", "pao", "pei", "pei", "pei", "pei", "pei",
				"pei", "pei", "pei", "pei", "pen", "pen", "peng", "peng", "peng", "peng", "peng,bang", "peng", "peng",
				"peng", "peng", "peng", "peng", "peng", "peng", "peng", "pi", "pi", "pi", "pi", "pi", "pi", "pi", "pi", };
	}

	private static String[] init198() {
		return new String[] { "lu", "lu", "chan", "shuang", "jian", "ping", "yan", "yan", "cao", "le", "ding", "tiao",
				"qiu", "peng", "yi", "chai,cha", "mian", "gan", "yu", "hu,xia", "zi", "hui,hu", "sui", "zhi",
				"tun,chun", "wei", "qi", "wen", "ren", "fu", "xu,zhu", "lun,hua", "jue", "gou", "ao", "chu", "mao",
				"reng", "hang", "chan,yin", "you", "yi", "su sa", "pi", "di,ti", "di", "li,ji", "yong", "bei", "yi",
				"zhu,ning", "ni", "pa,bo", "bing", "xiu", "yao", "xian", "hong", "zuo,zha", "dong", "die", "nie", "hu",
				"mei", "sheng,rui", "gu", "bi", "wei", "fu", "zi", "zhi", "ji", "cong", "yuan", "xue", "ge", "li",
				"rong", "chai", "chen", "yu", "hao", "zi", "lie", "wu", "ji", "gui", "ci", "hou", "guang", "jiao",
				"yu", "zi", "fa", "mang", "zhong", "pi", "pi", "pi", "pi", "pi", "pi", "pi", "pi", "pi", "pian",
				"pian", "pian", "pian", "piao", "piao", "piao", "piao", "pie", "pie", "pin", "pin,bin", "pin", "pin",
				"pin", "ping", "ping", "ping,peng", "ping", "ping", "ping", "ping", "ping", "ping,bing", "po", "po",
				"po", "po", "po", "po", "po,pai", "po", "pou", "pu", "pu", "pu", "pu", "pu", "pu", "pu", "pu,bu",
				"pu,po,piao", "pu", "pu", "pu", "pu", "pu,bao", "pu,bao", "qi,ji", "qi", "qi,xi", "qi", "qi", "qi",
				"qi", "qi", "qi", "qi", "qi,ji", "qi", "qi,ji", "qi", "qi", "qi", "qi", "qi", "qi", "qi", "qi", "qi",
				"qi", "qi,kai", "qi", "qi", "qi", "qi,qie,xie", "qi,qie", "qi", "qi", "qi", "qi", "qi", "qi", "qi",
				"qia", };
	}

	private static String[] init199() {
		return new String[] { "qian", "zhu", "huan", "fu", "gai", "da", "chuan", "jing", "er", "an", "qiao", "chi",
				"ping", "jin", "lao", "shu", "zhuang", "da", "ce", "zi", "du", "wei", "li", "dou", "fu", "ren", "yin",
				"bu", "yun", "sui", "cheng", "chen", "wu", "bie", "xi", "geng", "zhu", "mo", "zhuang", "zuo", "tuo",
				"qiu", "suo", "chen", "peng,feng", "meng", "xing", "jing", "che", "jun", "yan", "cuo", "han", "cuo",
				"jia", "wang", "su,you", "niu", "shao,xiao", "xian", "wen,wan,mian", "jie", "nan", "mu", "tu", "nu xi",
				"mang", "ci", "di", "qu", "dong", "zou,chu", "la", "lu", "wei", "nie,ren", "kun", "pu", "zi,zai",
				"gao", "guo", "lun", "chou", "chui", "zhan", "men", "li", "bao", "qin", "juan", "qin", "di", "jie,sha",
				"jin", "qiao,zhao", "tai,zhi,chi", "qia", "qia", "qian", "qian", "qian", "qian,yan", "qian", "qian",
				"qian", "qian", "qian", "qian,gan", "qian", "qian", "qian", "qian", "qian", "qian", "qian,jian",
				"qian", "qian,zan,jian", "qian,kan", "qian", "qian", "qiang", "qiang", "qiang", "qiang", "qiang",
				"qiang", "qiang,jiang", "qiang,cheng", "qiao", "qiao", "qiao", "qiao", "qiao", "qiao", "qiao", "qiao",
				"qiao", "qiao,shao", "qiao", "qiao", "qiao", "qiao,xiao", "qiao", "qie", "qie", "qie,ju", "qie", "qie",
				"qin", "qin", "qin,qing", "qin", "qin", "qin", "qin", "qin", "qin", "qin", "qin", "qing", "qing",
				"qing", "qing", "qing", "qing", "qing", "qing", "qing", "qing", "qing", "qing", "qing", "qiong",
				"qiong", "qiu", "qiu", "qiu", "qiu", "qiu", "qiu", "qiu", "qiu", "qu,cu", "qu,ou", "qu", "qu", "qu",
				"qu", "qu", "qu,ju", };
	}

	private static String[] init200() {
		return new String[] { "geng", "hua", "qin,jin", "an", "wang", "beng", "zhou", "jian", "lin,ma", "tan", "tian",
				"dao", "hu", "he", "chun", "chang", "huan", "fei", "lai", "sha", "yan", "yi", "tiao", "qi", "wan",
				"ce", "ku ta bi lai", "tuo", "jiu", "bi", "yi", "pan", "bo", "pao", "ding", "qiu", "ke", "xiang",
				"wan", "yu", "yu", "fu", "lian", "xuan", "nan", "ce", "wo", "chun", "shao", "bian", "mao", "an",
				"ying", "kuo", "kuo", "jiang", "mian", "zuo", "zuo", "zu", "rou", "xi", "ye", "an", "qu", "jian", "fu",
				"lv", "jing", "pen", "hong", "hong", "hou", "xing", "tu", "zi", "qing", "mi", "huang", "shen", "gai",
				"zhou", "qian", "wei", "bo", "wei", "ji", "duan", "yao", "jun", "quan", "zhen", "hun", "shi", "lan",
				"zong", "qu", "qu", "qu", "qu,cu", "qu", "quan,juan", "quan", "quan", "quan", "quan", "quan", "quan",
				"quan", "quan", "quan,xuan", "quan", "que", "que", "que", "que", "que", "que", "que", "que,qiao",
				"qun", "qun", "ran", "ran", "ran", "ran", "rang", "rang", "rang", "rang", "rang", "rao", "rao", "rao",
				"re", "re", "ren", "ren", "ren", "ren", "ren", "ren", "ren", "ren", "ren", "ren", "reng", "reng", "ri",
				"rong", "rong", "rong", "rong", "rong", "rong", "rong", "rong", "rong", "rong", "rou", "rou", "rou",
				"ru", "ru", "ru", "ru", "ru", "ru", "ru", "ru", "ru", "ru", "ruan", "ruan", "rui", "rui", "rui", "run",
				"run", "ruo,re", "ruo", "sa", "sa,xi", "sa", "sai", "sai,xi", "sai,se", "sai", "san", "san", };
	}

	private static String[] init201() {
		return new String[] { "yao", "yuan", "mei", "yun", "shu", "zhuan", "guan", "su ku mo", "xue", "uu", "wei",
				"yong", "sou", "yin", "shi", "chun", "shi", "yun", "zhen", "ru,na", "li", "que", "yuan,huan", "li",
				"ju", "xi", "chu", "xu,shu", "tu", "liu", "huo", "dian", "qian", "zu,ju", "po", "cuo", "yuan", "chu",
				"yu", "pan", "pu", "na", "xi", "fen", "yun", "ruo", "cang", "mi", "sun", "ming", "sou", "liu", "xi",
				"gu", "lang", "gai,ge,he", "cuo", "tang", "luo", "xuan", "yao,zhuo", "gui", "zong", "gun", "go zha",
				"tiao", "ce", "pei", "dan", "shen", "lang", "ling", "diao,tiao,di", "tiao", "mao", "tong", "zhu", "an",
				"lian", "cong", "ping", "qiu,xu,fu", "jin", "chun", "jie", "wei", "tui", "cao", "yu", "yi", "zi,ju",
				"bi", "lu", "bu", "zhang", "lei", "san", "san", "sang", "sang", "sang", "sao", "sao", "sao", "sao",
				"se", "se", "se", "sen", "seng", "suo,sha", "sha", "sha", "cha,sha", "sha", "sha", "sha", "sha", "sha",
				"shai", "shai", "shan", "shan", "shan,sha", "shan", "shan", "shan", "shan", "shan", "shan", "shan",
				"shan", "shan", "shan", "shan", "shan", "shan", "shang", "shang", "shang", "shang", "shang", "shang",
				"shang", "chang,shang", "shao,sao", "shao", "shao", "shao", "shao", "shao", "shao", "shao", "shao",
				"shao", "shao", "she", "she", "she,yi", "she", "she", "she", "she,nie", "she,ye,yi", "she", "she",
				"she", "she", "shen", "shen", "shen", "shen", "shen", "shen", "shen", "shen", "shen", "shen,chen",
				"shen", "shen", "shen", "shen", "shen", "shen", "sheng", "sheng", "sheng", "sheng", "sheng", "sheng", };
	}

	private static String[] init202() {
		return new String[] { "qiang", "man", "yan", "ling", "ji", "biao", "gun", "han", "di", "lu", "she", "shang",
				"di", "hun", "bo", "di", "cuo", "shen", "xuan", "hu", "ao", "mi", "lou", "zhong", "po", "jiang", "mi",
				"cong", "niao", "hui", "juan", "yin", "jian", "yin", "guo", "chen", "hu", "sha", "kou", "qian", "ma",
				"zang", "ze", "li", "wei", "ji", "qian", "sheng", "meng", "ou", "chan", "dian", "rui", "lei", "yu",
				"qiao", "zhu", "hua", "jian", "mai", "yun", "bao", "you", "lu", "rao", "e", "ti", "fei", "jue", "fa",
				"ru", "fen", "kui", "shun", "ya", "xu", "fu", "dang", "wu", "dong", "si", "xiao", "xi", "sa", "yun",
				"shao", "jian", "sun", "ling", "yu", "xia", "si", "nong", "xuan", "yun", "yu", "sheng,xing",
				"sheng,cheng", "sheng", "sheng", "sheng", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi",
				"shi", "shi,dan", "shi,she", "shi", "shi,shen", "shi,si,yi", "shi", "shi", "shi,zhi", "shi", "shi",
				"shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi",
				"shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi", "shi,zhi", "shi", "shi", "shi", "shi", "shi",
				"shou", "shou", "shou", "shou", "shou", "shou", "shou", "shou", "shou", "shou", "shu", "shu", "shu",
				"shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu", "shu",
				"shu", "shu", "shu", "shu", "shu,zhu", "shu,zhu", "shu", "shu", "shu", "shu", "shu", "shu", "shu",
				"shu,shuo", "shu", };
	}

	private static String[] init203() {
		return new String[] { "xi,xiao", "hao", "ai", "hui", "hui", "ji", "ci,zi", "xiang", "wan,luan", "mie", "leng",
				"jiang", "can", "shen", "qiang,se", "lian", "ke", "yuan", "da", "ti", "tang", "zhan", "sun",
				"xian,lian", "fan", "ding", "xie", "gu", "shu", "jian", "hao,kao", "sa", "xun", "yao", "bai", "dui",
				"pin", "yuan,wei", "ning", "chou,zhou", "mai,wo", "piao", "ji,qi", "zao", "chen", "zhen", "er", "ni",
				"ying", "cong", "xiao,hao", "qi", "fa", "jian", "xu,yu", "kui", "bian", "diao,zhuo", "mi", "lan",
				"jin", "qiong", "qi", "liao", "xian", "su", "lv", "yi", "xu", "xie", "yi", "la", "lei", "jiao", "di",
				"zhi", "bei", "yao,yue", "mo", "huan", "biao,pao", "sou", "tan", "tui", "qiong", "qiao", "wei", "liu",
				"hui", "ou", "gao", "yun", "bao", "li", "shu", "zhu,chu", "shu", "shua", "shua", "shuai", "shuai",
				"shuai", "shuai", "shuan", "shuan", "shuang", "shuang", "shuang", "shui", "shui", "shui", "shui",
				"shun", "shun", "shun", "shun", "shuo,shui,yue", "shuo,shi", "shuo", "shuo", "si", "si", "si",
				"si,sai", "si", "si", "si", "si", "si", "si", "si", "si", "si,ci", "si,shi", "si", "si", "song",
				"song", "song", "song", "song", "song", "song", "song", "sou", "sou", "sou", "sou", "su", "su", "su",
				"su", "su", "su", "su", "su", "su", "su,xiu", "su", "su", "suan", "suan", "suan", "sui", "sui,duo",
				"sui", "sui", "sui", "sui", "sui", "sui", "sui", "sui", "sui", "sun,xun", "sun", "sun", "suo", "suo",
				"suo", "suo,su", "suo", "suo", "suo", "suo", "ta", "ta", "ta", "ta,jie", "ta", };
	}

	private static String[] init204() {
		return new String[] { "ai", "lin", "xuan", "qin", "lai", "tuo", "wu", "rui", "rui", "qi", "lu", "su", "tui",
				"mang", "yun", "pin", "yu", "xun", "ji", "jiong", "xuan", "qiu", "su", "jiong", "peng", "bo", "rang",
				"yi", "xian", "yu", "ju", "lian", "lian", "yin", "qiang", "ying", "long", "tou", "hua", "yue", "ling",
				"yao", "mi", "lan", "gui", "lan", "ji", "dang", "ka te su ra", "lei", "lei", "hui", "feng", "zhi",
				"wei", "kui", "huai", "li", "ji", "lei", "huai", "luo", "ji", "kui", "lu", "jian", "sa ri", "teng",
				"lei", "quan", "xiao", "yi", "luan", "men", "bie", "si", "xiao", "chu", "hu", "xu", "cuo", "fu", "xu",
				"lu", "hu", "hao", "jiao", "ju", "bao", "yan", "zhan", "zhan", "kui", "bin", "xi", "shu", "ta", "ta",
				"ta", "ta", "tai", "tai", "tai", "tai", "tai", "tai", "tai", "tai", "tai", "tan", "tan", "tan", "tan",
				"tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan", "tan",
				"tang,shang", "tang", "tang", "tang", "tang", "tang", "tang", "tang", "tang,chang", "tang",
				"tang,chang", "tang", "tang", "tao", "tao", "tao", "tao", "tao", "tao", "tao", "tao", "tao", "tao",
				"tao", "te", "teng", "teng", "teng", "teng", "ti", "ti", "ti", "ti", "ti,di", "ti", "ti", "ti",
				"ti,ben", "ti", "ti", "ti", "ti", "ti", "ti", "tian", "tian", "tian,zhen", "tian", "tian", "tian",
				"tian", "tian", "tiao", "tiao", "tiao", "tiao", "tiao,tao", "tie", "tie", "tie", "ting", "ting",
				"ting", };
	}

	private static String[] init205() {
		return new String[] { "diao", "qiu", "ding", "uu", "jue", "zhe", "she", "yu", "han", "zi", "xiang",
				"fang,bang", "e", "ba", "chi", "qian", "wen", "yue", "yue", "jun", "qi", "tong", "qi,zhi", "yuan,wan",
				"jue,que", "hui", "qin,qian", "qi", "zhong", "mu", "wang", "fen", "fen", "hang", "fu", "ran", "bao",
				"ni", "dai,de", "ping", "chi", "ju", "li", "fu", "zha", "gou,qu,xu", "pi", "pi,bo", "xian", "diao",
				"bie", "bing", "zhan", "tie", "tun", "ying", "ge,luo", "ci", "hui", "mang,bang", "fu", "lie", "yi",
				"xian", "li", "yi,xu", "ping", "jie", "she", "yi", "wang", "mo", "qie,ni", "gui", "qiong", "e bi",
				"xing", "jie", "qiu", "jia", "tui", "che", "bei", "han", "xuan", "shen", "fu", "xian", "lang", "bi",
				"yuan", "you", "jie", "dan", "dian", "hui", "ting", "ting", "ting", "ting", "ting", "ting", "ting",
				"tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong", "tong",
				"tou", "tou", "tou", "tou", "tu", "tu", "tu", "tu", "tu", "tu", "tu", "tu", "tu", "tu", "tu", "tuan",
				"tuan", "tui", "tui", "tui", "tui", "tun", "tui", "tun", "tun,zhun", "tun", "tuo", "tuo", "tuo", "tuo",
				"tuo", "tuo", "tuo", "tuo", "tuo", "tuo,ta,zhi", "tuo", "wa", "wa,wa", "wa", "wa", "wa", "wa", "wa",
				"wai", "wai", "wan", "wan", "wan", "wan", "wan", "wan", "wan", "wan", "wan", "wan", "wan", "wan",
				"wan", "wan,yuan", "wan", "wan,mo", "wan", "wang", "wang", "wang,wu", "wang", "wang", "wang", "wang",
				"wang", "wang", "wang", "wei", };
	}

	private static String[] init206() {
		return new String[] { "zhong", "ju", "qi", "yu", "jun", "si", "lun", "li", "die", "tao", "kun", "han", "han",
				"bang", "fei", "wei", "dun", "yuan", "suo", "qian", "rui", "ni", "wei", "liang", "dong", "e", "ban",
				"di", "wang", "can", "yang", "uu", "la", "ji", "ting", "mao", "xu", "mian", "jie", "shi", "xuan",
				"yan", "rou", "wei", "fu", "yuan", "mei", "wei", "ru", "xie", "xia", "ying", "shi", "chong", "tang",
				"zhu", "zong", "di", "yuan", "meng", "la", "dai", "qiu", "li", "wo", "yun", "qu", "ying", "jiang",
				"ban", "si", "ci", "xi,qi", "weng", "lian", "ban", "rong", "ji", "wu", "xiu", "han", "yi", "bi,pi",
				"hua", "yi", "du", "nai,neng", "he,xia", "hu", "gui,hui", "ma", "yi", "wen", "ying", "teng", "zhong",
				"wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei",
				"wei", "wei", "wei", "wei,yi", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei", "wei",
				"wei", "wei,yu", "wei", "wei", "wen", "wen", "wen", "wen", "wen", "wen", "wen", "wen", "wen", "wen",
				"weng", "weng", "weng", "zhua,wo", "wo", "wo,guo", "wo", "wo", "wo,guan", "wo", "wo", "wo", "wu", "wu",
				"wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu,yu", "wu", "wu", "wu", "wu", "wu", "wu", "wu",
				"wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu", "wu", "xi", "xi", "xi", "xi", "xi", "xi",
				"xi", "xi", "xi", "xi", "xi", };
	}

	private static String[] init207() {
		return new String[] { "cang", "sao", "qi", "dao", "shang", "di", "lu", "wei", "die,zhi", "chen", "qu,ju", "pi",
				"yu", "chan,jian", "lou", "qin", "yin", "jiang", "wen", "xiao", "wan", "zhe", "zhe", "ma", "guo",
				"liu", "cong", "li", "man", "xiao", "chang", "mo", "zui", "si", "qiu", "te", "zhi", "peng", "jiao",
				"qu", "bie", "liao", "gui", "xi", "ji", "zhuan", "fei,ben", "lao,liao", "jue", "jue", "yin,xun",
				"chan", "jiao", "nao", "xiao", "wu", "chong", "xun", "si", "chu", "cheng", "dang", "li", "shan", "yi",
				"jing", "da", "qi", "ci", "xiang", "she", "qin", "ying", "chai", "li", "zei", "xuan", "zhu", "ze",
				"xie", "mang", "xie", "qi", "rong", "jian", "hao", "zhuo", "jie", "pin", "he", "fan", "lei", "jie",
				"la", "min", "li", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi", "xi",
				"xi", "xi", "xi", "xi", "xian,xi", "xi,xian", "xi,ji", "xi", "xi,hu", "xi", "xia", "xia", "xia", "xia",
				"xia", "xia", "xia", "xia", "xia", "xia", "sha,xia", "xia", "xia,he", "xian", "xian", "xian", "xian",
				"xian", "xian,qian", "xian", "xian", "xian", "xian", "xian", "xian", "xian", "xian", "xian", "xian",
				"xian", "xian", "xian,xuan", "xian", "xian", "xian", "xian", "xian", "xian", "xian", "xiang", "xiang",
				"xiang", "xiang", "xiang", "xiang", "xiang", "xiang", "xiang", "xiang", "xiang,yang", "xiang", "xiang",
				"xiang", "xiang", "xiang,hang", "xiang", "xiang", "xiang", "xiang", "xiao", "xiao", "xiao", "xiao,xue",
				"xiao", "xiao", "xiao", "xiao", "xiao", "xiao", "xiao", };
	}

	private static String[] init208() {
		return new String[] { "qiu", "nie", "lu", "du", "xiao", "zhu", "long", "li", "long", "feng", "ye", "pi",
				"nang", "gu", "ying", "shu", "xi", "can", "qu", "quan", "can", "man", "jie", "zhu", "zhuo", "huang",
				"nv", "pei", "zhong", "mai", "er", "ke", "mie", "xi", "kan", "yuan", "qu", "ling", "xuan", "shu",
				"tong", "xiang", "xian", "hu", "wei", "dao", "chong", "wei", "dao", "zhun", "gan", "yu", "yi", "fu",
				"fen", "jie", "zhong", "dan", "ri", "zhong", "jie", "zhi", "xie", "ran", "zhi", "jun", "chai", "hui",
				"ran", "tuo", "ling", "bao,pao", "yao", "zuo", "bi", "shao", "ju,jie", "he,ke", "xue", "zhen", "yi",
				"pa", "fu", "di", "fu", "gun", "zhi", "zhi", "ran", "yi", "tuo", "na,jue", "gou", "xuan", "zhe", "qu",
				"xiao", "xiao", "xiao,jiao", "xiao", "xiao", "xiao", "xiao", "xie", "xie,suo", "xie", "xie", "xie",
				"xie", "xie,jia", "xie", "xie,ya,ye,yu,xu", "xie", "xie", "xie", "xie", "xie", "xie", "xie", "xie",
				"xie,yi", "xie", "xie", "xie", "xin", "xin", "xin", "xin", "xin", "xin", "xin", "xin", "xin,shen",
				"xin", "xing", "xing", "xing", "xing", "xing", "xing", "xing", "xing", "xing", "xing", "xing", "xing",
				"xing", "xing", "xing", "xiong", "xiong", "xiong", "xiong", "xiong", "xiong", "xiong", "xiu,xu", "xiu",
				"xiu", "xiu", "xiu", "xiu", "xiu", "xiu", "xiu", "xu", "xu", "xu", "xu", "xu,shi", "xu", "xu", "xu,hu",
				"xu", "xu", "xu", "xu", "xu", "xu,chu", "xu", "xu", "xu", "xu", "xu", "xuan", "xuan", "xuan", "xuan",
				"xuan", "xuan", };
	}

	private static String[] init209() {
		return new String[] { "yu", "mi", "bo", "uu", "chi,nuo", "chi,qi,duo,nuo", "ku", "ren", "peng", "jian,zun",
				"bo,mo", "jie", "er", "ru", "zhu", "gui,gua", "yin", "ka mi xi mo", "hang", "xu", "kun", "niao", "shu",
				"jia", "kun", "li", "juan", "shen", "ge,jie", "zhen", "liu", "ji", "yi", "bu", "zhuang", "shui", "qun",
				"li", "bao", "chan", "kun", "tao", "yuan", "ling", "chi", "chang", "chou,dao", "liang", "pei", "fei",
				"yuan,gun", "yan,an", "du", "zhi", "yi", "qi", "guo", "ken", "qi", "ti", "ti", "fu", "chong", "xie",
				"die", "kun", "duan", "xiu", "xiu", "yuan", "fu", "yu", "tuan", "yan", "hui", "pao", "dan", "yun",
				"ta", "gou", "huai", "rong", "yuan", "nai", "jiong", "suo", "ban", "sang", "niao", "ying", "jie",
				"huai", "ku", "lian", "li", "shi", "xuan", "xuan", "xuan", "xuan", "xue", "xue", "xue", "xue", "xue",
				"xue", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun", "xun",
				"xun", "ya", "ya", "ya", "ya", "ya,ya", "ya", "ya", "ya", "ya", "ya", "ya", "ya", "ya", "ya", "ya",
				"ya", "yan", "yan,ye", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan",
				"yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan", "yan",
				"yan", "yan", "yan", "yan", "yan", "yan", "yang", "yang", "yang", "yang", "yang", "yang", "yang",
				"yang", "yang,xiang", "yang", "yang", "yang", "yang,ang", "yang", "yang", "yang", "yang", "yao", "yao",
				"yao", "yao", };
	}

	private static String[] init210() {
		return new String[] { "lv", "yi", "die", "xie", "xian", "wei", "biao", "cao", "ji", "sen", "bao", "qi ha ya",
				"fu", "jian", "zhuan", "jian", "cui", "ji", "dan", "za", "fan", "bo", "xiang", "xin", "bie", "rao",
				"man", "lan", "ao", "ze", "gui", "cao", "sui", "nong", "chan", "lian", "dang", "shu", "tan", "bi",
				"lan", "fu", "zhi", "ta e", "shu", "wa", "shi", "bai", "xie", "bo", "chen", "lai", "long", "xi",
				"xian", "lan", "zhe", "dai", "ta si ki", "zan", "shi", "jian", "yi", "lan", "ya", "ya", "feng", "fu",
				"fiao", "ba,po", "he", "ji", "ji", "jian,xian", "guan", "bian", "yan", "gui", "jue,jiao", "pian",
				"mao", "mi", "mi", "pie,mie", "shi", "si", "chan", "zhen", "jue,jiao", "mi", "tiao", "lian", "yao",
				"zhi", "jun", "xi", "yao", "yao", "yao", "yao", "yao", "yao", "yao", "yao", "yao", "yao", "yao", "ye",
				"ye", "ye", "ye", "ye", "ye", "ye", "ye", "ye", "ye", "ye,xie", "ye", "ye", "ye", "ye", "yi", "yi",
				"yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi,ni", "yi", "yi", "yi",
				"yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi",
				"yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi", "yi",
				"yi", "yin", "yin", "yin", "yin,yan", "yin", "yin", "yin", "yin", "yin", "yin", "yin", "yin", "yin",
				"yin", "yin", };
	}

	private static String[] init211() {
		return new String[] { "shan", "wei", "xi", "tian", "yu", "lan", "e", "du", "qin,qing", "pang", "ji", "ming",
				"ying", "gou", "qu", "zhan", "jin", "guan", "deng", "jian,bian", "luo,luan", "qu", "jian", "wei",
				"jue,jiao", "qu", "luo", "lan", "shen", "di", "guan", "yan", "tian", "qiu", "jin", "cu", "zhi", "chao",
				"ji", "dan", "di", "hua,xie", "quan", "ge", "shi", "gui", "jie,xie", "hun", "qiu", "xing", "ni",
				"ji,qi", "jue", "zha", "bi", "xing", "shang", "gong", "zhi", "xue,hu", "chu", "xi", "yi", "li,lu",
				"jue", "xi", "yan", "xi", "yan", "ding", "fu", "qiu", "qiu", "jiao", "ji", "fan", "xun", "diao",
				"hong", "chai", "tao", "xu", "jie", "dan", "ren", "xun", "yin", "shan", "qi", "tuo", "ji", "xun",
				"yin", "e", "fen", "ya", "yin", "ying", "ying", "ying", "ying", "ying", "ying", "ying", "ying", "ying",
				"ying", "ying", "ying", "ying", "ying", "ying", "ying", "ying", "ying", "yo", "yong", "yong", "yong",
				"yong", "yong", "yong", "yong", "yong", "yong", "yong", "yong,chong", "yong", "yong", "yong", "yong",
				"you", "you", "you", "you", "you", "you", "you", "you", "you", "you", "you", "you", "you", "you",
				"you", "you", "you", "you", "you", "you", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu",
				"yu,shu", "yu", "yu", "yu,tou", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu",
				"yu", "yu", "yu", "yu", "xu,yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", "yu", };
	}

	private static String[] init212() {
		return new String[] { "yao", "song", "shen", "yin", "xin", "jue", "xiao", "ne", "chen", "you", "zhi", "xiong",
				"fang", "xin", "chao", "she", "yan", "sa", "zhun", "xu", "yi", "yi", "su", "chi", "he", "shen", "he",
				"xu", "zhen", "zhu", "zheng", "gou", "zi", "zhan", "gu", "fu", "jian", "die", "ling", "di", "yang",
				"nao", "pan", "zhou", "gan", "yi", "ju", "yao", "zha", "tuo", "yi", "qu", "zhao", "ping", "bi",
				"xiong", "qu", "ba", "da", "zu", "tao", "nuo", "ci", "zhe", "yong", "xu", "xun", "yi", "huang", "he",
				"shi", "cha", "xiao", "shi", "hen", "cha", "gou", "gui", "quan", "hui", "jie", "hua", "gai", "xiang",
				"wei", "shen", "chou", "tong", "mi", "ming", "luo", "hui", "yan", "xiong", "gua", "er", "yu", "yu",
				"yu", "yu", "yu", "yu", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan",
				"yuan,yun", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yuan", "yue", "yue,yao",
				"yue", "yue", "yue,yao", "yue", "yue", "yue", "yue", "yue", "yun", "yun", "yun", "yun", "yun", "yun",
				"yun", "yun", "yun", "yun", "yun", "yun", "za", "za", "za", "zai", "zai", "zai", "zai", "zai", "zai",
				"zai", "zan,za,zan", "zan,cuan", "zan", "zan", "zang", "zang", "zang", "zao", "zao", "zao", "zao",
				"zao", "zao", "zao", "zao", "zao", "zao", "zao", "zao", "zao", "zao", "ze", "ze,zhai", "ze", "ze,shi",
				"zei", "zen", "zeng", "zeng", "zeng,ceng", "zeng", "za,zha", "zha,cha", "zha", "zha", "ya", };
	}

	private static String[] init213() {
		return new String[] { "bing", "tiao,diao", "yi,chi", "lei", "zhu", "kuang", "kua", "wu", "ji", "zhi", "ren",
				"cu", "lang", "e", "kuang", "ei,xi", "ting", "dan", "bei,bo", "chan", "you", "keng", "qiao", "qin",
				"shua", "an", "yu", "xiao", "cheng", "jie", "xian", "wu", "wu", "gao", "song", "bu", "hui", "jing",
				"shuo,shui,yue", "zhen", "shuo,shui,yue", "du", "hua", "chang", "shui,shei", "jie", "ke", "qu,jue",
				"cong", "xiao", "sui", "wang", "xian", "fei", "chi,lai", "ta", "yi", "ni,na", "yin", "diao,tiao",
				"pi,bei", "zhuo", "chan", "chen", "zhun", "ji", "ji", "tan", "zhui", "wei", "ju", "qing", "dong",
				"zheng", "ze,zuo,zha,cuo", "zou", "qian", "zhuo", "liang", "jian", "chu,ji", "xia,hao", "lun", "shen",
				"biao", "hua", "bian", "yu", "die", "xu", "pian", "shi,di", "xuan", "shi", "hun", "hua,gua", "zha",
				"zha", "zha", "zha,shan,shi,ce", "zha", "zha,za", "zha", "zha", "zha", "zhai", "zhai", "zhai", "zhai",
				"zhai", "zhai", "zhan", "zhan", "zhan", "zhan", "zhan", "zhan", "zhan", "zhan,nian", "zhan,chan",
				"zhan", "zhan", "zhan", "zhan", "zhan", "zhan", "zhan", "zhan", "zhang", "zhang", "zhang", "zhang",
				"zhang", "zhang", "zhang", "zhang", "zhang", "zhang", "zhang", "zhang", "zhang", "zhang", "zhang",
				"zhao", "zhao", "zhao", "zhao", "zhao", "zhao", "zhao", "zhao", "zhao", "zhao,shao", "zhe", "zhe,she",
				"zhe", "zhe", "zhe", "zhe", "zhe", "zhe", "zhe,zhei", "zhe", "zhen", "zhen", "zhen", "zhen", "zhen",
				"zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zhen", "zheng",
				"zheng", "zheng", "zheng", "zheng", "zheng", "zheng", "zheng", "zheng", "zheng", "zheng", };
	}

	private static String[] init214() {
		return new String[] { "e", "zhong", "di", "xie", "fu", "pu", "ting", "jian", "qi", "yu", "zi", "zhuan",
				"xi,shai,ai", "hui", "yin", "an", "xian", "nan", "chen", "feng", "zhu", "yang", "yan", "huang", "xuan",
				"ge", "nuo", "xu", "mou", "ye", "wei", "xing", "teng", "zhou", "shan", "bo", "kui", "huang", "huo",
				"ge", "ying", "mi", "xiao", "mi", "xi", "qiang", "chen", "xue", "ti", "su", "bang", "chi", "qian",
				"shi", "jiang", "yuan", "xie", "he", "tao", "yao", "yao", "lu", "yu", "biao", "cong", "li", "mo", "mo",
				"shang", "zhe", "miu", "jian", "ze", "jie", "lian", "lou", "can", "ou", "gun", "xi", "zhuo", "ao",
				"ao", "jin", "zhe", "yi", "hu", "jiang", "man", "chao", "han", "hua", "chan", "xu", "zeng", "se",
				"zhen", "zheng", "zheng", "zheng", "zhi", "zhi,qi", "zhi", "zhi,zi", "zhi", "zhi", "zhi", "zhi", "zhi",
				"zhi", "zhi", "zhi", "zhi", "zhi", "zhi,shi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi",
				"zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhi,shi", "zhi", "zhi", "zhi", "zhi",
				"zhi", "zhi", "zhi", "zhi", "zhi", "zhi", "zhong", "zhong", "zhong", "zhong", "zhong", "zhong",
				"zhong", "zhong", "zhong,chong", "zhong", "zhong", "zhou", "zhou", "zhou", "zhou", "zhou", "zhou,yu",
				"zhou", "zhou", "zhou", "zhou", "zhou", "zhou", "zhou", "zhou", "zhu", "zhu", "zhu", "zhu,shu", "zhu",
				"zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu", "zhu,chu", "zhu",
				"zhu", "zhu", "zhu", };
	}

	private static String[] init215() {
		return new String[] { "xi", "zha", "dui", "zheng", "nao", "lan", "e", "ying", "jue", "ji", "zun", "jiao", "bo",
				"hui", "zhuan", "wu", "zen", "zha", "shi", "qiao", "tan", "jian", "pu", "sheng", "xuan", "zao", "tan",
				"dang", "sui", "xian", "ji", "jiao", "zhan", "nong", "yi", "ai", "zhan", "hui", "hua", "yi", "yi",
				"shan", "rang", "rou", "qian", "dui", "ta", "hu", "zhou", "hao", "ai", "ying", "jian", "yu", "jian",
				"hui", "du", "zhe", "juan,xuan", "zan", "lei", "shen", "wei", "chan", "li", "yi,tui", "bian", "zhe",
				"yan", "e", "chou", "wei", "chou", "yao", "chan", "rang", "yin", "lan", "chen", "xie", "nie", "huan",
				"zan", "yi", "dang", "zhan", "yan", "du", "tuo", "ren", "xiong", "xiong", "bi", "zhou,chou", "shen",
				"xu", "zhu", "zhu", "zhu", "zhu", "zhua", "zhao,zhua", "zhuai,ye", "zhuan", "zhuan", "zhuan", "zhuan",
				"zhuan", "zhuan", "zhuang", "zhuang", "zhuang", "zhuang", "zhuang", "zhuang", "zhuang", "zhui,chui",
				"zhui", "zhui,dui", "zhui", "zhui", "zhui", "zhun", "zhun", "zhuo", "zhuo", "zhuo", "zhuo", "zhuo,zuo",
				"zhuo", "zhuo", "zhuo", "zhuo,zhao,zhe", "zhuo", "zhuo", "zi,ci", "zi", "zi", "zi", "zi", "zi", "zi",
				"zi", "zi,zai", "zi", "zi", "zi", "zi", "zi", "zi", "zong", "zong", "zong", "zong", "zong,zeng",
				"zong", "zong", "zou", "zou", "zou", "zou", "zu", "zu", "zu,cu", "zu", "zu", "zu", "zu", "zu", "zuan",
				"zuan", "zui", "zui", "zui", "zui", "zun", "zun", "zuo", "zuo", "zuo", "zuo,zha", "zuo", "zuo", "zuo",
				"zuo", };
	}

	private static String[] init216() {
		return new String[] { "qian", "hong", "xia", "ji", "hong", "han", "hong", "xi", "xi", "liao", "han", "du",
				"long", "qi", "li", "deng", "bi", "shu", "xian", "feng", "zhi", "zhi", "yan", "yan", "chu", "hui",
				"tun", "yi", "yi", "jian", "ba", "hou", "e", "chu", "jian", "ken", "gai", "ju", "fu", "xi", "bin",
				"zhu", "jia", "fen", "xi", "hu", "wen", "huan", "di", "zong", "fen", "yi", "an", "pi", "na", "pi",
				"gou", "na", "you", "mo", "si", "huan", "ken,kun", "he,mo", "an", "li", "ni", "bi", "yu", "jia",
				"tuan", "mao", "xi", "yi", "ju,lou", "chu", "tan", "huan", "jue", "bei", "zhen", "yuan,yun", "fu",
				"cai", "gong", "dai", "yi", "hang", "wan", "pin", "huo", "fan", "tan", "guan", "ze,zhai", "zhi", "chu",
				"qi,ji", "wu", "gai", "nian", "sa", "pi", "gen", "cheng", "ge", "nao", "e", "gun", "yu,ou", "pie",
				"bi", "tuo,zhe", "yao", "yao", "zhi", "di", "xin", "yin", "kui", "yu", "gao", "tao", "zhu", "ji,qi",
				"nai", "mie,nie", "ji", "qi", "mie", "bei", "se", "gu", "ze", "she", "cuo", "yan", "jue", "si", "ye",
				"yan", "fang", "po", "gui", "kui,gui", "bian", "ze", "gua", "you", "dao", "yi", "wen", "jing", "ku",
				"gui", "kai", "la", "ji", "yan,shan", "wan", "kuai", "piao", "jue", "qiao", "huo", "yi", "jiong",
				"wang", "ren", "ding", "zhang", "le", "sa", "yi,ge", "mu", "ren", "yu", "pi", "ya", "wa", "wu",
				"chang", "cang,chen", "kang", "zhu", "ning", "ka", "you", "yi,die", "gou,kou", };
	}

	private static String[] init217() {
		return new String[] { "er", "zhu", "shi", "bi", "zi", "er", "gui", "pian", "bian", "mai", "dai,te", "sheng",
				"kuang", "fei", "tie", "yi", "chi", "mao", "he", "bi,ben", "lu", "lin", "hui", "gai", "pian", "zi",
				"jia,gu", "xu", "zei", "jiao", "gai", "zang", "jian", "ying", "jun", "zhen", "she", "bin", "bin",
				"qiu", "she", "chuan", "zang", "zhou", "lai", "zan", "ci", "chen", "shang", "tian", "pei", "geng",
				"xian", "mai", "jian", "sui", "fu", "dan", "cong", "cong", "zhi", "lai", "zhang", "du", "jin",
				"xiong,min", "chun", "yun", "bao", "zai", "lai", "feng", "cang", "ji", "sheng", "ai", "zhuan,zuan",
				"fu", "gou", "sai", "ze", "liao", "yi", "bai", "chen", "wan", "zhi", "zhui", "biao", "yun", "zeng",
				"dan", "zan", "yan", "pu", "shan", "tong", "tuo", "ni", "qie,jia,ga", "ji", "er,nai", "you", "kua",
				"kan", "zhu", "yi", "tiao", "chai", "jiao", "nong", "mou", "chou", "yan", "li", "qiu", "li", "yu",
				"ping", "yong", "si,qi", "feng", "qian", "ruo", "pai", "zhuo", "shu", "luo", "wo,wei", "bi", "ti",
				"guan", "kong", "ju", "fen", "yan", "xie", "ji,jie", "wei", "zong", "lv,lou", "tang", "bin", "nuo",
				"chi", "xi", "jing", "jian", "jiao", "jiu", "tong,zhuang", "xuan", "dan", "tong", "tun", "she", "qian",
				"zu", "yue", "cuan", "di", "xi", "xun", "hong", "guo", "chan", "kui", "bao", "pu", "hong", "fu", "fu",
				"su", "si", "tou", "yan", "bo", "gun", "mao", "xie", "luan", "pou", "bing", "ying", "luo", "lei",
				"bing", "hu", "lie", "xian", };
	}

	private static String[] init218() {
		return new String[] { "wan", "ying", "jin", "gan", "xian", "zang", "bi", "du", "shu", "yan", "shang", "xuan",
				"long", "gan", "zang", "yuan", "bi", "zhou", "feng", "yun", "xi", "tong", "xi", "cheng", "cheng",
				"xia", "tang", "zou", "li", "shan", "qiong", "yin", "xian", "zi", "jue", "qin", "chi", "ci", "chen",
				"die,tu", "di", "xi", "zhan", "jue", "ji,jie", "qu", "chu", "gua,huo", "xue", "tiao", "duo", "gan",
				"suo", "cu", "xi", "zhao", "su", "yin", "ju", "jian", "que,qi,ji", "chuo", "cui", "lu", "dang", "qiu",
				"zi", "ti", "qu,cu", "chi", "huang", "qiao", "qiao", "jiao", "zao", "ti,yue", "er", "zan", "kua,wu",
				"ke", "jue,gui", "chen", "fang,pang", "yue", "ba,pao", "qi", "tuo", "yi", "jian,chen", "ling", "mei",
				"ku", "ci", "qia", "zhu", "ju", "song", "mi", "zhong", "ming", "yan", "jie", "hong", "shan", "ou",
				"ju", "ne", "gu", "he", "di", "zhao", "qu", "yi,dai", "kuang", "lei", "gua", "jie,ji", "hui", "shen",
				"gou", "quan", "zheng", "hun", "xu", "qiao", "gao", "kuang", "ei,xi", "zou", "zhuo", "wei", "yu",
				"shen", "chan", "sui", "chen", "jian", "xue", "ye", "e", "yu", "xuan", "an", "di", "zi", "pian", "mo",
				"dang", "su", "shi", "mi", "zhe", "jian", "zen", "qiao", "jue", "yan", "zhan", "chen", "jie", "jin",
				"fu", "wu", "qian", "jing", "ban", "dian", "zuo", "bei", "xing", "gai", "zhi", "nie", "zou", "chui",
				"pi", "wei", "huang", "wei,kui", "xi", "han", "qiong", "kuang", "mang", "wu", "fang", "bing", "pi",
				"bei", "ye", };
	}

	private static String[] init219() {
		return new String[] { "dian,tie,die", "pan,ban", "ju,qie", "ni", "yi", "ji", "dai,duo,chi", "duo", "zhu",
				"quan", "zhuai", "xiang", "die", "pian,beng", "zhi", "jie", "cai", "da", "ju", "shu,chou", "tu",
				"chuo", "jing", "nie", "xiao", "bu", "qun", "mu", "shu", "jiao", "qiao", "mou", "jian", "ji", "wo",
				"wei", "jie", "ji", "nie", "ju", "nie", "lun", "lu", "leng", "wan", "quan", "zu", "qie", "qi", "cu",
				"zong", "peng", "zheng", "yu", "dun", "chuan", "yong", "di", "zhe", "chen", "gua", "tang", "fu", "cu",
				"nuo", "cha", "tui", "qiang", "nian", "dian", "ti", "ji", "liu", "zan", "bi", "chong", "lu", "liao",
				"tang", "dai", "su", "xi", "kui", "ji", "zhi", "qiang", "di", "pan", "zong", "lian", "zao", "nian",
				"tui", "ju", "xian", "zhong", "di", "tai", "jia", "zhi", "zhu", "kuai", "qie,xi", "xun,huan", "yun",
				"li,zhi", "ying", "gao", "xi", "fu", "pi", "tan", "yan", "juan", "yan", "yin", "zhang", "po", "shan",
				"zou", "ling", "feng", "chu", "huan", "mai", "qu", "shao", "he", "ge,jia", "meng", "xu", "xie", "sou",
				"xie", "jue", "yin", "kan,qian", "dang", "chang", "si,mou", "bian", "ben", "qiu", "ben", "e", "fa",
				"shu", "ji", "yong", "he", "wei,xu", "wu", "ge", "zhen", "kuang", "pi", "yi", "li", "qi,yin", "ban",
				"gan", "long", "dian", "lu", "che", "di,chi", "tuo", "ni", "mu", "ao", "ya", "die", "dong,tong", "kai",
				"yan,shan", "shang", "nao", "gai", "yin", "cheng", "shi", "guo", "xun", "lie", "yuan,huan", "zhi",
				"an", "yi", "pi", "nian", };
	}

	private static String[] init220() {
		return new String[] { "bo", "cu", "jue", "lin", "ta", "qiao", "qiao", "liao", "dun", "guan", "da", "bi", "bi",
				"ju", "qiao", "dun", "chou", "ji", "wu", "yue", "nian", "zhi", "li,luo", "zhi", "chu", "duan", "wei",
				"long", "lin", "xian", "wei", "lan", "rang", "sa,xie", "nie", "ta", "qu", "ji", "cuan", "zuan", "xi",
				"kui", "jue", "lin", "dan", "sai ga lai re", "ti", "duo", "gong", "lang", "hai la wu", "luo", "ai",
				"ji", "ju", "wu te su ke", "lao", "yan", "xi tui kai", "kang", "qu", "lou", "lao", "duo", "zhi", "yan",
				"ti", "dao", "ya ga tei", "yu", "che,ju", "ya,zha,ga", "gui", "jun", "yue", "xin,xian", "dai", "xuan",
				"fan,gui", "ren", "shan", "kuang", "shu", "tun", "chen", "dai", "e", "na", "qi", "mao", "ruan",
				"kuang", "qian", "zhuan", "hong", "hu", "peng,beng", "tu", "sao", "dai", "ku", "die", "yin", "leng",
				"hou", "ge", "yuan", "man", "yong", "liang", "chi", "xin", "pi", "yi", "ao", "qiu", "nai", "du",
				"qian", "ji", "wan", "xiong", "qi", "xiang", "fu", "yuan,yan", "yun", "fei,fu", "ji", "li", "e",
				"ju,qu", "bi,pi", "zhi", "rui", "xian", "chang", "cong", "qin", "wu,hu", "qian", "qi", "shan", "bian",
				"zhu", "kou", "yi", "mo", "gan", "pie", "long", "ba", "mu", "ju,cha", "ran", "qing", "chi", "fu",
				"ling", "niao", "yin", "mao", "ying", "qiong", "min", "tiao,shao", "qian", "yi", "rao", "bi", "zi",
				"ju", "tong", "hui", "zhu", "ting", "qiao", "fu", "ren", "xing", "quan", "hui", "xun", "ming", "ji",
				"jiao", "chong", "jiang", "luo", "xing", };
	}

	private static String[] init221() {
		return new String[] { "qu", "kuang", "di", "ling", "dai", "ao", "zhen", "fan", "kuang", "yang", "peng", "bei",
				"gu", "gu", "pao", "zhu", "rong", "e", "ba", "zhou", "zhi", "yao", "ke", "yi,die", "qing", "shi",
				"ping", "er", "gong", "ju", "jiao", "guang", "lu", "kai", "quan", "zhou", "zai", "zhi", "she", "liang",
				"yu", "shao", "you", "wan", "yin", "zhe", "wan", "fu", "qing", "zhou", "ni", "ling", "zhe", "han",
				"liang", "zi", "hui", "wang", "chuo", "guo", "kan", "yi", "peng", "qian", "gun", "nian", "peng",
				"guan", "bei", "lun", "pai", "liang", "ruan", "rou", "ji", "yang", "xian", "chuan", "cou", "chun",
				"ge", "you", "hong", "shu", "fu", "zi", "fu", "wen", "fan", "zhan", "yu", "wen", "tao", "gu", "zhen",
				"xia", "qian", "gen", "jin", "mai", "sun", "hong", "zhou", "kan", "bi", "shi", "wo", "you", "e", "mei",
				"you", "li", "tu", "xian,lian", "fu,piao", "sui", "you", "di", "shen,xin", "guan,wan", "lang,liang",
				"ying", "chun", "jing", "qi", "xi", "song", "jin", "nai", "qi", "ba", "shu", "chang", "tie", "yu",
				"huan", "bi", "fu", "tu", "dan", "cui", "yan", "zu", "dang", "jian", "wan,yun", "ying", "gu", "han",
				"qia", "feng", "shen", "xiang", "wei", "chan", "kai", "qi", "kui,kuai", "xi", "e", "bao", "pa", "ting",
				"lou", "pai", "xuan", "jia", "zhen", "shi", "ru", "mo", "en", "bei", "weng", "hao", "ji", "li", "bang",
				"jian", "shuo", "lang", "ying", "yu", "su", "meng", "dou", "xi", "lian", "cu", "lin", };
	}

	private static String[] init222() {
		return new String[] { "yuan", "lu", "jiao", "chao", "zhuan", "wei", "hun", "xue", "zhe", "jiao", "zhan", "bu",
				"lao", "fen", "fan", "lin", "ge", "se", "kan", "huan", "yi", "ji", "dui", "er", "yu", "jian", "hong",
				"lei", "pei", "li", "li", "lu", "lin", "dai", "zhou", "liang", "wen", "ci", "zui", "bian", "la", "ci",
				"xue", "ban", "bian", "xue", "ban", "ci", "bian", "bian", "nong", "nong", "zhen", "chuo", "yi", "reng",
				"dao,bian", "shi", "yu", "chan", "gan", "yu", "yi", "qi", "bi", "wang,kuang", "tu", "zhun", "da",
				"hang", "da", "e", "da", "che", "chi", "zhi,li", "chen", "zhu,wang", "tao", "yi", "ke o pi", "hui",
				"dong", "you", "nai", "yi", "jie", "lie", "xun", "dun", "jiong", "you", "qiu", "di", "jing", "yi",
				"qu", "kou", "xu", "liao,lu", "hui", "xun", "jue", "rui", "zui", "ji", "meng", "fan", "qi", "hong",
				"xie", "hong", "wei", "yi", "weng", "sou", "bi", "hao", "tai", "ru", "xun", "xian", "gao", "li", "huo",
				"qu", "heng", "fan", "nie", "mi", "gong", "yi", "kuang", "lian", "da", "yi", "xi", "zang,zhuang",
				"pao", "you", "liao", "ga", "gan", "shou", "men", "tuan", "chen", "fu", "pan,pin,fan", "ao,niu",
				"jie,jia", "jiao", "za,zan", "yi", "luo,lv", "jun", "tian", "ye", "ai", "na", "ji", "guai", "bai",
				"ju", "pou", "lie", "qian", "guan", "she,die,ye", "zha", "ya", "qin", "yu", "an", "xuan", "bing",
				"kui", "yuan", "shu", "en", "chuai", "jian", "shuo", "zhan", "nuo", "sang", "luo", "ying", "zhi",
				"han", };
	}

	private static String[] init223() {
		return new String[] { "zhe", "wu", "lian", "suo", "hui", "gu", "lai", "ben", "cuo", "zhu", "beng", "you",
				"zhou", "jin", "yu", "chuo", "ti", "da", "yuan", "nuo", "dang", "sui", "yan", "chi", "di", "shi",
				"zhen", "you", "yun", "e", "guo", "da", "wei", "nan", "yao", "chou", "xun", "ta", "di", "chi", "yuan",
				"su", "he wo ong", "guan", "zhang", "shi", "ca", "chi", "su", "dun", "di", "lou", "chi", "cuo", "rao",
				"qian", "xuan", "yu", "yi", "e", "liao", "shi", "mai", "huan,hai", "zhan", "teng", "er", "bian",
				"bian", "li,chi", "yuan", "yao", "luo", "li", "ting", "qi", "shan", "yu", "ru", "xi", "fu",
				"kang,hang", "bin", "xin", "shen", "yuan", "cun", "huo", "bang", "ju", "bi", "wa", "kuang", "gui",
				"shi", "ku", "zhe", "xie", "lu", "zun", "cuan", "gan", "huan", "pi,bo", "xing", "zhuo", "huo", "zuan",
				"nang", "yi", "te,tui", "dai", "shi", "bu", "chi", "ji", "kou", "tao,dao", "le", "zha", "ya,a", "yao",
				"fu", "fu,?", "yi", "dai", "li", "e", "pi,bi", "bei,bai", "wai,he,wo,wa,gua,guo", "qin", "yin,shen",
				"za", "ka", "xia", "gua,gu", "ling", "dong", "ning", "duo", "nao", "you", "si", "kuang", "ji,xi,qia",
				"shen", "hui", "da", "lie", "yi", "xiao", "bi", "zi,ci", "guang", "yue,hui", "xiu", "yi", "pai",
				"kuai", "duo", "ji,jie,zhai", "mie", "mi", "zha", "nong", "gen,hen", "mou", "ma", "chi", "lao", "geng",
				"?g,m", "zha", "suo", "zao", "xi", "zuo", "ji", "feng", "ze", "nuo,re", "miao", "lan,lin", "zhuan",
				"zhou,zhao,tiao", "tao", "hu", "cui,qi", "sha", };
	}

	private static String[] init224() {
		return new String[] { "gai,hai", "he", "ji", "hou", "xing", "xi", "gui", "na", "lang", "yan", "cheng", "dou",
				"lv", "fu", "wu", "lang", "jia", "geng", "bo", "xi", "bei", "xiao,ao", "qi", "qing", "zhou", "zou",
				"ping", "lai", "ni", "you", "bu", "xiang", "ju", "yong", "qiao", "yi", "mei", "ruo", "bei", "shu",
				"yu", "yun", "hou", "kui", "xiang", "xiang", "sou", "tang", "ming", "xi", "ru", "chu", "zi", "zou",
				"yi", "wu", "xiang", "yun", "hao", "yong", "mao", "chao", "fu", "liao", "zhuan", "hu", "qiao", "man",
				"qiao", "xu", "deng", "bi", "xun", "bi", "zeng", "wei", "zheng", "mao", "lin", "dan", "meng", "ye",
				"cao", "kuai", "feng", "meng", "kuang", "lian", "zan", "chan", "you", "qi", "yan", "chan", "zan",
				"huan", "yo", "dan", "bo", "ding", "lang", "li", "shua", "chuo,chuai", "die,zha", "ta,da", "nan", "li",
				"kui", "jie", "yong", "kui", "jiu", "sou", "yin", "chi", "jie", "lou", "ku", "o,wo", "hui", "qin",
				"ao", "su", "du", "ke", "nie", "he", "chen", "suo", "ge", "sha,a", "?g,?g, g", "hao", "dia", "ai",
				"yi,ai", "suo", "hai,hei", "tong", "chi", "pei", "lei", "cao", "piao", "qi", "ying", "beng", "sou",
				"di", "mi", "peng", "jue", "liao", "pu", "zuo", "jiao", "o", "qin", "lu", "ceng", "deng", "hao", "jin",
				"jue,xue", "yi", "sai", "pi", "ru", "ca,cha", "huo", "nang", "wei,guo", "jian,nan", "nan", "lun", "hu",
				"ling", "you", "yu", "qing", "yu", "huan,yuan", "wei", "zhi", "pei", "tang,nu", "chou,dao", "ze",
				"guo", };
	}

	private static String[] init225() {
		return new String[] { "xi", "zan", "li", "yu", "yan", "zui", "mao", "dan", "dou", "zhen", "ki mo to", "fu",
				"tian", "qia", "po", "chou", "zai", "chuo", "you", "yin", "pu", "zui", "hai", "wei", "lu", "lan",
				"yan", "tao", "zhan", "tan,dan", "zhui", "xian", "du", "tan", "qiu,chou", "chun", "yun", "po,fa", "ke",
				"sou", "chou", "cuo", "yun", "yong", "ang", "zha", "jiang", "piao", "chan,chen", "yu", "li", "zao",
				"yi", "jiang", "tan", "po,fa", "nong", "yi,shi", "yan,lian,xian", "yi", "niang", "ru", "chou", "yan",
				"ling", "mi", "mi", "niang", "xin", "jiao", "shi", "mi", "yan", "bian", "shi", "shi", "li,xi", "jin",
				"ga", "yi", "liao", "dao", "zhao", "ding", "po", "qiu", "he", "zhen", "zhi", "ba", "luan", "fu", "nai",
				"diao", "shan", "qiao,jiao", "wei", "wo", "man", "zhang", "fu", "fan", "ji", "qi", "qian", "qi", "qu",
				"ya", "xian", "ao", "cen", "lan", "ba", "hu", "ke", "dong", "jia", "xiu", "dai", "gou", "mao", "min",
				"yi", "tong,dong", "jiao,qiao", "xun", "zheng", "lao", "lai", "song", "yan", "gu", "xiao", "guo",
				"kong", "jue", "rong", "yao", "wai,wei", "zai", "wei", "yu", "cuo", "lou", "zi", "mei", "sheng",
				"song", "ji", "zhang", "lin", "deng", "bin", "yi", "dian", "chi", "pang,fang", "cu", "xun", "yang",
				"hou", "lai", "xi", "chang", "huang", "yao", "zhi,zheng", "jiao", "qu", "shan,xian", "quan", "qiu",
				"han,an", "guang", "ma", "niu", "yun", "xia", "pao", "fei", "rong", "kuai", "shou", "sun", "bi",
				"juan", "li", "yu", "xian", "yin", };
	}

	private static String[] init226() {
		return new String[] { "kou", "chuan", "zi", "fan", "hua,yu", "hua,wu", "han", "gang", "qi", "mang",
				"ri,ren,jian", "di,dai", "si", "xi", "yi", "chai", "shi,yi", "tu", "xi", "nv", "qian", "qiu",
				"ri,ren,jian", "pi,zhao", "ye,ya", "jin", "ba", "fang", "chen", "xing", "dou", "yue", "qian", "fu",
				"bu", "na", "xin", "e", "jue", "dun", "gou", "yin", "qian", "ban", "sa", "ren", "chao", "niu", "fen",
				"yun", "yi", "qin", "pi", "guo", "hong", "yin", "jun", "diao", "yi", "zhong", "xi", "gai", "ri", "huo",
				"tai", "kang", "ha ba ki", "lu", "e", "qin", "duo", "zi", "ni", "tu", "shi", "min", "gu", "ke", "ling",
				"bing", "si", "gu", "bo", "pi", "yu", "si", "zuo", "bu", "you", "dian", "jia", "zhen", "shi", "shi",
				"tie", "ju", "suan", "yi", "guo", "luo", "ni", "she", "cu", "mi", "hu", "cha", "wei", "wei", "mei",
				"nao", "zhang", "jing", "jue", "liao", "xie", "xun", "huan", "chuan", "huo", "sun", "yin", "zhi,zhong",
				"shi", "xing", "tun", "xi", "ren", "yu", "chi", "yi", "xiang", "bo", "yu", "hun", "cha", "sou", "mo",
				"xiu", "jin", "san", "zhuan", "nang", "pi", "wu", "gui", "pao", "xiu", "xiang", "tuo", "an", "yu",
				"bei", "geng", "ao", "jin,qin", "chan", "xie", "lin", "ying", "xin", "dao", "cun", "chan", "wu", "zhi",
				"ou", "chong", "wu", "kai,xi", "chang", "chuang", "song,zhong", "bian", "niu", "hu", "chu", "peng",
				"da", "yang", "zuo,zha", "ni", "fu", "chao", "yi", "yi", "tong", "yan", "ce", "kai", "xun", };
	}

	private static String[] init227() {
		return new String[] { "zuan", "shi", "ta", "xuan", "zhao", "bao", "he", "bi", "sheng", "chu", "shi", "bo",
				"zhu", "chi", "za", "po", "tong", "qian", "fu", "zhai", "mao", "qian", "fu", "li", "yue", "pi", "yang",
				"ban", "bo", "jie", "gou", "shu", "zheng", "mu", "xi", "xi", "di", "jia", "mu", "tan", "shen", "yi",
				"si", "kuang", "ka", "bei", "tong", "xing", "hong", "jiao", "chi", "er", "ge", "bing", "shi", "mao",
				"ha", "yin", "jun", "zhou", "chong", "xiang,jiong", "tong", "mo", "lei", "ji", "yu,si", "xu,hui",
				"ren", "zun", "zhi", "shan,shuo", "chi,li", "xian,xi", "xing", "quan", "pi", "tie", "zhu", "hou,xiang",
				"ming", "kua", "diao,tiao,yao", "xian,kuo,tian,gua", "xian", "xiu", "jun", "cha", "lao", "ji", "pi",
				"ru", "mi", "yi", "yin", "guang", "ke", "yun", "bei", "song", "qian", "kui,li", "kun", "yi", "ti",
				"quan", "qie", "xing", "fei", "chang", "wang", "chou", "hu", "cui", "yun", "kui", "e", "leng", "zhui",
				"qiao", "bi", "su", "qian,qie", "yong", "jing", "qiao", "chong", "chu", "lin", "meng", "tian",
				"hui,duo", "shuan", "yan", "wei", "hong", "min", "kang", "ta", "lv", "kun", "jiu", "lang", "yu",
				"chang", "xi", "wen", "hun", "e", "qu", "que", "he", "tian", "que", "kan", "pan", "pan", "qiang",
				"shui", "qi", "si", "cha", "feng", "yuan", "mu", "mian", "dun", "mi", "gu,yu", "bian", "wen,men",
				"hang", "wei", "le", "gan", "shu", "long,shuang", "lu", "yang", "si", "tuo,duo", "ling", "mao",
				"luo,po", "xuan", "pan", "tuo", "hong", "min", "jing", };
	}

	private static String[] init228() {
		return new String[] { "an", "diu", "you", "se", "kao", "qian", "ka si ga yi", "ngai", "diao", "han", "rui",
				"shi,zhi", "keng", "qiu", "xiao", "zhe,nie", "xiu", "zang", "ti", "cuo", "xian,kuo,tian,gua",
				"hong,gong", "zhong,yong", "tou,tu,dou", "lv", "mei,meng", "lang", "wan,jian", "xin", "yun", "bei",
				"su", "yu", "chan", "ting,ding", "bo", "han", "jia", "hong", "juan,jian,cuan", "feng", "chan", "wan",
				"zhi", "si,tuo", "xuan,juan", "hua,wu", "wu", "tiao", "kuang", "zhuo,chuo", "l<e", "xing,jing", "qin",
				"shen", "han", "l<e", "ye", "chu", "zeng", "ju", "xian", "e", "mang", "pu", "li", "pan", "rui",
				"cheng", "gao", "li", "te", "biao", "zhu", "zhen", "tu", "liu", "zui,nie", "ju", "chang", "yuan,wan",
				"jian", "gang", "diao", "tao", "shang", "lun", "ke", "ling", "pi", "lu", "li", "qing", "pei", "juan",
				"min", "huan", "wei", "lie", "jia", "zhen", "yin", "hui", "zhu", "ji", "xu", "kuai,hui", "tao", "xun",
				"jiang", "liu", "hu,xu", "xun", "ru", "su", "wu", "lai", "wei", "zhuo", "juan", "cen", "bang", "xi",
				"mei", "huan", "zhu", "qi", "xi", "song", "du,dou", "zhuo", "pi,pei", "mian,sheng", "gan", "fei",
				"cong", "shen", "guan", "lu", "shuan", "xie", "yan,yin", "mian", "qiu,jiao", "sou", "huang", "xu",
				"pen", "jian", "xuan", "wo", "mei", "yan", "zhen,qin", "ke", "she", "mang", "ying", "pu", "li", "ru",
				"ta", "hun", "bi", "xiu", "fu", "tang", "pang", "ming", "huang,guang", "ying", "xiao", "lan", "cao",
				"hu", "luo,ta", "huan", "lian", "zhu", "yi", "lu", "xuan", "gan", "shu,zhu", "si", "shan", "shao",
				"tong", "chan", "lai", };
	}

	private static String[] init229() {
		return new String[] { "zui", "peng", "an", "pi", "xian", "ya", "zhui", "lei", "a", "kong", "ta", "kun", "du",
				"nei", "chui", "zi", "zheng", "ben", "nie", "cong", "chun", "tan", "ding", "qi", "qian", "zhui", "ji",
				"yu", "jin", "guan", "mao", "chang", "tian", "xi", "lian", "diao", "gu", "cuo", "shu", "zhen", "lu",
				"meng", "lu", "hua", "biao", "ga", "lai", "ken", "ka za li", "bu", "nai", "wan", "hu", "de", "xian",
				"uu", "huo", "liang", "fa", "men", "kai", "yang", "chi", "lian", "guo", "xian", "du", "tu", "wei",
				"zong", "fu", "rou", "ji", "e", "jun", "chen", "ti", "zha", "hu", "yang", "duan", "xia", "yu", "keng",
				"sheng", "huang", "wei", "fu", "zhao", "cha", "qie", "shi", "hong", "kui", "nuo", "qiao", "sui", "li",
				"dan,tan", "chan", "lian", "ru", "pu", "bi,pi", "hao", "zhuo,zhao", "han", "xie", "ying", "yue", "fen",
				"hao", "ba", "mian", "gui", "dang", "mi,fu", "you", "chen", "ning", "qian", "qian", "wu", "liao",
				"qian", "huan", "jian", "jian", "chuo", "ya", "wu", "jiong", "ze", "yi", "er", "jia", "jing", "dai",
				"hou", "pang", "bu", "li", "qiu", "xiao", "ti", "qun", "kui", "wei", "huan", "lu", "chuan", "huang",
				"qiu", "xia", "ao", "gou", "ta", "liu", "xian", "lin", "ju", "xie", "miao", "sui", "la", "xue", "hui",
				"tuan", "zhi", "kao", "zhi", "ji", "e", "chan,can", "xi", "ju", "chan", "jing", "nu", "mi", "fu", "bi",
				"yu", "che,cao", "shuo", "fei,pei", "yan", "wu", "yu", "bi", };
	}

	private static String[] init230() {
		return new String[] { "qiao", "hou", "tou", "cong", "huan", "ye", "min", "jian", "duan", "jian", "si", "kui",
				"hu", "xuan", "zhe", "jie", "zhen", "bian", "zhong", "zi", "xiu", "ye", "mei", "pai", "ai", "jie",
				"qian", "mei", "cuo,cha", "da,ta", "bang", "xia", "lian", "suo,se", "kai", "yao,zu", "ye,ta,ge", "nou",
				"weng", "rong", "tang", "suo", "qiang,cheng", "ge,li", "shuo", "chui", "bo", "pan", "da", "bi,pi",
				"sang", "gang", "zi", "wu", "ying", "huang", "tiao", "liu", "kai", "sun", "sha", "sou", "wan,jian",
				"gao,hao", "zhen", "zhen", "lang", "yi", "yuan", "tang", "nie", "xi", "jia", "ge", "ma", "juan",
				"ka su gai", "ha ba ki", "suo", "xia", "feng", "wen", "na", "lu", "suo", "ou", "zu,chuo", "tuan",
				"xiu", "guan", "xuan", "lian", "shou,sou", "man", "mo", "luo", "jin", "zi", "gui", "niu", "yu", "si",
				"da", "zhou", "shan", "qie", "ya", "rao", "shu", "luan", "jiao,xiao", "pin", "cha", "li", "ping", "wa",
				"xian", "suo", "di", "wei", "e", "jing", "biao", "jie", "chang", "bi", "chan", "nu", "ao,yun,wo",
				"yuan", "ting", "wu", "gou", "mo", "pi", "ai", "pin", "chi", "li", "yan", "qiang", "piao", "chang",
				"lei", "zhang", "xi", "shan", "bi", "niao", "mo", "shuang", "ga", "ga", "fu", "nu", "zi", "jie", "jue",
				"bao", "zang", "si", "fu", "zou", "yi", "nu", "tai", "xiao", "hua", "pian", "li", "qi", "ke", "zhui",
				"can", "zhi", "wu", "ao", "liu", "shan", "piao,biao", "cong", "chan", "ji", "xiang", "si", "yu",
				"zhou", "he,ge", "wan", "kuang", };
	}

	private static String[] init231() {
		return new String[] { "bi", "wei", "liu", "di", "san,qiao,can", "cong", "yi", "lu,ao", "keng", "qiang", "cui",
				"qi", "shang", "tang", "man", "yong", "chan", "feng", "jing", "biao", "shu", "lou", "xiu", "cong",
				"long", "zan", "jian,zan", "cao", "li", "xia", "xi", "kang", "shuang", "beng", "zhang", "qian",
				"zheng", "lu", "hua", "ji", "pu", "hui,sui,rui", "qiang", "po", "lin", "se", "xiu", "san,xian,sa",
				"cheng", "gui", "si", "liu", "nao", "huang", "pie", "sui", "fan", "qiao", "quan", "xi", "tang",
				"xiang", "jue", "jiao", "zun", "liao", "qi", "lao", "dui", "xin", "zan", "ji", "jian", "zhong", "deng",
				"ya", "ying", "dui", "jue", "nou", "zan", "pu", "te te su", "uu", "cheng", "ding", "shan", "kai",
				"jian", "fei", "sui", "lu", "juan", "hui", "yu", "lian", "yun", "pi,bi", "shu", "gan", "xie", "fu",
				"zhou", "fu", "chu", "dai", "ku", "hang", "jiang", "geng", "xiao", "ti", "ling", "qi", "fei", "shang",
				"gun", "duo", "shou", "liu", "quan", "wan", "zi", "ke", "xiang", "ti", "miao", "hui", "si",
				"bian,pian", "gou", "zhui", "min", "jin", "zhen", "ru", "gao", "li", "yi", "jian", "bin", "piao",
				"man", "lei", "mou,miu,miao,mu,liao", "sao", "xie", "liao", "zeng", "jiang", "qian", "qiao,sao",
				"huan", "zuan", "yao", "ji", "chuan", "zai,zi", "yong", "ding", "ji", "wei", "bin,fen", "min,wen",
				"jue", "ke", "long", "dian", "dai", "po", "min", "jia", "er", "gong", "xu", "ya", "heng", "yao", "luo",
				"xi", "hun,hui", "lian", "qi", "ying", "qi", "hu", "kun", "yan", "cong", "wan", };
	}

	private static String[] init232() {
		return new String[] { "zhuo", "qiao", "jian", "zhuo", "lei", "bi", "tie", "huan", "ye", "duo", "guo", "dang",
				"ju", "fen", "da", "yi", "ai", "zong", "xun", "diao", "zhu", "heng", "zhui", "ji", "nie", "he", "huo",
				"qing", "bin", "ying", "gui", "ning", "xu", "jian", "jian", "ya ri", "cha", "zhi", "mie", "li", "lei",
				"ji", "zuan", "kuang", "shang", "peng", "la", "du", "shuo", "chuo", "lv", "biao", "bao", "lu", "xian",
				"kuan", "long", "e", "lu", "jian", "lan", "bo", "jian", "yue", "chan", "xiang", "jian", "xi", "guan",
				"cang", "nie", "lei", "cuan", "qu", "pan", "luo", "zuan", "luan", "zao", "nie", "jue", "tang", "zhu",
				"lan", "sa,xi", "yang", "xing", "bao", "xing", "mang", "ya", "zhi", "xian,kuo,tian,gua", "wu", "qi",
				"chang", "chen", "ju", "mao", "yu", "yuan", "xia", "nao", "ai", "tang", "jin", "huang", "ying", "cui",
				"cong", "xuan", "zhang", "pu", "can", "qu", "lu", "bi", "zan", "wen", "wei", "yun,wen", "tao", "wu",
				"shao,biao", "qi", "cha", "ma", "li", "pi", "miao", "yao", "rui", "jian", "chu", "cheng", "cong,zong",
				"xiao", "fang,bing", "pa", "zhu", "nai", "zhi", "zhe", "long", "jiu", "ping", "lu", "xia", "xiao",
				"you", "zhi", "tuo", "zhi", "ling", "ju,gou", "di", "li,yue", "tuo,duo", "cheng", "kao", "lao", "ya",
				"rao,nao", "zhi", "zhen", "guang", "qi", "ting", "gua,tian", "jiu", "hua", "heng,hang", "gui,hui",
				"jie", "luan", "juan", "an", "xu", "fan", "gu", "fu", "jue", "zi", "suo", "ling", "chu", "fen", "du",
				"qian", "zhao,zhuo", };
	}

	private static String[] init233() {
		return new String[] { "zhi", "yang", "huang", "zi", "bo", "tang", "rong", "beng", "liu", "huan", "la", "chan",
				"chang", "chang", "jiu", "ao", "die", "jie", "liao", "mi", "men", "ma", "shuan", "shan", "huo,shan",
				"men", "yan", "bi", "han,bi", "bi", "ci ka ai lu", "kai", "kang", "beng", "hong", "run", "san", "xian",
				"xian,jian", "jian", "min", "xia", "lao", "dou", "zha", "nao", "zhan", "peng", "xia,ke", "ling",
				"bian,guan", "bi", "run", "he", "guan", "ge", "he,ge", "fa", "chu", "hong,xiang", "gui", "min", "se",
				"kun", "lang", "lv", "ting", "sha", "ju", "yue", "yue", "chan", "qu", "lin", "chang", "sha", "kun",
				"yan", "wen", "yan", "e,yan", "hun", "yu", "wen", "hong", "bao", "hong,juan,xiang", "qu", "yao", "wen",
				"ban,pan", "an", "wei", "yin", "kuo", "que", "luo", "chui", "liang", "guo", "jian", "di,dai,ti", "ju",
				"cou,zou", "zhen,shen", "nan", "zha,cha", "lian", "lan", "ji", "pin", "ju", "qiu", "duan", "chui",
				"chen", "lv", "cha", "ju", "xuan", "mei", "ying", "zhen", "fei", "ta", "sun", "xie", "gao", "cui",
				"gao", "shuo", "bin,bing", "rong", "zhu", "xie", "jin", "qiang", "qi,se", "chu", "tang", "zhu", "hu",
				"gan", "yue", "qing", "tuo", "jue", "qiao", "qin", "lu", "zun", "xi", "ju", "yuan", "lei", "yan",
				"lin", "bo", "cha", "you", "ao", "mo", "cu", "shang", "tian", "yun", "lian", "piao", "dan", "ji",
				"bin", "yi", "ren", "e", "gu", "ke", "lu", "zhi", "yi", "zhen", "hu", "li", "yao", "shi", "zhi",
				"quan", "lu", "zhe", "nian", "wang", };
	}

	private static String[] init234() {
		return new String[] { "lan", "du,she", "quan", "pei ying,po he deng", "tian", "nie", "ta", "kai", "he", "que",
				"chuang", "guan", "dou", "qi", "kui", "tang,chang", "guan", "piao", "kan,han", "xi,se,ta", "hui",
				"chan", "pi", "dang", "huan", "ta", "wen", "uu", "han,bi", "kai", "du", "hui", "ta", "huan", "le",
				"xin", "yi", "tuo", "yin", "yang", "dou", "e", "sheng", "pei", "keng", "yun", "zhi", "pi", "cheng",
				"e", "qu", "di", "lin", "tuo", "bing", "duo", "shu", "duo", "er", "gui", "yu", "jun", "qiao", "xing",
				"chun", "wu", "xia", "shan", "sheng", "pu", "zhen", "xian", "dao", "fei", "qi", "dui", "lun", "yin",
				"ju", "chen", "lu", "sheng", "xian", "yin", "zhu", "yang", "reng", "xia", "chong", "yan", "yin",
				"yu,yao,shu", "di", "wei", "nie", "dui,zhui", "chuo", "zi", "cou", "lu", "lin", "wei", "jian", "qiang",
				"jia", "ji", "ji", "kan", "deng", "gai", "jian", "zang,cang", "ou", "ling", "bu", "beng", "zeng", "pi",
				"pu", "ga", "la", "gan,han", "hao", "tan", "gao", "ze", "xin", "yun", "jiong,gui", "he", "zan", "mao",
				"yu", "chang", "ni", "qi,shi", "sheng,cheng", "ye", "chao", "yan", "hui", "bu", "han", "gui", "xuan",
				"kui", "ai", "ming", "tun", "xun", "yao", "xi", "nang", "bi", "shi", "kuang", "yi", "zhi", "zi", "gai",
				"jin", "zhen", "lai", "qiu", "ji", "dan", "fu", "chan", "ji", "xi", "di", "yu", "gou", "jin", "qu",
				"jian", "jiang", "pin", "mao", "gu", "wu", "gu", "ji", "ju", "jian,qian", "pian", "kao", "qie",
				"suo,sa,sha", "bai", };
	}

	private static String[] init235() {
		return new String[] { "an", "jie", "qi,gai,ai", "yan", "hui,duo", "yun", "wu", "tang", "ji", "dao", "ao", "xi",
				"yin", "sa", "rao", "lin", "tui", "deng", "pi", "sui", "ao,yu", "xian", "fen", "ni", "er", "ji", "dao",
				"yin", "zhi", "long", "xi", "li,dai", "li,dai", "hu,he", "zhi", "yi", "qin", "jian", "huan", "gou",
				"jun,juan", "hu", "za", "yu", "chou", "sui", "han", "huo", "shuang", "guan,huan", "chu", "za", "yong",
				"ji", "gui,xi", "liu", "li", "nan,nuo", "yu", "za", "chou", "ji", "na", "fou", "se,xi", "mu", "fen",
				"pang", "yun", "chi", "yang", "an", "wu,meng", "dian", "dang", "hu", "diao", "mu", "chen", "zha",
				"ling", "qi", "zhou", "hong", "zhan", "yin", "shu", "tun", "ling", "dong", "ying", "wu", "ling",
				"ling", "hong", "yin", "ge", "bo,bai", "mao", "mu", "cui", "jian", "san", "shu", "chang", "lu", "pu",
				"qu", "pie", "dao", "xian", "chuan", "dong", "ya", "yin", "ke", "yun", "pu", "chi", "jiao", "du",
				"die", "you", "yuan", "guo", "yue", "wo", "rong,chen", "huang", "jing", "ruan", "tai", "gong",
				"zhun,chun", "na", "yao", "qian", "long", "dong", "ka", "lu", "jia", "shen", "zhou", "zuo", "gua",
				"zhen", "qu,xu,chun", "zhi", "jing", "guang", "dong", "yan", "kuai", "sa", "hai", "pian", "zhen", "mi",
				"tun", "luo", "cuo", "pao", "wan", "niao", "jing", "yan", "fei", "yu", "zong", "ding", "jian", "cou",
				"nan", "mian", "wa", "e", "shu", "cheng", "ying", "ge", "lv", "bin", "teng", "zhi", "chuai", "gu",
				"meng", "sao", "shan,dan", };
	}

	private static String[] init236() {
		return new String[] { "mai", "mai", "yun", "liu", "meng", "bin", "wu", "wei", "kuo", "xi", "yi", "dan", "teng",
				"yu", "long", "dai", "ji", "pang", "yang", "wei", "uu", "xi", "ji", "meng", "meng", "lei", "li", "huo",
				"ai", "fei", "dai", "long", "ling", "ai", "feng", "li", "bao", "he", "he", "he", "bing", "qing",
				"tian", "zheng", "cheng", "qing", "jing", "jing", "tian", "fei", "mian", "pao", "mian", "hui", "ye",
				"ding", "cha", "jian", "ren", "di", "du", "wu", "ren", "qin", "niu", "yin", "sa", "na", "mo", "zu",
				"ban", "xie", "yao", "tao", "bei", "jie", "hong", "pao", "bing", "yin", "ge,ta,sa", "tao", "jie,ji",
				"an", "hen", "gong", "ko ha zei", "ting", "bian,ying", "sui", "tiao", "xuan,juan", "kong", "beng",
				"ta", "shang,zhang", "lian", "lin", "yu", "xi", "qi", "sha", "xin", "xi,she", "biao", "sa", "ju",
				"sou", "biao", "biao", "shu", "gou", "gu", "hu", "fei", "ji", "lan", "yu,wu", "pei", "mao", "zhan",
				"jing", "ni", "liu", "yi", "yang", "wei", "dun", "qiang", "shi", "hu", "zhu", "xuan", "tai", "ye",
				"yang", "wu", "han", "men", "zhuo,chao", "yan", "hu", "yu", "wei", "duan", "bao", "xuan", "bian",
				"tui", "liu", "man", "shang", "yun,yu", "yi", "yu", "fan", "sui", "xian", "jue", "cuan", "huo,biao",
				"dao", "xu", "xi", "li", "hu", "jiong", "hu", "fei", "shi", "si", "xian", "zhi", "qu", "hu", "fu",
				"zuo", "mi", "zhi", "ci", "zhen", "tiao", "qi", "chan,shan", "xi", "zhuo", "xi", "rang", "te", "tan", };
	}

	private static String[] init237() {
		return new String[] { "bing,pi,bi,bei", "kuo", "la", "xie,die", "bang", "eng", "qiu", "qiu", "he", "qiao",
				"mu,mou", "jian", "di", "wen,yun", "tao", "ta", "xie", "pan", "ge", "bi,bing", "kuo", "tang", "lou",
				"gui", "qiao", "xue", "ji", "jian", "jiang", "chan", "da", "huo", "xian", "qian", "du", "wa", "jian",
				"lan", "wei", "ren", "fu", "mei,wa", "quan", "ge", "wei", "qiao", "han", "chang", "kuo", "rou", "yun",
				"she,xie", "wei", "ge", "bai", "tao", "gou", "yun", "gao", "bi", "wei", "sui", "du", "wa", "du", "fu",
				"jiu", "xian", "xie", "xian", "ji", "za", "le", "peng", "huang", "ying", "yun", "peng", "an", "yin",
				"xiang", "hu", "ye", "ding", "qing", "qiu", "xiang", "shun", "han", "xu", "yi", "xu", "e", "song",
				"kui", "qi", "dui", "jia", "hui", "nv", "nen,nin", "yang", "zi", "que", "qian", "min", "te", "qi",
				"dui", "mao", "men", "gang,zhuang", "yu", "yu", "ta,da", "xue", "miao", "ji", "gan", "dang", "xu,hua",
				"che", "dun", "ya", "zhuo", "bian", "feng", "fa", "ai", "li", "long", "zha", "tong", "di", "li,la",
				"tuo", "fu,fei", "xing", "mang", "xia", "qiao", "zhai", "dong", "nao", "luo,ge", "wo", "qi", "dui",
				"bei", "ding", "chen", "zhou", "jie,ya", "di", "xuan", "bian", "zhe", "gun", "sang", "qing", "qu",
				"dun", "deng", "jiang", "ca", "meng", "bo", "kan", "zhi", "fu", "fu", "xu", "mian", "kou", "dun",
				"miao", "dan", "sheng", "yuan", "yi,chi", "gui,sui", "zi", "chi", "mou", "lai", "jian", "di", "suo",
				"ya", "ni", };
	}

	private static String[] init238() {
		return new String[] { "hang", "yu", "wan", "ban", "dun", "di", "dan", "pan", "po", "ling", "che", "jing",
				"lei", "he", "qiao", "e", "e", "wei", "jie", "kuo", "shen", "yi", "yi", "ke", "dui", "yu", "ping",
				"lei", "fu", "jia", "tou", "hui", "kui", "jia", "luo", "ting", "cheng", "ying", "jun", "hu", "han",
				"jing", "tui", "tui", "bin", "lai", "tui", "zi", "zi", "chui", "ding", "lai", "tan", "han", "qian",
				"ke", "cui", "jiong", "qin", "yi", "sai", "ti", "e", "e", "yan", "wen", "kan", "yong", "zhuan", "yan",
				"xian", "xin", "yi", "yuan", "sang", "dian", "dian", "jiang", "kui", "lei", "lao", "piao", "wai",
				"man", "cu", "yao", "hao", "qiao", "gu", "xun", "yan", "hui", "chan", "ru", "meng", "bin", "sui", "bi",
				"rui", "sou", "kui", "mao", "ke", "ming", "piao", "cheng", "kan", "lin", "gu", "ting,ding", "bi",
				"quan", "tian", "fan", "zhen", "she", "wan", "tuan", "fu", "gang", "gu", "li", "yan", "pi", "lan",
				"li", "ji", "zeng", "he", "guan", "juan", "jin", "ga", "yi", "po", "zhao", "liao", "tu", "chuan",
				"shan", "men", "chai", "nv", "bu", "tai", "ju", "ban", "qian", "fang", "kang", "dou", "huo", "ba,pa",
				"yu", "zheng", "gu", "ke", "po", "bu", "bo", "yue", "mu", "tan", "dian,tian", "shuo", "shi", "xuan",
				"ta,tuo", "bi", "ni", "pi", "duo", "kao", "lao", "er", "you", "cheng", "jia", "nao", "ye",
				"dang,cheng", "diao", "yin", "kai", "zhu", "ting,ding", "diu", "hua", "quan", "ha,ke", };
	}

	private static String[] init239() {
		return new String[] { "xian", "pin", "lu", "lan", "nie", "quan", "ting", "jiong", "hui", "ying", "yong", "lei",
				"feng", "biao,diu", "gua", "fu", "xia", "zhan", "biao", "sa", "ba,fu", "tai", "lie", "gua", "xuan",
				"xiao", "ju", "biao", "si", "wei", "yang", "yao", "sou", "kai", "sao,sou", "fan", "liu", "xi",
				"liu,liao", "piao", "piao", "liu", "biao", "biao", "biao", "liao", "biao", "se", "feng", "xiu", "yang",
				"zhan", "si", "yao", "liu", "fei", "fan", "fei", "shi", "can", "ji", "ding", "si", "tuo", "zhan",
				"tun", "ren", "yu", "yang,juan", "chi", "yin", "fan", "fan", "sun", "yin", "zhu,tou", "yi,si",
				"zuo,ze,zha", "bi", "jie", "tao", "bao", "ci", "tie", "si", "bao", "shi", "duo", "hai", "ren", "tian",
				"jiao", "he", "bing", "yao", "tong", "sha", "diao,tiao,yao", "zheng", "se", "chong", "tang", "an",
				"ru", "lao", "lai", "te", "keng", "zeng", "li", "gao", "e", "cuo", "l<e", "liu", "kai", "jian", "lang",
				"qin", "ju", "a", "qiang", "nuo", "ben", "de", "ke", "kun", "gu", "huo", "pei", "juan", "tan", "zi",
				"qie", "kai", "si", "e", "cha", "sou", "huan", "ai", "lou", "qiang", "fei", "mei", "mo", "ge", "juan",
				"na", "liu", "yi", "jia", "bin", "biao", "tang", "man", "luo", "yong", "zu", "xuan", "di", "xin",
				"jue", "pu", "lu", "dui", "lan", "pu", "cuan", "qiang", "deng", "huo", "zhuo", "yi", "cha", "biao",
				"zhong", "shen", "cuo", "zhi", "bi", "zi", "mo", "shu", "lv", "ji", "fu", "lang", "ke", "ren", };
	}

	private static String[] init240() {
		return new String[] { "ci", "xiang", "yang", "juan", "er", "le", "xi", "bo", "nei", "e", "bu", "jun", "dou",
				"su", "yu", "shi", "yao", "hun", "guo", "shi", "jian", "chuo", "bing", "xian", "bu", "ye", "dan",
				"fei", "zhang", "wei", "guan", "e", "nuan", "yun", "hu", "huang", "hui", "jian", "hou", "ai", "xing",
				"fen", "wei", "gu", "cha", "song", "tang", "bo", "gao", "xi", "kui", "liu", "sou", "tao", "ye", "wen",
				"mo", "tang", "man", "bi", "yu", "xiu", "jin", "san", "kui", "zhuan", "shan", "xi", "dan", "yi", "ji",
				"rao", "cheng", "wei", "xiang", "zhan", "fen", "hai", "meng", "yan", "mo", "chan", "xiang", "luo",
				"zan", "nang", "ding", "tuo", "duo", "he", "le", "xi", "dou", "jun", "guo", "gu", "zhen", "ji", "se",
				"nian", "fu", "rang", "gui", "jiao", "hao", "xi", "po", "die", "hu", "yong", "jiu", "yuan", "bao",
				"zhen", "gu", "dong", "lu", "qu", "chi", "si", "er", "zhi", "gua", "xiu", "luan", "bo", "li", "hu",
				"yu", "xian", "ti", "wu", "miao", "an", "bei", "chun", "hu", "e", "ci", "mei", "wu", "yao", "jian",
				"ying", "zhe", "liu", "liao", "jiao", "jiu", "yu", "hu", "lu", "guan", "ne", "ding", "jie", "li,lai",
				"shan", "li", "you", "gan", "ke", "dan", "zha", "pao", "zhu", "xuan", "jia", "ya", "yi", "zhi", "lao",
				"wu", "cuo", "xian", "sha", "zhu", "fei", "gu", "wei", "yu", "yu", "dan", "la", "yi", "hou",
				"chai,cuo", "lou", "jia,xia", "sao", };
	}

	private static String[] init241() {
		return new String[] { "ye", "bo", "fen", "bo", "ni", "bi", "bo", "tu", "han", "fei", "jian", "an", "ai",
				"xian", "yun,wo", "fen", "pin", "xin", "ma", "yu", "feng,ping", "han", "di", "tuo,duo", "tuo,zhe",
				"chi", "xun", "zhu", "zhi,shi", "pei", "xin,jin", "ri", "sa", "yun", "wen", "zhi", "dan", "lu", "you",
				"bo", "bao", "jue,kuai", "tuo,duo", "yi", "qu", "wen", "qu", "jiong", "po", "zhao", "yuan", "peng",
				"zhou", "ju", "zhu", "nu", "ju", "pi", "zang", "jia", "ling", "zhen", "tai,dai", "fu", "yang", "shi",
				"bi", "tuo", "tuo", "si", "liu", "ma", "pian", "tao", "zhi", "rong", "teng", "dong", "xun,xuan",
				"quan", "shen", "jiong", "er", "hai", "bo", "zhu", "yin", "luo", "zhou", "dan", "hai", "liu", "ju",
				"song", "qin", "mang", "chi", "mo", "ban", "ji", "huang", "biao", "luo", "ying", "zhai", "long", "yin",
				"chou", "ban", "lai", "yi", "dian", "pi", "dian", "qu", "yi", "song", "xi", "qiong", "zhun", "bian",
				"yao", "tiao,yao", "dou", "ke", "yu", "yin,xun", "ju", "yu", "yi", "cha", "na", "ren", "jin", "mei",
				"pan", "dang", "jia,jie,qia", "ge", "ken", "lian", "cheng", "lian", "jian", "biao", "zhu", "xi,ti",
				"bi,pi", "ju", "duo", "da", "bei", "bao", "lv", "bian", "lan", "chi", "zhe", "qiang", "ru", "pan",
				"pi,ya,shu", "xu", "jun", "cun", "jin,qin,guan", "lei", "zi", "chao", "si", "huo", "lao", "tang", "ou",
				"lou", "jiang", "nou", "mo", "die", "ding", "dan", "ling", "ning", "guo", "kui", "ao", "tan,qin",
				"han", "qi", "hang", };
	}

	private static String[] init242() {
		return new String[] { "liang,lang", "han", "tu", "xuan", "tui", "jun", "e", "cheng", "xing", "si", "lu",
				"zhui", "zhou", "she", "pian", "kun", "tao", "lai", "zong", "ke", "qi", "qi", "yan", "fei", "sao",
				"yan", "ge", "yao", "wu", "pian", "cong", "pian", "qian", "fei", "huang", "qian", "huo", "yu", "ti",
				"quan", "xia", "zong", "kui", "rou", "si", "gua", "tuo", "gui", "sou", "qian", "cheng", "zhi", "liu",
				"peng", "teng", "xi", "cao", "du", "yan", "yuan", "zou", "sao", "shan", "qi", "zhi", "shuang", "lu",
				"xi", "luo", "zhang", "mo", "ao", "can", "piao", "cong", "qu", "bi", "zhi", "yu", "xu", "hua", "bo",
				"su", "xiao", "lin", "zhan", "dun", "liu", "tuo", "ceng", "dian", "jiao", "tie", "yan", "luo", "zhan",
				"jie,xie,jia", "he,ge", "ying", "ke", "han", "e", "zhuan", "nie", "man", "sang", "hao", "ru", "pin",
				"hu", "qian", "qiu", "ji", "chai", "hui", "ge", "meng", "fu", "pi", "rui", "xian", "hao", "jie",
				"gong,zhong", "dou", "yin", "chi", "han", "gu", "ke", "li", "you", "ran", "zha", "qiu", "ling",
				"cheng", "you", "qiong", "jia", "nao", "zhi", "si", "qu", "ting", "kuo", "qi", "jiao", "yang", "mou",
				"shen", "zhe", "xiao", "wu", "li", "chu", "fu", "qiang", "qing", "qi", "xi", "yu", "fei", "guo", "guo",
				"yi", "pi", "tiao", "quan", "wan", "lang", "meng", "chun", "rong", "nan", "fu", "kui", "ke", "fu",
				"sou", "yu", "you", "lou", "qiu", "bian", "mao", "qin", "ao", "man", "mang,meng", };
	}

	private static String[] init243() {
		return new String[] { "jing", "yi", "ye", "tuo", "pin", "zhou", "yan", "long", "lv", "teng", "xiang", "ji",
				"shuang", "ju", "xi", "huan", "li", "biao", "ri", "yin", "biao", "xing", "qin", "zong", "su", "kui",
				"shuang", "wei", "wei", "wei", "yu", "gan", "yi", "ang", "bao", "bei,mo", "ci", "ti", "qiao,xiao",
				"kua", "tui", "geng", "pian", "ou", "sui", "bo", "xiao", "bang", "bo,jue", "ci", "mo", "liao", "lou",
				"xiao", "zang", "ti", "bin", "kuan", "lu", "gao", "qiao", "kao", "qiao", "lao", "sao", "kun", "di",
				"fang", "xiu", "ran", "dan", "kun", "bin", "fa", "pi", "fa", "ti", "bao", "bi,po", "mao,meng", "fu",
				"er", "er", "qu", "gong", "kuo,yue", "peng", "zhua", "shao", "sha", "ti", "li", "bin", "ti", "peng",
				"song", "ma", "yuan", "xi", "chi", "tang", "pang", "shi,zhe", "huang", "cao", "piao", "tang", "xi",
				"xiang", "zhong", "zhang", "shuai", "mao", "peng", "hui", "pan", "shan", "huo", "meng", "chan", "lian",
				"mie", "li", "du", "qu", "fou", "ying", "qing", "xia", "shi", "zhu,du", "yu", "ji", "du", "ji", "jian",
				"zhao", "zi", "hu", "qiong", "po", "da", "sheng", "zuo,ze", "gou", "li", "si", "tiao", "jia", "bian",
				"chi", "kou", "bi", "xian", "yan", "quan", "zheng", "yun,jun", "shi", "gang", "pa", "shao", "xiao",
				"qing,jing", "ze", "qie", "zhu", "ruo", "qian", "tuo", "bi", "dan", "kong", "wan,yuan", "xiao", "zhen",
				"kui", "huang", "hou", "gou", "fei", "li", "bi", "chi", "su", "mie", "dou", "lu", "duan", "gui", };
	}

	private static String[] init244() {
		return new String[] { "zheng", "zong", "shun", "jian", "duo", "hu", "la", "qi", "lian", "zhen", "peng", "ma",
				"san", "man", "man", "seng", "xu", "lie", "qian", "qian", "nong", "kuo", "ning", "bin", "rang", "dou",
				"dou", "nao", "hong", "xi", "dou", "kan", "dou", "dou", "jiu", "yu", "yu", "yan", "fu", "zeng", "gui",
				"zong", "liu", "gui", "shang", "mei", "ji", "qi", "ga", "xu", "yu", "tui", "qi", "liang", "gan",
				"piao", "bi", "ji", "xu", "chou", "yan", "zhan", "yu", "dao", "ren", "ji", "bi li", "hong", "tuo",
				"diao", "ji", "yu", "e", "ji", "sha", "hang", "tun", "mo", "jie", "shen", "ban", "yuan", "pi", "lu",
				"wen", "hu", "lu", "za", "fang", "fen", "na", "you", "na ma zi", "mo", "he", "xia", "dian", "zan",
				"deng", "bo", "lai", "zhou", "yu", "yu", "chong", "xi", "nie", "nv", "chuan", "shan", "yi", "bi",
				"zhong", "ban", "fang", "ge", "lu", "zhu", "ze", "xi", "shao", "wei", "meng", "shou", "cao", "chong",
				"meng", "qin", "niao", "jia", "qiu", "sha", "bi", "di", "qiang", "suo", "jie", "tang", "xi", "xian",
				"mi", "ba", "li", "tiao", "xi", "zi,ci", "can", "lin", "zong", "san,shen", "hou", "zan", "ci", "xu",
				"rou", "qiu", "jiang", "gen", "ji", "yi", "ling", "xi", "zhu", "fei", "jian", "pian", "he", "yi",
				"mi,si", "zhi", "qi", "qing,qi", "yao,you,zhou", "dao", "fu", "qu", "jiu", "qie,ju", "lie", "zi",
				"zan", "nan", "zhe", "jiang", "chi", "ding", "gan", "zhou", "yi", "gu", };
	}

	private static String[] init245() {
		return new String[] { "qu", "han", "pi", "ling", "tuo", "ba", "qiu", "ping", "fu", "bi", "ci,ji", "wei", "ju",
				"diao", "bo,ba", "you", "gun", "pi", "nian", "xing", "tai", "bao", "fu", "zha", "ju", "gu", "shi",
				"dong", "chou", "ta", "jie", "shu", "hou", "xiang", "er", "an", "wei", "zhao", "zhu", "yin", "lie",
				"luo,ge", "tong", "yi", "yi", "bing", "wei", "jiao", "ku", "gui,xie,wa,kui", "xian", "ge", "hui",
				"luo la", "ma tai", "kao", "xiu", "tuo", "jun", "ti", "mian", "shao", "zha", "suo", "qin", "yu", "nei",
				"zhe", "gun", "geng", "su", "wu", "qiu", "shan", "pu,bu", "huan", "tiao", "li", "sha", "sha", "kao",
				"meng", "cheng", "li", "si ba xi li", "ka zi nou ke", "yong", "shen", "zi", "qi", "qing", "xiang",
				"nei", "chun", "ji", "diao", "zuo", "tuo", "xian", "ming", "zhi", "yan", "shi", "cheng", "tu", "lei",
				"kun", "pei", "hu", "ti", "xu", "hai", "tang", "lao", "bu", "jiao", "xi", "ju", "li", "xun", "shi",
				"cuo", "dun", "qiong", "xue", "cu", "bie", "bao,bo", "ta", "jian", "fu", "qiang", "zhi", "fu", "shan",
				"li,luo", "tuo", "jia", "bo", "tai", "kui", "qiao", "bi", "xian", "xian", "ji", "jiao", "liang", "ji",
				"chuo", "huai", "chi", "zhi", "dian", "bo", "zhi", "jian", "die", "chuai", "zhong", "ju", "duo", "cuo",
				"pian", "rou", "nie", "pan", "xi", "chu", "jue", "pu", "fan", "cu", "zhu", "lin", "chan", "lie",
				"zuan", "xie", "zhi", "diao", "mo", "xiu", "mo", "pi", "hu", "jue", "shang", "gu", "zi,zui", };
	}

	private static String[] init246() {
		return new String[] { "qie", "gu", "zhou", "dong", "lai", "fei", "ni", "yi,si", "kun", "lu", "jiu", "chang",
				"jing", "lun", "ling", "zou", "li", "meng", "zong", "zhi", "nian", "xia qi ho ko", "duo ji ya wu",
				"shu ke tou da ra", "shi", "shen", "huan", "ti", "hou", "xing", "zhu", "la", "zong", "ji", "bian",
				"bian", "huan", "quan", "zei", "wei", "wei", "yu", "chun", "rou", "die", "huang", "lian", "yan", "qiu",
				"qiu", "jian", "bi", "e", "yang", "fu", "sai", "jian", "xia", "tuo", "hu", "shi", "ruo", "ha la ka",
				"wen", "jian", "hao", "wu", "pang", "sao", "liu", "ma", "shi", "shi", "guan", "zi", "teng", "ta",
				"yao", "e", "yong", "qian", "qi", "wen", "ruo", "ha ta ha ta", "lian", "ao", "le", "hui", "min", "ji",
				"tiao", "qu", "jian", "shen", "man", "gong", "su", "zhi", "zi", "qing", "jing", "yu", "li", "wen",
				"ting", "ji", "pei", "fei", "sha", "yin", "ai", "xian", "mai", "chen", "ju", "bao", "tiao", "zi",
				"yin,ken", "yu", "chuo", "wo", "min,mian,meng", "yuan", "tuo", "zhui,cui,wei", "sun", "jun,juan", "ju",
				"luo", "qu,ju", "chou", "qiong", "luan", "wu", "zan", "mou", "ao", "liu", "bei", "xin", "you", "fang",
				"ba", "ping", "nian", "lu", "su", "fu", "hou", "tai", "gui,xie", "jie", "wei", "er", "ji", "jiao",
				"xiang", "xun", "geng", "li", "lian", "jian", "shi", "tiao", "gun", "sha", "huan", "ji", "qing",
				"ling", "zou", "fei", "kun", "chang", "gu", "ni", "nian", "diao", "shi", "zi", "fen", "die", "e",
				"qiu", "fu", "huang", "bian", "sao", };
	}

	private static String[] init247() {
		return new String[] { "xi", "qiu", "piao", "ji", "ji", "zhu", "jiang", "xiu", "zhuan", "yong", "zhang", "kang",
				"xue", "bie", "yu", "qu", "xiang", "bo", "jiao", "xun", "su", "huang", "zun", "shan", "shan", "fan",
				"gui", "lin", "xun", "yao", "xi", "ai suo", "ki ao", "fen", "guan", "hou", "kuai", "zei", "sao",
				"zhan", "gan", "gui", "ying", "li", "chang", "ha ta ha ta", "se", "ai", "ru", "ji", "xu", "hu",
				"shi ra", "li", "lie", "le", "mie", "zhen", "xiang", "e", "lu", "guan", "li", "xian", "dao", "ji",
				"tun", "ba", "he,ge", "you", "zha", "bo,ba", "pi", "kao", "tong", "zei", "hou", "kuai", "zha", "jun",
				"yong", "qi", "shen", "bi", "chang", "ti", "wen", "wei", "quan", "jiang", "pang", "jian", "wei", "xi",
				"hu", "gan", "ao", "qi", "ta", "guan", "yao", "le", "biao", "xue", "man", "min", "yong", "gui,jue",
				"shan", "zun", "li", "da", "yang", "da", "qiao", "man,men", "jian", "ju", "rou", "gou", "bei", "jie",
				"tou", "ku", "gu", "di", "hou", "ge", "ke", "bi", "lou", "qia", "kuan", "bin", "du", "mei", "ba",
				"yan", "liang", "xiao", "wang", "chi", "xiang", "yan", "tie", "tao", "yong", "biao", "kun", "mao",
				"ran", "tiao", "ji", "zi", "xiu", "quan", "jiu", "bin", "huan", "lie", "mo,me", "hui", "mi", "ji",
				"jun,qun", "zhu", "mi", "qi", "ao", "she", "lin", "dai", "chu", "you", "xia", "yi", "qu", "du", "li",
				"qing", "can", "an", "fen", "you", "wu", "yan", "xi", "qiu", "han", "zha", };
	}

	private static String[] init248() {
		return new String[] { "zhan,shan", "guan", "niao,diao", "yi", "fu", "li", "jiu", "bu", "yan", "fu",
				"diao,zhao", "ji", "feng", "ni o", "gan,han,yan", "shi", "feng", "ming", "bao", "yuan", "zhi", "hu",
				"qin", "fu,gui", "ban,fen", "wen", "jian,qian,zhan", "shi", "yu", "fou", "yao", "jue", "jue", "pi",
				"huan", "zhen", "bao", "yan", "ya", "zheng", "fang", "feng", "wen", "ou", "dai", "jia", "ru", "ling",
				"mie", "fu", "tuo", "min", "li", "bian", "zhi", "ge", "yuan", "ci", "qu", "xiao", "chi", "dan", "ju",
				"yao", "gu", "zhong", "yu", "yang", "yu", "ya", "die", "yu", "tian", "ying", "dui", "wu", "er", "gua",
				"ai", "zhi", "yan", "heng", "xiao", "jia", "lie", "zhu", "yang", "yi", "hong", "lu", "ru", "mou", "ge",
				"ren", "jiao", "xiu", };
	}

	private static String[] init249() {
		return new String[] { "zhou", "chi", "luo", "qi duo li", "tuo ki", "e", "luan", "jia", "ji", "tu", "huan",
				"tuo", "bu", "wu", "jian", "yu", "bo", "jun", "jun", "bi", "xi", "jun", "ju", "tu", "jing", "ti", "e",
				"e", "kuang", "hu", "wu", "shen", "lai", "zan", "ka kai si", "lu", "pi", "shu", "fu", "an", "zhuo",
				"peng", "qin", "qian", "bei", "diao", "lu", "que", "jian", "ju", "tu", "ya", "yuan", "qi", "li", "ye",
				"zhui", "kong", "duo", "kun", "sheng", "qi", "jing", "yi", "yi", "jing", "zi", "lai", "dong", "qi",
				"chun", "geng", "ju", "qu", "yi si ka", "ki ku yi ta da ki", "ji", "shu", "ying", "chi", "miao", "rou",
				"an", "qiu", "ti,chi", "hu", "ti,chi", "e", "jie", "mao", "fu,bi", "chun", "tu", "yan", "he,jie",
				"yuan", };
	}

	private static String[] init250() {
		return new String[] { "pian,bian", "kun", "mei", "hu", "ying", "chuan,zhi", "wu", "ju", "dong", "cang,qiang",
				"fang", "he,hu", "ying", "yuan", "xian", "weng", "shi", "he", "chu", "tang", "xia", "ruo", "liu", "ji",
				"gu,hu", "jian", "sun,xun", "han", "ci", "ci", "yi", "yao", "yan", "ji", "li", "tian", "kou", "ti",
				"ti", "yi", "tu", "ma", "xiao", "gao", "tian", "chen", "ji", "tuan", "zhe", "ao", "yao", "yi", "ou",
				"chi", "zhi", "liu", "yong", "lou,lv", "bi", "shuang", "zhuo", "yu", "wu", "jue", "yin", "ti", "si",
				"jiao", "yi", "hua", "bi", "ying", "su", "huang", "fan", "jiao", "liao", "yan", "gao", "jiu", "xian",
				"xian", "tu", "mai", "zun", "yu", "ying", "lu", "tuan", "xian", "xue", "yi", "pi", "zhu", "luo", "xi", };
	}

	private static String[] init251() {
		return new String[] { "yi", "ji", "ze", "yu", "zhan", "ye", "yang", "pi", "ning", "hu", "mi", "ying", "meng",
				"di", "yue", "yu", "lei", "bu", "lu", "he", "long", "shuang", "yue", "ying", "guan", "qu", "li",
				"luan", "shi", "cang", "xiao", "ling", "xue", "heng", "zhou", "wu", "kun", "qian", "geng", "yuan",
				"su", "he", "qiu", "yi", "weng", "liu", "ji", "yi", "yi", "huan", "zhan", "meng", "shuang", "lu",
				"jin", "ling", "jian", "xian", "cuo", "jian", "jian", "yan", "you", "cu", "pao,biao", "cu", "pao",
				"zhu,cu", "jian", "mi", "yu", "liu", "chen", "jun", "lin", "ni", "jiu", "jun", "jing", "li", "xiang",
				"xian", "jia", "mi", "li", "zhang", "jing", "qi", "ling", "yan", "cu", "mai", "he", "chao", "fu",
				"mian", };
	}

	private static String[] init252() {
		return new String[] { "mian", "fu", "pao", "qu", "qu", "mou", "fu", "xian", "lai", "mian", "chi", "feng", "qu",
				"mian", "mo,me", "mi", "zou", "nun", "fen", "huang", "jin", "guang", "tian", "tou", "hua", "kuang",
				"hong", "chi", "hei", "yi", "dan", "xi", "tun", "mo", "qian", "dian", "yan", "mei", "yan", "yue",
				"dang", "yan", "yan", "yan", "dan,shen", "zhen,yan", "dai", "can", "yi", "mei", "dan,zhan", "yan",
				"du", "lu", "fen", "min,mian,meng", "yuan", "cu", "qu", "chao", "wa", "zhu", "zhi", "meng", "ao",
				"bie", "tuo", "bi", "chao", "mi", "ding", "zi", "gu", "dong", "fen", "yuan", "chang", "gao", "cao",
				"yuan", "tang", "teng", "ne zu mi", "fei", "wen", "ba", "diao", "tuo", "zhong", "qu", "sheng", "shi",
				"shi", "ting", "ju", "jing", };
	}

	private static String[] init253() {
		return new String[] { "hun", "ju", "yan", "tu", "si", "xian", "lei", "yao", "wu", "wu", "hou", "xie", "e",
				"xiu", "weng", "zha", "nong", "nang", "qi", "zhai", "ji", "zi", "ji", "ji", "chi", "chen", "chen",
				"he", "ya", "yin", "xie", "bao", "ze", "xie", "zi", "chi", "yan", "ju", "tiao", "ling", "ling", "chu",
				"quan", "xie", "yin", "nie", "jiu", "yao", "chuo", "yun", "yu", "chu", "yi", "ni", "ze", "zou", "qu",
				"yun", "yan", "yu", "e", "wo", "yi", "ci", "zou", "dian", "chu", "jin", "ya", "he", "yin,ken", "long",
				"pang", "gong,wo", "pang", "yan", "long", "long", "gong", "kan", "da", "ling", "da", "gui,jun,qiu",
				"qiu", "bie", "chui", "he", "jiao", };
	}

	/**
	 * 获得字符对应的ascii码
	 * 
	 * @param cn
	 * @return string
	 */
	public static String getASCII(char cn) {
		try {
			byte[] bytes = (String.valueOf(cn)).getBytes("gbk");
			if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
				return "";
			}
			if (bytes.length == 1) {
				return new String(bytes);
			}
			if (bytes.length == 2) {
				int upperByte = 256 + bytes[0];

				int lowByte = bytes[1] < 0 ? 256 + bytes[1] : bytes[1];

				String ascii = upperByte + "-" + lowByte;

				return ascii;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 计算字符串对应的ascii码
	 * 
	 * @param ascii
	 * @return String
	 */
	public static String getByASCII(String ascii) {
		if (ascii.indexOf("-") > -1) {
			return SpellUtil.getSpellByAscii(ascii);
		} else {
			return ascii;
		}
	}

	/**
	 * 获得中文的全拼
	 * 
	 * @param cnStr
	 * @return String
	 */
	public static String getFull(String cnStr) {
		if (null == cnStr || "".equals(cnStr.trim())) {
			return cnStr;
		}

		char[] chars = cnStr.toCharArray();
		StringBuffer retuBuf = new StringBuffer();
		for (int i = 0, Len = chars.length; i < Len; i++) {
			String ascii = getASCII(chars[i]);
			if (ascii.length() == 0) {
				retuBuf.append(chars[i]);
			} else {
				String spell = getByASCII(ascii);
				if (spell == null) {
					retuBuf.append(chars[i]);
				} else {
					retuBuf.append(spell);
				}
			}
		}
		return retuBuf.toString();
	}

	/**
	 * 获得中文的拼音首字母
	 * 
	 * @param cnStr
	 * @return
	 */
	public static String getFirst(String cnStr) {
		if (null == cnStr || "".equals(cnStr.trim())) {
			return cnStr;
		}

		char[] chars = cnStr.toCharArray();
		StringBuffer retuBuf = new StringBuffer();
		for (int i = 0, Len = chars.length; i < Len; i++) {
			String ascii = getASCII(chars[i]);
			if (ascii.length() == 1) {
				retuBuf.append(chars[i]);
			} else {

				String spell = getByASCII(ascii).substring(0, 1);
				if (spell == null) {
					retuBuf.append(chars[i]);
				} else {
					retuBuf.append(spell);
				}
			}
		}
		return retuBuf.toString();
	}

	public static void main(String[] args) {
		String str = getFull("乐");
		System.out.println(str);
	}

}