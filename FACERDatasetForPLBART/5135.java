   public static String shortenText(String txttoshort, int maxLength) {
	   if(maxLength<dotdotdot.length()+2)
		   return txttoshort;
	   if(txttoshort.length()<=maxLength)
		   return txttoshort;
	   
	   int cutout= Double.valueOf((maxLength - 3) / 2).intValue();
	   //BLog.e("CUTOUT", "value: "+cutout);
	   StringBuilder sb=new StringBuilder(txttoshort.substring(0,cutout));
	   sb.append(dotdotdot);
	   sb.append(txttoshort.substring(txttoshort.length()-cutout,txttoshort.length()));
	   
	   return sb.toString();
	   
   }

