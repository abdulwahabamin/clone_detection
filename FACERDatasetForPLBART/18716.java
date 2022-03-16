    /**
     * Plays the specified file/folder.
     *
     * @param itemType Specifies whether the input path is a file path
     *                 or a folder path.
     * @param index The index of the first song to play. Pass 0 if itemType
     *              is FOLDER.
     * @param folderPath The path of the folder that should be played.
     */
    public void play(int itemType, int index, String folderPath) {
        //Build the query's selection clause.
        String querySelection = MediaStore.Audio.Media.DATA + " LIKE "
                + "'" + folderPath.replace("'", "''") + "/%'";

        //Exclude all subfolders from this playback sequence if we're playing a file.
        if (itemType==AUDIO_FILE) {
            for (int i = 0; i < fileFolderPathList.size(); i++) {
                if (fileFolderTypeList.get(i) == FOLDER)
                    querySelection += " AND " + MediaStore.Audio.Media.DATA + " NOT LIKE "
                            + "'" + fileFolderPathList.get(i).replace("'", "''") + "/%'";

            }

            mApp.getPlaybackKickstarter().initPlayback(mContext,
                                                       querySelection,
                                                       Common.PLAY_ALL_IN_FOLDER,
                                                       index,
                                                       true, false);

        } else if (itemType==FOLDER) {
            mApp.getPlaybackKickstarter().initPlayback(mContext,
                                                       querySelection,
                                                       Common.PLAY_ALL_IN_FOLDER,
                                                       index,
                                                       true, false);
        } else {
            Toast.makeText(mContext, R.string.cant_play_this_file, Toast.LENGTH_SHORT).show();
        }

    }

