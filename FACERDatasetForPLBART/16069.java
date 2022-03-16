    @Override
    public void onResume() {
        super.onResume();

        //start PlayerService
        Intent intent = new Intent(getContext(), PlayerService.class);
        getContext().startService(intent);

        intent = new Intent(getActivity(), PlayerService.class);
        getActivity().bindService(intent, serviceConnection, Context.BIND_ABOVE_CLIENT);
    }

