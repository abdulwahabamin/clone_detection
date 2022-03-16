    /**
     * Method that retrieve the finds the preferred activity, if one exists. In case
     * of multiple preferred activity exists the try to choose the better
     *
     * @param ctx The current context
     * @param intent The query intent
     * @param info The initial info list
     * @return ResolveInfo The resolved info
     */
    private static final ResolveInfo findPreferredActivity(
            Context ctx, Intent intent, List<ResolveInfo> info) {

        final PackageManager packageManager = ctx.getPackageManager();

        // Retrieve the preferred activity that can handle the file. We only want the
        // resolved activity if the activity is a preferred activity. Other case, the
        // resolved activity was never added by addPreferredActivity
        List<ResolveInfo> pref = new ArrayList<ResolveInfo>();
        int cc = info.size();
        for (int i = 0; i < cc; i++) {
            ResolveInfo ri = info.get(i);
            if (isInternalEditor(ri)) continue;
            if (ri.activityInfo == null || ri.activityInfo.packageName == null) continue;
            List<ComponentName> prefActList = new ArrayList<ComponentName>();
            List<IntentFilter> intentList = new ArrayList<IntentFilter>();
            IntentFilter filter = new IntentFilter();
            filter.addAction(intent.getAction());
            try {
                filter.addDataType(intent.getType());
            } catch (Exception ex) {/**NON BLOCK**/}
            intentList.add(filter);
            packageManager.getPreferredActivities(
                    intentList, prefActList, ri.activityInfo.packageName);
            int count = prefActList.size();
            String activityName = ri.activityInfo.name;
            for (int index = 0;index < count; index++) {
                 if (prefActList.get(index).getClassName().equals(activityName)) {
                     pref.add(ri);
                      break;
                 }
            }
        }
        // No preferred activity is selected
        if (pref.size() == 0) {
            return null;
        }

        // Sort and return the first activity
        Collections.sort(pref, new Comparator<ResolveInfo>() {
            @Override
            public int compare(ResolveInfo lhs, ResolveInfo rhs) {
                if (lhs.priority > rhs.priority) {
                    return -1;
                } else if (lhs.priority < rhs.priority) {
                    return 1;
                }
                if (lhs.preferredOrder > rhs.preferredOrder) {
                    return -1;
                } else if (lhs.preferredOrder < rhs.preferredOrder) {
                    return 1;
                }
                if (lhs.isDefault && !rhs.isDefault) {
                    return -1;
                } else if (!lhs.isDefault && rhs.isDefault) {
                    return 1;
                }
                if (lhs.match > rhs.match) {
                    return -1;
                } else if (lhs.match > rhs.match) {
                    return 1;
                }
                return 0;
            }
        });
        return pref.get(0);
    }

