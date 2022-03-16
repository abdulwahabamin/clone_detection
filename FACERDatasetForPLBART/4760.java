    public static void refresh(Context context) {
        //Log.e("INDS","Indexder refresh call !! ......................................................................");
        BrowseService.ensureStartups(context);
        if(IND.context==null)
            IND.context=context;
        if(!IND.isRunning && Validator.isValidCaller()) {
            IND.isRunning=true;

            IndexerDb.init(context);
            Runnable go = new Runnable() {
                @Override
                public void run() {
                    if(Device.isMediaMounted()) {
                        BriefSettings set=State.getSettings();
                        if(set!=null) {
                            long lastindex = set.getLong(BriefSettings.LONG_LAST_INDEX_QUICK);
                            if (lastindex == 0) {
                                // if is less than 50kb
                                Log.e("INDS", "Indexder FIRST TIME RUN,  DB size on disk: ");
                                IND.isRunningFullIndex = true;
                                runFullIndex();
                                BriefSettings settings = State.getSettings();
                                settings.setLong(BriefSettings.LONG_LAST_INDEX_QUICK, Cal.getUnixTime());
                                settings.save();
                                IND.isRunningFullIndex = false;
                            }
                        }
                    }

                    IND.isRunning=false;
                }
            };
            go.run();
        }
    }

