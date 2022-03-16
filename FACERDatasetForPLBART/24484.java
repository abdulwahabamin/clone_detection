    public static void showMe(Activity activity, Uri uri) {
        TrackInfoFragment trackInfoFragment = new TrackInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("uri", uri.toString());
        trackInfoFragment.setArguments(bundle);
        trackInfoFragment.show(activity.getFragmentManager(), "TrackInfo");
    }

