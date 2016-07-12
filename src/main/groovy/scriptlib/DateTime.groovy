package scriptlib
//Author Jodi D.Krol 2013-12
import org.codehaus.groovy.runtime.DateGroovyMethods
class DateTime {
	static String getCurrentYear(){
		def dateTime = new Date()
		DateGroovyMethods.format(dateTime, 'yyyy')
	}
	static String getCurrentYearMonthDay(){
		def dateTime = new Date()
		DateGroovyMethods.format(dateTime, 'yyyymmdd')
	}
	static String getCurrentYearMonthDayTime(){
		def dateTime = new Date()
		DateGroovyMethods.format(dateTime, 'yyyymmdd:hhss')
	}
}
