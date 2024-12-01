package Mediator;

public interface Colleague {
  // 中介者を設定
  public abstract void setMediator(Mediator mediator);
  // Medicatorから有効・無効が指示された際の有効・無効化
  public abstract void setColleagueEnabled(boolean enabled);
}