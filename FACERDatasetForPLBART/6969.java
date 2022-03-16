    public static String getTailName(String name) {
        String type=null;
        if(name.contains(".")){
            String[] splits=name.split("\\.");
            type=splits[splits.length-1].toLowerCase();
        }
        return type;
    }

