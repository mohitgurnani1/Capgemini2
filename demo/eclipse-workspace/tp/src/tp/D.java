package tp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class D  {
	  public static void main (String[] args) throws Exception {
DateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
java.util.Date d1=sf.parse("2016-06-12");
long p1=d1.getTime();
java.util.Date d2=new java.util.Date(p1);
java.sql.Date d3=new java.sql.Date(p1);
System.out.println(d1.toString());
System.out.println(d2.toLocaleString());
System.out.println(d3.toLocaleString());
	  }}
