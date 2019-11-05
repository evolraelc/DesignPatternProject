package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Order.*;


public interface OrderRecordingStrategy {
    Order execute(Item dish, Order order);
}
