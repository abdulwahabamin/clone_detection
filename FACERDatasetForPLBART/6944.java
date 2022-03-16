    public static Comparator<File> getWebFileQueryMethod(int method){
        switch (method){
            case SORT_BY_FOLDER_AND_NAME:
                return new SortByFolderAndName(true, true);
            case SORT_BY_FOLDER_REVERSE_AND_NAME:
                return new SortByFolderAndName(false, true);
            case SORT_BY_FOLDER_AND_NAME_REVERSE:
                return new SortByFolderAndName(true, false);
            case SORT_BY_FOLDER_REVERSE_AND_NAME_REVERSE:
                return new SortByFolderAndName(false, false);
            case SORT_BY_FOLDER_AND_SIZE:
                return new SortByFolderAndSize(true, true);
            case SORT_BY_FOLDER_REVERSE_AND_SIZE:
                return new SortByFolderAndSize(false, true);
            case SORT_BY_FOLDER_AND_SIZE_REVERSE:
                return new SortByFolderAndSize(true, false);
            case SORT_BY_FOLDER_REVERSE_AND_SIZE_REVERSE:
                return new SortByFolderAndSize(false, false);
            case SORT_BY_FOLDER_AND_TIME:
                return new SortByFolderAndTime(true, true);
            case SORT_BY_FOLDER_REVERSE_AND_TIME:
                return new SortByFolderAndTime(false, true);
            case SORT_BY_FOLDER_AND_TIME_REVERSE:
                return new SortByFolderAndTime(true, false);
            case SORT_BY_FOLDER_REVERSE_AND_TIME_REVERSE:
                return new SortByFolderAndTime(false, false);
            default:
                break;
        }
        return null;
    }

