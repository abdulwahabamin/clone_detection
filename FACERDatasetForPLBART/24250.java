    public static void showMe(Activity activity, long[] songs) {
        CreatePlaylist fragment = new CreatePlaylist();
        Bundle bundle = new Bundle();
        bundle.putLongArray("songs", songs);
        fragment.setArguments(bundle);
        fragment.show(activity.getFragmentManager(), "CreatePlaylist");
    }

