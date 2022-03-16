	public static void add(String methodString, Exception e) {
		if(E.isDebug) {
            if(!E.isInitialised)
                init();
            LimitSizeForAdd();
            StringBuilder sb=new StringBuilder(Cal.getCal().getDatabaseDate()+" - ");
            sb.append(methodString);
            sb.append("\nexception:\n");
            sb.append(e.getMessage());
            sb.append("\nStack:\n");
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
            BLog.e(methodString,stack.toString());
            sb.append(stack.toString());
            try {
                E.data.put(E.data.length(),sb.toString());
            } catch(Exception ex) {
                Log.e("LOG ERROR", "Failed add from exception");
            }
		}
	}

