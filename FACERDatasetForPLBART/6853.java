    public boolean goBack() {

        if (folderHistory.isEmpty())
            return true;
        folderHistory.pop();
        if (!folderHistory.isEmpty())
            activity.populateRecyclerViewValues(folderHistory.peek());
        return false;
    }

