   public static String makeFileNameSafe(String fileName) {
       fileName = fileName.replaceAll("\n","");
       //fileName = fileName.replaceAll("[ ]+"," ");
       //fileName = fileName.replaceAll("\\\\w","_");
       fileName = fileName.replaceAll("[/\\\\ ]+","_");
       //fileName = fileName.replaceAll("\\\\W","_");
       //System.out.println("---------made safe: "+fileName);
       return fileName;
   }

