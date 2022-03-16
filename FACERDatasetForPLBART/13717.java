    public void createNewFile(String currentDirectory, String newFileName, boolean isDirectory) {
        if (currentDirectory == null) {
            view.onError("No Directory Found");
            return;
        }

        if (newFileName == null) {  // This should never happen, since it is already handled
            view.onError("File Name Not Found");
            return;
        }

        File newFile = new File(currentDirectory, newFileName);
        if (!newFile.exists()) {

            boolean fileCreated = false;
            try {
                if (isDirectory)
                    fileCreated = newFile.mkdirs();
                else
                    fileCreated = newFile.createNewFile();  // throws IOException :|
            } catch (IOException e) {
                view.onError("Error: " + e.getMessage());
                return;
            }

            if (fileCreated)
                fetchCurrentStorageDirectory(currentDirectory);
            else
                view.onError("Could not create");
        } else {
            view.onError("File with same name already exists");
        }
    }

