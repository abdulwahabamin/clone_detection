    /**
     * Method that checks the input name
     * @param name
     * @hide
     */
    void checkName(String name) {

        //The name is empty
        if (TextUtils.isEmpty(name)) {
            setMsg(
                InputNameDialog.this.mContext.getString(
                      R.string.input_name_dialog_message_empty_name), false);
            return;
        }

        // Too long
        if (name.length() >= FILENAME_CHAR_LIMIT) {
            setMsg(InputNameDialog.this.mContext.getString(
                    R.string.input_name_dialog_message_invalid_name_length), true);
            return;
        }

        // The path is invalid
        if (name.contains(File.separator)) {
            setMsg(
                InputNameDialog.this.mContext.getString(
                      R.string.input_name_dialog_message_invalid_path_name,
                      File.separator), false);
            return;
        }

        // No allow . or ..
        if (name.compareTo(FileHelper.CURRENT_DIRECTORY) == 0 ||
                name.compareTo(FileHelper.PARENT_DIRECTORY) == 0) {
            setMsg(
                InputNameDialog.this.mContext.getString(
                        R.string.input_name_dialog_message_invalid_name), false);
            return;
        }

        // The same name
        if (this.mFso != null && !this.mAllowFsoName && name.compareTo(this.mFso.getName()) == 0) {
            setMsg(null, false);
            return;
        }

        // Name exists
        if (FileHelper.isNameExists(this.mContext, this.mParent, name)) {
            setMsg(
                InputNameDialog.this.mContext.getString(
                        R.string.input_name_dialog_message_name_exists), false);
            return;
        }

        //Valid name
        setMsg(null, true);

    }

