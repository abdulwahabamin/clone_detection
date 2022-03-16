    protected int getActivityLabelResourceId() {
        int labelRes;
        try {
            labelRes = getPackageManager().getActivityInfo(getComponentName(), 0).labelRes;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException();
        }
        return labelRes;
    }

