/**
 * @author sinarf
 */


/**
 * @param date date to format, default to now. 
 * @param format SimpleDateFormat pattern, default value is "yyyyMMdd-hhmmss"
 * @return a string of date formated as format. 
 */
static String dateAsString(java.util.Date date = new Date(), def format = "yyyyMMdd-hhmmss"){
	def df = new java.text.SimpleDateFormat(format)
	return df.format(date)
}

/**
 * @return returns a string of today date formated as "dd MMMM yyyy"
 */
static String todayAsString (){
	return dateAsString (new Date(), "dd MMMM yyyy")
}


