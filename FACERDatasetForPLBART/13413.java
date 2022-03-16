    public static final String getIcon(Context context, FileSystemObject fso, boolean firstFound) {
        //Ensure that mime types are loaded
        if (sMimeTypes == null) {
            loadMimeTypes(context);
        }

        // Return the symlink ref mime/type icon
        if (fso instanceof Symlink && ((Symlink) fso).getLinkRef() != null) {
            return getIcon(context, ((Symlink) fso).getLinkRef());
        }

        //Check if the argument is a folder
        if (fso instanceof Directory) {
            if (fso.isSecure() && SecureConsole.isSecureStorageDir(fso.getFullPath())) {
                return "fso_folder_secure"; //$NON-NLS-1$
            } else if (fso.isRemote()) {
                return "fso_folder_remote"; //$NON-NLS-1$
            }
            return "ic_fso_folder_drawable"; //$NON-NLS-1$
        }

        //Get the extension and delivery
        String ext = FileHelper.getExtension(fso);
        if (ext != null) {
            MimeTypeInfo mimeTypeInfo = getMimeTypeInternal(fso, ext, firstFound);

            if (mimeTypeInfo != null) {
                // Create a new drawable
                if (!TextUtils.isEmpty(mimeTypeInfo.mDrawable)) {
                    return mimeTypeInfo.mDrawable;
                }

                // Something was wrong here. The resource should exist, but it's not present.
                // Audit the wrong mime/type resource and return the best fso drawable (probably
                // default)
                Log.w(TAG, String.format(
                        "Something was wrong with the drawable of the fso:" + //$NON-NLS-1$
                        "%s, mime: %s", //$NON-NLS-1$
                        fso.toString(),
                        mimeTypeInfo.toString()));
            }
        }

        // Check  system file
        if (FileHelper.isSystemFile(fso)) {
            return "fso_type_system_drawable"; //$NON-NLS-1$
        }
        // Check if the fso is executable (but not a symlink)
        if (fso.getPermissions() != null && !(fso instanceof Symlink)) {
            if (fso.getPermissions().getUser().isExecute() ||
                fso.getPermissions().getGroup().isExecute() ||
                fso.getPermissions().getOthers().isExecute()) {
                return "fso_type_executable_drawable"; //$NON-NLS-1$
            }
        }
        return "ic_fso_default_drawable"; //$NON-NLS-1$
    }

