    @SuppressWarnings("deprecation")
    private void dumpPhoneInfo(PrintWriter pw) {
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
            pw.print("App Version: ");
            pw.print(pi.versionName);
            pw.print("_");
            pw.println(pi.versionCode);

            pw.print("OS Version: ");
            pw.print(Build.VERSION.RELEASE);
            pw.print("_");
            pw.println(Build.VERSION.SDK_INT);

            pw.print("Vendor: ");
            pw.println(Build.MANUFACTURER);

            pw.print("Model: ");
            pw.println(Build.MODEL);

            pw.print("CPU API: ");
            pw.println(Build.CPU_ABI);
        } catch (PackageManager.NameNotFoundException ex) {
            ex.printStackTrace();
        }
    }

