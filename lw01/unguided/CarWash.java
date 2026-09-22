package lw01.unguided;

public class CarWash extends WashService {
    public CarWash (String id, int days) {
        super(id, days);

        @Override 
        public int calculateCharge() {
            int charge;

            if (getdays() <= 3) {
                charge = getdays() * 35000;
            } else {
                charge = (3 * 35000) + ((getdays() - 3) * 25000);
            }
            return charge + 15000;
        }
        @Override 
        public String label() {
            return "Car";
        }
    }
}
