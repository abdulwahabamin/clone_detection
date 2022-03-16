    private void dumpException2SDCard(Throwable ex) throws IOException {
        File dumpDir = FileUtil.getSDCardDir(mContext, CRASH_DUMP_DIR);
        if (null == dumpDir)
            return;

        if (!dumpDir.exists())
            dumpDir.mkdir();

        String time = StringUtil.getCurrentDateTime("yyyy-MM-dd_HH:mm:ss_");
        File dumpFile = new File(dumpDir.getPath() + File.separator + time + CRASH_DUMP_FILE);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(dumpFile)));
        pw.println(time);
        dumpPhoneInfo(pw);
        pw.println();
        ex.printStackTrace(pw);
        pw.close();
    }

