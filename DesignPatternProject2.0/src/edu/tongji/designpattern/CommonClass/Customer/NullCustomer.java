package edu.tongji.designpattern.CommonClass.Customer;

public class NullCustomer extends AbstractCustomer {

    @Override
    public boolean isNull() {
        return true;
    }
}
