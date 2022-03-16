    public static String getTrimmed(String name){
        if(name.length()>16){
            return name.substring(0,15)+"...";
        }
        return name;
    }

