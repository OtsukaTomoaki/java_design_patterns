public interface State {
  public abstract void doClick(Context context, int hour);
  public abstract void doUse(Context context);
  public abstract void doAlarm(Context context);
  public abstract void doPhone(Context context);
}