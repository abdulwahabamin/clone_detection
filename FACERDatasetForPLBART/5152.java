   public static String replaceLineBreaks(String instr) {
       instr = instr.replaceAll("\r\n","<br/>");
       instr = instr.replaceAll("\n","<br/>");
       instr = instr.replaceAll("\r","<br/>");
       instr = instr.replaceAll("<br/><br/>","<br/>");
       instr = instr.replaceAll("<br/><br/>","<br/>");
       return instr;
       
   }

