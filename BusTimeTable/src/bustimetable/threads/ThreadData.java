package bustimetable.threads;

public interface ThreadData<P,R> {
	public R getResult(P[] args) throws Exception;
	public void afterExecuting(R result);
	public void showError(Exception e);
}
