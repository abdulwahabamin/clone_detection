    @Shortcut(id = "graphs", icon = R.drawable.shortcut_graph, shortLabel = "Weather Graphs", rank = 1)
    public void addGraphs() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.setSelectionAtPosition(2);
                GraphsFragment graphsFragment = newGraphInstance(new ArrayList<>(wf.getDailyJson()));
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, graphsFragment)
                        .commit();
            }
        }, 750);
    }

