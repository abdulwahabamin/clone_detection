    public String getTitle() {
        if (size() == 1 && root != null) {
            return root.title;
        } else if (size() > 1) {
            return peek().displayName;
        } else {
            return null;
        }
    }

