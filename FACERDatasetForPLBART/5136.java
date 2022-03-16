   public static String javascriptSafe(String text) {
       if(text!=null) {
           text= Sf.replaceLineBreaks(text);
           text=text.replaceAll("'", "\\\\'");
       } else {
           return "";
       }
       return text;
   }

