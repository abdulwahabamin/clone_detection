        @Override
        public void onClick(View v) {
            if (mApp.isShuffleOn())
                ((MainActivity) getActivity()).playAll(true);
            else
                ((MainActivity) getActivity()).playAll(false);

        }

