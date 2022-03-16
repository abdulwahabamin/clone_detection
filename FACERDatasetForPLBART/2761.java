    private void changeDir(String newPath) {
        if (newPath.equals("../")) {
            currentDir = currentDir.getParentFile();
        } else {
            currentDir = new File(newPath);
        }
        parent = currentDir.getParent();
        setTitle(newPath);
    }

