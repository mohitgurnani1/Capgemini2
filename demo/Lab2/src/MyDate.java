import java.util.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


class MyDate{

private Date date=null;
private SimpleDateFormat formatter=null;


public MyDate(String joiningdate,String format){

try{
formatter=new SimpleDateFormat(format);
date=(Date) formatter.parse(joiningdate);
}
catch(Exception e)
{
System.out.println("Wrong date format");
}

}

public MyDate(String joiningdate){

try{
formatter=new SimpleDateFormat("dd-mm-yyyy");
date=(Date) formatter.parse(joiningdate);
}
catch(Exception e)
{
System.out.println("Wrong date format");
}

}


return date;
}




public static String date2(String joiningmonth){
SimpleDateFormat formatter=null;
try{
formatter=new SimpleDateFormat("dd-mm-yyyy");
date=(Date) formatter.parse(joiningmonth);
}
catch(Exception e)
{
System.out.println("Wrong date format");
}
return formatter.format(date);
}



}