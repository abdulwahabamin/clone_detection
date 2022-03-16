    public Stack<String> getHistory()
    {
        File musicFilePath = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_MUSIC);
        folderHistory.add(musicFilePath.toString());
        return folderHistory;
    }

