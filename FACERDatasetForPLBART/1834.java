    private void editMode(boolean show)
    {

        edit.setVisibility(show?View.GONE:View.VISIBLE);
        TransitionManager.beginDelayedTransition(container_save, new TransitionSet()
                .addTransition(show?(new Slide(Gravity.LEFT)):(new Slide(Gravity.RIGHT))));
        save.setVisibility(show?View.VISIBLE:View.INVISIBLE);
    }

