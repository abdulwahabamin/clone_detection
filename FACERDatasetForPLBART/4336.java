	public static boolean isValidCaller() {
		Exception ex = new Exception();
        String calleeClassName = "run.brief";
        //BLog.e("CALLING CLASS", "called: " + calleeClassName + ", startwith?: " + State.getPackageName());
		if(ex.getStackTrace().length>2) {

            String fromClass = ex.getStackTrace()[2].getClassName();
			if(fromClass.startsWith(calleeClassName)) {
				return true;
			} else {
                BLog.e("CALLING CLASS", "BAD ----*********************---------  called: " + calleeClassName + ", startwith?: " + State.getPackageName());
            }
		}
		return false;
	}

