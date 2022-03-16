    /**
     * Method that returns an {@link Intent} from his {@link ResolveInfo}
     *
     * @param ri The ResolveInfo
     * @param request The requested intent
     * @return Intent The intent
     */
    public static final Intent getIntentFromResolveInfo(ResolveInfo ri, Intent request) {
        Intent intent =
                getIntentFromComponentName(
                    new ComponentName(
                        ri.activityInfo.applicationInfo.packageName,
                        ri.activityInfo.name),
                    request);
        boolean isInternalEditor = isInternalEditor(ri);
        if (isInternalEditor) {
            String a = Intent.ACTION_VIEW;
            if (ri.activityInfo.metaData != null) {
                a = ri.activityInfo.metaData.getString(
                        IntentsActionPolicy.EXTRA_INTERNAL_ACTION,
                        Intent.ACTION_VIEW);
            }
            intent.setAction(a);
        } else {
            // Opening image files with Gallery2 will behave incorrectly when started
            // as a new task. We want to be able to return to CMFM with the back button.
            if (!(Intent.ACTION_VIEW.equals(intent.getAction())
                  && isGallery2(ri)
                  && intent.getData() != null
                  && MediaStore.AUTHORITY.equals(intent.getData().getAuthority()))) {
                // Create a new stack for the activity
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }

        // Grant access to resources if needed
        grantSecureAccessIfNeeded(intent, ri);

        return intent;
    }

