	private void startCpuProfilerService() {
		if (getResources().getBoolean(R.bool.cpu_profiling)) {
			// If serviceCpuName is null it means the service hasn't been
			// started yet.
			if (cpuProfilerName == null) {
				String action = "com.byivan.cpufrequencies.action.PROFILING_TIME_IN_STATE";
				intentCpuProfilerService = new Intent(action);
				intentCpuProfilerService.addCategory("com.byivan.cpufrequencies.category.DEFAULT");
				cpuProfilerName = startService(intentCpuProfilerService);
				if (cpuProfilerName == null)
					Log.e(getClass().getName(), "Service for action=" + action + " cannot be started");
				else
					Log.i(getClass().getName(), "Service " + cpuProfilerName.getClassName() + " has been started");
			}
		}
	}

