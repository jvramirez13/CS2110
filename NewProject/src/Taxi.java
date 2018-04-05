
public class Taxi {
	private int seats;
	private boolean seatsAvailable, reservation, makeReservation, cancelReservation;
	private double estimatePickUp, estimateArrival;
	private double timeIdle, timeCarry, timePickUp;
	
	
	public Taxi(int seats, boolean seatsAvailable) {
		this.seats = seats;
		this.seatsAvailable = seatsAvailable;
		timeCarry = 0;
	}


	public double getEstimatePickUp() {
		return estimatePickUp;
	}


	public void setEstimatePickUp(double estimatePickUp) {
		this.estimatePickUp = estimatePickUp;
	}


	public double getEstimateArrival() {
		return estimateArrival;
	}


	public void setEstimateArrival(double estimateArrival) {
		this.estimateArrival = estimateArrival;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public boolean isSeatsAvailable() {
		return seatsAvailable;
	}


	public void setSeatsAvailable(boolean seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}


	public boolean isReservation() {
		return reservation;
	}


	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}


	public boolean isMakeReservation() {
		return makeReservation;
	}


	public void setMakeReservation(boolean makeReservation) {
		this.makeReservation = makeReservation;
	}


	public boolean isCancelReservation() {
		return cancelReservation;
	}


	public void setCancelReservation(boolean cancelReservation) {
		this.cancelReservation = cancelReservation;
	}


	public double getEstimate() {
		return estimatePickUp;
	}


	public void setEstimate(double estimatePickUp) {
		this.estimatePickUp = estimatePickUp;
	}


	public double getTimeIdle() {
		return timeIdle;
	}


	public void setTimeIdle(double timeIdle) {
		this.timeIdle = timeIdle;
	}


	public double getTimeCarry() {
		return timeCarry;
	}


	public void setTimeCarry(double timeCarry) {
		this.timeCarry = timeCarry;
	}


	public double getTimePickUp() {
		return timePickUp;
	}


	public void setTimePickUp(double timePickUp) {
		this.timePickUp = timePickUp;
	}
	
	public boolean makeReservation(Taxi b1) {
		if (seatsAvailable) {
			seatsAvailable = false;
			return true;
		} else {
			return false;
		}
	}
	
	public double calculateFare() {
		double fare = timeCarry * 1.25;
		return fare;
	}
	
	public boolean pickUp(Taxi b1) {
		if(makeReservation(b1) && estimatePickUp == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public double timeCarried() {
		return estimateArrival - estimatePickUp;
	}

}
