package pl.michal.olszewski.matury.pr2017stara.zad5;

public class HeatingStatistics {

  private final int gasEveningHeatingCount;
  private final int gasMorningHeatingCount;
  private final int woodenEveningHeatingCount;
  private final int woodenMorningHeatingCount;
  private final int deliverCount;
  private final int woodenState;
  private final int woodenForEachHeating;
  private final int woodenDeliver;

  public HeatingStatistics(int woodenState, int woodenDeliver) {
    this.woodenState = woodenState;
    this.woodenMorningHeatingCount = 0;
    this.woodenEveningHeatingCount = 0;
    this.gasMorningHeatingCount = 0;
    this.gasEveningHeatingCount = 0;
    this.deliverCount = 0;
    this.woodenForEachHeating = 26;
    this.woodenDeliver = woodenDeliver;
  }

  private HeatingStatistics(int gasEveningHeatingCount, int gasMorningHeatingCount, int woodenEveningHeatingCount, int woodenMorningHeatingCount, int deliverCount, int woodenState,
      int woodenDeliver) {
    this.gasEveningHeatingCount = gasEveningHeatingCount;
    this.gasMorningHeatingCount = gasMorningHeatingCount;
    this.woodenEveningHeatingCount = woodenEveningHeatingCount;
    this.woodenMorningHeatingCount = woodenMorningHeatingCount;
    this.deliverCount = deliverCount;
    this.woodenState = woodenState;
    this.woodenForEachHeating = 26;
    this.woodenDeliver = woodenDeliver;
  }

  public HeatingStatistics increaseGasEveningHeatingCount() {
    return new HeatingStatistics(gasEveningHeatingCount + 1, gasMorningHeatingCount, woodenEveningHeatingCount, woodenMorningHeatingCount, deliverCount, woodenState, woodenDeliver);
  }

  public HeatingStatistics increaseGasMorningHeatingCount() {
    return new HeatingStatistics(gasEveningHeatingCount, gasMorningHeatingCount + 1, woodenEveningHeatingCount, woodenMorningHeatingCount, deliverCount, woodenState, woodenDeliver);
  }

  public HeatingStatistics increaseWoodenEveningHeatingCount() {
    return new HeatingStatistics(gasEveningHeatingCount, gasMorningHeatingCount, woodenEveningHeatingCount + 1, woodenMorningHeatingCount, deliverCount, woodenState - woodenForEachHeating,
        woodenDeliver);
  }

  public HeatingStatistics increaseWoodenMorningHeatingCount() {
    return new HeatingStatistics(gasEveningHeatingCount, gasMorningHeatingCount, woodenEveningHeatingCount, woodenMorningHeatingCount + 1, deliverCount, woodenState - woodenForEachHeating,
        woodenDeliver);
  }

  public HeatingStatistics increaseDeliverCount() {
    return new HeatingStatistics(gasEveningHeatingCount, gasMorningHeatingCount, woodenEveningHeatingCount, woodenMorningHeatingCount, deliverCount + 1, woodenState + woodenDeliver, woodenDeliver);
  }

  public HeatingStatistics weekendMorningHeating() {
    boolean canMorningWoodenHeating = woodenState >= woodenForEachHeating;
    if (canMorningWoodenHeating) {
      return this.increaseWoodenMorningHeatingCount();
    } else {
      return this.increaseGasMorningHeatingCount();
    }
  }

  public HeatingStatistics weekDayMorningHeating() {
    return this.increaseGasMorningHeatingCount();
  }

  public HeatingStatistics eveningHeating() {
    boolean canEveningWoodenHeating = woodenState >= woodenForEachHeating;
    if (canEveningWoodenHeating) {
      return this.increaseWoodenEveningHeatingCount();
    } else {
      return this.increaseGasEveningHeatingCount();
    }
  }

  public HeatingStatistics fridayWoodenDelivering() {
    if (woodenState < 100) {
      return this.increaseDeliverCount();
    }
    return this;
  }

  public int getGasEveningHeatingCount() {
    return gasEveningHeatingCount;
  }

  public int getGasMorningHeatingCount() {
    return gasMorningHeatingCount;
  }

  public int getWoodenEveningHeatingCount() {
    return woodenEveningHeatingCount;
  }

  public int getWoodenMorningHeatingCount() {
    return woodenMorningHeatingCount;
  }

  public int getDeliverCount() {
    return deliverCount;
  }

  @Override
  public String toString() {
    return "HeatingStatistics{" +
        "gasEveningHeatingCount=" + gasEveningHeatingCount +
        ", gasMorningHeatingCount=" + gasMorningHeatingCount +
        ", woodenEveningHeatingCount=" + woodenEveningHeatingCount +
        ", woodenMorningHeatingCount=" + woodenMorningHeatingCount +
        ", deliverCount=" + deliverCount +
        '}';
  }
}
