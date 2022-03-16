    /**
     * Displays a dialog allowing user to enter personal OWM key.
     */
    private void showEnterPersonalApiKeyDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        EnterPersonalApiKeyFragment personalKeyFragment = (EnterPersonalApiKeyFragment)
                fragmentManager.findFragmentByTag(PERSONAL_API_KEY_FRAGMENT_TAG);
        if (personalKeyFragment == null) {
            personalKeyFragment = new EnterPersonalApiKeyFragment();
            personalKeyFragment.show(fragmentManager, PERSONAL_API_KEY_FRAGMENT_TAG);
        }
    }

