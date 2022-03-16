        @Override
        public void onClick(View v) {

            //Hide the "Current queue" item if it's already visible.
            if (mApp.isTabletInLandscape())
                popup.getMenu().findItem(R.id.current_queue).setVisible(false);

            popup.show();
        }

