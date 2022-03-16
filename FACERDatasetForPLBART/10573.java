    /**
     * Method that check if a file should be displayed according to the restrictions
     *
     * @param fso The file system object to check
     * @param restrictions The restrictions map
     * @return boolean If the file should be displayed
     */
    private static boolean isDisplayAllowed(
            FileSystemObject fso, Map<DisplayRestrictions, Object> restrictions) {
        Iterator<DisplayRestrictions> it = restrictions.keySet().iterator();
        while (it.hasNext()) {
            DisplayRestrictions restriction = it.next();
            Object value = restrictions.get(restriction);
            if (value == null) {
                continue;
            }
            switch (restriction) {
                case CATEGORY_TYPE_RESTRICTION:
                    if (value instanceof MimeTypeCategory) {
                        MimeTypeCategory cat1 = (MimeTypeCategory)value;
                        // NOTE: We don't need the context here, because mime-type
                        // database should be loaded prior to this call
                        MimeTypeCategory cat2 = MimeTypeHelper.getCategory(null, fso);
                        if (cat1.compareTo(cat2) != 0) {
                            return false;
                        }
                    }
                    break;

                case MIME_TYPE_RESTRICTION:
                    String[] mimeTypes = null;
                    if (value instanceof String) {
                        mimeTypes = new String[] {(String) value};
                    } else if (value instanceof String[]) {
                        mimeTypes = (String[]) value;
                    }
                    if (mimeTypes != null) {
                        boolean matches = false;
                        for (String mimeType : mimeTypes) {
                            if (mimeType.compareTo(MimeTypeHelper.ALL_MIME_TYPES) == 0) {
                                matches = true;
                                break;
                            }
                            // NOTE: We don't need the context here, because mime-type
                            // database should be loaded prior to this call
                            if (MimeTypeHelper.matchesMimeType(null, fso, mimeType)) {
                                matches = true;
                                break;
                            }
                        }
                        if (!matches) {
                            return false;
                        }
                    }
                    break;

                case SIZE_RESTRICTION:
                    if (value instanceof Long) {
                        Long maxSize = (Long)value;
                        if (fso.getSize() > maxSize.longValue()) {
                            return false;
                        }
                    }
                    break;

                case DIRECTORY_ONLY_RESTRICTION:
                    if (value instanceof Boolean) {
                        Boolean directoryOnly = (Boolean) value;
                        if (directoryOnly.booleanValue() && !FileHelper.isDirectory(fso)) {
                            return false;
                        }
                    }
                    break;

                case LOCAL_FILESYSTEM_ONLY_RESTRICTION:
                    if (value instanceof Boolean) {
                        Boolean localOnly = (Boolean)value;
                        if (localOnly.booleanValue()) {
                            /** TODO Needed when CMFM gets networking **/
                        }
                    }
                    break;

                default:
                    break;
            }
        }
        return true;
    }

