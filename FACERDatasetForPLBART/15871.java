    public RemoteCoverTask loadRemoteCover(ImageView imageView,
                                           String username, long albumId, String filePath) {

        RemoteCoverTask remoteCoverTask = new RemoteCoverTask(imageView, username, albumId,
                filePath);

        super.loadAsync(remoteCoverTask);

        return remoteCoverTask;
    }

