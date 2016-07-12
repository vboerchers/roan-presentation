package scriptlib

import java.util.ArrayList;

class StringLib {
	static String getArrayElementWithLeftStr(ArrayList al, String leftStr){// null if none
		Integer i=0;
		String result=null
		if (al==null||al==[]) return null
		else while(i<al.size()&&result==null){
			if(StringLib.isLeft(al[i],leftStr)) result= al[i] else i+=1
		}
		return result
	}
	
	static Boolean isLeft(String str, String leftStr){
		return left(str, leftStr.size())==leftStr
	}
	
	static String left(String str, Integer n){
		if (n <= 0)
			return "";
		else if (n > str.length())
			return str;
		else
			return str.substring(0,n);
	}
	static String right(String str, Integer n){
		if (n <= 0)
		   return "";
		else if (n > str.length())
		   return str;
		else {
		   Integer iLen = str.length();
		   return str.substring(iLen, iLen - n);
		}
	}
	
	
	static ArrayList nodeIds(String s){// ID_0123,ID_1234
		ArrayList r=[]
		ArrayList parms=s.split(",")
		parms.each{
			if (StringLib.isLeft(it,"ID_")) r+=[it]
		}
		return r
	}
	
	// Depreciated; Do not use, see LinkLib
	static String toRegexStr(String s){// %, space, round brackets, curly brackets etc
		return s.replaceAll(/%/, /%25/).replaceAll(" ", "%20").replaceAll(/\(/,"%28").replaceAll(/\)/,"%29").replaceAll(/\{/,"%7B").replaceAll(/\}/,"%7D").replaceAll(/\[/,"%5B").replaceAll(/\]/,"%5D")
	}
	static String fromRegexStr(String s){// space, round brackets, curly brackets etc
		return s.replaceAll("%20"," ").replaceAll( /%25/,/%/).replaceAll("%29",/\(/).replaceAll("%28",/\)/).replaceAll("%&B",/\{/).replaceAll("%7D",/\}/).replaceAll("%5B",/\[/).replaceAll("5D",/\]/)
	}
}
