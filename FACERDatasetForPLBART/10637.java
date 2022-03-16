    /**
     * Method that loads the mime type information.
     *
     * @param context The current context
     */
    //IMP! This must be invoked from the main activity creation
    public static synchronized void loadMimeTypes(Context context) {
        if (sMimeTypes == null) {
            try {
                // Load the mime/type database
                Properties mimeTypes = new Properties();
                mimeTypes.load(context.getResources().openRawResource(R.raw.mime_types));

                // Parse the properties to an in-memory structure
                // Format:  <extension> = <category> | <mime type> | <drawable>
                sMimeTypes = new HashMap<String, ArrayList<MimeTypeInfo>>();
                sExtensionMimeTypes = new HashMap<String, MimeTypeInfo>();
                Enumeration<Object> e = mimeTypes.keys();
                while (e.hasMoreElements()) {
                    try {
                        String extension = (String)e.nextElement();
                        String data = mimeTypes.getProperty(extension);
                        String[] datas = data.split(",");
                        for (String theData : datas) {
                            String[] mimeData = theData.split("\\|");  //$NON-NLS-1$

                            // Create a reference of MimeType
                            MimeTypeInfo mimeTypeInfo = new MimeTypeInfo();
                            mimeTypeInfo.mCategory = MimeTypeCategory.valueOf(mimeData[0].trim());
                            mimeTypeInfo.mMimeType = mimeData[1].trim();
                            mimeTypeInfo.mDrawable = mimeData[2].trim();

                            // If no list exists yet for this mimetype, create one.
                            // Else, add it to the existing list.
                            if (sMimeTypes.get(extension) == null) {
                                ArrayList<MimeTypeInfo> infoList = new ArrayList<MimeTypeInfo>();
                                infoList.add(mimeTypeInfo);
                                sMimeTypes.put(extension, infoList);
                            } else {
                                sMimeTypes.get(extension).add(mimeTypeInfo);
                            }
                            sExtensionMimeTypes.put(extension + mimeTypeInfo.mMimeType,
                                                    mimeTypeInfo);
                        }

                    } catch (Exception e2) { /**NON BLOCK**/}
                }

            } catch (Exception e) {
                Log.e(TAG, "Fail to load mime types raw file.", e); //$NON-NLS-1$
            }
        }
    }

