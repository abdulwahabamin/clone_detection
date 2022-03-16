    private String getLicenseText(final License license) {
        if (license != null) {
            return mShowFullLicenseText ? license.getFullText(mContext) : license.getSummaryText(mContext);
        }
        return "";
    }

