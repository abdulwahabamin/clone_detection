    public static Date getDateFromPath(String path){
        try{
            String format=completeDateFormat.format(new File(path).lastModified());
            return completeDateFormat.parse(format);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

