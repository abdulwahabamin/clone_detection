	public static void init() {
        if(true || Validator.isValidCaller()) {
            if (DB.settings == null) {

                frt = new FileReadTask(Files.HOME_PATH_APP, Files.FILENAME_GENERAL_SETTINGS);
                if (!frt.exists()) {
                    //Log.e("SETTINGS","not exists creating");
                    DB.settings = new BriefSettings();
                    DB.isLoaded = true;
                    Save();
                }
                if (frt.ReadSecureFromSd()) {
                    //Log.e("SETTINGS","--"+frt.getFileContent());
                    if (frt.getFileContent() != null && !frt.getFileContent().isEmpty()) {
                        try {
                            JSONObject db = new JSONObject(frt.getFileContent());
                            if (db != null) {
                                DB.settings = new BriefSettings(db);
                                DB.isLoaded = true;
                                //BLog.e("LOADEDSSS", "load settings ---- - - - " + DB.settings.toString());
                            } else {
                                //BLog.e("Sb.jon().no create","DB IS NULL");
                            }
                        } catch (Exception e) {
                            //if(e.getMessage()!=null)
                            //BLog.e("Sb.init()", e.getMessage());
                        }
                    } else {
                        //Log.e("Sb.init().empty",frt.getStatusMessage());
                        DB.settings = new BriefSettings();
                        DB.isLoaded = true;
                        Save();
                    }
                } else {
                    //BLog.e("Sb.init().no read",frt.getStatusMessage());
                }

            }

        }
	}

