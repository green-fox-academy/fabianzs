package fabian.zsofia.frontend.models;

import java.util.Map;

public class DoUntil {

    private int result;

    public DoUntil(String action, Until until) {
        if (action.equals("sum")) {
            this.result = until.getUntil();
            for (int i = 1; i < until.getUntil(); i++) {
                this.result += i;
            }
        } else if (action.equals("factor")) {
            this.result = until.getUntil();
            for (int i = 1; i < until.getUntil(); i++) {
                this.result *= i;
            }
        }
    }

   /* public DoUntil(String action, Map<String, Integer> until) {
        if (action.equals("sum")) {
            this.result = until.get("until");
            for (int i = 1; i < until.get("until"); i++) {
                this.result += i;
            }
        } else if (action.equals("factor")) {
            this.result = until.get("until");
            for (int i = 1; i < until.get("until"); i++) {
                this.result *= i;
            }
        }
    }*/

    public int getResult() {
        return result;
    }

    public void setResult() {

    }
}
