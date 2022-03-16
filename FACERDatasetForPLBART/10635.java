    /**
     * Method that returns the description of the category
     *
     * @param context The current context
     * @param category The category
     * @return String The description of the category
     */
    public static final String getCategoryDescription(
                    Context context, MimeTypeCategory category) {
        if (category == null || category.compareTo(MimeTypeCategory.NONE) == 0) {
            return "-";  //$NON-NLS-1$
        }
        try {
            String id = "category_" + category.toString().toLowerCase(Locale.ROOT); //$NON-NLS-1$
            int resid = ResourcesHelper.getIdentifier(
                    context.getResources(), "string", id); //$NON-NLS-1$
            return context.getString(resid);
        } catch (Throwable e) {/**NON BLOCK**/}
        return "-";  //$NON-NLS-1$
    }

