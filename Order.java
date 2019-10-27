package code;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Employee> employees=new ArrayList<Employee>();
    public List<Item> items=new ArrayList<Item>();
    private int orderState;
    public int getOrderState() {
        return orderState;
    }
    public void setOrderState(int state){
        this.orderState=state;
        notifyAllEmployees();
    }
    public void addEmploy(Employee e){
        employees.add(e);
    }

    private void notifyAllEmployees() {
        for (Employee employee : employees) {
            employee.update();
        }
    }
}
