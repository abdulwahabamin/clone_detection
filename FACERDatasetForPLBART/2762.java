    private void refresh() {
        // get names of current directory contents
        ArrayList<File> contents = new ArrayList<>();
        ArrayList<File> contentsFiles = new ArrayList<>();

        if (currentDir.canRead()) {
            File[] currentDirList = currentDir.listFiles();

            // convert string array to arraylist
            if (currentDirList != null) {
                // exclude hidden items
                for (File aCurrentDirList : currentDirList) {
                    if (!aCurrentDirList.isHidden() || settings.showHidden) {
                        // keep files separate from folders until later for sorting purposes
                        if (aCurrentDirList.isDirectory()) {
                            contents.add(aCurrentDirList);
                        } else {
                            contentsFiles.add(aCurrentDirList);
                        }
                    }
                }
            }

            // sort alphabetically
            Collections.sort(contents);
            Collections.sort(contentsFiles);
            // now append files to folders, so that folders are at top of list
            contents.addAll(contentsFiles);

            if (parent != null) {
                contents.add(0, new File("../"));
            }
        } else {
            contents.add(0, new File("../"));
        }

        // link file names to ListView using FileAdapter
        fileAdapter = new FileAdapter(this, contents);
        lView.setAdapter(fileAdapter);
        registerForContextMenu(lView);
    }

