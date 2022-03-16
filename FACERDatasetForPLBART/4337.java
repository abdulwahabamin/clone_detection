    public static String callingClass() {
        Exception ex = new Exception();

        if(ex.getStackTrace().length>2) {

            return ex.getStackTrace()[2].getClassName()+"."+ex.getStackTrace()[2].getMethodName()+"() --";

        }
        return "no.class.found";
    }

