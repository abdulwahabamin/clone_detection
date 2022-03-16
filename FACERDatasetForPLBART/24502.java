    private void notifyFragmentConnected(int id, MediaPlayback service) {
        Fragment fragment = getFragmentManager().findFragmentById(id);
        if (fragment != null && fragment.isInLayout()) {
            ((FragmentServiceConnection) fragment).onServiceConnected(service);
        }
    }

