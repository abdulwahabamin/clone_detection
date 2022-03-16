    private void startIOService(String[] paths, FileOp op) {
        Intent i = new Intent(this, IOService.class);
        i.putExtra("PATHS", paths);
        i.putExtra("OPERATION", op);

        startService(i);
    }

