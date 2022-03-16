    public static void hideKeyboard(Fragment fragment) {
        if (fragment == null) {
            return;
        }

        hideKeyboard(fragment.getActivity());
    }

