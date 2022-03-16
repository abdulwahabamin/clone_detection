    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_speech:
                speechPresenter.speech();
                break;
        }
    }

