package org.example;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("This project Is Created by Naman Jain");
    }
}
