    public IOThread(String[] paths, FileOp mode, IOService observer) {
        this.paths = paths;
        this.mode = mode;
        if (observer != null) {
            addObserver(observer);
        }
    }

