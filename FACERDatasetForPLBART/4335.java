    public static void calldata() {
        Exception ex = new Exception();
        StackTraceElement[] st = ex.getStackTrace();
        for(int i=st.length-1; i>=0; i--) {

            //BLog.e("ST", st[i].getClassName() + " -- " + st[i].getLineNumber() + " -- " + st[i].getMethodName());
        }
        //String calleeClassName = [ex.getStackTrace().length-1]..getClassName();
        StringWriter stack = new StringWriter();
        ex.printStackTrace(new PrintWriter(stack));
        BLog.e("STACK", stack.toString());
        //return "";
    }

